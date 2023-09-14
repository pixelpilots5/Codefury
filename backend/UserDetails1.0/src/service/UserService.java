package service;
import java.util.List;

import entity.User;
import exception.UserAlreadyExsistException;
import exception.UserNotFoundException;


public interface UserService {
	
	    void addUser(User user) throws UserAlreadyExsistException;
	    User getUserById(int userId) throws UserNotFoundException;
	    List<User> getUsersByTitle(String title)throws UserNotFoundException;
	    User getUserByEmail(String email)throws UserNotFoundException;
	    List<User> getAllUsers()throws UserNotFoundException;
	    void deleteUser(int userId)throws UserNotFoundException;
	    void updateUser(User user)throws UserNotFoundException;
}

	

