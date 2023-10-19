package com.kraftexlab.step_defs;

import com.kraftexlab.services.UsersRequests;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Users_stepDefs {
    UsersRequests usersRequests = new UsersRequests();
    @Given("Send a request for registering new user with POST method")
    public void sendARequestForRegisteringNewUserWithPOSTMethod() {
        usersRequests.registerNewUser();
    }

    @When("Verify that new user is created")
    public void verifyThatNewUserIsCreated() {
        usersRequests.verifyThatUserIsCreated();
    }

    @When("Delete this new user")
    public void deleteThisNewUser() {
        
    }

    @Then("Verify that new user is deleted")
    public void verifyThatNewUserIsDeleted() {
    }
}
