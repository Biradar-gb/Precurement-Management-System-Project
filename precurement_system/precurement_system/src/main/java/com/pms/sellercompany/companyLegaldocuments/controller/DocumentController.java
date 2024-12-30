package com.pms.sellercompany.companyLegaldocuments.controller;

import com.pms.sellercompany.companyLegaldocuments.dto.CompanyDocDto;
import com.pms.sellercompany.companyLegaldocuments.model.CompanyLegalDocuments;
import com.pms.sellercompany.companyLegaldocuments.service.CompanyDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class DocumentController {

    @Autowired
    CompanyDocService service;

    @PostMapping("/addDocs")
    public CompanyLegalDocuments addDocuments(@RequestBody CompanyDocDto companyDocDto){

        return service.addDocuments(companyDocDto);

    }
    @GetMapping("/Legaldetails/{id}")
    public @ResponseBody CompanyLegalDocuments getAll(@PathVariable("id") Integer legalId ){

        return service.getAll(legalId);
    }

    @PutMapping("/update/{id}")
    public CompanyDocDto updateDocuments(@PathVariable ("id") Integer legalId , @RequestBody CompanyDocDto dto){

        return service.updateDocuments(legalId,dto);

    }

}
