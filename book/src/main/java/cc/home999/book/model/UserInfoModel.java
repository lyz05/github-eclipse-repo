package cc.home999.book.model;

public class UserInfoModel {
	private String username = null;
	private String readername = null;
	private String role = null;
	
	public UserInfoModel() {
		super();
	}
	public UserInfoModel(String username, String readername,String role) {
		super();
		this.username = username;
		this.readername = readername;
		this.role = role;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
