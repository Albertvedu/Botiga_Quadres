package com.exercici_botigaquadres.exercici.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "picture")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="idPicture")
    private int idPicture;
    @Column(name="Name")
    private String name;
    @Column(name="Author")
    private String author;
    @Column(name="Price")
    private double price;
    @Column(name="Date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;


    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinColumn(name="idStore", insertable = false, updatable = false)
    private ShopStore shopStore;

    @Column(name = "idStore")
    private int idStore;

    public Picture() {
    }

    public Picture(int idPicture, String name, String author, double price, Date date, ShopStore shopStore) {
        this.idPicture = idPicture;
        this.name = name;
        this.author = author;
        this.price = price;
        this.date = date;
        this.shopStore = shopStore;
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
        return shopStore;
    }

    public void setShopStore(ShopStore shopStore) {
        this.shopStore = shopStore;
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

            Date ahora = new Date();
            SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");


        return formateador.format(ahora);
       // return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
