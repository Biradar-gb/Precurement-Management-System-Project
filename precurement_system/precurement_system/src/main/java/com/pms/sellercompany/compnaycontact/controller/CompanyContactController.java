package com.pms.sellercompany.compnaycontact.controller;

import com.pms.sellercompany.compnaycontact.dto.CompanyContactDto;
import com.pms.sellercompany.compnaycontact.model.CompanyContact;
import com.pms.sellercompany.compnaycontact.service.CompanyContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyContactController {


    @Autowired
    CompanyContactService service;

    @PostMapping("/contacts")
    public CompanyContactDto addContacts(@RequestBody CompanyContactDto dto) {

        return service.addContacts(dto);
    }

    @GetMapping("/contacts/{id}")
    public @ResponseBody CompanyContactDto fetchContact(@PathVariable("id") Integer contactId) {
        return service.fetchContact(contactId);
    }

    @GetMapping("/contacts/allcontaccts")
    public @ResponseBody List<CompanyContact> fetchAllContact() {
        return service.fetchAllContact();
    }

    @PutMapping("/contacts/{id}")
    public @ResponseBody CompanyContactDto updateContacts(@PathVariable("id") Integer id, @RequestBody CompanyContactDto dto) {
        return service.updateContacts(id, dto);
    }

}
