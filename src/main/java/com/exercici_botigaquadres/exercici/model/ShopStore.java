package com.exercici_botigaquadres.exercici.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shop_store")
public class ShopStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idStore")
    private int idStore;
    @Column(name="Name")
    private String name;
    @Column(name="Capacity")
    private int capacity;


    @OneToMany(mappedBy="homeshopStore" , fetch = FetchType.LAZY)
    private List<Picture> pictureList ;

    public ShopStore() {
        super();
        pictureList = new ArrayList<>();
    }

    public ShopStore(int idStore, String name, int capacity, List<Picture> pictureList) {
        super();
        this.idStore = idStore;
        this.name = name;
        this.capacity = capacity;
        this.pictureList = pictureList;
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

    public void setPictureList(Picture picture) {

        this.pictureList.add(picture);
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
