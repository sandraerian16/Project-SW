package com.example.demo.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Actions {

    @Id @GeneratedValue
    int ID;
    String type;
    String productName;
    String storeID;
    String product_type;
    int product_quntity;
    int product_price;


    public Actions(String type, String productName
            , String storeID, String product_type, int product_quntity
            , int product_price) {
        this.type = type;
        this.productName = productName;
        this.storeID = storeID;
        this.product_type = product_type;
        this.product_quntity = product_quntity;
        this.product_price = product_price;
    }

    public Actions() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public int getProduct_quntity() {
        return product_quntity;
    }

    public void setProduct_quntity(int product_quntity) {
        this.product_quntity = product_quntity;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }
}
