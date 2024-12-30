package com.pms.sellercompany.companybank.controller;

import com.pms.sellercompany.companybank.dto.BankDto;
import com.pms.sellercompany.companybank.model.CompanyBank;
import com.pms.sellercompany.companybank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyBankController {

    @Autowired
    BankService bankService;

    @PostMapping("/banks")
    public BankDto addBank(@RequestBody BankDto bankDto) {

        return bankService.addBank(bankDto);
    }

    @GetMapping("/banks/{id}")
    public  @ResponseBody BankDto fetchBank(@PathVariable("id") Integer id) {

        return bankService.fetchBank(id);
    }

    @PutMapping("/bank/{id}")
    public BankDto updateBankDetails(@PathVariable("id") Integer bankId, @RequestBody BankDto bankDto){
        return bankService.updateBankDetails(bankId , bankDto);
    }

}

