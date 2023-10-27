package com.kraftexlab.step_defs;

import com.kraftexlab.services.EducationRequests;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Education_StepDefs {

    EducationRequests educationRequests = new EducationRequests();


    @When("Get user's all educations with GET method")
    public void get_user_s_all_educations_with_GET_method() {
        educationRequests.getUsersAllEducations();
    }

    @When("Verify that there is NO any education information")
    public void verify_that_there_is_NO_any_education_information() {
        educationRequests.verifyThatThereIsNOEducation();
    }

    @When("Add education to user with POST method")
    public void add_education_to_user_with_POST_method() {
        educationRequests.addEducation();

    }

    @Then("Verify that education is added")
    public void verify_that_education_is_added() {
        educationRequests.verifyThatEducationIsAdded();
    }

}
