package com.kraftexlab.common;

import com.github.javafaker.Faker;
import com.kraftexlab.utilities.Globals;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DataForApi {
  static   Faker faker;
    /*
    * "name": "aFm",
     *   "email": "dev@krafttechexlab.com",
     *   "password": "123467",
     *   "about": "About Me",
     *   "terms": "10"
     * */
    public static Map<String,Object> registerNewUserBody(){
        Map<String,Object> userInfo=new HashMap<>();
         faker = new Faker();

        String name = faker.name().fullName();

        String email = faker.internet().emailAddress();

        String password = "Ab!1"+faker.internet().password();
        Globals.password =password;

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

    /**{
     "school": "School",
     "degree": "Degree",
     "study": "Study",
     "fromdate": "YYYY-MM-DD",
     "todate": "YYYY-MM-DD",
     "current": "false",
     "description": "Description"
     }*/
    public static Map<String,Object> addEducationBody(){
        String university = faker.educator().university();
        String campus = faker.educator().campus();
     //   String name = faker.university().name();
        String secondarySchool = faker.educator().secondarySchool();



        Boolean bl = faker.random().nextBoolean();
        String sentence = faker.lorem().sentence();
        Map<String,Object> educationBody= new HashMap<>();
        educationBody.put("school",university);
        educationBody.put("degree",campus);
        educationBody.put("study",secondarySchool);
        educationBody.put("fromdate","2014-06-06");
        educationBody.put("todate","2018-09-15");
        educationBody.put("current",bl);
        educationBody.put("description",sentence);

        return educationBody;
    }
}
