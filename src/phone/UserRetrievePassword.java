package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class UserRetrievePassword {
	public void userRetrievePassword(){
		Scanner userInput = new Scanner(System.in);
		User user = new User();
		System.out.println("��ӭ�����һ�����");
		System.out.println("�������û�����");
		//nextLine(),���û����ַ�����ʽ����
		user.setUsername(userInput.nextLine().trim());
		int num = 0;
		while(user.getUsername().equals("")){
			if(num >=3){
				//��ת����ҳ
				System.err.println("�û�������������࣬���������û�ϵͳ��ҳ��");
				UserSystem userSystem = new UserSystem();
				userSystem.userSystem();
			}
			System.err.println("��������û���Ϊ�����������룡");
			user.setUsername(userInput.nextLine().trim());
			num++;
		}
		System.out.println("�������ֻ��ţ�");
		//nextLine(),���û���������ֵ��ʽ����
		user.setPhone(userInput.nextLine().trim());
		VerifyPhone verifyPhone = new VerifyPhone();
		int verifyPhoneNum = verifyPhone.verifyPhone(user.getPhone());
		System.out.println(verifyPhoneNum);
		while(verifyPhoneNum == 0 || verifyPhoneNum == 1 || verifyPhoneNum == 2){
			if(verifyPhoneNum == 0){
				System.err.println("��������ֻ���Ϊ�գ�");
				user.setPhone(userInput.nextLine().trim());
				verifyPhoneNum = verifyPhone.verifyPhone(user.getPhone());
			}else if(verifyPhoneNum == 1){
				System.err.println("��������ֻ��Ų����Ϲ���11λ��");
				user.setPhone(userInput.nextLine().trim());
				verifyPhoneNum = verifyPhone.verifyPhone(user.getPhone());
			}else if(verifyPhoneNum == 2){
				System.err.println("��������ֻ��Ų���ȷ��");
				user.setPhone(userInput.nextLine().trim());
				verifyPhoneNum = verifyPhone.verifyPhone(user.getPhone());
			}else if(verifyPhoneNum == 3){
				
			}
		}
		System.out.println("���������ú�����룺��6-16λ��");
		user.setPassword(userInput.nextLine().trim());
		VerifyPassword verifyPassword = new VerifyPassword();
		int verifyPasswordNum = verifyPassword.verifyPassword(user.getPassword());
		while(verifyPasswordNum == 0 || verifyPasswordNum == 1){
			if(verifyPasswordNum == 0){
				System.err.println("�����������Ϊ�����������룡");
				user.setPassword(userInput.nextLine().trim());
				verifyPasswordNum = verifyPassword.verifyPassword(user.getPassword());
			}
			if(verifyPasswordNum == 1){
				System.err.println("����������볤�Ȳ�����6-16λ��");
				user.setPassword(userInput.nextLine().trim());
				verifyPasswordNum = verifyPassword.verifyPassword(user.getPassword());
			}
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone","root","123456");
			String sql = "UPDATE USER SET PASSWORD=? WHERE username=? and phone=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,user.getPassword());
			ps.setString(2,user.getUsername());
			ps.setString(3,user.getPhone());
			int res = ps.executeUpdate();
			if(res != 0){
				System.out.println("�û����ڣ���������ɹ�����ת����¼ҳ��");
				UserSystem userSystem = new UserSystem();
				userSystem.userSystem();
			}else{
				System.out.println("�û������ڣ�������һ��");
				UserSystem userSystem = new UserSystem();
				userSystem.userSystem();
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}