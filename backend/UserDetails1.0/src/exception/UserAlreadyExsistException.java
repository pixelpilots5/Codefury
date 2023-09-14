package exception;

public class UserAlreadyExsistException extends Exception {
	
	String msg;

	public UserAlreadyExsistException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public UserAlreadyExsistException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
