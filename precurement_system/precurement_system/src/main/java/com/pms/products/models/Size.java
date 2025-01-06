package com.pms.products.models;

import jakarta.persistence.*;

@Entity
@Table(name="sizes")
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sizes_id")
    private Size productSize;

    private Integer Sizes_id;

    @ManyToOne(targetEntity = Size.class,cascade = CascadeType.MERGE ,fetch = FetchType.LAZY)
    @JoinColumn(name="Product_details_id")
    private Integer product_details_id;

}
