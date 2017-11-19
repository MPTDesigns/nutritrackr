package com.codeup.nutritrackr.controllers;

import com.codeup.nutritrackr.models.Goal;
import com.codeup.nutritrackr.models.User;
import com.codeup.nutritrackr.services.Goals;
import com.codeup.nutritrackr.services.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GoalsController {
    private final Goals goals;
    private final Users users;

    public GoalsController(Goals goals, Users users) {
        this.goals = goals;
        this.users = users;
    }

    @GetMapping("/goals")
    @ResponseBody
    public String getUserGoals() {
        User user = users.findOne(1);
        Goal userGoals = goals.findMostRecentUserGoals(user);
        if(userGoals != null) {
            return String.format("Calories: %s", userGoals.getCalorieGoal());
        }
        return "User has no goals";
    }

    @GetMapping("/goals/create")
    public String createUserGoals() {
        User user = users.findOne(1);
        goals.save(new Goal(user, 2000, 50, 35, 15));
        return "redirect:/goals";
    }
}
