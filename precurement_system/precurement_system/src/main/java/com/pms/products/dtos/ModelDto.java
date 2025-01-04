package com.pms.products.dtos;

import com.pms.products.models.Product;

import java.util.List;

public class ModelDto {

    private Integer id;
    private String modelName;
    private List<Product> p;


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

    public List<Product> getP() {
        return p;
    }

    public void setP(List<Product> p) {
        this.p = p;
    }
}
