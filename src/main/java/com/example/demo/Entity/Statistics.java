package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Statistics {
    String Entity;
    @Id
    String Function;
    long Value;

    public Statistics(String entity, String function, long value) {
        Entity = entity;
        Function = function;
        Value = value;
    }

    public String getEntity() {
        return Entity;
    }

    public void setEntity(String entity) {
        Entity = entity;
    }

    public String getFunction() {
        return Function;
    }

    public void setFunction(String function) {
        Function = function;
    }

    public long getValue() {
        return Value;
    }

    public void setValue(long value) {
        Value = value;
    }

    public Statistics() {

    }
}
