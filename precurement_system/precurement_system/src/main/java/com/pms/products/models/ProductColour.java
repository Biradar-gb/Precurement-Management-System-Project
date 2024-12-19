package com.pms.products.models;

import jakarta.persistence.*;

@Entity
@Table(name="Product_details_has_sizes")
public class ProductColour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer colour_id;


    private  Integer product_details_id;

}
