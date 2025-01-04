package com.pms.products.models;

import com.pms.sellercompany.company.model.Company;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "product_details")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "p_name")
    private String productName;

    @Column(name = "unit_price")
    private Integer unitPrice;

    @Column(name = "decription")
    private String decription;

    @ManyToOne(targetEntity = Brand.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "brand_details_id")
    private Integer brandId;

    @Transient
    private Integer brand_id;

    @ManyToOne(targetEntity = Model.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "model_details_id", referencedColumnName = "id")
    private Integer modelId;

    @Transient
    private Integer model_Id;

    @ManyToOne(targetEntity = Company.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_details_id", referencedColumnName = "id")
    private Integer companyId;

    @Transient
    private Integer company_id;

    @OneToMany(targetEntity = ProductReview.class , cascade = CascadeType.MERGE , fetch = FetchType.LAZY)
    @JoinColumn(name="id" , referencedColumnName = "Product_details_id")
    private List<ProductReview> reviewList;

    @Transient
    private List<ProductReview> review;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public List<ProductReview> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<ProductReview> reviewList) {
        this.reviewList = reviewList;
    }
}
