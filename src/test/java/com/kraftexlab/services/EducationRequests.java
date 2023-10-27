package com.kraftexlab.services;

import com.kraftexlab.common.DataForApi;
import com.kraftexlab.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.junit.Assert;

public class EducationRequests extends Globals {
    public JsonPath getUsersAllEducations(){
       response = RestAssured.given()
                .header("token",token)
                .get("/sw/api/v1/education/all");
        response.prettyPrint();
        return response.jsonPath();

    }

    public void verifyThatThereIsNOEducation(){
        response.then()
                .statusCode(404)
                .body("message", Matchers.containsString("No Education Record Found...."));
    }
    public void addEducation(){
        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(DataForApi.addEducationBody())
                .header("token",token)
                .post("/sw/api/v1/education/add");
        schoolId = response.path("id");
    }

    public void verifyThatEducationIsAdded(){
        int actualSchoolId = getUsersAllEducations().get("id[0]");
        String actualSchoolName = getUsersAllEducations().get("school[0]");

        Assert.assertEquals(schoolId,actualSchoolId);
        Assert.assertEquals(schoolName,actualSchoolName);
    }
}
