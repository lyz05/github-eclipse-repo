package cc.home999.book.model;

import javax.validation.constraints.NotNull;

public class AlterPasswordModel {

	@NotNull
	private String username;
	@NotNull
	private String pwd;
	@NotNull
	private String newpwd;
	@NotNull
	private String newpwd2;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getNewpwd2() {
		return newpwd2;
	}
	public void setNewpwd2(String newpwd2) {
		this.newpwd2 = newpwd2;
	}
	
	/**
	 * 判断两次输入的新密码是否一致
	 * @return
	 */
	public boolean confirmnewpwd() {
		return newpwd.equals(newpwd2);
	}
	
	/**
	 * 判断旧密码与新密码是否不同
	 * @return
	 */
	public boolean confirmoldandnewpwd() {
		return !newpwd.equals(pwd);
	}
}
