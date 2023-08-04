package ownertest;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import owner.util.Admindashboard;

public class adminacceptandreject {

    private Admindashboard admindashboard;
    private int actionResult1,actionResult2;

    @Given("that the user is an admin")
    public void that_the_user_is_an_admin() {
        admindashboard = new Admindashboard();
    }

    @When("the admin recieves a housing advertisement with id <{int}> and admin chooses to <{string}> it")
    public void the_admin_recieves_a_housing_advertisement_with_id_and_admin_chooses_to_it(Integer int1, String string) {
        int choice = string.equalsIgnoreCase("Accept") ? 1 : 2;
        actionResult1 = admindashboard.takeAction(choice, int1);
    }
    @When("the admin recieves a housing advertisement with id <{int}> the admin chooses to <{string}> it")
    public void the_admin_recieves_a_housing_advertisement_with_id_the_admin_chooses_to_it(Integer int1, String string) {
        int choice = string.equalsIgnoreCase("Reject") ? 2 : 1;
        actionResult2 = admindashboard.takeAction(choice, int1);
    }

    @Then("the house is accepted")
    public void the_house_is_accepted() {
        assertEquals(0, actionResult1);
    }

    @Then("the house is rejected")
    public void the_house_is_rejected() {
        assertEquals(0, actionResult2);
    }
}