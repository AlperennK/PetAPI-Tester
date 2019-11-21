//package com.epampets.steps;
//
//import com.epampets.domain.entity.PetStatus;
//import com.epampets.domain.helper.PetService;
//import com.epampets.domain.response.ResponsePet;
//import com.fasterxml.jackson.annotation.JsonTypeInfo;
//import cucumber.api.PendingException;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import io.restassured.response.Response;
//import org.junit.Assert;
//import org.junit.Test;
//
//public class GetNumberSteps {
//    private PetService petHelper;
//    private ResponsePet pet;
//    private int petId;
//    private int pedId;
//    private int numberOfPets;
//    private int totalNumberOfPets;
//
//    public GetNumberSteps(PetService petHelper){
//        this.petHelper=petHelper;
//    }
//    @Given("^I get number of \"([^\"]*)\" pets$")
//    public void i_get_number_of_pets(String status) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        totalNumberOfPets += petHelper.getPetList(status);
//    }
//    @When("^I create a pet with a status of \"([^\"]*)\"$")
//    public void i_create_a_pet_with_a_status_of(String status) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        petHelper.createPetWithStatus(status);
//    }
//
//    @Then("^I should see \"([^\"]*)\" pets increased one$")
//    public void i_should_see_pets_increased_one(String status, int generatedPetCount) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        Assert.assertEquals(petHelper.getPetList(status), numberOfPets + generatedPetCount);
//
//    }
//
//
//}
