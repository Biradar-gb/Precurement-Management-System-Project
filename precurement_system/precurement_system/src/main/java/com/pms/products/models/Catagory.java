package com.pms.products.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.annotation.processing.Generated;

@Entity
public class Catagory {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String Category_name;


}
