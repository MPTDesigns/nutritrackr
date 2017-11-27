package com.codeup.nutritrackr.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Meals")
public class Meal {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MealType mealType;

    @Column(nullable = false)
    private LocalDate mealDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "Meal_Items",
        joinColumns = {@JoinColumn(name = "meal_id")},
        inverseJoinColumns = {@JoinColumn(name = "food_drink_id")}
    )
    private List<FoodDrink> foodItems;

    @Autowired
    public Meal(User user) {
        this.user = user;
    }

    public Meal() { }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public LocalDate getMealDate() {
        return mealDate;
    }

    public void setMealDate(LocalDate mealDate) {
        this.mealDate = mealDate;
    }

    public List<FoodDrink> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodDrink> foodItems) {
        this.foodItems = foodItems;
    }
}
