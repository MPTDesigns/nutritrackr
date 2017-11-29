package com.codeup.nutritrackr.controllers;

import com.codeup.nutritrackr.models.FoodDrink;
import com.codeup.nutritrackr.models.Meal;
import com.codeup.nutritrackr.models.MealType;
import com.codeup.nutritrackr.models.User;
import com.codeup.nutritrackr.services.FoodDrinks;
import com.codeup.nutritrackr.services.Meals;
import com.codeup.nutritrackr.services.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
@SessionAttributes({"diaryDate", "meal"})
public class FoodDrinksController {
    private FoodDrinks foodDrinks;
    private Meals meals;
    private Users users;

    @Autowired
    public FoodDrinksController(FoodDrinks foodDrinks, Meals meals, Users users) {
        this.foodDrinks = foodDrinks;
        this.meals = meals;
        this. users = users;
    }

    @GetMapping("/foods/add")
    public String showAddFoodForm(Model model) {
        model.addAttribute("newFoodDrink", new FoodDrink());
        return "foods/add";
    }

    @PostMapping("/foods/add")
    public String addNewFoodDrink(@ModelAttribute FoodDrink foodDrink) {
        FoodDrink foodDrinkToAdd = foodDrinks.save(foodDrink);

        return String.format("redirect:/foods/%d/addToMeal", foodDrinkToAdd.getId());
    }

    @GetMapping("/foods/search/{mealType}")
    public String forwardToFoodSearch(@PathVariable MealType mealType,
                                      @ModelAttribute("diaryDate") LocalDate diaryDate,
                                      Model model
    ) {

        User user = users.findOne(1);
        Meal meal = meals.findMealForDayByType(user, diaryDate, mealType);
        model.addAttribute("meal", meal);
        return "redirect:/foods/search";
    }

    @GetMapping("/foods/search")
    public String showFoodDrinksSearchFormAndResults() {
        return "foods/search";
    }

    @PostMapping("/foods/search")
    public String showSearchResults(@RequestParam("search-terms") String searchTerms, Model model) {
        model.addAttribute("results", foodDrinks.searchFoodDrinks(searchTerms));
        return "foods/search";
    }

    @GetMapping("/foods/{foodDrinkId}/addToMeal")
    public String addFoodToMeal(@PathVariable long foodDrinkId, @ModelAttribute("meal") Meal meal, SessionStatus status) {
        FoodDrink foodDrink = foodDrinks.findOne(foodDrinkId);
        meal.getFoodItems().add(foodDrink);
        meals.save(meal);
        return "redirect:/diary";
    }
}
