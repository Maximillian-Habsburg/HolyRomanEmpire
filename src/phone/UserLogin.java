package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class UserLogin {
	public void userLogin(){
		Scanner userInput = new Scanner(System.in);
		User user = new User();
		System.out.println("欢迎进入登录");
		System.out.println("请输入用户名：");
		//nextLine(),将用户以字符串形式返回
		user.setUsername(userInput.nextLine().trim());
		int num = 0;
		while(user.getUsername().equals("")){
			if(num >=3){
				//跳转回首页
				System.err.println("用户名输入次数过多，即将返回用户系统首页！");
				UserSystem userSystem = new UserSystem();
				userSystem.userSystem();
			}
			System.err.println("您输入的用户名为空请重新输入！");
			user.setUsername(userInput.nextLine().trim());
			num++;
		}
		System.out.println("请输入密码：（6-16位）");
		user.setPassword(userInput.nextLine().trim());
		VerifyPassword verifyPassword = new VerifyPassword();
		int verifyPasswordNum = verifyPassword.verifyPassword(user.getPassword());
		while(verifyPasswordNum == 0 || verifyPasswordNum == 1){
			if(verifyPasswordNum == 0){
				System.err.println("您输入的密码为空请重新输入！");
				user.setPassword(userInput.nextLine().trim());
				verifyPasswordNum = verifyPassword.verifyPassword(user.getPassword());
			}
			if(verifyPasswordNum == 1){
				System.err.println("您输入的密码长度不满足6-16位！");
				user.setPassword(userInput.nextLine().trim());
				verifyPasswordNum = verifyPassword.verifyPassword(user.getPassword());
			}
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone","root","123456");
			String sql = "SELECT * FROM USER WHERE username=? and password=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getPassword());
			ResultSet res = ps.executeQuery();
			if(res.next()){
				System.out.println("登录成功，跳转到商店页面");
				Useroption useroption = new Useroption();
				useroption.useroption();
			}else{
				System.out.println("登录失败，返回上一级");
				UserSystem userSystem = new UserSystem();
				userSystem.userSystem();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}

	
	

