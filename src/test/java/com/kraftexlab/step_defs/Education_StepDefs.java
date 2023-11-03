package com.kraftexlab.step_defs;

import com.google.gson.Gson;
import com.kraftexlab.services.EducationRequests;
import com.kraftexlab.utilities.Globals;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.Map;

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
    @Then("Verify that first education information {int} , {string} , {string}")
    public void verify_that_first_education_information(int educationId, String school, String degree) {
        educationRequests.verifyThatFirstEducationInfo(educationId,school,degree);
    }

    @Then("Verify that first education information {int} , {string} , {string} with gson")
    public void verifyThatFirstEducationInformationEducationIdWithGson(int educationId, String school, String degree) {
       Gson gson = new Gson();
       List<Map<String,Object>> listOfMap =  gson.fromJson(Globals.response.asPrettyString(), List.class);
       System.out.println("listOfMap.get(0) = " + listOfMap.get(0));

        double actualDoubleId =(double) listOfMap.get(0).get("id");
        int actualId = (int)actualDoubleId;
        String actualSchool = (String) listOfMap.get(0).get("school");
        String actualDegree = (String) listOfMap.get(0).get("degree");

        Assertions.assertThat(actualId).isEqualTo(educationId);
        Assertions.assertThat(actualSchool).isEqualTo(school);
        Assertions.assertThat(actualDegree).isEqualTo(degree);

    }
}
