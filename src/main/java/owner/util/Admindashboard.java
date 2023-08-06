package owner.util;
import java.util.Scanner;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admindashboard {


	private static final Logger logger = Logger.getLogger(Admindashboard.class.getName());


	public Admindashboard() {
		logger.info("Welcome to Admin Dashboard");
	}

	boolean isLoggedIn = true;

	public void displayDashboard() {

		while (isLoggedIn) {
			logger.info("Welcome to Admin Dashboard Panel");
			logger.info("1 - Show pending Houses");
			logger.info("2 - Accept and Reject houses");
			logger.info("3 - Log Out");


			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();

			switch (choice) {
				case 1:
					viewRequests();
					break;
				case 2:
					acceptandreject();
					break;


				case 3:
					logger.info("Logged out successfully");
					isLoggedIn = false;
					break;

				default:
					logger.info("Invalid choice");
					displayDashboard();
					break;
			}}}



	private void acceptandreject() {
		Scanner scanner = new Scanner(System.in);

		if (Residences.getmHouses() == null) {
			logger.info("NO pending houses");
		} else {
			logger.info("enter a id for house to accept or reject it" );
		int id1 = scanner.nextInt();
		if(Residences.getId()==id1){
			logger.info("Choose action :1 for Accept \n 2 for Reject");
		if(takeAction(scanner.nextInt(),id1)==1) {
			logger.info("House accepted Successfully");
		}
		else {
			logger.info("House Rejected Successfully");
		}}
		else{
			logger.info("no id ");
		}
	}}

	public int takeAction(int nextInt, int id1) {
		if(nextInt !=1 && nextInt !=2)
			return 0;
		else if(nextInt==1) {
			Residences.getHouses().add(	Residences.getmHouses().get(--id1));
			Residences.getmHouses().remove(id1);
			return 1;

		}
		else {

			Residences.getmHouses().remove(--id1);
			return 2;
		}


	}

	public void viewRequests() {
		List<House> mhouses = Residences.getmHouses();
		logger.info("test");
		if (Residences.getmHouses() == null) {
			logger.info("NO pending houses");
		} else {
			int i = 1;
			for (House house : mhouses) {
				if (logger.isLoggable(Level.INFO)) {
					logger.info(String.format("%d - Name: %s, ID: %d, Location: %s, Description: %s",
							i++, house.getName(), house.getId(), house.getLocation(), house.getDescription()));
				}

			}
		}
	}

}