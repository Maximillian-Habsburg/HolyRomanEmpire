package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class UserRegister {
	public void userRegister(){
		Scanner userInput = new Scanner(System.in);
		User user = new User();
		System.out.println("欢迎进入注册页面！");
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

		System.out.println("请输入手机号：");
		//nextLine(),将用户输入以数值形式返回
		user.setPhone(userInput.nextLine().trim());
		VerifyPhone verifyPhone = new VerifyPhone();
		int verifyPhoneNum = verifyPhone.verifyPhone(user.getPhone());
		System.out.println(verifyPhoneNum);
		while(verifyPhoneNum == 0 || verifyPhoneNum == 1 || verifyPhoneNum == 2){
			if(verifyPhoneNum == 0){
				System.err.println("您输入的手机号为空！");
				user.setPhone(userInput.nextLine().trim());
				verifyPhoneNum = verifyPhone.verifyPhone(user.getPhone());
			}else if(verifyPhoneNum == 1){
				System.err.println("您输入的手机号不符合规则（11位）");
				user.setPhone(userInput.nextLine().trim());
				verifyPhoneNum = verifyPhone.verifyPhone(user.getPhone());
			}else if(verifyPhoneNum == 2){
				System.err.println("您输入的手机号不正确！");
				user.setPhone(userInput.nextLine().trim());
				verifyPhoneNum = verifyPhone.verifyPhone(user.getPhone());
			}else if(verifyPhoneNum == 3){
				
			}
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
		System.out.println("请二次确认密码：");
		String verifyConfirm = userInput.nextLine().trim();
		while(!user.getPassword().equals(verifyConfirm)){
			System.err.println("您输入的密码不一致请重新输入！");
			user.setPassword(userInput.nextLine().trim());
			verifyPassword = new VerifyPassword();
			verifyPasswordNum = verifyPassword.verifyPassword(user.getPassword());
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
			System.out.println("请二次确认密码：");
			verifyConfirm = userInput.nextLine();
		}
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone","root","123456");
			String sql = "INSERT INTO USER(username,phone,PASSWORD) VALUE( ?, ?, ?)";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,user.getPassword());
			ps.setString(2,user.getUsername());
			ps.setString(3,user.getPhone());
			int res = ps.executeUpdate();
			if(res != 0){
				System.out.println("注册成功，跳转到登录页面");
				UserLogin userLogin = new UserLogin();
				userLogin.userLogin();
			}else{
				System.out.println("注册失败，返回上一级");
				UserSystem userSystem = new UserSystem();
				userSystem.userSystem();
			}
			//ResultSet res = st.executeQuery(sql);
			//System.out.println(res);
			//while(res.next()){
				/*System.out.println(res.getInt(1));
				System.out.println(res.getString(2));
				System.out.println(res.getString(3));*/
				//System.out.println("用户名:"+res.getString(2)+"\t\t手机号"+res.getString(3));
			//}
			/*res.next();
			System.out.println(res.getInt(1));
			System.out.println(res.getString(2));
			System.out.println(res.getString(3));
			System.out.println(res.getString(4));*/
			con.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}	
}
