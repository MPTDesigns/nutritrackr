package com.codeup.nutritrackr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping(path = "/")
    @ResponseBody
    public String getHomePage() {
        return "Site currently under construction";
    }

    @GetMapping(path = "/test")
    public String getTestPage() {
        return "test/test";
    }
}
