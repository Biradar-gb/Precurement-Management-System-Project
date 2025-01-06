package com.pms.products.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pms.sellercompany.company.model.Company;
import jakarta.persistence.*;

import java.awt.Image;
import java.util.List;


@Entity
@Table(name = "product_details")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "p_name")
    private String productName;

    @Column(name = "unit_price")
    private Integer unitPrice;

    @Column(name = "decription")
    private String decription;

    @ManyToOne(targetEntity = Brand.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_details_id", referencedColumnName = "id")
    private Brand brandId;

    @Transient
    private Integer brand_id;

    @JsonBackReference
    @ManyToOne(targetEntity = Model.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "model_details_id", referencedColumnName = "id")
    private Model modelId;

    @Transient
    private Integer model_Id;

    @JsonBackReference
    @ManyToOne( targetEntity = Company.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_details_id", referencedColumnName = "id")
    private Company companyId;

    @Transient
    private Integer company_id;

    @OneToMany(targetEntity = Review.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "Product_details_id")
    private List<Review> reviewList;

    @Transient
    private List<Review> review;


    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(
            name = "colour_has_Product_details",
            joinColumns = @JoinColumn(name = "Product_details_id"),
            inverseJoinColumns = @JoinColumn(name = "colour_id"))
    private List<Colour> colours;

    @Transient
    private List<Colour> col;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name="id" , referencedColumnName = "Product_details_id")
    private List<Image> img;

    @Transient
    private  List<Image> images;

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

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }


    public List<Colour> getColours() {
        return colours;
    }

    public void setColours(List<Colour> colours) {
        this.colours = colours;
    }

    public List<Image> getImg() {
        return img;
    }

    public void setImg(List<Image> img) {
        this.img = img;
    }

    public Model getModelId() {
        return modelId;
    }

    public void setModelId(Model modelId) {
        this.modelId = modelId;
    }
}
