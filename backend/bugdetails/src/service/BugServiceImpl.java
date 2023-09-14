package service;

import entity.Bug;
import exception.BugAlreadyClosedException;
import exception.BugAlreadyExistsException;

public class BugServiceImpl implements BugService {

	@Override
	public void registerBug(Bug bug) throws BugAlreadyExistsException {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeBug(Bug bug) throws BugAlreadyClosedException {
		// TODO Auto-generated method stub

	}

	@Override
	public String viewBugStatus(int bugId) {
		// TODO Auto-generated method stub
		return null;
	}

}
