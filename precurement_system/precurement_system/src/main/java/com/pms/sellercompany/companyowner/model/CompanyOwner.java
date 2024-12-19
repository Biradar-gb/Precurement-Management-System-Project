package com.pms.sellercompany.companyowner.model;

import com.pms.sellercompany.company.model.Company;
import jakarta.persistence.*;

@Entity
@Table(name="Company_owner")
public class CompanyOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="owner_id")
    private Integer  owner_id;

    @Column(name="name")
    private String name;

    @Column(name="cin_number")
    private  String cin_number;

    @Column(name="din_number")
    private String  din_number;

    @Column(name="mobile")
    private Long mobile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_details_id",referencedColumnName = "id")
    private Company company_details;

    @Transient
    private  String company_details_id;

}




