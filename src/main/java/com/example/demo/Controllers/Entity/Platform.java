package com.example.demo.Controllers.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Platform {
    @Id
    String Product_name;
    String Product_brand;
    int price_start;
    String product_category;

    public int getPrice_end() {
        return price_end;
    }

    public int getPrice_start() {
        return price_start;
    }

    public void setPrice_start(int price_start) {
        this.price_start = price_start;
    }

    public void setPrice_end(int price_end) {
        this.price_end = price_end;
    }

    int price_end;

    public Platform(String product_name, String product_brand, int product_price, String product_category,int Price_end) {
        Product_name = product_name;
        Product_brand = product_brand;
        price_start = product_price;
        this.product_category = product_category;
        this.price_end=Price_end;
    }

    public Platform() {
    }

    public String getProduct_name() {
        return Product_name;
    }

    public void setProduct_name(String product_name) {
        Product_name = product_name;
    }

    public String getProduct_brand() {
        return Product_brand;
    }

    public void setProduct_brand(String product_brand) {
        Product_brand = product_brand;
    }


    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }
}
