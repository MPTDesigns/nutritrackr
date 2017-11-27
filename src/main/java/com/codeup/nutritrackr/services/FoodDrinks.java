package com.codeup.nutritrackr.services;

import com.codeup.nutritrackr.models.FoodDrink;
import com.codeup.nutritrackr.repositories.FoodDrinksRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodDrinks {
    private FoodDrinksRepository foodDrinksDao;

    public FoodDrinks(FoodDrinksRepository foodDrinksDao) {
        this.foodDrinksDao = foodDrinksDao;
    }

    public FoodDrink findOne(long id) {
        return foodDrinksDao.findOne(id);
    }

    public FoodDrink save(FoodDrink foodDrink) {
        return foodDrinksDao.save(foodDrink);
    }

    public List<FoodDrink> findAll() {
        return (List<FoodDrink>) foodDrinksDao.findAll();
    }

    public List<FoodDrink> searchFoodDrinks(String description) {
        return (List<FoodDrink>) foodDrinksDao.findAllByDescriptionContainingIgnoreCase(description);
    }
}
