package com.kraftexlab.step_defs;

import com.kraftexlab.services.UsersRequests;
import com.kraftexlab.utilities.Globals;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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
        usersRequests.getUserByID();
    }


    @When("Login and Get Token with POST method")
    public void login_and_Get_Token_with_POST_method() {
        usersRequests.loginAndGetToken();
    }

    @Given("Get a user by {int}")
    public void get_a_user_by(int userId) {
       usersRequests.getUserByID(userId);
    }

    @When("Verify that the status code is {int}")
    public void verify_that(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode,Globals.response.statusCode());
    }
}