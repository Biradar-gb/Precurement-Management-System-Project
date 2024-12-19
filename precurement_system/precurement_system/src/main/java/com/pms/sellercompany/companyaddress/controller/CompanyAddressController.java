package com.pms.sellercompany.companyaddress.controller;


import com.pms.sellercompany.companyaddress.dtos.CompanyAddressDto;
import com.pms.sellercompany.companyaddress.service.CompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyAddressController {

    @Autowired
    CompanyAddressService companyAddressService;

    @PostMapping("/address")
    public CompanyAddressDto postAddress(CompanyAddressDto companyAddressDto){

        return companyAddressService.postAddress(companyAddressDto);
    }


//
//    @PutMapping("/put")
//    public CompanyAddressDto updateAddress(CompanyAddressDto CompanyAddressDto){
//
//        return companyAddressService.updateAddress(CompanyAddressDto);
//    }

}
