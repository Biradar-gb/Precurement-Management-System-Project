package com.pms.sellercompany.companybank.model;

import com.pms.sellercompany.company.model.Company;
import jakarta.persistence.*;

@Entity
@Table(name="company_bank_details")
public class CompanyBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer  id;

    @Column(name="bank_name")
    private String name;

    @Column(name="account_number")
     private Long accountNumber;

     @Column(name="branch")
     private String branch;

     @Column(name="ifsc_code")
     private String ifscCode;

     @Column(name="pan_number")
     private String panNumber;

     @OneToOne(targetEntity = Company.class , cascade = CascadeType.MERGE ,fetch = FetchType.LAZY)
     @JoinColumn(name="company_details_id",referencedColumnName = "id")
     private Company companyDetails;

     @Transient
     private Integer  companyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public Company getCompanyDetails() {
        return companyDetails;
    }

    public void setCompanyDetails(Company companyDetails) {
        this.companyDetails = companyDetails;
    }
}
