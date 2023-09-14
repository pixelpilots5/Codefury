package exception;

public class NoProjectException extends Exception{

	public NoProjectException() {
		super();
	}

	public NoProjectException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoProjectException(String message) {
		super(message);
	}

	public NoProjectException(Throwable cause) {
		super(cause);
	}

}
