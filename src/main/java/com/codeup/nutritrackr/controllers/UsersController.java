package com.codeup.nutritrackr.controllers;

import com.codeup.nutritrackr.models.User;
import com.codeup.nutritrackr.services.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@SessionAttributes("diaryDate")
public class UsersController {
    private Users users;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsersController(Users users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, Errors validation, Model model, @RequestParam("confirmPwd") String confirmPassword) {
        if (!confirmPassword.equals(user.getPassword())) {
            validation.rejectValue("password", "user.password", "Your password do not match!");

            if (validation.hasErrors()) {
                model.addAttribute("errors", validation);
                model.addAttribute("user", user);
                return "users/register";
            }

//            String hash = passwordEncoder.encode(user.getPassword());
//            user.setPassword(hash);
//            users.save(user);
        }
        if (users.findByEmail(user.getEmail()) == null && user.getPassword().equals(confirmPassword)) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            users.save(user);
            return "redirect:/login";
        }

        return "users/register";
    }
}

