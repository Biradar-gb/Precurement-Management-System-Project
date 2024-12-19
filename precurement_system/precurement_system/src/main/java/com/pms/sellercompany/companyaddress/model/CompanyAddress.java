package com.pms.sellercompany.companyaddress.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pms.sellercompany.location.model.Location;
import jakarta.persistence.*;

@Entity
@Table(name = "company_address")
public class CompanyAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "address_L1")
    private String address_L1;

    @Column(name = "address_L2")
    private String address_L2;

    @JsonBackReference
    @ManyToOne(targetEntity = Location.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @Transient
    private String location_id;

    public Integer getId() {
        return id;
    }

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress_L1() {
        return address_L1;
    }

    public void setAddress_L1(String address_L1) {
        this.address_L1 = address_L1;
    }

    public String getAddress_L2() {
        return address_L2;
    }

    public void setAddress_L2(String address_L2) {
        this.address_L2 = address_L2;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
//
//    public String getLocation_id() {
//        return location_id;
//    }
//
//    public void setLocation_id(String location_id) {
//        this.location_id = location_id;
//    }
}
