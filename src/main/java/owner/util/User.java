package owner.util;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class User {
	private static final Logger logger = Logger.getLogger(Admindashboard.class.getName());

	public User() {
	}
	public String username;
	public String password;
	private UserType type;
	public static boolean t=false;
	public static boolean a=false;
	public static boolean o=false;
	public static boolean flage=true;
	static Scanner first;
	public User(String username, String password, UserType type) {
		this.username=username;
		this.password=password;
		this.type=type;
	}
	private static ArrayList<User> usersystem= new ArrayList<>();

	public boolean testuser;
	boolean flaga=true;
	boolean flago=false;
	boolean flagt=false;  
	public  boolean  login(String username1, String password1) {
		usersystem.add(new User("ahmad","789",UserType.ADMINISTRATOR));
		usersystem.add(new User("laila","123",UserType.TENANT));
		usersystem.add(new User("ali","123",UserType.TENANT));
		usersystem.add(new User("noor","123",UserType.TENANT));
		usersystem.add(new User("suha","123",UserType.TENANT));
		usersystem.add(new User("shahad","123456",UserType.OWNER));
        
		testuser= check(username1, password1);
		return testuser;
	}
	//h
	private static boolean check(String username, String password) {
		logger.info(username);
		for(User user1: usersystem) {
			if (user1.getUsername().equals(username) && user1.getPassword().equals(password)) {
				if(user1.getType().equals(UserType.ADMINISTRATOR)) {
	a=true;
					return true;
				}
				else if(user1.getType().equals(UserType.OWNER)) {
					o=true;

					return true;
				}
				else if(user1.getType().equals(UserType.TENANT)) {
			t=true;
					return true;
				}
			}
		}

		logger.info("Login failed, the password or username invalid");
		return false;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}}
