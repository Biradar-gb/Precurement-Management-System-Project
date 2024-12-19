package com.pms.sellercompany.companybank.model;

import com.pms.sellercompany.compnaycontact.model.CompanyContact;
import jakarta.persistence.*;

@Entity
@Table(name="company_bank_details")
public class CompanyBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer  id;

    @Column(name="name")
    private String name;

    @Column(name="accont_number")
     private Long account_number;

     @Column(name="branch")
     private String branch;

     @Column(name="ifsc_code")
     private String ifsc_code;

     @Column(name="pan_number")
     private String pan_number;

     @OneToOne(cascade = CascadeType.MERGE)
     @JoinColumn(name="company_details_id",referencedColumnName = "id")
     private CompanyContact company_details;

     @Transient
     private Integer  company_details_id;


}
