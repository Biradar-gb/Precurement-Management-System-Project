package com.pms.products.models;


import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "image")
    private String image;

    @ManyToOne(targetEntity = Product.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "Product_details_id" ,referencedColumnName = "id")
    private Product productId;

    @Transient
    private Integer product_details_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public Product getProductId() {
//        return productId;
//    }
//
//    public void setProductId(Product productId) {
//        this.productId = productId;
//    }
}
