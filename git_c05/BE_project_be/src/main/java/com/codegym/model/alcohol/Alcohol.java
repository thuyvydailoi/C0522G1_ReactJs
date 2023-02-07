package com.codegym.model.alcohol;

import javax.persistence.*;

@Entity
public class Alcohol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private boolean isDelete;
    private String price;
    private Integer discount;
    private String description;
    private String manufacturer;
    private String image;

    @ManyToOne
    @JoinColumn(name = "alcohol_type_id", referencedColumnName = "id")
    private AlcoholType alcoholType;

    public Alcohol() {
    }

    public Alcohol(Integer id, String name, boolean isDelete, String price, Integer discount, String description, String manufacturer, String image, AlcoholType alcoholType) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
        this.price = price;
        this.discount = discount;
        this.description = description;
        this.manufacturer = manufacturer;
        this.image = image;
        this.alcoholType = alcoholType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public AlcoholType getAlcoholType() {
        return alcoholType;
    }

    public void setAlcoholType(AlcoholType alcoholType) {
        this.alcoholType = alcoholType;
    }
}
