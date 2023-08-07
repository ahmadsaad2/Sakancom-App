package ownertest;

import static org.junit.Assert.assertEquals;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import owner.util.House;

import owner.util.Residences;


public class viewRequest {
    int c,flage=0 , flage2=0;
    Residences res;
    House house2;
    @When("i will inter the number <{int}> to add rented house by owner")
    public void i_will_inter_the_number_to_add_rented_house_by_owner(Integer int1) {
        c=int1;
        house2 = new House(int1, 2, "House 2", "Description 2", 1500, "street-17", "sensative flam");
        res.addmHouse(house2);
    }

    @Then("i will add it to pending house in admin")
    public void i_will_add_it_to_pending_house_in_admin() {
        for (House h : res.getmHouses()) {
            if (h.getId() == c) {
                flage=1;
                break;
            }
        }
        assertEquals(1, flage);

    }

    @When("i will inter the number <{int}> and fail add rented house by owner")
    public void i_will_inter_the_number_and_fail_add_rented_house_by_owner(Integer int1) {
        for (House h : res.getmHouses()) {
            if (h.getId() != c) {
                flage2 = 1;
                break;
            }
        }
    }


    @Then("the outputt <{string}>")
    public void the_outputt(String expectedOutput) {
        assertEquals(1, flage2);
    }
}
