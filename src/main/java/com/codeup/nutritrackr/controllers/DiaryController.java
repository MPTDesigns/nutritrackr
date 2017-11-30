package com.codeup.nutritrackr.controllers;

import com.codeup.nutritrackr.models.FoodDrink;
import com.codeup.nutritrackr.models.Meal;
import com.codeup.nutritrackr.models.MealType;
import com.codeup.nutritrackr.models.User;
import com.codeup.nutritrackr.services.Meals;
import com.codeup.nutritrackr.services.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class DiaryController {

    private final Users users;
    private final Meals meals;
    private final LocalDate diaryDate;



    public DiaryController(Users users, Meals meals, LocalDate diaryDate) {
        this.users = users;
        this.meals = meals;
        this.diaryDate = diaryDate;


    }

    @GetMapping("/diary")
    public String showDiaryPage(HttpSession session, Model model) {
//        Meal mealToSave = new Meal(users.findOne(1));
//        mealToSave.setMealType(MealType.BREAKFAST);
//        mealToSave.setMealDate(LocalDate.now());
//        mealToSave.setFoodItems(new ArrayList<>());
//        mealToSave.getFoodItems().add(foodDrinks.findOne(3));
//        meals.save(mealToSave);
        LocalDate diaryDate = (LocalDate) session.getAttribute("diaryDate");
        if(diaryDate == null) {
            diaryDate = LocalDate.now();
            session.setAttribute("diaryDate", diaryDate);
        }

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

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

    @GetMapping("/diary/prev")
    public String minusDate() {
        diaryDate.minusDays(1);
        return "redirect:/diary";
    }

    @GetMapping("/diary/next")
    public String plusDate(@ModelAttribute LocalDate diaryDate){
        diaryDate.plusDays(1);
        return "redirect/diary";

    }



}
