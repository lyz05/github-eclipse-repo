package cc.home999.book.bean;

import javax.validation.constraints.NotNull;

public class User {

    @NotNull
    private String username;

    @NotNull
    private String password;

    private String role;

    @NotNull
    private String locale;

    public User() {
		super();
	}

	public User(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public boolean hasRole(String role) {
        return this.role.equals(role);
    }
}