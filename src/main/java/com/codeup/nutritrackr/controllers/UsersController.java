package com.codeup.nutritrackr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsersController {

    @GetMapping("/register")
    public String showRegisterPage() {
        return "users/register";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "users/login";
    }
}
