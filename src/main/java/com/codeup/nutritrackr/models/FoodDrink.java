package com.codeup.nutritrackr.models;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "Food_Drinks")
public class FoodDrink {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Min(value = 0)
    private int calories;

    @Column(nullable = false)
    @Min(value = 0)
    private int protein;

    @Column(nullable = false)
    @Min(value = 0)
    private int fat;

    @Column(nullable = false)
    private int carbohydrates;

    public FoodDrink(String description, int calories, int protein, int fat, int carbohydrates) {
        this.description = description;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
}
