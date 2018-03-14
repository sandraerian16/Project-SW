package com.example.demo.Controllers.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.reflect.Array;

@Entity
public class Store {
    @Id
    String Store_name;
    String store_address;
    String store_telephone;
    String type;
    String location;
    Boolean approved;

    String Owner;

    public Store() {
        approved = false;
    }

    public Store(String store_name, String store_address, String store_telephone, String type, String location , String Owner) {
        Store_name = store_name;
        this.store_address = store_address;
        this.store_telephone = store_telephone;
        this.type = type;
        this.location = location;
        this.approved = false;
        this.Owner = Owner;
    }

    public String getOwner() {

        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getStore_name() {
        return Store_name;
    }

    public void setStore_name(String store_name) {
        Store_name = store_name;
    }

    public String getStore_address() {
        return store_address;
    }

    public void setStore_address(String store_address) {
        this.store_address = store_address;
    }

    public String getStore_telephone() {
        return store_telephone;
    }

    public void setStore_telephone(String store_telephone) {
        this.store_telephone = store_telephone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
}