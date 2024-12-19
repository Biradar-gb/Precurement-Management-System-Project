package com.pms.products.models;

import jakarta.persistence.*;

@Entity
@Table(name = "offers")
public class ProductOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "off_name")
    private String offerName;

    @Column(name = "Product_details_id")
    private String product_details_id;


}
