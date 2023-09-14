package service;

import java.util.List;

import dao.UserDao;
import entity.User;
import exception.UserAlreadyExsistException;
import exception.UserNotFoundException;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	 public UserServiceImpl(UserDao userDao) {
	        this.userDao = userDao;
	    }

	@Override
	public void addUser(User user) throws UserAlreadyExsistException {
		// TODO Auto-generated method stub
        try {
            userDao.addUser(user);
        } catch (UserAlreadyExsistException e) {
            throw e;
        }

	}

	@Override
	public User getUserById(int userId) throws UserNotFoundException {
		
		 User user = userDao.getUserById(userId);
	        if (user == null) {
	            throw new UserNotFoundException("User not found with ID: " + userId);
	        }
	        return user;
	}

	@Override
	public List<User> getUsersByTitle(String title) throws UserNotFoundException {
		
        List<User> users = userDao.getUsersByTitle(title);
        if (users.isEmpty()) {
            throw new UserNotFoundException("No users found with title: " + title);
        }
        return users;
	}

	@Override
	public User getUserByEmail(String email) throws UserNotFoundException {
        User user = userDao.getUserByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("User not found with email: " + email);
        }
        return user;
	}

	@Override
	public List<User> getAllUsers() throws UserNotFoundException {
        List<User> users = userDao.getAllUsers();
        if (users.isEmpty()) {
            throw new UserNotFoundException("No users found.");
        }
        return users;
	}

	@Override
	public void deleteUser(int userId) throws UserNotFoundException {
        User user = userDao.getUserById(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found with ID: " + userId);
        }
        userDao.deleteUser(userId);
	}

	@Override
	public void updateUser(User user) throws UserNotFoundException {
		// TODO Auto-generated method stub
        User existingUser = userDao.getUserById(user.getUserId());
        if (existingUser == null) {
            throw new UserNotFoundException("User not found with ID: " + user.getUserId());
        }
        userDao.updateUser(user);

	}

}
