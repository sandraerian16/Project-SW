package com.example.demo.Entity;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

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
    String Collab;

    public String getCollab() {
        return Collab;
    }

    public void setCollab(String collab) {
        Collab = collab;
    }

    //ArrayList<Collaborators_Class> Collaborator= new ArrayList<>();


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
    /*public void setCollaborator(ArrayList<Collaborators_Class> collaborator) {
        Collaborator = collaborator;
    }

    public ArrayList<Collaborators_Class> getCollaborator()
    {
        return Collaborator;
    }

    public void AddCols(Collaborators_Class C)
    {
        Collaborator.add(C);
    }*/
    ArrayList<String> Collaborators= new ArrayList<>();

    public ArrayList<String> getCollaborators() {
        return Collaborators;
    }

    public void setCollaborators(ArrayList<String> collaborators) {
        Collaborators = collaborators;
    }


    public void Add_COLL_STRING(String C)
    {
        Collaborators.add(C);
        setCollaborators(Collaborators);
        /*Collaborators_Class d= new Collaborators_Class();
        d.setName(C);
        Collaborator.add(d);*/
    }
}