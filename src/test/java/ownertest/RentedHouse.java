package ownertest;
import static org.junit.Assert.assertTrue;
 
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import owner.util.Tenant;
  
public class RentedHouse {
	int idhome , idhome2 ; 
	Tenant T=new Tenant();
	@When("i will inter the number <{int}> of booking")
	public void i_will_inter_the_number_of_booking(Integer int1) {
		idhome = int1 ;
	}
	@When("i will inter the number <{int}> of booking house")
	public void i_will_inter_the_number_of_booking_house(Integer int1) {
	   idhome2=int1;
	}


	@Then("i will remove the house from avalible house")
	public void i_will_remove_the_house_from_avalible_house() {
         assertTrue( T.homeRemove(idhome));
	}

	@Then("the output <{string}>")
	public void the_output(String string) {
	 assertTrue(T.homeRented(idhome2)==null);    
	
	}
}