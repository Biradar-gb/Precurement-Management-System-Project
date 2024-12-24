package com.pms.sellercompany.companybank.service;


import com.pms.sellercompany.companybank.dto.BankDto;
import com.pms.sellercompany.companybank.model.CompanyBank;
import com.pms.sellercompany.companybank.repository.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {


    @Autowired
    BankRepo bankRepo;

    public BankDto addBank(BankDto bankDto) {

        CompanyBank companyBank = new CompanyBank();
        companyBank.setName(bankDto.getName());
        companyBank.setAccountNumber(bankDto.getAccountNumber());
        companyBank.setBranch(bankDto.getBranch());
        companyBank.setIfscCode(bankDto.getIfscCode());
        companyBank.setPanNumber(bankDto.getPanNumber());
        companyBank.setCompanyDetails(bankDto.getCompanyDetails());


        return bankDto;
    }
}
