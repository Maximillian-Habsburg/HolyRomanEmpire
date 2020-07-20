package phone;

import java.util.Scanner;

public class AdminInformation {

	public void adminInformation() {
		Scanner adminInput = new Scanner(System.in);
		System.out.println("查询操作请输入1");
		System.out.println("添加操作请输入2");
		System.out.println("更改操作请输入3");
		System.out.println("删除操作请输入4");
		System.out.println("返回上一级请输入quit");
		String adminChange = adminInput.nextLine();
		System.out.println(adminChange);
		if(adminChange.equals("1")){
			AdminInformationquery adminInformationquery = new AdminInformationquery();
			adminInformationquery.adminInformationquery();
		}else if(adminChange.equals("2")){
			AdminInformationadd adminInformationadd = new AdminInformationadd();
			adminInformationadd.adminInformationadd();
		}else if(adminChange.equals("3")){
			AdminInformationchange adminInformationchange = new AdminInformationchange();
			adminInformationchange.adminInformationchange();
		}else if(adminChange.equals("4")){
			AdminInformationdelete adminInformationdelete = new AdminInformationdelete();
			adminInformationdelete.adminInformationdelete();
		}else if(adminChange.equals("quit")){
			//进入初始界面
			AdminIstraion adminIstraion = new AdminIstraion();
			adminIstraion.adminIstraion();
		}else{
			System.err.println("请做出正确的输入！");
			adminInformation();
		}
		
	}

}
