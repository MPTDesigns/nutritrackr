package com.codeup.nutritrackr.services;

import com.codeup.nutritrackr.models.Diary;
import com.codeup.nutritrackr.models.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class Diaries {
    private List<Diary> foods;

    @Autowired
    public Diaries() {
        createFoods();
    }

    public List<Diary> findAll() {
        return foods;
    }

    public Diary save(Diary food) {
        food.setId(foods.size() + 1);
        foods.add(food);
        return food;
    }

    private void setId(int i) {
    }


    public Diary findOne(long id) {
        return foods.get((int) (id - 1));
    }

    private void createFoods() {
        // create some ad objects and add them to the ads list
        // with the save method
    }

}