package com.pms.sellercompany.companyLegaldocuments.dto;

public class CompanyDocDto {

    private Integer id;
    private String registrationNum;
    private String cinNum;
    private String dunNum;
    private String gstNum;



    public CompanyDocDto(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }

    public String getCinNum() {
        return cinNum;
    }

    public void setCinNum(String cinNum) {
        this.cinNum = cinNum;
    }

    public String getDunNum() {
        return dunNum;
    }

    public void setDunNum(String dunNum) {
        this.dunNum = dunNum;
    }

    public String getGstNum() {
        return gstNum;
    }

    public void setGstNum(String gstNum) {
        this.gstNum = gstNum;
    }
}
