package com.codeup.nutritrackr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping(path = "/")
    public String getHomePage() {
        return "users/home";
    }

    @GetMapping("/about-us")
    public String getAboutUsPage() {
        return "about-us";
    }
}
