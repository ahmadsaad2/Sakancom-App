package ownertest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//import java.security.acl.Owner;
import java.util.List;
import owner.util.Owner;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import owner.util.OwnerDashboard;
import owner.util.Residences;

public class add { 
 
	    OwnerDashboard o = new OwnerDashboard(); 
	    Owner owner1 =new Owner();
		int input , input2;
		boolean flag=false;
		@When("i enter the id <{int}> of reisdences to add it")
		public void i_enter_the_id_of_reisdences_to_add_it(Integer int1) {
		   input = int1;
		}
		
		@Then("i will save itt <{string}>")
		public void i_will_save_itt(String string) {
			assertTrue(owner1.ckeck(input));
		}
		@When("i enter the id <{int}> of reisdences to add itt")
		public void i_enter_the_id_of_reisdences_to_add_itt(Integer int2) {
		   input2=int2;
		}
	
		@Then("i thee output <{string}>")
		public void i_thee_output(String string) {
			assertFalse(owner1.ckeck(input2));
		}

}
