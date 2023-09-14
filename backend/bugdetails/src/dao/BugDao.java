package dao;

import entity.Bug;
import exception.BugAlreadyClosedException;
import exception.BugAlreadyExistsException;

public interface BugDao {
	void registerBug(Bug bug) throws BugAlreadyExistsException;
	void closeBug(Bug bug) throws BugAlreadyClosedException;
	String viewBugStatus(int bugId);
}
