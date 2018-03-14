package com.example.demo.Controllers.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    String user_name;
    String password;
    String email;
    String bankaccount;
    String address;
    String type;



    public User(String user_name, String password, String email, String Bank_account,  String Address,  String type) {
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        bankaccount = Bank_account;
        address = address;
        this.type = type;
    }

    public User() {
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBank_account() {
        return bankaccount;
    }

    public void setBank_account(String Bank_account) {
        bankaccount = Bank_account;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        address = Address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
