package com.pms.sellercompany.companyaddress.dtos;

import com.pms.sellercompany.companyaddress.model.CompanyAddress;
import com.pms.sellercompany.location.dto.LocationDto;
import com.pms.sellercompany.location.model.Location;

import java.util.List;

public class CompanyAddressDto {

    private Integer id;

    private String address_L1;

    private String address_L2;

    private Integer companyId;

    private LocationDto location;

    private Integer  addresId;

    public CompanyAddressDto() {

    }


    public Integer getId() {
        return id;
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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public Integer getAddresId() {
        return addresId;
    }

    public void setAddresId(Integer addresId) {
        this.addresId = addresId;
    }
}
