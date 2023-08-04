package owner.util;
import owner.util.*;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
	public User() {		
	} 
public String username;
public String password;
private UserType type;
  public static boolean t=false;
  public static boolean a=false;
  public static boolean o=false;
  public static boolean flage=true;
   
public User(String username, String password, UserType type) {
this.username=username;
this.password=password;
this.type=type;
}
private static ArrayList<User> user= new ArrayList<>();
private Scanner first;
//public static boolean testAdmin =false ;
//public static boolean testOwner =false ;
//public static boolean testTenant =false ;
public static boolean testuser;
boolean flaga=true;
boolean flago=false;
boolean flagt=false;
public  boolean  login(String username1, String password1) {
	user.add(new User("ahmad","789",UserType.AdminStrator));
	user.add(new User("laila","123",UserType.Tenant));
	user.add(new User("ali","123",UserType.Tenant));
	user.add(new User("noor","123",UserType.Tenant));
	user.add(new User("suha","123",UserType.Tenant));
	user.add(new User("shahad","123456",UserType.Owner));

 testuser= check(username1, password1);
 if(testuser){
	 return true;
 } 
 return false;
}

private static boolean check(String username, String password) {
	System.out.println(username);
	for(User user1: user) {
		if (user1.getUsername().equals(username) && user1.getPassword().equals(password)) {
			if(user1.getType().equals(UserType.AdminStrator)) {
				 Admindashboard adminDashboard = new Admindashboard();
		         adminDashboard.displayDashboard();
		
             return true;
         }
			else if(user1.getType().equals(UserType.Owner)) {
				    Owner owner = new Owner(username, 1 , username, password);
				    
            	    Residences residence1 = new Residences(1, username, " nabblus", 2, 4, "Services ");
            	    House house1 = new House(1, 1, "House 1", "Description 1", 2000, "street-98", "have balcony");
                    House house2 = new House(2, 1, "House 2", "Description 2", 1500, "street-17", "sensative flam");
            	  	
                    residence1.addHouse(house1);
                    residence1.addHouse(house2);
            	    owner.addResidence(residence1);
            	    OwnerDashboard ownerDashboard = new OwnerDashboard(owner);
            	    ownerDashboard.displayDashboard();
				
	             return true;
	         }
			else if(user1.getType().equals(UserType.Tenant)) {
				  System.out.println("Welcome to Sakancom!");
			      System.out.println("1 - Available Housing & Book Accommodation");
			      System.out.println("2 - Show furniture");
			      System.out.println("3 - View Tenant Profile");
			      System.out.println("4 - Log Out");
		         Tenant.displayDashboard();
	             return true;
	         }
		}		
   }

	 System.out.println("Login failed, the password or username invalid");
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
