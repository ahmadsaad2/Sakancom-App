package owner.util;
import java.util.Scanner;
import java.util.*;
public class Admindashboard {





	public Admindashboard() {
	}

	boolean isLoggedIn = true;

	public void displayDashboard() {
		while (isLoggedIn) {
			System.out.println("Welcome to Admin Dashboard Panel");
			System.out.println("1 - Show pending Houses");
			System.out.println("2 - Accept and Reject houses");
			System.out.println("3 - Log Out");


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
					System.out.println("Logged out successfully");
					isLoggedIn = false;
					break;

				default:
					System.out.println("Invalid choice");
					displayDashboard();
					break;
			}}}



	private void acceptandreject() {
		Scanner scanner = new Scanner(System.in);

		if (Residences.getmHouses() == null) {
			System.out.println("NO pending houses");
		} else {
		System.out.print("enter a id for house to accept or reject it" );
		int id1 = scanner.nextInt();
		if(Residences.getId()==id1){
		System.out.print("Choose action :1 for Accept \n 2 for Reject");
		if(takeAction(scanner.nextInt(),id1)==1) {
			System.out.print("House accepted Successfully");
		}
		else {
			System.out.println("House Rejected Successfully");
		}}
		else{
			System.out.println("no id ");
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
		System.out.print("test");
		if (Residences.getmHouses() == null) {
			System.out.println("NO pending houses");
		} else {
			int i = 1;
			for (House house : mhouses) {
				System.out.println(i++ + " - Name: " + house.getName() + ", ID: " + house.getId() + ", Location: " + house.getLocation() + ", Description: " + house.getDescription());
			}
		}
	}

}