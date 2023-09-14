package view;

import java.util.Scanner;
import entity.User;
import exception.UserAlreadyExsistException;
import exception.UserNotFoundException;
import service.UserService;
import service.UserServiceImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import java.util.List;


public class TestMain {
	
	public static void main(String[] args) {
		
		

	
		        Scanner scanner = new Scanner(System.in);
		        boolean exit = false;

		        // Assuming you have already initialized the UserDao and UserService
		        UserDao userDao = new UserDaoImpl();
		        UserService userService = new UserServiceImpl(userDao);


		        while (!exit) {
		            System.out.println("Options:");
		            System.out.println("1. Add User");
		            System.out.println("2. Get User by ID");
		            System.out.println("3. Get Users by Title");
		            System.out.println("4. Get User by Email");
		            System.out.println("5. Get All Users");
		            System.out.println("6. Delete User");
		            System.out.println("7. Update User");
		            System.out.println("8. Exit");

		            System.out.print("Enter your choice: ");
		            int choice = scanner.nextInt();
		            scanner.nextLine(); // Consume newline

		            switch (choice) {
		                case 1:
		                    // Add User
		                    User newUser = new User();
		                    System.out.print("Enter User ID: ");
		                    newUser.setUserId(scanner.nextInt());
		                    scanner.nextLine(); // Consume newline
		                    System.out.print("Enter Username: ");
		                    newUser.setUserName(scanner.nextLine());
		                    System.out.print("Enter Email: ");
		                    newUser.setEmail(scanner.nextLine());
		                    System.out.print("Enter Password: ");
		                    newUser.setPassword(scanner.nextLine());
		                    System.out.print("Enter Title: \n Manager \n Developer \n Tester");
		                    newUser.setTitle(scanner.nextLine());

		                    try {
		                        userService.addUser(newUser);
		                        System.out.println("User added successfully.");
		                    } catch (UserAlreadyExsistException e) {
		                        System.out.println(e.getMessage());
		                    }
		                    break;
		                    
		                    
		                case 2:
		                    // Get User by ID
		                    System.out.print("Enter User ID: ");
		                    int userId = scanner.nextInt();
		                    try {
		                        User user = userService.getUserById(userId);
		                        if (user != null) {
		                            System.out.println("User found: " + user);
		                        } else {
		                            System.out.println("User not found with ID: " + userId);
		                        }
		                    } catch (UserNotFoundException e) {
		                        System.out.println(e.getMessage());
		                    }
		                    break;
		                    
		                    
		                    
		                case 3:
		                    // Get Users by Title
		                    System.out.print("Enter Title: \n Manager \n Developer \n Tester");
		                    String title = scanner.nextLine();
		                    try {
		                        List<User> usersByTitle = userService.getUsersByTitle(title);
		                        if (!usersByTitle.isEmpty()) {
		                            System.out.println("Users with title " + title + ":");
		                            for (User user : usersByTitle) {
		                                System.out.println(user);
		                            }
		                        } else {
		                            System.out.println("No users found with title: " + title);
		                        }
		                    } catch (UserNotFoundException e) {
		                        System.out.println(e.getMessage());
		                    }
		                    break;
		                    
		                    
		                    
		                case 4:
		                    // Get User by Email
		                    System.out.print("Enter Email: ");
		                    String email = scanner.nextLine();
		                    try {
		                        User user = userService.getUserByEmail(email);
		                        if (user != null) {
		                            System.out.println("User found: " + user);
		                        } else {
		                            System.out.println("User not found with email: " + email);
		                        }
		                    } catch (UserNotFoundException e) {
		                        System.out.println(e.getMessage());
		                    }
		                    break;
		                    
		                    
		                    
		                case 5:
		                    // Get All Users
		                    try {
		                        List<User> allUsers = userService.getAllUsers();
		                        if (!allUsers.isEmpty()) {
		                            System.out.println("All Users:");
		                            for (User user : allUsers) {
		                                System.out.println(user);
		                            }
		                        } else {
		                            System.out.println("No users found.");
		                        }
		                    } catch (UserNotFoundException e) {
		                        System.out.println(e.getMessage());
		                    }
		                    break;
		                    
		                    
		                    
		                case 6:
		                    // Delete User
		                    System.out.print("Enter User ID to delete: ");
		                    int userIdToDelete = scanner.nextInt();
		                    try {
		                        userService.deleteUser(userIdToDelete);
		                        System.out.println("User with ID " + userIdToDelete + " deleted successfully.");
		                    } catch (UserNotFoundException e) {
		                        System.out.println(e.getMessage());
		                    }
		                    break;
		                    
		                    
		                    
		                case 7:
		                    // Update User
		                    User updatedUser = new User();
		                    System.out.print("Enter User ID to update: ");
		                    updatedUser.setUserId(scanner.nextInt());
		                    scanner.nextLine(); // Consume newline
		                    System.out.print("Enter Updated Username: ");
		                    updatedUser.setUserName(scanner.nextLine());
		                    System.out.print("Enter Updated Email: ");
		                    updatedUser.setEmail(scanner.nextLine());
		                    System.out.print("Enter Updated Password: ");
		                    updatedUser.setPassword(scanner.nextLine());
		                    System.out.print("Enter Updated Title: \n Manager \n Developer \n Tester");
		                    updatedUser.setTitle(scanner.nextLine());

		                    try {
		                        userService.updateUser(updatedUser);
		                        System.out.println("User updated successfully.");
		                    } catch (UserNotFoundException e) {
		                        System.out.println(e.getMessage());
		                    }
		                    break;
		                    
		                    
		                    
		                case 8:
		                    // Exit
		                    exit = true;
		                    break;
		                default:
		                    System.out.println("Invalid choice. Please try again.");
		                    break;
		            }
		        }

		        System.out.println("Goodbye!");
		        scanner.close();
		    }
		}

