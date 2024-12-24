package com.pms.sellercompany.companyaddress.service;

import com.pms.sellercompany.companyaddress.dtos.CompanyAddressDto;
import com.pms.sellercompany.companyaddress.repository.CompanyAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class CompanyAddressService {

    @Autowired
    private CompanyAddressRepo companyAddressRepo;

    public CompanyAddressDto postAddress(CompanyAddressDto companyAddressDto){

        return companyAddressRepo.postAddress(companyAddressDto);
    }


    public CompanyAddressDto updateAddress( Integer addressId , CompanyAddressDto companyAddressDto){

        return companyAddressRepo.updateAddress(addressId , companyAddressDto);
    }

}
