package owner.util;
import java.util.List;

import java.util.Scanner;

import owner.util.House;

import java.util.ArrayList;

public class Tenant { 
  private String name;
  private String phoneNumber;
  private String bankCard;
  private String email;
  private String password;
  public static List<House> availableHouses;
  public List<House> HousesAfterRemove  = new ArrayList<>();;  
  private List<Furniture> advertisedFurniture;
  public int houseId;

  private List<House> ownedHouses;
   public static boolean tenancheck1 =false ;
  static Scanner scanner = new Scanner(System.in);
  List<House> availableHousesCopy = new ArrayList<>();
  public static boolean Remove ;
  public Tenant(String name, String phoneNumber, String bankCard, String email, String password) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.bankCard = bankCard;
    this.email = email;
    this.password = password;
    this.availableHouses = new ArrayList<>();
    this.advertisedFurniture = new ArrayList<>();
    this.ownedHouses = new ArrayList<>();
  }

  public Tenant() {
	// TODO Auto-generated constructor stub
}

public void updatePhoneNumber(String newPhoneNumber) {
    this.phoneNumber = newPhoneNumber;
  }

  public void updateBankCard(String newBankCard) {
    this.bankCard = newBankCard;
  }

  public void updateEmail(String newEmail) {
    this.email = newEmail;
  }

  public void updatePassword(String newPassword) {
    this.password = newPassword;
  }

  public void addHouse(House house, boolean rented) {
      house.setRented(rented);
      availableHouses.add(house);
      ownedHouses.add(house);
  }
  public void addAdvertisedFurniture(Furniture furniture) {
    advertisedFurniture.add(furniture);
  }

  public List<Furniture> getAdvertisedFurniture() {
    return advertisedFurniture;
  }

  public void addFurniture(Furniture furniture) {
    advertisedFurniture.add(furniture);
  }

  public boolean removeFurnitureByName(String name) {
    for (Furniture furniture : advertisedFurniture) {
      if (furniture.getName().equalsIgnoreCase(name)) {
        advertisedFurniture.remove(furniture);
        return true;
      }
    }
    return false;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getBankCard() {
    return bankCard;
  } 

  public void setBankCard(String bankCard) {
    this.bankCard = bankCard;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  public void viewOwnedHouses() {
      System.out.println("Owned Houses:");
      for (House house : ownedHouses) {
          System.out.println("House Name: " + house.getName());
          System.out.println("Description: " + house.getDescription());
          System.out.println("Price: " + house.getPrice());
          System.out.println("Location: " + house.getLocation());
          System.out.println("Services: " + house.getServices());
          System.out.println("-------------------------");
      }
  }
  public static void displayDashboard() {
    Tenant activeTenant = null; // Initialize activeTenant variable
    
    // Create multiple tenant instances to simulate different tenants logging in
    Tenant tenant1 = new Tenant("laila", "123456789", "1234 5678 3456", "laila@com", "123");

    tenant1.addHouse(new House(1,1, "house 1", "description", 2000, "nablus", "Services 1"), true);
    tenant1.addHouse(new House(2,1, "House 2", "description", 1500, "nablus", "Services 2"), false);
    tenant1.addHouse(new House(3,1, "House 3", "description", 1500, "nablus", "Services 3"), false);
    boolean isLoggedIn = true;
    tenancheck1=true;
    while (isLoggedIn) {
    

      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          activeTenant = tenant1; // Set the active tenant to tenant1 or tenant2
          if (activeTenant != null) {
            activeTenant.bookAccommodation();
          } else {
            System.out.println("Please log in to book accommodation.");
          }
          break;
        case 2:
          activeTenant = tenant1; // Set the active tenant to tenant1 or tenant2
          if (activeTenant != null) {
            activeTenant.showFurniture();
          } else {
            System.out.println("Please log in to view furniture.");
          }
          break;
        case 3:
          activeTenant = tenant1; // Set the active tenant to tenant1 or tenant2
          if (activeTenant != null) {
            activeTenant.viewProfile();
          } else {
            System.out.println("Please log in to view your profile.");
          }
          break;
        case 4:

          System.out.println("Logged out successfully");
          isLoggedIn = false;
          break;
        case 5:
            activeTenant.viewOwnedHouses(); // View owned houses added by the tenant
            break;
        default:
          System.out.println("Invalid choice!");
          break;
      }

      // After logging out, go back to the username and password page
//      if (!isLoggedIn) {
//        username.main(null);
//      }
    }
  }
  // Rest of the code...

  public void showFurniture() {
    System.out.println("Welcome to your furniture view...");
    System.out.println("1 - Showing advertised furniture");
    System.out.println("2 - Advertise furniture");
    System.out.println("3 - Go back to Dashboard menu");
    System.out.println("4 - Log out from the system");
    boolean isLoggedIn2 = true;

    while (isLoggedIn2) {
      try (Scanner scanner = new Scanner(System.in)) {
        int choice = scanner.nextInt();

        switch (choice) {
          case 1:
            showFurniture1();
            break;
          case 2:
            advertiseFurniture();
            break;
          case 3:
            // Go back to the main menu
            displayDashboard();
            break;
          case 4:
            // Log out
            System.out.println("Logged out successfully");
            isLoggedIn2=false;
            break;
          default:
            System.out.println("Invalid choice!");
            break;
        }
      }
    }
  }

  public void addRentedHouse(String houseName) {
    for (House house : availableHouses) {
      if (house.getName().equalsIgnoreCase(houseName)) {
        house.setRented(true);
        break;
      }
    }
  }

  public void showFurniture1() {

    System.out.println("Showing advertised furniture...");
    System.out.println("1 - Go back to Dashboard menu");
    for (Furniture furniture : advertisedFurniture) {
      System.out.println("Name: " + furniture.getName());
      System.out.println("Description: " + furniture.getDescription());
      System.out.println("Price: " + furniture.getPrice());
      System.out.println("-------------------------");
    }

    try (Scanner scanner = new Scanner(System.in)) {
      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          showFurniture();
          break;
        default:
          System.out.println("Invalid input");
          break;
      }
    }
  }
 public int checkbill(int numberOfMounth , int cost ) {
	 int rentAmount = cost * numberOfMounth;
	return rentAmount;
	 
 }
  public void advertiseFurniture() {
    Scanner scanner = new Scanner(System.in);
    scanner = new Scanner(System.in);

    System.out.println("Enter furniture details:");
    System.out.print("Name: ");
    String name = scanner.nextLine();

    System.out.print("Description: ");
    String description = scanner.nextLine();

    System.out.print("Price: ");
    double price = scanner.nextDouble();

    Furniture furniture = new Furniture(name, description, price);
    addFurniture(furniture);

    System.out.println("Furniture advertised successfully!");
    System.out.println("1 -Go back to Dashboard menu");
    System.out.println("2 - Add more advertised furniture");
    System.out.println("3 - Remove advertised furniture");
    int choice = scanner.nextInt();

    switch (choice) {
      case 1:
        showFurniture();
        break;
      case 2:
        advertiseFurniture();
        break;
      case 3:
        removeFurniture();
        break;
      default:
        System.out.println("Invalid input");
        break;
    }
  }

  public void removeFurniture() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the name of the furniture to remove:");
    String name = scanner.nextLine();

    boolean removed = removeFurnitureByName(name);
    if (removed) {
      System.out.println("Furniture removed successfully!");
    } else {
      System.out.println("Furniture not found!");
    }

    System.out.println("1 - Go back to Dashboard menu");
    System.out.println("2 - Add more advertised furniture");

    int choice = scanner.nextInt();

    switch (choice) {
      case 1:
        showFurniture();
        break;
      case 2:
        advertiseFurniture();
        break;
      default:
        System.out.println("Invalid input");
        break;
    }
  }

  public void bookAccommodation() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Booking accommodation...");

    System.out.println("Available houses:");
    int count = 1;

    for (Residences ss : Owner.ownedResidences) {
      for(House house : ss.getHouses())
      if (!house.isRented()) {
        System.out.println("House " + count);
        System.out.println("ID: " + house.getId());
        System.out.println("Name: " + house.getName());
        System.out.println("Description: " + house.getDescription());
        System.out.println("Price: " + house.getPrice());
        System.out.println("Location: " + house.getLocation());
        System.out.println("Services: " + house.getServices());
        System.out.println("-------------------------");
        count++;
        availableHousesCopy.add(house);
      }
    }
    if (availableHousesCopy.isEmpty()) {
      System.out.println("No available houses at the moment. Please check again later.");
      System.out.println("1 - Go to showFurniture");

      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          showFurniture();
          break;
        default:
          System.out.println("Invalid input");
          break;
      }
    }

    System.out.print("Enter the ID of the house you want to book: ");
    houseId = scanner.nextInt();

    House chosenHouse = homeRented(houseId);
//    for (House house : availableHousesCopy) {
//      if (house.getId() == houseId) {
//        chosenHouse = house;
//        break;
//      }
//    }
    
    
    if (chosenHouse == null) {
      System.out.println("Invalid house selection.");
      bookAccommodation();
      return;
    }

    scanner.nextLine(); // Consume newline character
    System.out.print("Enter your full name: ");
    String tenantName = scanner.nextLine();

    System.out.print("Enter the number of months to rent: ");
    int numMonths = scanner.nextInt();
    double rentAmount =checkbill( chosenHouse.getPrice(), numMonths);


    scanner.nextLine(); // Consume newline character
    System.out.print("Enter the payment method and details: ");
    String paymentMethod = scanner.nextLine();

    chosenHouse.setRented(true);

    System.out.println("Booking successful! You have booked the house:");
    System.out.println("House Name: " + chosenHouse.getName());
    System.out.println("Tenant Name: " + tenantName);
    System.out.println("Number of Months: " + numMonths);
    System.out.println("Rent Amount: " + rentAmount);
    System.out.println("Payment Method: " + paymentMethod);
    System.out.println("---------------------------------------------");
    System.out.println("---------------------------------------------");

    addRentedHouse(chosenHouse.getName());
    availableHouses.remove(chosenHouse);
    HousesAfterRemove=availableHouses;
     Remove = homeRemove(houseId);
    System.out.println("1 - Go back to bookAccommodation");
    System.out.println("2 - Go back to Dashboard menu");

    int choice = scanner.nextInt();

    switch (choice) {
      case 1:
        bookAccommodation();
        System.out.print("test");
        break;
      case 2:
        displayDashboard();
        break;
      default:
        System.out.println("Invalid input");
        break;
    }
  }

  public static String newPhoneNumber;
  public static String newBankCard;
  public static String newEmail;
  public static String newPassword;
  public boolean FlageUpdatePassword = false;
  public boolean FlageUpdatePhone = false;
  public boolean FlageUpdateBank = false;
  public boolean FlageUpdateEmail = false;

  public void viewProfile() {
    System.out.println("Viewing tenant profile...");
    System.out.println("Name: " + name);
    System.out.println("Phone Number: " + phoneNumber);
    System.out.println("Bank Card: " + bankCard);
    System.out.println("Email: " + email);
    System.out.println("Password: " + password);

    System.out.println("1 - Go back to Dashboard menu");
    System.out.println("2 - Edit Profile Information");
    int choice = scanner.nextInt();

    switch (choice) {
      case 1:
        displayDashboard();
        break;
      case 2:
        updateProfileInformation();
        break;
      default:
        System.out.println("Invalid input");
        break;
    }
  }
public static  int profileChoice;

  public int updateProfileInformation() {
    System.out.println("---------------------");
    System.out.println("1 - Update phone number");
    System.out.println("2 - Update bank card");
    System.out.println("3 - Update email");
    System.out.println("4 - Update password");

    profileChoice = scanner.nextInt();
    scanner.nextLine(); // Consume newline character

    switch (profileChoice) {
      case 1:
        System.out.print("Enter new phone number: ");
        newPhoneNumber = scanner.nextLine();
        updatePhoneNumber(newPhoneNumber);
        System.out.println("Phone number updated successfully!");
        FlageUpdatePhone = true;
        break;
      case 2:
        System.out.print("Enter new bank card: ");
        newBankCard = scanner.nextLine();
        updateBankCard(newBankCard);
        System.out.println("Bank card updated successfully!");
        FlageUpdateBank = true;
        break;
      case 3:
        System.out.print("Enter new email: ");
        newEmail = scanner.nextLine();
        updateEmail(newEmail);
        System.out.println("Email updated successfully!");
        FlageUpdateEmail = true;
        break;
      case 4:
        System.out.print("Enter new password: ");
        newPassword = scanner.nextLine();
        updatePassword(newPassword);
        System.out.println("Password updated successfully!");
        FlageUpdatePassword = true;
        break;
      default:
        System.out.println("Invalid choice!");
        break;
    }
    viewProfile();
    return profileChoice;
  }
public boolean homeRemove(int id) {
	
for (House house : HousesAfterRemove) {
	  System.out.print(house.getId()) ;
	  System.out.print(id) ;
	  System.out.println("") ;
    if (house.getId() == id)
     return false;
}
  	   return true;
  
}

  public House homeRented(int id) {
	  for (House house : availableHousesCopy) {
	      if (house.getId() == id) {
	        return house ;
	      }
	     }
	return null;
  }
	public List<House> getOwnedHouses() {
		return ownedHouses;
	}

	public void setOwnedHouses(List<House> ownedHouses) {
		this.ownedHouses = ownedHouses;
	}
  // Other methods and class definitions...
}
