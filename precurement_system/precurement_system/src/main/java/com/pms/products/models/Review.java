package com.pms.products.models;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "comments")
    private String comments;

    @ManyToOne(targetEntity = Product.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "Product_details_id", referencedColumnName = "id")
    private Integer productId;

    @Transient
    private Integer Product_details_id;

}
