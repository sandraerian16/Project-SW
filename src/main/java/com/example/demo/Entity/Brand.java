package com.example.demo.Entity;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Brand {
    @Id
    String name;
    String category;
    String type;


    public Brand(String name, String category,  String type) {
        this.name = name;
        this.category = category;
        this.type = type;
    }

    public Brand() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

