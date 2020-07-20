package phone;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class UserCommodity {
	public void userCommodity() {
		Scanner userInput = new Scanner(System.in);
		Commodity commodity = new Commodity();
		System.out.println("欢迎进入商店页面！");
		System.out.println("请输入任意字符进行查看");
		commodity.setPhonename(userInput.nextLine().trim());
		while(commodity.getPhonename().equals("")){
			System.err.println("您输入的信息为空请重新输入！");
			commodity.setPhonename(userInput.nextLine().trim());
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/phone","root","123456");
			Statement ps = (Statement) con.createStatement();
			ResultSet res = ((java.sql.Statement) ps).executeQuery("SELECT * FROM COMMODITY");
			if(res.next()){
				System.out.println("查询成功，信息如下");
				System.out.println(res.getString("phonename"));
				System.out.println(res.getInt("number"));
				System.out.println(res.getInt("price"));
				System.out.println();
			}else{
				System.out.println("查询失败，返回上一级");
				Useroption useroption = new Useroption();
				useroption.useroption();
			}
		}catch (Exception e){

			e.printStackTrace();
		}

	}
}
