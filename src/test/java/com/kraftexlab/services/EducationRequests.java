package com.kraftexlab.services;

import com.kraftexlab.common.DataForApi;
import com.kraftexlab.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;

public class EducationRequests extends Globals {
    public void getUsersAllEducations(){
       response = RestAssured.given()
                .header("token",token)
                .get("/sw/api/v1/education/all");
        response.prettyPrint();

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
        response.prettyPrint();
    }
}
