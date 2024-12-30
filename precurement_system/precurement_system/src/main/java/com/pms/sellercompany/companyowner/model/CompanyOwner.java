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


    @Column(name="name")
    private String ownerName;

    @Column(name="din_number")
    private String  dinNumber;

    @Column(name="mobile")
    private Long mobileNumber;

    @ManyToOne( targetEntity = Company.class ,cascade = CascadeType.MERGE ,fetch = FetchType.LAZY)
    @JoinColumn(name="company_details_id",referencedColumnName = "id")
    private Company company_details;

    @Transient
    private  String company_details_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }


    public String getDinNumber() {
        return dinNumber;
    }

    public void setDinNumber(String dinNumber) {
        this.dinNumber = dinNumber;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Company getCompany_details() {
        return company_details;
    }

    public void setCompany_details(Company company_details) {
        this.company_details = company_details;
    }
}




