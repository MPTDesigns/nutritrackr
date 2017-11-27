package com.codeup.nutritrackr.repositories;

import com.codeup.nutritrackr.models.FoodDrink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodDrinksRepository extends CrudRepository<FoodDrink, Long> {

}
