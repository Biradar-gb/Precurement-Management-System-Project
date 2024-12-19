package com.pms.sellercompany.companydocuments.model;

import jakarta.persistence.*;

@Entity
@Table (name="company_leagal_details")
public class CompanyDocuments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="registration_num")
    private String registration_num;

    @Column(name="cin_num")
    private String cin_num;

    @Column(name="dun_num")
    private String dun_num;

    @Column(name="gst_num")
    private String gst_num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistration_num() {
        return registration_num;
    }

    public void setRegistration_num(String registration_num) {
        this.registration_num = registration_num;
    }

    public String getCin_num() {
        return cin_num;
    }

    public void setCin_num(String cin_num) {
        this.cin_num = cin_num;
    }

    public String getDun_num() {
        return dun_num;
    }

    public void setDun_num(String dun_num) {
        this.dun_num = dun_num;
    }

    public String getGst_num() {
        return gst_num;
    }

    public void setGst_num(String gst_num) {
        this.gst_num = gst_num;
    }
}
