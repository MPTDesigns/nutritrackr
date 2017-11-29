package com.codeup.nutritrackr.repositories;

import com.codeup.nutritrackr.models.Meal;
import com.codeup.nutritrackr.models.MealType;
import com.codeup.nutritrackr.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {
    Meal findByUserAndMealDateAndMealType(User user, LocalDate mealDate, MealType mealType);
    List<Meal> getAllByUser(User user);
}
