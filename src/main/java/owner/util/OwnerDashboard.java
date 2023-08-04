package owner.util;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class OwnerDashboard { 
	
	
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
            System.out.println("Residence with ID " + residenceId + " not found.");
            return;
        }

        House newHouse = new House(residenceId, price, name, description, price, houseLocation, services);
        Tenant.availableHouses.add(newHouse);
        selectedResidence.addHouse(newHouse);
        System.out.println("House added to the residence successfully!");
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
        System.out.println("Welcome to Housing Owner's Control Panel");
        System.out.println("1 - View My Residences");
        System.out.println("2 - Add a New Residence");
        System.out.println("3 - Add a House to Residence");
        System.out.println("4 - Log Out");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                viewMyResidences();
                break;
            case 2:
            	addresidence();
break;
             

            case 3:
            	addhousetoresidence();

                break;

         

            case 4:  
            
            
        System.out.println("Logged out successfully");
        isLoggedIn = false;
                break;
            default:
                System.out.println("Invalid choice!");
                displayDashboard();
                break;
        }
      
    }
    }
    

	private void addhousetoresidence() {
   	
//    	Scanner scanner=new Scanner(System.in);
   	
    	
    	
    	System.out.println("Please provide the ID of the residence to which you want to add a house:");
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
            System.out.println("Residence with ID " + residenceIdToAddHouse + " not found.");
            displayDashboard();
            return;
        }

        System.out.println("Please provide the details of the house to add:");
        System.out.print("House ID: ");
        int houseId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("House Name: ");
        String name = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Price: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Location: ");
        String houseLocation = scanner.nextLine();

        System.out.print("Services: ");
        String services = scanner.nextLine();

        House newHouse = new House(houseId, residenceIdToAddHouse, name, description, price, houseLocation, services);

        // Find the residence with the given ID and add the house
        for (Residences residence : ownedResidences) {
            if (residence.getId() == residenceIdToAddHouse) {
                residence.addmHouse(newHouse);
                break;
            }
        }

        System.out.println("House added to the residence successfully!");
    	
    	
    }
	public int residenceId;
	  public   boolean checkresidenceId;
    private void addresidence() {
    	
    	  System.out.println("Please provide the details of the new residence:");
    	 
          
          
          System.out.print("Residence ID: ");
           residenceId = scanner.nextInt();
        checkresidenceId =checkResidenceId( residenceId);
          scanner.nextLine(); // Consume the newline character
          
          System.out.print("Owner Information: ");
          String ownerInfo = scanner.nextLine();
          
          System.out.print("Location: ");
          String location = scanner.nextLine();
          
          System.out.print("Number of Floors: ");
          int floor = scanner.nextInt();
          
          System.out.print("Number of Apartments per Floor: ");
          int housePerFloor = scanner.nextInt();
          scanner.nextLine(); // Consume the newline character
          
          System.out.print("Available Services: ");
          String availableServices = scanner.nextLine();

          addResidences(residenceId, ownerInfo, location, floor, housePerFloor, availableServices);
          System.out.println("Residence added successfully!");
          displayDashboard();
          

    	
    }
    
//    public boolean checkResidenceId(int residenceId2) {
//        for (Residences residenceData : dataArrayList) {
//            String[] residenceInfo = residenceData.split(",");
//
//            // Assuming the ID is at the first position in the data
//            int residenceId = Integer.parseInt(residenceInfo[0]);
//            System.out.print(residenceId);
//            if (residenceId == residenceId2) {
//            	System.out.print(residenceId);
//                return true; // The residenceId2 exists in the dataArrayList
//            }
//       }
////        System.out.print(residenceId2);
////        System.out.println("ddddddddddddd");
//    return false ;
//        
//        // The residenceId2 does not exist in the dataArrayList
//    }

    public boolean checkResidenceId( int residenceId2) {

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
            System.out.println("Residence with ID " + residenceId + " not found.");
            displayDashboard();
            return;
        }

//        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide the details of the house to add:");
        System.out.print("House ID: ");
        int houseId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("House Name: ");
        String name = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Price: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Location: ");
        String houseLocation = scanner.nextLine();

        System.out.print("Services: ");
        String services = scanner.nextLine();

        House newHouse = new House(houseId, residenceId, name, description, price, houseLocation, services);
        selectedResidence.addHouse(newHouse);

        System.out.println("House added to the residence successfully!");
        displayDashboard();
    }
    private void viewMyResidences() {
        List<Residences> ownedResidences = owner.getOwnedResidences();

        if (ownedResidences.isEmpty()) {
            System.out.println("You have no owned residences.");
        } else {
            System.out.println("My Residences:");
            for (Residences residence : ownedResidences) {
                System.out.println("Residence ID: " + residence.getId());
                System.out.println("Owner Information: " + residence.getOwnerInfo());
                System.out.println("Location: " + residence.getLocation());
                System.out.println("Number of Floors: " + residence.getFloor());
                System.out.println("Number of Apartments per Floor: " + residence.getHousePerFloor());
                System.out.println("Available Services: " + residence.getAvailableServices());
                System.out.println("Houses:");

                List<House> houses = residence.getHouses();
                if (houses.isEmpty()) {
                    System.out.println("   No houses added to this residence yet.");
                } else {
                    for (House house : houses) {
                        System.out.println("   House ID: " + house.getId());
                        System.out.println("   House Name: " + house.getName());
                        System.out.println("   Description: " + house.getDescription());
                        System.out.println("   Price: " + house.getPrice());
                        System.out.println("   Location: " + house.getLocation());
                        System.out.println("   Services: " + house.getServices());
                        System.out.println();
                    }
                }
            }
        }

        displayDashboard();
    }    

}