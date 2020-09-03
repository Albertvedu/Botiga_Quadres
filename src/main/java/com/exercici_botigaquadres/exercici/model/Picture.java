package com.exercici_botigaquadres.exercici.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "picture")
public class Picture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="idPicture", unique = true)
    private int idPicture;

    @NotEmpty
    @Column(name="Name")
    private String name;
    @NotEmpty
    @Column(name="Author")
    private String author;
    //@NonNull
    @Column(name="Price")
    private double price;
    @Column(name="Date")
    Date date;
//    @JoinColumn(name = "picture_number")
//    private int cosas;

  //  @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
//    @JoinTable(name = "picture_in_shop"
//                ,joinColumns=@JoinColumn(name = "PICTURE_ID", referencedColumnName = "IdPicture")
//                ,inverseJoinColumns = @JoinColumn(name = "SHOPSTORE_ID", referencedColumnName = "IdStore")
//    )
    @JsonIgnore
    @ManyToOne (fetch = FetchType.LAZY,  cascade=CascadeType.REFRESH)
    @JoinColumn(name="idStore", insertable = false, updatable = false)
    private ShopStore shopStoreMany;

    @Column(name = "idStore")
    private int idStore;

    public Picture() {
//        super();

    }

    public Picture(int idPicture, String name, String author, double price, ShopStore shopStore) {
        super();
        this.idPicture = idPicture;
        this.name = name;
        this.author = author;
        this.price = price;
        this.shopStoreMany = shopStore;
       // this.picture_number = picture_number;
    }
//
//    public int getCosas() {
//        ShopStore shopStore = new ShopStore();
//
//        return cosas;
//    }
//
//    public void setCosas(int cosas) {
//        this.cosas = cosas;
//    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int shopId) {
        this.idStore = shopId;
    }

    public int getIdPicture() {
        return idPicture;
    }

    public void setIdPicture(int idPicture) {
        this.idPicture = idPicture;
    }

    public ShopStore getShopStore() {
        return shopStoreMany;
    }

    public void setShopStore(ShopStore shopStore) {
        this.shopStoreMany = shopStore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {

        date = new Date();
        DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return fecha.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
