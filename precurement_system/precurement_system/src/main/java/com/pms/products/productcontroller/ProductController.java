package com.pms.products.productcontroller;

import com.pms.products.dtos.ProductDto;
import com.pms.products.models.Product;
import com.pms.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    ProductService service;

    @PostMapping("/create")
    public ProductDto addProducts(@RequestBody ProductDto dto){

        return service.addProducts(dto);
    }

}
