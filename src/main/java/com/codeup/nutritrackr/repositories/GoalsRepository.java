package com.codeup.nutritrackr.repositories;

import com.codeup.nutritrackr.models.Goal;
import com.codeup.nutritrackr.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalsRepository extends CrudRepository<Goal, Long> {
    Goal findTop1ByUserOrderByStartDateDesc(User user);
}
