package com.codeup.nutritrackr.services;

import com.codeup.nutritrackr.models.FoodDrink;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodDrinks {
    private List<FoodDrink> items;

    public FoodDrinks() {
        createFoodDrinks();
    }

    private void createFoodDrinks() {
        items = new ArrayList<>();
        save(new FoodDrink(
            "Chicken",
                200,
                20,
                5,
                0
        ));

        save(new FoodDrink(
            "Cake",
                500,
                1,
                20,
                50
        ));
    }

    public List<FoodDrink> findAll() {
        return items;
    }

    public FoodDrink findOne(long id) {
        return items.get((int) (id - 1));
    }

    public FoodDrink save(FoodDrink foodDrink) {
        foodDrink.setId(items.size() + 1);
        items.add(foodDrink);
        return foodDrink;
    }
}
