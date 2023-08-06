package owner.util;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class OwnerDashboard {
    private static final Logger logger = Logger.getLogger(Admindashboard.class.getName());


    private Owner owner;
    private List<Residences> ownedResidences;
    Scanner scanner = new Scanner(System.in);
    private List<String> saveDataToArrayList;
    private List<String> loadDataFromArrayList;
    public OwnerDashboard() {
    	
    	}

    public OwnerDashboard(Owner owner) {
        this.owner = owner;
        this.ownedResidences = owner.getOwnedResidences();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
	public void addResidences(int id, String ownerInfo, String location, int floor, int housePerFloor, String availableServices) {
        Residences newResidence = new Residences(id, ownerInfo, location, floor, housePerFloor, availableServices);
        owner.addResidence(newResidence);
    }
    

        
        
  
    public void addHouseToResidence(int residenceId, String name, String description, int price, String houseLocation, String services) {
        Residences selectedResidence = null;

        // Find the residence with the given ID
        for (Residences residence : ownedResidences) {
            if (residence.getId() == residenceId) {
                selectedResidence = residence;
                break;
            }
        }

        if (selectedResidence == null) {
            logger.info("Residence with ID " + residenceId + " not found.");
            return;
        }

        House newHouse = new House(residenceId, price, name, description, price, houseLocation, services);
        Tenant.availableHouses.add(newHouse);
        selectedResidence.addHouse(newHouse);
        logger.info("House added to the residence successfully!");
    }
    
   public Residences fun() {
	  	Residences residence1 = new Residences(1, "Owner Info 1", "Location 1", 2, 4, "Services 1");

        // Add a house to residence1
        House house1 = new House(6, 1, "House 1", "Description 1", 2000, "street-98", "have balcony");
        House house2 = new House(2, 1, "House 2", "Description 2", 1500, "street-17", "sensative flam");
	  	
        residence1.addHouse(house1);
        residence1.addHouse(house2);
		return residence1;
   }

    boolean isLoggedIn = true;
    public void displayDashboard() {
//    	Owner owner = new Owner("Shahad", 1, "shahad", "123");
    	fun();
    	while (isLoggedIn) {
        logger.info("Welcome to Housing Owner's Control Panel");
        logger.info("1 - View My Residences");
        logger.info("2 - Add a New Residence");
        logger.info("3 - Add a House to Residence");
        logger.info("4 - Log Out");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                viewMyResidences();
                break;
            case 2:
            	addresidence();
break;
             

            case 3:
                addHouseToResidence();

                break;

         

            case 4:  
            
            
        logger.info("Logged out successfully");
        isLoggedIn = false;
                break;
            default:
                logger.info("Invalid choice!");
                displayDashboard();
                break;
        }
      
    }
    }
    

	private void addHouseToResidence() {
   	

    	
    	
    	logger.info("Please provide the ID of the residence to which you want to add a house:");
        int residenceIdToAddHouse = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Check if the residence with the given ID exists
        boolean residenceExists = false;
        for (Residences residence : ownedResidences) {
            if (residence.getId() == residenceIdToAddHouse) {
                residenceExists = true;
                break;
            }
        }

        if (!residenceExists) {
            logger.info("Residence with ID " + residenceIdToAddHouse + " not found.");
            displayDashboard();
            return;
        }

        logger.info("Please provide the details of the house to add:");
        logger.info("House ID: ");
        int houseId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        logger.info("House Name: ");
        String name = scanner.nextLine();

        logger.info("Description: ");
        String description = scanner.nextLine();

        logger.info("Price: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        logger.info("Location: ");
        String houseLocation = scanner.nextLine();

        logger.info("Services: ");
        String services = scanner.nextLine();

        House newHouse = new House(houseId, residenceIdToAddHouse, name, description, price, houseLocation, services);

        // Find the residence with the given ID and add the house
        for (Residences residence : ownedResidences) {
            if (residence.getId() == residenceIdToAddHouse) {
                residence.addmHouse(newHouse);
                break;
            }
        }

        logger.info("House added to the residence successfully!");
    	
    	
    }
	public int residenceId;
	  public   boolean checkresidenceId;
    private void addresidence() {
    	
    	  logger.info("Please provide the details of the new residence:");
    	 
          
          
          logger.info("Residence ID: ");
           residenceId = scanner.nextInt();
        checkresidenceId =checkresidenceId( residenceId);
          scanner.nextLine(); // Consume the newline character
          
          logger.info("Owner Information: ");
          String ownerInfo = scanner.nextLine();
          
          logger.info("Location: ");
          String location = scanner.nextLine();
          
          logger.info("Number of Floors: ");
          int floor = scanner.nextInt();
          
          logger.info("Number of Apartments per Floor: ");
          int housePerFloor = scanner.nextInt();
          scanner.nextLine(); // Consume the newline character
          
          logger.info("Available Services: ");
          String availableServices = scanner.nextLine();

          addResidences(residenceId, ownerInfo, location, floor, housePerFloor, availableServices);
          logger.info("Residence added successfully!");
          displayDashboard();
          

    	
    }
    

    public boolean checkresidenceId( int residenceId2) {

        for (Residences residence : ownedResidences) {
//            String[] residenceInfo = residence.split(",");

            // Assuming the ID is at the first position in the data
         //   int residenceId = Integer.parseInt(residenceInfo[0]);
            if (residence.getId() == residenceId2) {
            //if (residenceId == residenceId2) {
                return true; // The residenceId2 exists in the dataArrayList
            }
        }

        return false; // The residenceId2 does not exist in the dataArrayList
    }

	private void addHouseToResidence(int residenceId) {
        Residences selectedResidence = null;

        // Find the residence with the given ID
        for (Residences residence : ownedResidences) {
            if (residence.getId() == residenceId) {
                selectedResidence = residence;
                break;
            }
        }

        if (selectedResidence == null) {
            logger.info("Residence with ID " + residenceId + " not found.");
            displayDashboard();
            return;
        }

//        Scanner scanner = new Scanner(System.in);
        logger.info("Please provide the details of the house to add:");
        logger.info("House ID: ");
        int houseId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        logger.info("House Name: ");
        String name = scanner.nextLine();

        logger.info("Description: ");
        String description = scanner.nextLine();

        logger.info("Price: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        logger.info("Location: ");
        String houseLocation = scanner.nextLine();

        logger.info("Services: ");
        String services = scanner.nextLine();

        House newHouse = new House(houseId, residenceId, name, description, price, houseLocation, services);
        selectedResidence.addHouse(newHouse);

        logger.info("House added to the residence successfully!");
        displayDashboard();
    }
    private void viewMyResidences() {
        List<Residences> ownedResidences = owner.getOwnedResidences();

        if (ownedResidences.isEmpty()) {
            logger.info("You have no owned residences.");
        } else {
            logger.info("My Residences:");
            for (Residences residence : ownedResidences) {
                logger.info("Residence ID: " + residence.getId());
                logger.info("Owner Information: " + residence.getOwnerInfo());
                logger.info("Location: " + residence.getLocation());
                logger.info("Number of Floors: " + residence.getFloor());
                logger.info("Number of Apartments per Floor: " + residence.getHousePerFloor());
                logger.info("Available Services: " + residence.getAvailableServices());
                logger.info("Houses:");

                List<House> houses = residence.getHouses();
                if (houses.isEmpty()) {
                    logger.info("   No houses added to this residence yet.");
                } else {
                    for (House house : houses) {
                        logger.info("   House ID: " + house.getId());
                        logger.info("   House Name: " + house.getName());
                        logger.info("   Description: " + house.getDescription());
                        logger.info("   Price: " + house.getPrice());
                        logger.info("   Location: " + house.getLocation());
                        logger.info("   Services: " + house.getServices());
                       
                    }
                }
            }
        }

        displayDashboard();
    }    

}