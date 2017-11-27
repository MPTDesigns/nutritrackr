package com.codeup.nutritrackr.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Meals")
public class Meal {
    public static void save(Meal meal) {
    }

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "Meal_Items",
        joinColumns = {@JoinColumn(name = "meal_id")},
        inverseJoinColumns = {@JoinColumn(name = "food_drink_id")}
    )
    private List<FoodDrink> foodItems;

    @Autowired
    public Meal() {
    }

    public void setId(long id) {
        this.id = id;
    }
}
