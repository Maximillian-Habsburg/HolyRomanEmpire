package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class AdminStockchange {
	public void adminStockchange() {
		Scanner adminInput = new Scanner(System.in);
		Order order = new Order();
		System.out.println("欢迎进入库存更改页面！");
		System.out.println("请输入货物号：");
		order.setId(adminInput.nextLine().trim());
		while(order.getId().equals("")){
			System.err.println("您输入的信息为空请重新输入！");
			order.setId(adminInput.nextLine().trim());
		}
		System.out.println("请输入要更改货物的手机名：");
		order.setPhonename(adminInput.nextLine().trim());
		while(order.getPhonename().equals("")){
			System.err.println("您输入的信息为空请重新输入！");
			order.setPhonename(adminInput.nextLine().trim());
		}
		System.out.println("请输入要更改的个数：");
		order.setNumber(adminInput.nextLine().trim());
		VerifyNumber verifyNumber = new VerifyNumber();
		int verifyNumberNum = verifyNumber.verifyNumber(order.getNumber());
		while(verifyNumberNum == 0 || verifyNumberNum == 1){
			if(verifyNumberNum == 0){
				System.err.println("您输入个数为空请重新输入！");
				order.setNumber(adminInput.nextLine().trim());
				verifyNumberNum = verifyNumber.verifyNumber(order.getNumber());
			}
			if(verifyNumberNum == 1){
				System.err.println("您输入个数过多！（0-99）");
				order.setNumber(adminInput.nextLine().trim());
				verifyNumberNum = verifyNumber.verifyNumber(order.getNumber());
			}
		}
		System.out.println("请输入要更改的价格信息：");
		order.setPrice(adminInput.nextLine().trim());
		VerifyPrice verifyPrice = new VerifyPrice();
		int verifyPriceNum = verifyPrice.verifyPrice(order.getPrice());
		while(verifyPriceNum == 0 || verifyPriceNum == 1){
			if(verifyPriceNum == 0){
				System.err.println("您输入价格为空请重新输入！");
				order.setPrice(adminInput.nextLine().trim());
				verifyPriceNum = verifyPrice.verifyPrice(order.getPrice());
			}
			if(verifyPriceNum == 1){
				System.err.println("您输入价格不符合规则！（100-99999）");
				order.setPrice(adminInput.nextLine().trim());
				verifyPriceNum = verifyPrice.verifyPrice(order.getPrice());
			}
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone","root","123456");
			String sql="UPDATE STOCK SET phonename=? , number=? , price=? WHERE id=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,order.getPhonename());
			ps.setString(2,order.getNumber());
			ps.setString(3,order.getPrice());
			ps.setString(4,order.getId());
			int res = ps.executeUpdate();
			if(res != 0){
				System.out.println("更改成功！");
			}else{
				System.out.println("无此货物，更改失败，返回上一级");
				AdminIstraion adminIstraion = new AdminIstraion();
				adminIstraion.adminIstraion();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
