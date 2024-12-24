package com.pms.sellercompany.companyaddress.controller;


import com.pms.sellercompany.companyaddress.dtos.CompanyAddressDto;
import com.pms.sellercompany.companyaddress.service.CompanyAddressService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyAddressController {

    @Autowired
    CompanyAddressService companyAddressService;

    @PostMapping("/address")
    public CompanyAddressDto postAddress(@RequestBody CompanyAddressDto companyAddressDto){

        return companyAddressService.postAddress(companyAddressDto);
    }

    @PutMapping("/{id}")
    public  CompanyAddressDto updateAddress( @PathVariable("id") Integer addressId , @RequestBody CompanyAddressDto companyAddressDto){

        return companyAddressService.updateAddress(addressId ,companyAddressDto);
    }

}
