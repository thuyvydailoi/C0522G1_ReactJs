package com.codegym.model.order;

import com.codegym.model.alcohol.Alcohol;
import com.codegym.model.customer.Customer;

import javax.persistence.*;

@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String datePayment;
    private boolean isDelete = false;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "alcohol_id", referencedColumnName = "id")
    private Alcohol alcohol;

    public OrderDetail(Integer id, String datePayment, boolean isDelete, Integer quantity, Alcohol alcohol) {
        this.id = id;
        this.datePayment = datePayment;
        this.isDelete = isDelete;
        this.quantity = quantity;
        this.alcohol = alcohol;
    }

    public OrderDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(String datePayment) {
        this.datePayment = datePayment;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Alcohol getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Alcohol alcohol) {
        this.alcohol = alcohol;
    }
}
