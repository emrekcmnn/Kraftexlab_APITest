package com.kraftexlab.step_defs;

import com.kraftexlab.services.GetAllUsers;
import io.cucumber.java.en.Given;

public class GetAllUsers_stepDefs {
    GetAllUsers allUsers = new GetAllUsers();
    @Given("get all users")
    public void get_all_users() {
    allUsers.getUsers();

    }
}
