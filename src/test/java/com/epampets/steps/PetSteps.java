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

public class PetSteps {
    private PetService petHelper;
    private ResponsePet pet;
    private int petId;
    private int pedId;
    private int numberOfPets;
    private int totalNumberOfPets;

    public PetSteps(PetService petHelper){
        this.petHelper = petHelper;
    }


    @Given("^I create a pet$")
    public void iCreateAPet() {
        petId = petHelper.createPet();
    }

    @When("^I check newly created pet$")
    public void iCheckNewlyCreatedPet() {
        Assert.assertEquals(petHelper.findPetWithId(petId).name, "Gaspar");
    }

    @Then("^I update my pet$")
    public void iUpdateMyPet() {
        petHelper.updatePetWithId(petId);
    }
    @Then("^I check updated pet")
    public void iCheckUpdatedPet(){
        Assert.assertEquals(petHelper.findPetWithId(petId).name, "GasparUpdated");
    }
    @Given("^I create a pet called Garfield")
    public void iCreateGarfield() {
        petId = petHelper.createPetWithName("Garfield");
    }
    @When("^I change status to \"([^\"]*)\"$")
    public void iUpdateStatusOfPetAsA(String status) throws Throwable {
        petHelper.updatePetStatusWithId(petId, status);
    }

    @Then("^I should get \\\"([^\\\"]*)\\\" for the pet$")
    public void iShouldSeeNewlyCreatedPetSStatusIs(String status) throws Throwable {
        Assert.assertEquals(petHelper.findPetWithId(petId).status, PetStatus.valueOf(status));
    }

}