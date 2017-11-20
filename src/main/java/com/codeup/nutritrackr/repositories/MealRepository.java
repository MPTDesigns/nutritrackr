package com.codeup.nutritrackr.repositories;

import com.codeup.nutritrackr.models.Meal;
import com.codeup.nutritrackr.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {

    List<Meal> getAllByUser(User user);
}
