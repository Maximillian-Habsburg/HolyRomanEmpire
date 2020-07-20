package phone;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Connection;

import com.mysql.jdbc.Statement;

public class UserOrderquery {
	public void userOrderquery() {
		Scanner userInput = new Scanner(System.in);
		Order order = new Order();
		System.out.println("欢迎进入订单查询页面！");
		System.out.println("请输入任意字符进行查看");
		order.setPhonename(userInput.nextLine().trim());
		while(order.getPhonename().equals("")){
			System.err.println("您输入的信息为空请重新输入！");
			order.setPhonename(userInput.nextLine().trim());
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone","root","123456");
			Statement ps = (Statement) con.createStatement();
			ResultSet res = ps.executeQuery("SELECT * FROM BILL");
			if(res.next()){
				System.out.println("查询成功，订单信息如下");
				System.out.println("订单编号："+res.getInt("id")+"\t手机名称："+res.getString("phonename")+"\t手机个数："+res.getString("number")+"\t价格信息："+res.getString("price")+"\t更改时间："+res.getString("ts"));
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
