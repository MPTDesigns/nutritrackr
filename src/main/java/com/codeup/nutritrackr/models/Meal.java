package com.codeup.nutritrackr.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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

    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "Meal_Items",
        joinColumns = {@JoinColumn(name = "meal_id")},
        inverseJoinColumns = {@JoinColumn(name = "food_drink_id")}
    )
    private List<FoodDrink> foodItems;

    @Autowired
//    public Meal(User user) {
//        this.user = user;
//    }

    public Meal(User user, LocalDate mealDate, MealType mealType) {
        this.user = user;
        this.mealDate = mealDate;
        this.mealType = mealType;
        this.foodItems = new ArrayList<>();
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

    public int getTotalCalories() {
        int total = 0;

        for(FoodDrink foodItem : this.foodItems) {
            total += foodItem.getCalories();
        }

        return total;
    }

    public int getTotalProtein() {
        int total = 0;

        for(FoodDrink foodItem : this.foodItems) {
            total += foodItem.getProtein();
        }

        return total;
    }

    public int getTotalFat() {
        int total = 0;

        for(FoodDrink foodItem : this.foodItems) {
            total += foodItem.getFat();
        }

        return total;
    }

    public int getTotalCarbohydrates() {
        int total = 0;

        for(FoodDrink foodItem : this.foodItems) {
            total += foodItem.getCarbohydrates();
        }

        return total;
    }
}
