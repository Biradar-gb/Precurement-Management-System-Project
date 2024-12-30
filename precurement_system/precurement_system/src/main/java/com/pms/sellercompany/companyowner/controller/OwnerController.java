package com.pms.sellercompany.companyowner.controller;

import com.pms.sellercompany.companyowner.dto.OwnerDto;
import com.pms.sellercompany.companyowner.model.CompanyOwner;
import com.pms.sellercompany.companyowner.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class OwnerController {

    @Autowired
    OwnerService service;

    @PostMapping("/owners")
    public OwnerDto addOwner(@RequestBody OwnerDto dto) {

        return service.addOwner(dto);
    }

    @PutMapping("/owners/{id}")
    public Integer updateOwner(@PathVariable("id") Integer id, @RequestBody OwnerDto dto) {
        return service.updateOwner(id, dto);

    }

}
