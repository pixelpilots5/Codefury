package exception;

public class BugAlreadyClosedException extends Exception {
 String msg;

public BugAlreadyClosedException() {
	super();
}

public BugAlreadyClosedException(String msg) {
	super();
	this.msg = msg;
}
 
}
