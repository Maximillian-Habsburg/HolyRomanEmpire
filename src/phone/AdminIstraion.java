package phone;

import java.util.Scanner;

public class AdminIstraion {

	public void adminIstraion() {
		Scanner adminInput = new Scanner(System.in);
		System.out.println("进入设备管理页面请输入1");
		System.out.println("进入出货管理页面请输入2");
		System.out.println("进入进货管理页面请输入3");
		System.out.println("进入库存管理页面请输入3");
		System.out.println("返回上一级请输入quit");
		String adminChange = adminInput.nextLine();
		System.out.println(adminChange);
		if(adminChange.equals("1")){
			AdminInformation adminInformation = new AdminInformation();
			adminInformation.adminInformation();
		}else if(adminChange.equals("2")){
			AdminShipment adminShipment = new AdminShipment();
			adminShipment.adminShipment();
		}else if(adminChange.equals("3")){
			AdminPurchase adminPurchase = new AdminPurchase();
			adminPurchase.adminPurchase();
		}else if(adminChange.equals("4")){
			AdminStock adminStock = new AdminStock();
			adminStock.adminStock();
		}else if(adminChange.equals("quit")){
			//进入初始界面
			Login login = new Login();
			login.Login();
		}else{
			System.err.println("请做出正确的输入！");
			adminIstraion();
		}
	}	
}
