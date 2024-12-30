package com.pms.sellercompany.companyowner.dto;

public class OwnerDto {
    private Integer id;

    private String ownerName;


    private String  dinNumber;

    private Long mobileNumber;

    private Integer companyId;

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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
