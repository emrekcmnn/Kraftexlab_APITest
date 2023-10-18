package com.kraftexlab.services;


import com.kraftexlab.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetAllUsers extends Globals {

    public void getUsers(){
    response = RestAssured.given()
            .accept(ContentType.JSON)
            .when()
            .queryParam("pagesize","5")
            .queryParam("page","1")
            .get("/sw/api/v1/allusers/alluser");
    response.prettyPrint();

    }

}
