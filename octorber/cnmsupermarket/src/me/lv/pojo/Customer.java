package me.lv.pojo;

public class Customer {
	
	private int id;
	private String nickname;
	private String sex;
	private String email;
	private String phone;
	private int userLoginId;
	private UserLogin userLogin;

	

	public Customer() {
		// TODO Auto-generated constructor stub
	}


	public Customer(String nickname, String sex, String email, String phone, int userLoginId) {
		super();
		this.nickname = nickname;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.userLoginId = userLoginId;
	}


	public Customer(int id,String nickname, String sex, String email, String phone, int userLoginId) {
		super();
		this.id=id;
		this.nickname = nickname;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.userLoginId = userLoginId;
	}






	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(int userLoginId) {
		this.userLoginId = userLoginId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}
	@Override
	public String toString() {
		return "Customer [ nickname=" + nickname + ", sex=" + sex + ", email=" + email
				+ ", phone=" + phone + ", userLoginId=" + userLoginId + "]";
	}

}
