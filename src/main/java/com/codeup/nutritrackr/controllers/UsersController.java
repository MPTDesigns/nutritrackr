package com.codeup.nutritrackr.controllers;

import com.codeup.nutritrackr.models.User;
import com.codeup.nutritrackr.services.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@SessionAttributes("diaryDate")
public class UsersController {
    private Users users;

    @Autowired
    public UsersController(Users users) {
        this.users = users;
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, @RequestParam("confirmPwd") String confirmPassword) {
        if(users.findByEmail(user.getEmail()) == null && user.getPassword().equals(confirmPassword)) {
            users.save(user);
            return "redirect:/login";
        } else {
            return "users/register";
        }
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "users/login";
    }

//    @PostMapping("/login")
//    public ModelAndView loginUser(RedirectAttributes redirectAttributes) {
//        redirectAttributes.addFlashAttribute("diaryDate", LocalDate.now().plusDays(5));
//        return new ModelAndView("redirect:/diary");
//    }
    @PostMapping("/login")
    public String logUserIn(Model model) {
        model.addAttribute("diaryDate", LocalDate.now().minusDays(2));
        return "redirect:/diary";
    }
}
