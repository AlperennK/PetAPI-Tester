package com.epampets.steps;


import com.epampets.domain.entity.PetStatus;
import com.epampets.domain.helper.PetService;
import com.epampets.domain.response.ResponsePet;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class PossibleStatusSteps {
    private PetService petHelper;
    private ResponsePet pet;
    private int petId;
    private int numberOfPets;
    private int totalNumberOfPets;

    public PossibleStatusSteps(PetService petHelper){
        this.petHelper=petHelper;
    }
//    @When("^I create a pet with a status \"([^\"]*)\"$")
//    public void iCreateAPetWithAStatus(String status) throws Throwable {
//
//    }
//
//    @Then("^I check newly created pet's status is \"([^\"]*)\"$")
//    public void iCheckNewlyCreatedPetSStatusIs(String status) throws Throwable {

//    }
    @When("^I generate a new peth with \"([^\"]*)\" status$")
    public void i_generate_a_new_peth_with_status(String status) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        petId = petHelper.createPetWithStatus(status);

    }

    @Then("^I check newly created pet's status is \"([^\"]*)\"$")
    public void i_check_newly_created_pet_s_status_is(String status) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(petHelper.findPetWithId(petId).status, PetStatus.valueOf(status));

    }



}
