package com.example.models;

import javax.persistence.*;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = true, unique = true, name = "id")
    private int id;
    @OneToOne
    private Products product;
    @OneToOne
    private Customers customer;
    @Column(name = "order_time")
    private String orderTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Products getProducts() {
        return product;
    }

    public void setProducts(Products product) {
        this.product = product;
    }

    public Customers getCustomers() {
        return customer;
    }

    public void setCustomers(Customers customer) {
        this.customer = customer;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }
}
