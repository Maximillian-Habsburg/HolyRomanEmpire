package phone;

import java.util.Scanner;

public class AdminShipment {
	public void adminShipment() {
		Scanner adminInput = new Scanner(System.in);
		System.out.println("进入查看出货信息页面请输入1");
		System.out.println("进入添加出货信息页面请输入2");
		System.out.println("返回上一级请输入quit");
		String adminChange = adminInput.nextLine();
		System.out.println(adminChange);
		if(adminChange.equals("1")){
			AdminShipmentquery adminShipmentquery = new AdminShipmentquery();
			adminShipmentquery.adminShipmentquery();
		}else if(adminChange.equals("2")){
			AdminShipmentadd adminShipmentadd = new AdminShipmentadd();
			adminShipmentadd.adminShipmentadd();
		}else if(adminChange.equals("quit")){
			//进入初始界面
			AdminIstraion adminIstraion = new AdminIstraion();
			adminIstraion.adminIstraion();
		}else{
			System.err.println("请做出正确的输入！");
			adminShipment();
		}
	}	
	
}
