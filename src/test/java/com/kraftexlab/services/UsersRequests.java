package com.kraftexlab.services;

import com.kraftexlab.common.DataForApi;
import com.kraftexlab.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

public class UsersRequests extends Globals {


    public void registerNewUser(){
       response = RestAssured
                .given()
                .accept(ContentType.JSON)
               .contentType(ContentType.JSON)
                .body(DataForApi.registerNewUserBody())
                .post("/sw/api/v1/allusers/register");
        response.prettyPrint();

        userId = response.path("id");
        token = response.path("token");
        name = response.path("name");
        email = response.path("email");
    }

    public void verifyThatUserIsCreated(){
        Assert.assertEquals(200,response.statusCode());
        Assert.assertNotNull(token);
    }

    public void getUserByID(){

        response = RestAssured.given()
                .accept(ContentType.JSON)
                .pathParam("id",userId)
                .get("/sw/api/v1/allusers/getbyid/{id}");
        response.prettyPrint();
    }

    public void loginAndGetToken() {
        response = RestAssured.given()
                .accept(ContentType.MULTIPART)
                .formParam("email",email)
                .formParam("password",password)
                .when()
                .post("/sw/api/v1/allusers/login");
        token = response.path("token");
        System.out.println("token = " + token);
    }
    public void deleteUser(){
        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("token",token)
                .queryParam("id",userId)
                .when()
                .delete("/sw/api/v1/user/delete");
        response.prettyPrint();
    }
    public void verifyThatUserIsDeleted(){
        Assert.assertEquals("User Deleted Successfully...",response.path("message"));
        Assert.assertEquals(200,response.statusCode());
    }
}
