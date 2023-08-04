package owner.util;
 
import java.util.List;

public class Furniture {
    private String name;
    private String description;
    private double price;
    private List<Furniture> advertisedFurniture;
        
    public Furniture(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Furniture() {
		// TODO Auto-generated constructor stub
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

    public double getPrice() {
        return price;
    }

    public void  setPrice(double price) {
        this.price = price;
    }
}
