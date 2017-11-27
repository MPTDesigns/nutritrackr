package com.codeup.nutritrackr.controllers;

import com.codeup.nutritrackr.models.Meal;
import com.codeup.nutritrackr.models.MealType;
import com.codeup.nutritrackr.services.FoodDrinks;
import com.codeup.nutritrackr.services.Meals;
import com.codeup.nutritrackr.services.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class DiaryController {

    private final Users users;
    private final Meals meals;
    private final FoodDrinks foodDrinks;

    public DiaryController(Users users, Meals meals, FoodDrinks foodDrinks) {
        this.users = users;
        this.meals = meals;
        this.foodDrinks = foodDrinks;
    }

    @GetMapping("/diary")
    public String showDiaryPage(Model model) {
//        Meal mealToSave = new Meal(users.findOne(1));
//        mealToSave.setMealType(MealType.BREAKFAST);
//        mealToSave.setMealDate(LocalDate.now());
//        mealToSave.setFoodItems(new ArrayList<>());
//        mealToSave.getFoodItems().add(foodDrinks.findOne(3));
//        meals.save(mealToSave);
        Meal breakfast = meals.findMealForDayByType(
            users.findOne(1),
            LocalDate.now(),
            MealType.BREAKFAST
        );
        model.addAttribute("breakfastItems", breakfast.getFoodItems());

        return "users/diary";
    }

    @PostMapping("/diary")
    public String saveDiaryEntries(@ModelAttribute Meal meal) {
        return "redirect:/diary";
    }

    @GetMapping("/diary/create")
    public String createDiaryPost(){
       return "users/diary";
    }



}
