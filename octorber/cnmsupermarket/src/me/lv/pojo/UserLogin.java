package me.lv.pojo;

public class UserLogin {
	private int id;
	private String username;
	private String password;

	public UserLogin() {
		super();
	}

	public UserLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public UserLogin(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLogin [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}
