package com.pms.products.dtos;

import com.pms.products.models.Product;

import java.util.List;

public class BrandDto {

    private Integer id;

    private String brandName;


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

//    public List<Product> getP() {
//        return p;
//    }
//
//    public void setP(List<Product> p) {
//        this.p = p;
//    }
}
