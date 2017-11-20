package com.codeup.nutritrackr.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Meals")
public class Diary {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private LocalDateTime date;


    public Diary(long id, User user, String type) {
        this.id = id;
        this.user = user;
        this.type = type;
    }

    public Diary() {

    }

//    public void setfood(Diary food) {
//        this.food = food;
//    }

    public void save(Diary diary) {
    }

    public void setId(long id) {
        this.id = id;
    }
}
