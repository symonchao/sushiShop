package com.sushi.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "sushi")
public class Sushi {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private int id;
    @Column(name = "name") private String name;
    @Column(name = "time_to_make") private int timeToMake;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeToMake() {
        return timeToMake;
    }

    public void setTimeToMake(int timeToMake) {
        this.timeToMake = timeToMake;
    }

    @Override
    public String toString() {
        return "Sushi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", timeToMake=" + timeToMake +
                '}';
    }
}
