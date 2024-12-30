package com.pms.sellercompany.companybank.dto;

import com.pms.sellercompany.company.model.Company;
import com.pms.sellercompany.companybank.model.CompanyBank;

public class BankDto {


    private Integer id;
    private String name;
    private Long accountNumber;
    private String branch;
    private String ifscCode;
    private String panNumber;
    private Integer companyId;
    private Company companyDetails;

    public BankDto() {


    }

    public BankDto(CompanyBank companyBank) {
        id = companyBank.getId();
        name = companyBank.getName();
        accountNumber = companyBank.getAccountNumber();
        panNumber = companyBank.getPanNumber();
        ifscCode = companyBank.getIfscCode();
        branch = companyBank.getBranch();
        companyDetails = companyBank.getCompanyDetails();
    }

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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
