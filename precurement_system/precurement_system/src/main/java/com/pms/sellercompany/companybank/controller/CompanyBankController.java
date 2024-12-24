package com.pms.sellercompany.companybank.controller;

import com.pms.sellercompany.companybank.dto.BankDto;
import com.pms.sellercompany.companybank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyBankController {

    @Autowired
    BankService bankService;

    @PostMapping("banks")
    public BankDto addBank(BankDto bankDto) {

        return bankService.addBank(bankDto);
    }


}
