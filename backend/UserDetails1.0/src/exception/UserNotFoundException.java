package exception;

public class UserNotFoundException extends Exception {
	String msg;

	public UserNotFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public UserNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
