package com.codeup.nutritrackr.controllers;

import com.codeup.nutritrackr.models.FoodDrink;
import com.codeup.nutritrackr.services.FoodDrinks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FoodDrinksController {
    private FoodDrinks foodDrinks;

    @Autowired
    public FoodDrinksController(FoodDrinks foodDrinks) {
        this.foodDrinks = foodDrinks;
    }

    @GetMapping("/foods/add")
    public String showAddFoodForm(Model model) {
        model.addAttribute("newFoodDrink", new FoodDrink());
        return "foods/add";
    }

    @PostMapping("/foods/add")
    public String addNewFoodDrink(@ModelAttribute FoodDrink foodDrink) {
        foodDrinks.save(foodDrink);
        return "redirect:/foods";
    }

    @GetMapping("/foods")
    @ResponseBody
    public String showFoods() {
        String response = "";
        for (FoodDrink fd : foodDrinks.findAll()) {
            response += String.format("id: %d\ndescription: %s\n\n", fd.getId(), fd.getDescription());
        }
        return response;
    }
}