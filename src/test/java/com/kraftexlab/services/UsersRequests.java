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
}
