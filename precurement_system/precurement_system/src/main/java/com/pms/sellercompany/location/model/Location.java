package com.pms.sellercompany.location.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pms.sellercompany.companyaddress.model.CompanyAddress;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @JsonManagedReference
    @OneToMany(targetEntity = CompanyAddress.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private List<CompanyAddress> companyAddress;

    @Transient
    private List<CompanyAddress> address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<CompanyAddress> getCompanyAddress() {

        return companyAddress;
    }

    public void setCompanyAddress(List<CompanyAddress> companyAddress) {

        companyAddress = companyAddress;
    }
}
