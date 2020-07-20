package phone;

public class VerifyPassword {
	public int verifyPassword(String password){
		if(password.equals("")){
			return 0;
		}
		if(password.length()<6 || password.length()>16){
			return 1;
		}
		return 2;
	}
}
