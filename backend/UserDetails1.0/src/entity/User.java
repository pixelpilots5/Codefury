package entity;

public class User {

	private int userId;
	private String userName,email,password,title;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String userName, String email, String password, String title) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.title = title;
	}
	@Override
	public String toString() {
		return "User "
				+ "{userId=" + userId + ", "
						+ "userName=" + userName + ", "
								+ "email=" + email + ","
										+ " password=" + password+ ", "
				+ "title=" + title + "}";
	}
	
	
	
	
	
}
