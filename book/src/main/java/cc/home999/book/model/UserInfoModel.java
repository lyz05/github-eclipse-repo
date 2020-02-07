package cc.home999.book.model;

public class UserInfoModel {
	private String username;
	private String readername;
	
	public UserInfoModel() {
		super();
	}
	public UserInfoModel(String username, String readername) {
		super();
		this.username = username;
		this.readername = readername;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getReadername() {
		return readername;
	}
	public void setReadername(String readername) {
		this.readername = readername;
	}
	
}
