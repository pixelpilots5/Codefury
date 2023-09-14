package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import exception.UserAlreadyExsistException;

public class UserDaoImpl implements UserDao{
	
	
	String url="jdbc:mysql://localhost:3306/user";//table ---> person 
	String username="root";
	String password="0405";
	
	
	
	@Override
	public void addUser(User user) throws UserAlreadyExsistException {
		// TODO Auto-generated method stub
	    if (getUserById(user.getUserId()) != null) {
	        // You can throw a custom exception or handle this situation as needed
	        // For example, you can throw a UserAlreadyExistsException
	        throw new UserAlreadyExsistException("User with the same Id already exists.");
	    }
		
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		 String sql = "INSERT INTO user (userId, userName, email, paswd, title) VALUES (?, ?, ?, ?, ?)";
		    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
		        preparedStatement.setInt(1, user.getUserId());
		        preparedStatement.setString(2, user.getUserName());
		        preparedStatement.setString(3, user.getEmail());
		        preparedStatement.setString(4, user.getPassword());
		        preparedStatement.setString(5, user.getTitle());
		        preparedStatement.executeUpdate();
		    } }
		catch (SQLException e) {
		        e.printStackTrace();
		    }
	
	
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		 String sql = "SELECT * FROM user WHERE userId = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setInt(1, userId);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            if (resultSet.next()) {

	                if (resultSet.next()) {
	                    return extractUserFromResultSet(resultSet);
	                }
	                
	            }
	        } }catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
		
	}

	@Override
	public List<User> getUsersByTitle(String title) {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		 String sql = "SELECT * FROM user WHERE title = ?";
	        
	        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setString(1, title);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                users.add(extractUserFromResultSet(resultSet));
	            }
	        } }catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
		
		
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		String sql = "SELECT * FROM user WHERE email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return extractUserFromResultSet(resultSet);
            }
        }} catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		 String sql = "SELECT * FROM user";
	        List<User> users = new ArrayList<>();
	        try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                users.add(extractUserFromResultSet(resultSet));
	            }
	        } }catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
		}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		 String sql = "DELETE FROM user WHERE userId = ?";
		 try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setInt(1, userId);
	            preparedStatement.executeUpdate();
	        } }catch (SQLException e) {
	            e.printStackTrace();
	        }
	
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
		String sql = "UPDATE user SET userName = ?, email = ?, paswd = ?, title = ? WHERE userId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getTitle());
            preparedStatement.setInt(5, user.getUserId());
            preparedStatement.executeUpdate();
        } }catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
	
	
	private User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getInt("userId"));
        user.setUserName(resultSet.getString("userName"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("paswd"));
        user.setTitle(resultSet.getString("title"));
        return user;
    }	
	

}
