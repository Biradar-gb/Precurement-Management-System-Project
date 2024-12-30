package com.pms.sellercompany.companyLegaldocuments.model;

import jakarta.persistence.*;

@Entity
@Table (name="company_legal_details")
public class CompanyLegalDocuments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="registration_num")
    private String registrationNum;

    @Column(name="cin_num")
    private String cinNum;

    @Column(name="dun_num")
    private String dunNum;

    @Column(name="gst_num")
    private String gstNum;

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
