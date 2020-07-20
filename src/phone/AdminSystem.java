package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class AdminSystem {
	public void adminSystem(){
		Scanner adminInput = new Scanner(System.in);
		Admin admin = new Admin();
		System.out.println("欢迎管理员！");
		System.out.println("请输入用户名：");
		admin.setAdminname(adminInput.nextLine().trim());
		int num = 0;
		while(admin.getAdminname().equals("")){
			if(num >=3){
				//跳转回首页
				System.err.println("用户名输入次数过多，即将返回用户系统首页！");
				UserSystem userSystem = new UserSystem();
				userSystem.userSystem();
			}
			System.err.println("您输入的用户名为空请重新输入！");
			admin.setAdminname(adminInput.nextLine().trim());
			num++;
		}
		System.out.println("请输入密码：（6-16位）");
		admin.setPassword(adminInput.nextLine().trim());
		VerifyPassword verifyPassword = new VerifyPassword();
		int verifyPasswordNum = verifyPassword.verifyPassword(admin.getPassword());
		while(verifyPasswordNum == 0 || verifyPasswordNum == 1){
			if(verifyPasswordNum == 0){
				System.err.println("您输入的密码为空请重新输入！");
				admin.setPassword(adminInput.nextLine().trim());
				verifyPasswordNum = verifyPassword.verifyPassword(admin.getPassword());
			}
			if(verifyPasswordNum == 1){
				System.err.println("您输入的密码长度不满足6-16位！");
				admin.setPassword(adminInput.nextLine().trim());
				verifyPasswordNum = verifyPassword.verifyPassword(admin.getPassword());
			}
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone","root","123456");
			String sql = "SELECT * FROM ADMINISTRATORS WHERE adminname=? and password=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,admin.getAdminname());
			ps.setString(2,admin.getPassword());
			ResultSet res = ps.executeQuery();
			if(res.next()){
				System.out.println("登录成功，跳转到管理页面");
				AdminIstraion adminIstraion = new AdminIstraion();
				adminIstraion.adminIstraion();
			}else{
				System.out.println("登录失败，返回上一级");
				Login login = new Login();
				login.Login();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}

