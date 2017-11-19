package com.codeup.nutritrackr.repositories;

import com.codeup.nutritrackr.models.Goal;
import org.springframework.data.repository.CrudRepository;

public interface GoalsRepository extends CrudRepository<Goal, Long> {

}
