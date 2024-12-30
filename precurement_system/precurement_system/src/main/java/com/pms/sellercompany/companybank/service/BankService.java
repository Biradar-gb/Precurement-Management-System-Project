package com.pms.sellercompany.companybank.service;


import com.pms.sellercompany.companybank.dto.BankDto;
import com.pms.sellercompany.companybank.model.CompanyBank;
import com.pms.sellercompany.companybank.repository.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class BankService {


    @Autowired
    BankRepo bankRepo;

    public BankDto addBank(BankDto bankDto) {
        return bankRepo.addBank(bankDto);
    }

    public  BankDto fetchBank(Integer id ){
        return bankRepo.fetchBank(id);
    }

    public BankDto updateBankDetails(Integer bankId, BankDto bankDto){
        return bankRepo.updateBankDetails(bankId , bankDto);
    }
}