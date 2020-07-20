package phone;
import java.sql.Date;
public class Information {
	private String id;
	private String phonename;
	private String configure;
	private String price;
	private String ts;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhonename() {
		return phonename;
	}
	public void setPhonename(String phonename) {
		this.phonename = phonename;
	}
	public String getConfigure() {
		return configure;
	}
	public void setConfigure(String configure) {
		this.configure = configure;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTs() {
		return ts;
	}
	public void setTs(String ts) {
		this.ts = ts;
	}
}
