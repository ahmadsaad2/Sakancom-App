package owner.util;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Tenant {
  private static final Logger logger = Logger.getLogger(Admindashboard.class.getName());

  private String name;
  private String phoneNumber;
  private String bankCard;
  private String email;
  private String password;
  private static  Scanner inputscanner = new Scanner(System.in);
  public List<House> housesAfterRemove = new ArrayList<>();
  private List<Furniture> advertisedFurniture;
  private List<House> availableHouses;
  int count;
  private static final String PRICE_LABEL = "Price: ";
  private static final String DECRRIPTION_LABEL = "Description : ";
  private static final String LOCATION_LABEL = "location : ";
  private static final String NAME_LABEL = "Name : ";
  private static final String INVALID_LABEL= "Invalid choice!" ;
  private static final String GOBACK_LABEL= "1 - Go Back TO Dashboard" ;

  
  private static int choice;
  public static int houseId;

  private List<House> ownedHouses;
  public static boolean tenancheck1 = false;
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
	  name=null;
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
    logger.info("Owned Houses:");
    for (House house : ownedHouses) {
      logger.info("House Name: " + house.getName());
      logger.info(DECRRIPTION_LABEL + house.getDescription());
      logger.info(PRICE_LABEL + house.getPrice());
      logger.info( LOCATION_LABEL + house.getLocation());
      logger.info("Services: " + house.getServices());
      logger.info("-------------------------");
    }
  }
  public static void displayDashboard() {
	  logger.info("Welcome to Sakancom!");
		logger.info("1 - Available Housing & Book Accommodation");
		logger.info("2 - Show furniture");
		logger.info("3 - View Tenant Profile");
		logger.info("4 - Log Out");
    Tenant activeTenant = null; // Initialize activeTenant variable

    // Create multiple tenant instances to simulate different tenants logging in
    Tenant tenant1 = new Tenant("laila", "123456789", "1234 5678 3456", "laila@com", "123");

    tenant1.addHouse(new House(1,1, "house 1", DECRRIPTION_LABEL, 2000, "nablus", "Services 1"), true);
    tenant1.addHouse(new House(2,1, "House 2", DECRRIPTION_LABEL, 1500, "ramallah", "Services 2"), false);
    tenant1.addHouse(new House(3,1, "House 3", DECRRIPTION_LABEL, 1500, "jenin", "Services 3"), false);
    boolean isLoggedIn = true;
    tenancheck1=true;
    while (isLoggedIn) {


    	choice = inputscanner.nextInt();

      switch (choice) {
        case 1 -> {
          activeTenant = tenant1; // Set the active tenant to tenant1 or tenant2
          activeTenant.bookAccommodation();

        }
        case 2 -> {
          activeTenant = tenant1; // Set the active tenant to tenant1 or tenant2

          activeTenant.showFurniture();

        }
        case 3 -> {
          activeTenant = tenant1; // Set the active tenant to tenant1 or tenant2
          activeTenant.viewProfile();

        }
        case 4 -> {
          logger.info("Logged out successfully");
          isLoggedIn = false;
          break;
        }
        case 5 ->{
          if (activeTenant != null) {
            activeTenant.viewOwnedHouses(); // View owned houses added by the tenant
          } else {
            logger.info("Error: activeTenant is null.");
          }
        }
        default -> logger.info(INVALID_LABEL);
      }

    }
  }








  public void showFurniture() {
    logger.info("Welcome to your furniture view...");
    logger.info("1 - Showing advertised furniture");
    logger.info("2 - Advertise furniture");
    logger.info("3 - Go back to Dashboard menu");

    boolean isLoggedIn2 = true;

    while (isLoggedIn2) {
    	choice = inputscanner.nextInt(); // Use the existing scanner for input

      switch (choice) {
        case 1:
          showFurniture1();
          break;
        case 2:
          advertiseFurniture();
          break;
        case 3:
          isLoggedIn2 = false;
          break;
        default:
          logger.info(INVALID_LABEL);
          break;
      }
    }}






  public void addRentedHouse(String houseName) {
    for (House house : availableHouses) {
      if (house.getName().equalsIgnoreCase(houseName)) {
        house.setRented(true);
        break;
      }
    }
  }

  public void showFurniture1() {

    logger.info("Showing advertised furniture...");
    logger.info("1 - Go back to Dashboard menu");
    for (Furniture furniture : advertisedFurniture) {
      logger.info(NAME_LABEL + furniture.getName());
      logger.info(DECRRIPTION_LABEL+ furniture.getDescription());
      logger.info(PRICE_LABEL+ furniture.getPrice());
     
    }

 
       choice = inputscanner.nextInt();

      switch (choice) {
        case 1:
          showFurniture();
          break;
        default:
          logger.info(INVALID_LABEL);
          break;
      }
    }
  
  public int checkbill(int numberOfMounth , int cost ) {
    int rentAmount = cost * numberOfMounth;
    return rentAmount;

  }
  public void advertiseFurniture() {
    logger.info("Enter furniture details:");

    logger.info(NAME_LABEL);
    String furnitureName  = inputscanner.nextLine();

    logger.info(DECRRIPTION_LABEL);
    String description = inputscanner.nextLine();

    logger.info(PRICE_LABEL);
    double price = inputscanner.nextDouble();

    Furniture furniture = new Furniture(furnitureName , description, price);
    addFurniture(furniture);

    logger.info("Furniture advertised successfully!");
    logger.info(GOBACK_LABEL);
    logger.info("2 - Add more advertised furniture");
    logger.info("3 - Remove advertised furniture");
     choice = inputscanner.nextInt();

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
        logger.info(INVALID_LABEL);
        break;
    }
  }

  public void removeFurniture() {

    logger.info("Enter the name of the furniture to remove:");
    String furnitureName  = inputscanner.nextLine();

    boolean removed = removeFurnitureByName(furnitureName);
    if (removed) {
      logger.info("Furniture removed successfully!");
    } else {
      logger.info("Furniture not found!");
    }

    logger.info(GOBACK_LABEL);
    logger.info("2 - Add more advertised furniture");

     choice = inputscanner.nextInt();

    switch (choice) {
      case 1:
        showFurniture();
        break;
      case 2:
        advertiseFurniture();
        break;
      default:
        logger.info(INVALID_LABEL);
        break;
    }
  }

  public void bookAccommodation() {

    logger.info("Booking accommodation...");

    logger.info("Available houses:");
     count = 1;

    if (Owner.isOwnedResidencesEmpty()) {
      logger.info("No owned residences.");
      logger.info("1 - Go to showFurniture");

       choice = inputscanner.nextInt();

      switch (choice) {
        case 1:
          showFurniture();
          break;
        default:
          logger.info(INVALID_LABEL);
          break;
      }
    } else {
      logger.info("Owned residences are available.");


      for (Residences ss : Owner.ownedResidences) {
        for (House house : Residences.getHouses())
          if (!house.isRented()) {
            logger.info("House is:");

            logger.info("ID: " + house.getId());
            logger.info("Name: " + house.getName());
            logger.info(DECRRIPTION_LABEL + house.getDescription());
            logger.info(PRICE_LABEL + house.getPrice());
            logger.info(LOCATION_LABEL + house.getLocation());
            logger.info("Services: " + house.getServices());
            logger.info("-------------------------");
            count++;
            availableHousesCopy.add(house);
          }
      }
      if (availableHousesCopy.isEmpty()) {
        logger.info("No available houses at the moment. Please check again later.");
        logger.info("1 - Go to showFurniture");

         choice = inputscanner.nextInt();

        switch (choice) {
          case 1:
            showFurniture();
            break;
          default:
            logger.info(INVALID_LABEL);
            break;
        }
      }

      logger.info("Enter the ID of the house you want to book: ");
      houseId = inputscanner.nextInt();

      House chosenHouse = homeRented(houseId);


      if (chosenHouse == null) {
        logger.info("Invalid house selection.");
        bookAccommodation();
        return;
      }

      inputscanner.nextLine(); // Consume newline character
      logger.info("Enter your full name: ");
      String tenantName = inputscanner.nextLine();

      logger.info("Enter the number of months to rent: ");
      int numMonths = inputscanner.nextInt();
      double rentAmount = checkbill(chosenHouse.getPrice(), numMonths);


      inputscanner.nextLine(); // Consume newline character
      logger.info("Enter the payment method and details: ");
      String paymentMethod = inputscanner.nextLine();

      chosenHouse.setRented(true);


      logger.info("Booking successful! You have booked the house:");
      logger.info(() -> "House Name: " + chosenHouse.getName());
      logger.info(() -> "Tenant Name: " + tenantName);
      logger.info(() -> "Number of Months: " + numMonths);
      logger.info(() -> "Rent Amount: " + rentAmount);
      logger.info(() -> "Payment Method: " + paymentMethod);
      logger.info("---------------------------------------------");


      addRentedHouse(chosenHouse.getName());
      availableHouses.remove(chosenHouse);
      housesAfterRemove = availableHouses;
      Remove = homeRemove(houseId);
      logger.info("1 - Go back to bookAccommodation");
      logger.info("2 - Go back to Dashboard menu");

       choice = inputscanner.nextInt();

      switch (choice) {
        case 1:
          bookAccommodation();
          logger.info("test");
          break;
        case 2:
          displayDashboard();
          break;
        default:
          logger.info(INVALID_LABEL);
          break;
      }
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
    logger.info("Viewing tenant profile...");
    logger.info(() -> "Name: " + name);
    logger.info(() -> "Phone Number: " + phoneNumber);
    logger.info(() -> "Bank Card: " + bankCard);
    logger.info(() -> "Email: " + email);
    logger.info(() -> "Password: " + password);



    logger.info(GOBACK_LABEL);
    logger.info("2 - Edit Profile Information");
     choice = inputscanner.nextInt();

    switch (choice) {
      case 1:
        displayDashboard();
        break;
      case 2:
        updateProfileInformation();
        break;
      default:
        logger.info(INVALID_LABEL);
        break;
    }
  }
  public static  int profileChoice;

  public int updateProfileInformation() {
    logger.info("---------------------");
    logger.info("1 - Update phone number");
    logger.info("2 - Update bank card");
    logger.info("3 - Update email");
    logger.info("4 - Update password");

    profileChoice = inputscanner.nextInt();
    inputscanner.nextLine(); // Consume newline character

    switch (profileChoice) {
      case 1:
        logger.info("Enter new phone number: ");
        newPhoneNumber = inputscanner.nextLine();
        updatePhoneNumber(newPhoneNumber);
        logger.info("Phone number updated successfully!");
        FlageUpdatePhone = true;
        break;
      case 2:
        logger.info("Enter new bank card: ");
        newBankCard = inputscanner.nextLine();
        updateBankCard(newBankCard);
        logger.info("Bank card updated successfully!");
        FlageUpdateBank = true;
        break;
      case 3:
        logger.info("Enter new email: ");
        newEmail = inputscanner.nextLine();
        updateEmail(newEmail);
        logger.info("Email updated successfully!");
        FlageUpdateEmail = true;
        break;
      case 4:
        logger.info("Enter new password: ");
        newPassword = inputscanner.nextLine();
        updatePassword(newPassword);
        logger.info("Password updated successfully!");
        FlageUpdatePassword = true;
        break;
      default:
        logger.info(INVALID_LABEL);
        break;
    }
    viewProfile();
    return profileChoice;
  }
  public boolean homeRemove(int id) {

    for (House house : housesAfterRemove) {

      logger.info(() -> String.valueOf(house.getId()));
      logger.info(() -> String.valueOf(id));
      logger.info(() -> "");
      if (house.getId() == id){
        logger.info("Method invoked because the condition is met.");

        return false;}
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
