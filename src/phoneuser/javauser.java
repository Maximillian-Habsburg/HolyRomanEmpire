package phoneuser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Statement;


public class javauser {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("请输入用户名:");
		String username = userInput.nextLine();
		System.out.println(username);
		System.out.println("输入手机号:");
		Long phone = userInput.nextLong();
		System.out.println(phone);
		System.out.println("输入密码:");
		Long password = userInput.nextLong();
		System.out.println(password);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone","root","123456");
			String sql = "INSERT INTO USER(username,phone,PASSWORD)VALUE('"+username+"','"+phone+"','"+password+"')";
			//String sql="DELETE FROM USER WHERE username='zqm3'";
			//String sql="UPDATE USER SET PASSWORD='123'WHERE username='zqm1' AND phone='12345678910'";
			//String sql="SELECT * FROM USER";
			System.out.println(sql);
			Statement st =   (Statement) con.createStatement();
			int res = st.executeUpdate(sql);
			System.out.println(res);
			if(res ==1){
				System.out.println("成功");
			}else{
				System.out.println("失败");
			}
			//ResultSet res = st.executeQuery(sql);
			//System.out.println(res);
			//while(res.next()){
				/*System.out.println(res.getInt(1));
				System.out.println(res.getString(2));
				System.out.println(res.getString(3));*/
				//System.out.println("用户名:"+res.getString(2)+"\t\t手机号"+res.getString(3));
			//}
			/*res.next();
			System.out.println(res.getInt(1));
			System.out.println(res.getString(2));
			System.out.println(res.getString(3));
			System.out.println(res.getString(4));*/
			con.close();
		}catch (Exception e){
			e.printStackTrace();
		}
}

}
