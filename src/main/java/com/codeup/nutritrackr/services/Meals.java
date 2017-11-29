package com.codeup.nutritrackr.services;

import com.codeup.nutritrackr.models.FoodDrink;
import com.codeup.nutritrackr.models.Meal;
import com.codeup.nutritrackr.models.User;
import com.codeup.nutritrackr.repositories.MealRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Meals {

    private final MealRepository mealDao;

    public Meals(MealRepository mealDao) {
        this.mealDao = mealDao;
    }

    private List<Meal> findAllByUser(User user){

        return mealDao.getAllByUser(user);
    }

//    public Meal save(Meal meal) {
//        meal.setId(items.size() + 1);
//        items.add(meal);
//        return meal;
//    }

}
