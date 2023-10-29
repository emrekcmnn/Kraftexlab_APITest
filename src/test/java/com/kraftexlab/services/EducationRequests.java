package com.kraftexlab.services;

import com.kraftexlab.common.DataForApi;
import com.kraftexlab.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.junit.Assert;
import java.util.List;
import java.util.Map;

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

    public void verifyThatFirstEducationInfo(int educationId, String school, String degree){
        List<Map<String,Object>> listOfUserInfo = response.as(List.class);
        System.out.println("listOfUserInfo = " + listOfUserInfo);
        List<Map<String,Object>> listOfEducation =  (List<Map<String,Object>>)listOfUserInfo.get(0).get("education");

//        System.out.println("listOfEducation = " + listOfEducation);
//        System.out.println("listOfEducation.get(0) = " + listOfEducation.get(0));

        double actualEducationIdDouble = (double) listOfEducation.get(0).get("id");
        int actualEducationId= (int) actualEducationIdDouble;
        String actualSchool = (String) listOfEducation.get(0).get("school");
        String actualDegree = (String) listOfEducation.get(0).get("degree");

        Assert.assertEquals(educationId,actualEducationId);
        Assert.assertEquals(school,actualSchool);
        Assert.assertEquals(degree,actualDegree);
    }
}
