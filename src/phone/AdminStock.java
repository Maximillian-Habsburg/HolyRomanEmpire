package phone;

import java.util.Scanner;

public class AdminStock {
	public void adminStock() {
		Scanner adminInput = new Scanner(System.in);
		System.out.println("进入查看库存信息页面请输入1");
		System.out.println("进入添加库存信息页面请输入2");
		System.out.println("进入更改库存信息页面请输入3");
		System.out.println("进入删除库存信息页面请输入4");
		System.out.println("返回上一级请输入quit");
		String adminChange = adminInput.nextLine();
		System.out.println(adminChange);
		if(adminChange.equals("1")){
			AdminStockquery adminStockquery = new AdminStockquery();
			adminStockquery.adminStockquery();
		}else if(adminChange.equals("2")){
			AdminStockadd adminStockadd = new AdminStockadd();
			adminStockadd.adminStockadd();
		}else if(adminChange.equals("3")){
			AdminStockchange adminStockchange = new AdminStockchange();
			adminStockchange.adminStockchange();
		}else if(adminChange.equals("4")){
			AdminStockdelete adminStockdelete = new AdminStockdelete();
			adminStockdelete.adminStockdelete();
		}else if(adminChange.equals("quit")){
			AdminIstraion adminIstraion = new AdminIstraion();
			adminIstraion.adminIstraion();
		}else{
			System.err.println("请做出正确的输入！");
			adminStock();
		}
	}	
}
