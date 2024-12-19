package com.pms.products.models;

import jakarta.persistence.*;

@Entity
@Table(name = "model_details")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="m_name")
    private String m_name;


}
