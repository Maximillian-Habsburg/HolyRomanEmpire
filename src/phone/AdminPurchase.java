package phone;

import java.util.Scanner;

public class AdminPurchase {
	public void adminPurchase() {
		Scanner adminInput = new Scanner(System.in);
		System.out.println("进入查看进货信息页面请输入1");
		System.out.println("进入添加进货信息页面请输入2");
		System.out.println("返回上一级请输入quit");
		String adminChange = adminInput.nextLine();
		System.out.println(adminChange);
		if(adminChange.equals("1")){
			AdminPurchasequery adminPurchasequery = new AdminPurchasequery();
			adminPurchasequery.adminPurchasequery();
		}else if(adminChange.equals("2")){
			AdminPurchaseadd adminPurchaseadd = new AdminPurchaseadd();
			adminPurchaseadd.adminPurchaseadd();
		}else if(adminChange.equals("quit")){
			//进入初始界面
			AdminIstraion adminIstraion = new AdminIstraion();
			adminIstraion.adminIstraion();
		}else{
			System.err.println("请做出正确的输入！");
			adminPurchase();
		}
	}	
}
