package com.codeup.nutritrackr.services;

import com.codeup.nutritrackr.models.FoodDrink;
import com.codeup.nutritrackr.models.Meal;
import com.codeup.nutritrackr.models.MealType;
import com.codeup.nutritrackr.models.User;
import com.codeup.nutritrackr.repositories.MealRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public Meal save(Meal meal) {
        return mealDao.save(meal);
    }

    public Meal findOne(long id) {
        return mealDao.findOne(id);
    }

    public Meal findMealForDayByType(User user, LocalDate mealDate, MealType mealType) {
        Meal meal = mealDao.findByUserAndMealDateAndMealType(user, mealDate, mealType);

        if(meal == null) {
            return new Meal(user, mealDate, mealType);
        }

        return meal;
    }

    public void delete(FoodDrink entryToDelete) {
        mealDao.delete(entryToDelete.getId());
    }

}
