package phone;

public class VerifyPrice {
	public int verifyPrice(String price){
		if(price.equals("")){
			return 0;
		}
		if(price.length()<3 || price.length()>5){
			return 1;
		}
		return 2;
	}
}
