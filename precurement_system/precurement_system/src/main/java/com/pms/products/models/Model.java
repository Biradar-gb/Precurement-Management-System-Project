package com.pms.products.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "model_details")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "m_name")
    private String modelName;

    @OneToMany(targetEntity = Product.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "model_details_id", referencedColumnName = "id")
    private List<Product> product;

    @Transient
    private List<Product> p1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

}
