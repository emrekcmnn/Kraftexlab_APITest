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
        usersRequests.deleteUser();
    }

    @Then("Verify that new user is deleted")
    public void verifyThatNewUserIsDeleted() {
        usersRequests.verifyThatUserIsDeleted();
    }

    @When("Get user by ID with GET method")
    public void get_user_by_ID_with_GET_method() {

    }

    @When("Verify that the user is new user")
    public void verify_that_the_user_is_new_user() {

    }
    @When("Login and Get Token with POST method")
    public void login_and_Get_Token_with_POST_method() {

    }
}
