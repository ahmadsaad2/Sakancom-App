package owner.util;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class Username  {
    static Scanner first = new Scanner(System.in);
    static String username , pass;
    private static final Logger logger = Logger.getLogger(Username .class.getName());
    private static ArrayList<User> usersystem= new ArrayList<>();

    public static void main(String[] args) {
    	
        while (true) {
        	usersystem.add(new User("ahmad","789",UserType.ADMINISTRATOR));
    		usersystem.add(new User("laila","123",UserType.TENANT));
    		usersystem.add(new User("ali","123",UserType.TENANT));
    		usersystem.add(new User("noor","123",UserType.TENANT));
    		usersystem.add(new User("suha","123",UserType.TENANT));
    		usersystem.add(new User("shahad","123456",UserType.OWNER));
    		
            User us = new User();
            logger.info("Enter username: ");
             username = first.nextLine();

            logger.info("Enter password: ");
            pass = first.nextLine();
            us.login(username, pass);
            for(User user1: usersystem) {
    			if ( user1.login(username,pass)==true) {
    				if(User.a){
    					Admindashboard adminDashboard = new Admindashboard();
    					adminDashboard.displayDashboard();

    					
    				}
    				else if(User.o) {
    					Owner owner = new Owner(username, 1 ,username, pass);

    					Residences residence1 = new Residences(1, user1.username, " nabblus", 2, 4, "Services ");
    					House house1 = new House(1, 1, "House 1", "Description 1", 2000, "street-98", "have balcony");
    					House house2 = new House(2, 1, "House 2", "Description 2", 1500, "street-17", "sensative flam");

    					residence1.addHouse(house1);
    					residence1.addHouse(house2);
    					owner.addResidence(residence1);
    					OwnerDashboard ownerDashboard = new OwnerDashboard(owner);
    					ownerDashboard.displayDashboard();

    				}
    				else if(User.t) {
    			
    					Tenant.displayDashboard();
    				
    				}
    			}
    			break;
            }
            logger.info("Do you want to continue? (yes/no): ");
            String answer = first.nextLine().toLowerCase();
            if (answer.equals("no")) {
                break;
            }
            
    			}
    			}
            }
        
 
