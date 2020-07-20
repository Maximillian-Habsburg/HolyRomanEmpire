package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class AdminPurchasequery {
	public void adminPurchasequery() {
		Scanner adminInput = new Scanner(System.in);
		Order order = new Order();
		System.out.println("欢迎进入进货查询页面！");
		System.out.println("请输入任意字符进行查看");
		order.setPhonename(adminInput.nextLine().trim());
		while(order.getPhonename().equals("")){
			System.err.println("您输入的信息为空请重新输入！");
			order.setPhonename(adminInput.nextLine().trim());
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone","root","123456");
			Statement ps = (Statement) con.createStatement();
			ResultSet res = ps.executeQuery("SELECT * FROM PURCHASE");
			if(res.next()){
				System.out.println("查询成功，信息如下");
				System.out.println("设备编号："+res.getInt("id")+"\t手机名称："+res.getString("phonename")+"\t个数信息："+res.getString("number")+"\t价格信息："+res.getString("price")+"\t更改时间："+res.getString("ts"));
			}else{
				System.out.println("查询失败，返回上一级");
				AdminInformation adminInformation = new AdminInformation();
				adminInformation.adminInformation();
			}
		}catch (Exception e){
			e.printStackTrace();
		}

	}
}
