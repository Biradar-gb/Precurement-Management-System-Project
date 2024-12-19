package com.pms.products.models;


import jakarta.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "image")
    private String image;

    @Column(name = "Product_details_id")
    private Integer product_details_id;
}
