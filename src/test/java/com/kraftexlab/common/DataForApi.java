package com.kraftexlab.common;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class DataForApi {

    /*
    * "name": "aFm",
     *   "email": "dev@krafttechexlab.com",
     *   "password": "123467",
     *   "about": "About Me",
     *   "terms": "10"
     * */
    public static Map<String,Object> registerNewUserBody(){
        Map<String,Object> userInfo=new HashMap<>();
        Faker faker = new Faker();

        String name = faker.name().fullName();

        String email = faker.internet().emailAddress();

        String password = faker.internet().password();

        String about = faker.job().position();

        String terms = faker.number().digit();

        System.out.println("name = " + name);
        System.out.println("email = " + email);
        System.out.println("password = " + password);
        System.out.println("about = " + about);
        System.out.println("terms = " + terms);

        userInfo.put("name",name);
        userInfo.put("email",email);
        userInfo.put("password",password);
        userInfo.put("about",about);
        userInfo.put("terms",terms);

        return userInfo;
    }
}
