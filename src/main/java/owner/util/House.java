package owner.util;


public class House {
    private int id;
    private int residenceId;
    private String name;
    private String description;
    private int price;
    private String location;
    private String services;
    private boolean rented;

    public House(int id, int residenceId, String name, String description, int price, String location, String services) {
        this.id = id;
        this.residenceId = residenceId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.location = location;
        this.services = services;
        this.rented = false;
    }

    public int getId() {
        return id;
    }

    public int getResidenceId() {
        return residenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }
 
    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}

