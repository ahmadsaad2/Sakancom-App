package ownertest;
import static org.junit.Assert.assertTrue;
import java.util.List;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import owner.util.House;
import owner.util.Owner;
import owner.util.OwnerDashboard;
import owner.util.Residences;
public class searchhome { 
	Owner owner2 =new Owner();
	OwnerDashboard o = new OwnerDashboard();
	Residences res = new Residences();
	int price , idr , idHome;
	List <House> house ;
	String location , services;
 
	@When("i want a home its location  <{string}> services <{string}>")
	public void i_want_a_home_its_price_location_services( String string, String string2) {
		
		location = string;
		services =  string2;
		
		res= o.fun();
		house=res.getHouses();
		System.out.println("Done1");

		  for (House h : house) {
				System.out.println(h.getLocation() + location);				
				System.out.println(h.getServices()+services);

			if(h.getLocation().equals(location)  && h.getServices().equals(services)) {
				System.out.println("Done3");
			  idHome = h.getId();
			  idr=h.getResidenceId();
		  }
		}
	}

	@Then("i given id  home  <{int}> and its reissdences  <{int}>")
	public void i_given_id_home_and_its_reissdences(Integer int1, Integer int2) {
	  
	  assertTrue(idHome==int1 && idr==int2);

	}

}
