package com.sushi.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @Column(name = "id") private int id;
    @Column(name = "name") private String name;
}
