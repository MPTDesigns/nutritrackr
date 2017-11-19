package com.codeup.nutritrackr.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;


@Entity
@Table(name = "Goals")
public class Goal {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    @Min(value = 0)
    private int calorieGoal;

    @Column(nullable = false)
    @Min(value = 0, message = "The protein percentage goal cannot be less than 0%")
    @Max(value = 100, message = "The protein percentage goal cannot be more than 100%")
    private int proteinGoal;

    @Column(nullable = false)
    @Min(value = 0, message = "The fat percentage goal cannot be less than 0%")
    @Max(value = 100, message = "The fat percentage goal cannot be more than 100%")
    private int fatGoal;

    @Column(nullable = false)
    @Min(value = 0, message = "The carbohydrate percentage goal cannot be less than 0%")
    @Max(value = 100, message = "The carbohydrate percentage goal cannot be more than 100%")
    private int carbGoal;

    @Autowired
    public Goal() {
    }

    public Goal(User user, int calorieGoal, int proteinGoal, int fatGoal, int carbGoal) {
        this.user = user;
        this.startDate = LocalDateTime.now();
        this.calorieGoal = calorieGoal;
        this.proteinGoal = proteinGoal;
        this.fatGoal = fatGoal;
        this.carbGoal = carbGoal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public int getCalorieGoal() {
        return calorieGoal;
    }

    public void setCalorieGoal(int calorieGoal) {
        this.calorieGoal = calorieGoal;
    }

    public int getProteinGoal() {
        return proteinGoal;
    }

    public void setProteinGoal(int proteinGoal) {
        this.proteinGoal = proteinGoal;
    }

    public int getFatGoal() {
        return fatGoal;
    }

    public void setFatGoal(int fatGoal) {
        this.fatGoal = fatGoal;
    }

    public int getCarbGoal() {
        return carbGoal;
    }

    public void setCarbGoal(int carbGoal) {
        this.carbGoal = carbGoal;
    }
}
