package exception;

public class BugAlreadyExistsException extends Exception {
String msg;

public BugAlreadyExistsException() {
	super();
}

public BugAlreadyExistsException(String msg) {
	super();
	this.msg = msg;
}

}
