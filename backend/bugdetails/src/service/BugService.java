package service;

import entity.Bug;
import exception.BugAlreadyClosedException;
import exception.BugAlreadyExistsException;

public interface BugService {
	void registerBug(Bug bug) throws BugAlreadyExistsException;
	void closeBug(Bug bug) throws BugAlreadyClosedException;
	String viewBugStatus(int bugId);
}
