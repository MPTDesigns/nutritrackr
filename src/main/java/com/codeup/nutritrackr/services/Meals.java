package com.codeup.nutritrackr.services;

import com.codeup.nutritrackr.models.Meal;
import com.codeup.nutritrackr.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Meals {

    private final Meals mealDao;

    public Meals(Meals mealDao) {
        this.mealDao = mealDao;
    }

    private List<Meal> findAllByUser(User user){

        return mealDao.findAllByUser(user);
    }
}
