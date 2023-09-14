package exception;

public class ProjectAlreadyExistsException extends Exception{

	public ProjectAlreadyExistsException() {
		super();
	}

	public ProjectAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProjectAlreadyExistsException(String message) {
		super(message);
	}

	public ProjectAlreadyExistsException(Throwable cause) {
		super(cause);
	}

}
