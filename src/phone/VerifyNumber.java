package phone;

public class VerifyNumber {
	public int verifyNumber(String number){
		if(number.equals("")){
			return 0;
		}
		if(number.length()>2){
			return 1;
		}
		return 2;
	}
}
