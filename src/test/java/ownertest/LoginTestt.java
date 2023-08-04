package ownertest;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import owner.util.Tenant;
import owner.util.User;

  

public class LoginTestt {
     User user=new User();
     boolean check;
     boolean check1;
     boolean check2;
 	@Given("inter user name and password")
 	public void inter_user_name_and_password() {
		System.out.println();
		System.out.println("----- Welcome To SakanCom -----  ");
		
	}


	@When("I submit user name <{string}> and password <{string}> and should enter to admin page")
	public void i_submit_user_name_and_password_and_should_enter_to_admin_page(String arg0, String arg1) {
		check = user.login(arg0,arg1);
	}
	

	@When("I submit user name <{string}> and password <{string}> and should enter to owner page")
	public void iSubmitUserNameAndPasswordAndShouldEnterToOwnerPage(String arg0, String arg1) {
		check1 =user.login(arg0,arg1) ;

	}



	@When("I submit user name <{string}> and password <{string}> and should enter to tenant page")
	public void iSubmitUserNameAndPasswordAndShouldEnterToTenantPage(String arg0, String arg1) {
		check2 =user.login(arg0,arg1);
	}

	@Then("I should be logged in to admin page for username <{string}> and password <{string}>")
	public void i_should_be_logged_in_to_admin_page_for_username_and_password(String string, String string2) {
		assertTrue(check);
	}

	@Then("I should be logged in to owner page")
	public void i_should_be_logged_in_to_owner_page() {
	
		assertTrue(check1);
	}

	@Then("I should be logged in to tenant page")
	public void i_should_be_logged_in_to_tenant_page() {
		 assertTrue(check2 );
	}


}
