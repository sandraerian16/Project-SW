package com.example.demo.Entity;

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
    double balance;
    int  bought;


    public User(String user_name, String password, String email, String Bank_account,  String Address,  String type ,double balance) {
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.bankaccount = Bank_account;
        this.address = Address;
        this.type = type;
        this.balance=balance;
        this.bought=0;
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
        this.bankaccount = Bank_account;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    public double getbalance() {
        return balance;
    }

    public void setbalance(double balance) {
        this.balance = balance;
    }

    public int getBought() {
        return bought;
    }

    public void setBought(int bought) {
        this.bought= bought;
    }
}
