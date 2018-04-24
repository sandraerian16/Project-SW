package com.example.demo.Entity;

import javax.persistence.*;

@Entity
public class Collaborators_Class {

    @Id
    String name;
    String Password_ID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPassword_ID() {
        return Password_ID;
    }

    public void setPassword_ID(String password_ID) {
        Password_ID = password_ID;
    }
    public Collaborators_Class() {
    }

    public Collaborators_Class(String name, String password_ID) {
        this.name = name;
        Password_ID = password_ID;
    }

}
