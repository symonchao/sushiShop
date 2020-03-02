package com.sushi.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalTime;

@Entity
@Table(name = "sushi_order")
public class SushiOrder {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private int id;
    @Column(name = "status_id") private int statusId;
    @Column(name = "sushi_id") private int sushiId;
    @Column(name = "createdat") private Timestamp createdAt;

   // Timestamp timestamp = Timestamp.valueOf(now);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getSushiId() {
        return sushiId;
    }

    public void setSushiId(int sushiId) {
        this.sushiId = sushiId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
