package com.pms.products.models;

import jakarta.persistence.*;

@Entity
@Table(name="sizes")
public class ProductSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sizes_id")
    private ProductSize productSize;

    private Integer Sizes_id;

    @ManyToOne(targetEntity = ProductSize.class,cascade = CascadeType.MERGE ,fetch = FetchType.LAZY)
    @JoinColumn(name="Product_details_id")
    private Integer product_details_id;

}
