package com.codeup.nutritrackr.controllers;

import com.codeup.nutritrackr.models.Goal;
import com.codeup.nutritrackr.models.User;
import com.codeup.nutritrackr.services.Goals;
import com.codeup.nutritrackr.services.Users;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public GoalsController(Goals goals) {
        this.goals = goals;
    }

    @GetMapping("/goals")
    public String getUserGoals(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Goal userGoals = goals.findMostRecentUserGoals(user);
        if (userGoals == null) {
            return "redirect:/goals/set";
        }
        model.addAttribute("userGoals", userGoals);

        return "goals/view";
    }

    @GetMapping("/goals/set")
    public String createUserGoals(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Goal mostRecentGoals = goals.findMostRecentUserGoals(user);

        if(mostRecentGoals == null) {
            mostRecentGoals = new Goal();
        } else {
            mostRecentGoals = new Goal(mostRecentGoals);
        }

        model.addAttribute("goal", mostRecentGoals);
        return "goals/set";
    }

    @PostMapping("/goals/set")
    public String saveNewGoal(@ModelAttribute Goal goal) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        goal.setUser(user);
        goal.setStartDate(LocalDateTime.now());
        goals.save(goal);
        return "redirect:/goals";
    }
}
