package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class AdminInformationquery {

	public void adminInformationquery() {
		Scanner adminInput = new Scanner(System.in);
		Information information = new Information();
		System.out.println("��ӭ�����ѯҳ�棡");
		System.out.println("�����������ַ����в鿴");
		information.setPhonename(adminInput.nextLine().trim());
		while(information.getPhonename().equals("")){
			System.err.println("���������ϢΪ�����������룡");
			information.setPhonename(adminInput.nextLine().trim());
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone","root","123456");
			Statement ps = (Statement) con.createStatement();
			ResultSet res = ps.executeQuery("SELECT * FROM INFORMATION");
			if(res.next()){
				System.out.println("��ѯ�ɹ�����Ϣ����");
				System.out.println("�豸��ţ�"+res.getInt("id")+"\t�ֻ����ƣ�"+res.getString("phonename")+"\t������Ϣ��"+res.getString("configure")+"\t�۸���Ϣ��"+res.getString("price")+"\t����ʱ�䣺"+res.getString("ts"));
			}else{
				System.out.println("��ѯʧ�ܣ�������һ��");
				AdminInformation adminInformation = new AdminInformation();
				adminInformation.adminInformation();
			}
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
