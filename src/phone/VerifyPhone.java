package phone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyPhone {
	public int verifyPhone(String phone){
		if(phone.equals("")){
			return 0;
		}else if(phone.length()!= 11){
			return 1;
		}else{
			String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(phone);
			boolean isMatch = m.matches();
			if(!isMatch){
				return 2;
			}else{
				return 3;
			}
		}
	}
}
