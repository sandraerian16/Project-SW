package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    String name;
    String store_ID;
    String product_type;
    int quntity;
    int price;

    public int getNum_buy() {
        return num_buy;
    }

    public void setNum_buy(int num_buy) {
        this.num_buy = num_buy;
    }

    public int getNum_view() {
        return num_view;
    }

    public void setNum_view(int num_view) {
        this.num_view = num_view;
    }

    int num_buy;
    int num_view;

    public Product(String name, String store_ID, String product_type, int quntity, int price, int num_buy, int num_view) {
        this.name = name;
        this.store_ID = store_ID;
        this.product_type = product_type;
        this.quntity = quntity;
        this.price = price;
        this.num_buy = num_buy;
        this.num_view = num_view;
    }

    public Product() {
         num_buy=0;
         num_view=0;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStore_ID() {
        return store_ID;
    }

    public void setStore_ID(String store_ID) {
        this.store_ID = store_ID;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public int getQuntity() {
        return quntity;
    }

    public void setQuntity(int quntity) {
        quntity = quntity;
    }
}
