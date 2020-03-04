package com.pmarcin.projects.rng.randomnumbergenerator.repository.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "numbers")
public class Number {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer value;

    public Number() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
