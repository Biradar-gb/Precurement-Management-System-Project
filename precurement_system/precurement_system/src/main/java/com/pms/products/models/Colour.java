package com.pms.products.models;

import jakarta.persistence.*;

import java.util.List;

public class Colour {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "colour", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

    @Transient
    private List<Product> p;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
