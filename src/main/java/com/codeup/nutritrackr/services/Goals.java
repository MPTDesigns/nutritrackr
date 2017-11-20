package com.codeup.nutritrackr.services;

import com.codeup.nutritrackr.models.Goal;
import com.codeup.nutritrackr.models.User;
import com.codeup.nutritrackr.repositories.GoalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Goals {
    private final GoalsRepository goalsDao;

    @Autowired
    public Goals(GoalsRepository goalsDao) {
        this.goalsDao = goalsDao;
    }

    public Goal findMostRecentUserGoals(User user) {
        return goalsDao.findTop1ByUserOrderByStartDateDesc(user);
    }

    public Goal save(Goal goal) {
        return goalsDao.save(goal);
    }
}
