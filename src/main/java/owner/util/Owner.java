package owner.util;
import java.util.ArrayList;
import java.util.List;


public class Owner {
    private String name; 
    private int id;
    private String username;
    private String password;
    private static final List<Residences> ownedResidences = new ArrayList<>();


    public Owner(String name, int id, String username, String password) {
        this.name = name;
        this.id = id;
        this.username = username;
        this.password = password;
     
      
        // Constructor and other methods for the Owner class

	    // Getter method for ownedResidences
	   
	    }
    public static List<Residences> getOwnedResidences1() {
        return ownedResidences;
        
    }

    public Owner() {
    	

    	

		
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static List<Residences> getOwnedResidences() {
        return ownedResidences;
    }

    public void addResidence(Residences newResidence) {
        ownedResidences.add(newResidence);
    }
    
    public boolean check(int input) {
        OwnerDashboard own = new OwnerDashboard();
        // Remove the unused "residences" local variable and call the method directly
        if (own.fun().getId() != input)
            return true;
        else
            return false;
    }


          }
        