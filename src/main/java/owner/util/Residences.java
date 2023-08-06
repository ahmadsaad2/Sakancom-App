package owner.util;
import java.util.ArrayList;
import java.util.List;

public class Residences {
    private static int idresidences;
    private String ownerInfo;
    private String location;
    private int floor;
    private int housePerFloor;
    private String availableServices;
    private  static List<House> houses;
    private  static List<House> mhouses;


    public Residences(int residenceId, String ownerInfo, String location, int floor, int housePerFloor, String availableServices) {
        idresidences=residenceId;
        this.ownerInfo = ownerInfo;
        this.location = location;
        this.floor = floor;
        this.housePerFloor = housePerFloor;
        this.availableServices = availableServices;

    }

    public Residences() {
		// TODO Auto-generated constructor stub
	}

	public static int getId() {
        return idresidences;
    }

    public static List<House> getmHouses() {
        return mhouses;
    }

    public static void setmHouses(List<House> mhouses) {
        Residences.mhouses = mhouses;
    }

    public String getOwnerInfo() {
        return ownerInfo;
    }

    public void setOwnerInfo(String ownerInfo) {
        this.ownerInfo = ownerInfo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getHousePerFloor() {
        return housePerFloor;
    }

    public void setHousePerFloor(int housePerFloor) {
        this.housePerFloor = housePerFloor;
    }

    public String getAvailableServices() {
        return availableServices;
    }

    public void setAvailableServices(String availableServices) {
        this.availableServices = availableServices;
    }

    public static List<House> getHouses() {
        return houses;
    }

    public void addHouse(House house) {
        houses.add(house);
    }
    public static void addmHouse(House house) {
        mhouses.add(house);

    }
}
