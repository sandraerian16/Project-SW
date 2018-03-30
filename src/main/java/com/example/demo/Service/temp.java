package com.example.demo.Service;

import javax.persistence.Entity;

public class temp{
    int num;
    String address;
    String name;
    boolean agree;


     public temp() {
         agree=false;
     }

     public temp(int num, String address, String name, boolean agree) {
         this.num = num;
         this.address = address;
         this.name = name;
         this.agree = agree;
     }


     public int getNum() {
         return num;
     }

     public void setNum(int num) {
         this.num = num;
     }

     public String getAddress() {
         return address;
     }

     public void setAddress(String address) {
         this.address = address;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public boolean isAgree() {
         return agree;
     }

     public void setAgree(boolean agree) {
         this.agree = agree;
     }
 }


