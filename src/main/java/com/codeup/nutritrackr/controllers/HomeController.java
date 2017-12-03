package com.codeup.nutritrackr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping(path = "/")
    public String getTestPage() {
        return "users/home";
    }
}
