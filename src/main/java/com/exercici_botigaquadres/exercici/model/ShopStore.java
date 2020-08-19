package com.exercici_botigaquadres.exercici.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shop_store")
public class ShopStore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idStore")
    private int idStore;
    @Column(name="Name")
    private String name;
    @Column(name="Capacity")
    private int capacity;


    @OneToMany(mappedBy="shopStore")
    private List<Picture> pictureList = new ArrayList<>(capacity);


    public ShopStore() {
    }

    public ShopStore(int idStore, String name, int capacity) {
        this.idStore = idStore;
        this.name = name;
        this.capacity = capacity;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int id) {
        this.idStore = id;
    }

    public List<Picture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<Picture> picture) {
        this.pictureList = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


}
