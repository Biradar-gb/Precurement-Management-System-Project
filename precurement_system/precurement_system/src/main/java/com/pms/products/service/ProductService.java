package com.pms.products.service;


import com.pms.products.dtos.ProductDto;
import com.pms.products.models.Product;
import com.pms.products.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;


    public ProductDto addProducts(@RequestBody ProductDto dto){

        return repo.addProducts(dto);
    }


}
