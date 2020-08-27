package com.exercici_botigaquadres.exercici.model;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
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
    @NotEmpty
    @Column(name="Name")
    private String name;
    //@NotEmpty(message = "Please enter name")
    //@Pattern(regexp = "[0-9]+", message="Solo números\n")
    @NonNull
    @Column(name="Capacity")
    private int capacity;



//    @JoinTable(name = "picture_in_shop"
//            ,joinColumns=@JoinColumn(name = "pictureId", referencedColumnName = "IdPicture")
//            ,inverseJoinColumns = @JoinColumn(name = "shopStoreId", referencedColumnName = "IdStore")
//    )
   // @OrderColumn(name="picture_number", nullable = true)
    @OneToMany(mappedBy="shopStoreMany" , fetch = FetchType.LAZY,  cascade=CascadeType.ALL)
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
