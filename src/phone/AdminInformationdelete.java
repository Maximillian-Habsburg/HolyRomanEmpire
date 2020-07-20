package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class AdminInformationdelete {

	public void adminInformationdelete() {
		Scanner adminInput = new Scanner(System.in);
		Information information = new Information();
		System.out.println("欢迎进入删除页面！");
		System.out.println("请输入设备号：");
		information.setId(adminInput.nextLine().trim());
		while(information.getId().equals("")){
			System.err.println("您输入的信息为空请重新输入！");
			information.setId(adminInput.nextLine().trim());
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone","root","123456");
			String sql="DELETE FROM INFORMATION WHERE phonename=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,information.getPhonename());
			int res = ps.executeUpdate();
			if(res != 0){
				System.out.println("删除成功");
			}else{
				System.out.println("已无此设备，删除失败，返回上一级");
				AdminInformation adminInformation = new AdminInformation();
				adminInformation.adminInformation();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
