package com.codeup.nutritrackr.controllers;

import com.codeup.nutritrackr.models.Goal;
import com.codeup.nutritrackr.models.User;
import com.codeup.nutritrackr.services.Goals;
import com.codeup.nutritrackr.services.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class GoalsController {
    private final Goals goals;
    private final Users users;

    public GoalsController(Goals goals, Users users) {
        this.goals = goals;
        this.users = users;
    }

    @GetMapping("/goals")
    public String getUserGoals(Model model) {
        User user = users.findOne(1);
        Goal userGoals = goals.findMostRecentUserGoals(user);
        model.addAttribute("userGoals", userGoals != null ? userGoals : new Goal());

        return "goals/view";
    }

    @GetMapping("/goals/create")
    public String createUserGoals(Model model) {
        model.addAttribute("goal", goals.findMostRecentUserGoals(users.findOne(1)));
        return "goals/create";
    }

    @PostMapping("/goals/create")
    public String saveNewGoal(@ModelAttribute Goal goal) {
        User user = users.findOne(1);
        goal.setUser(user);
        goal.setStartDate(LocalDateTime.now());
        goals.save(goal);
        return "redirect:/goals";
    }
}
