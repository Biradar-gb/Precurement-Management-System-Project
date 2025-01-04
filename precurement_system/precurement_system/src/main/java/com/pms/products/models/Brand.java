package com.pms.products.models;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.lang.reflect.GenericArrayType;
import java.util.List;

@Entity
@Table(name = "brand_details")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "b_name")
    private String brandName;

    @OneToMany( targetEntity = Brand.class, cascade = CascadeType.MERGE ,fetch = FetchType.LAZY)
    @JoinColumn(name = "id" , referencedColumnName = "brand_details_id")
    private List<Product> p ;

    @Transient
    private List<Product> p1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<Product> getP() {
        return p;
    }

    public void setP(List<Product> p) {
        this.p = p;
    }
}
