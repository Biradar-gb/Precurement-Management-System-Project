package com.pms.products.models;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.lang.reflect.GenericArrayType;

@Entity
@Table(name = "brand_details")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String b_name;
}
