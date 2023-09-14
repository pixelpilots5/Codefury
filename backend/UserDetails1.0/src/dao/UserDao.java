package dao;

import java.util.List;

import entity.User;
import exception.UserAlreadyExsistException;

public interface UserDao {
    void addUser(User user)throws UserAlreadyExsistException ;
    User getUserById(int userId);
    List<User> getUsersByTitle(String title);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    void deleteUser(int userId);
    void updateUser(User user);
}


//User u=new User();
//u.setUserId(resultSet.getInt("userId"));
//u.setEmail(resultSet.getString("email"));
//u.setUserName(resultSet.getString("userName"));
//u.setTitle(resultSet.getString("title"));
//
//return u;