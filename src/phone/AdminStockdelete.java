package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class AdminStockdelete {
	public void adminStockdelete() {
		Scanner adminInput = new Scanner(System.in);
		Order order = new Order();
		System.out.println("欢迎进入库存删除页面！");
		System.out.println("请输入货物号：");
		order.setId(adminInput.nextLine().trim());
		while(order.getId().equals("")){
			System.err.println("您输入的信息为空请重新输入！");
			order.setId(adminInput.nextLine().trim());
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/order","root","123456");
			String sql="DELETE FROM STOCK WHERE id=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1,order.getId());
			int res = ps.executeUpdate();
			if(res != 0){
				System.out.println("删除成功，跳转到登录页面");
			}else{
				System.out.println("已无此货物，删除失败，返回上一级");
				Useroption useroption = new Useroption();
				useroption.useroption();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
