package com.exercici_botigaquadres.exercici.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "picture")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="idPicture")
    private int idPicture;

    @Column(name="Name")
    private String name;
    @Column(name="Author")
    private String author;
    @Column(name="Price")
    private double price;
    @Column(name="Date")
    Date date;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinTable(name = "shop_pictures"
                ,joinColumns=@JoinColumn(name = "idPicture", referencedColumnName = "idPicture")
                ,inverseJoinColumns = @JoinColumn(name = "idStore", referencedColumnName = "idStore")
    )
    //@JoinColumn(name="idStore", insertable = false, updatable = false)
    private ShopStore homeshopStore;

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
        //this.date = date;
        this.homeshopStore = shopStore;
    }

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
        return homeshopStore;
    }

    public void setShopStore(ShopStore shopStore) {
        this.homeshopStore = shopStore;
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
