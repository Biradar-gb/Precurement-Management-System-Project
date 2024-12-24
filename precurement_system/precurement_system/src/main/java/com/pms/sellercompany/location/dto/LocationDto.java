package com.pms.sellercompany.location.dto;


import com.pms.sellercompany.location.model.Location;

public class LocationDto {

    private Integer id ;

    private String state;

    private String city;

    private String country;

//
    public LocationDto(){

    }
    public LocationDto(Location location){
        id= location.getId();
        state= location.getState();
        city= location.getCity();
        country= location.getCountry();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
