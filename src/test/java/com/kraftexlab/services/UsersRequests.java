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
    }

    public void verifyThatUserIsCreated(){
        Assert.assertEquals(200,response.statusCode());
        Assert.assertNotNull(token);
        Assert.assertNotNull(userId);
    }

    public void deleteUser(){
        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("token",token)
                .queryParam("id",userId)
                .when()
                .delete("/sw/api/v1/user/delete");
    }
    public void verifyThatUserIsDeleted(){
        response.prettyPrint();
        Assert.assertEquals("User Deleted Successfully...",response.path("message"));
        Assert.assertEquals(200,response.statusCode());

    }
}
