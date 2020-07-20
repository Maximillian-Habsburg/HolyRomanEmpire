package phone;

import java.util.Scanner;

public class Useroption {
	public void useroption(){
		Scanner userInput = new Scanner(System.in);
		System.out.println("查看商品请输入1");
		System.out.println("查看订单请输入2");
		System.out.println("添加订单请输入3");
		System.out.println("更改订单请输入4");
		System.out.println("删除订单请输入5");
		System.out.println("返回上一级请输入quit");
		String userChange = userInput.nextLine();
		System.out.println(userChange);
		if(userChange.equals("1")){
			UserCommodity userCommodity = new UserCommodity();
			userCommodity.userCommodity();
		}else if(userChange.equals("2")){
			UserOrderquery userOrderquery = new UserOrderquery();
			userOrderquery.userOrderquery();
		}else if(userChange.equals("3")){
			UserOrderadd userOrderadd = new UserOrderadd();
			userOrderadd.userOrderadd();
		}else if(userChange.equals("4")){
			UserOrderchange userOrderchange = new UserOrderchange();
			userOrderchange.userOrderchange();
		}else if(userChange.equals("5")){
			UserOrderdelete userOrderdelete = new UserOrderdelete();
			userOrderdelete.userOrderdelete();
		}else if(userChange.equals("quit")){
			UserLogin userLogin = new UserLogin();
			userLogin.userLogin();
		}else{
			System.err.println("请做出正确的输入！");
			useroption();
		}
	}
}
