package com.pms.products.models;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "product_details")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "p_name")
    private String p_name;
    @Column(name = "unit_price")
    private Integer unit_price;
    @Column(name = "decription")
    private String decription;

    @ManyToOne(targetEntity = Brand.class, fetch = FetchType.LAZY)
    @JoinColumn(name="brand_details_id",referencedColumnName = "id")
    private Integer brand_details_id;


    private Integer model_details_id;

    private Integer company_details_id;


}
