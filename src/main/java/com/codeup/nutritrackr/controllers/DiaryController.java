package com.codeup.nutritrackr.controllers;

import com.codeup.nutritrackr.models.FoodDrink;
import com.codeup.nutritrackr.models.Meal;
import com.codeup.nutritrackr.models.MealType;
import com.codeup.nutritrackr.models.User;
import com.codeup.nutritrackr.services.Meals;
import com.codeup.nutritrackr.services.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
@SessionAttributes({"diaryDate"})
public class DiaryController {

    private final Users users;
    private final Meals meals;

    public DiaryController(Users users, Meals meals) {
        this.users = users;
        this.meals = meals;
    }

    @GetMapping("/diary")
    public String showDiaryPage(@ModelAttribute("diaryDate") LocalDate diaryDate, Model model) {
//        Meal mealToSave = new Meal(users.findOne(1));
//        mealToSave.setMealType(MealType.BREAKFAST);
//        mealToSave.setMealDate(LocalDate.now());
//        mealToSave.setFoodItems(new ArrayList<>());
//        mealToSave.getFoodItems().add(foodDrinks.findOne(3));
//        meals.save(mealToSave);
        User user = users.findOne(1);

        if(diaryDate == null) {
            diaryDate = LocalDate.now();
        }

        Meal breakfast = meals.findMealForDayByType(user, diaryDate, MealType.BREAKFAST);
        Meal lunch = meals.findMealForDayByType(user, diaryDate, MealType.LUNCH);
        Meal dinner = meals.findMealForDayByType(user, diaryDate, MealType.DINNER);
        Meal snacks = meals.findMealForDayByType(user, diaryDate, MealType.SNACK);

        model.addAttribute("diaryDate", diaryDate);
        model.addAttribute("breakfast", breakfast);
        model.addAttribute("lunch", lunch);
        model.addAttribute("dinner", dinner);
        model.addAttribute("snacks", snacks);

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
