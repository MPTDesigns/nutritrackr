package com.codeup.nutritrackr.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Meals")
public class Meal {
    private enum MealName {
        BREAKFAST,
        LUNCH,
        DINNER,
        SNACK
    }

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MealName type;

    @Column(nullable = false)
    private LocalDateTime meal_date;

    @Autowired
    public Meal() {
    }
}
