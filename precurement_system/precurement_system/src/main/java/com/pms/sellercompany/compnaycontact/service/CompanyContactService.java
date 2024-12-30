package com.pms.sellercompany.compnaycontact.service;

import com.pms.sellercompany.compnaycontact.dto.CompanyContactDto;
import com.pms.sellercompany.compnaycontact.model.CompanyContact;
import com.pms.sellercompany.compnaycontact.repository.CompanyContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class CompanyContactService {

    @Autowired
    CompanyContactRepo repo;

    public CompanyContactDto addContacts(@RequestBody CompanyContactDto dto) {

        return repo.addContacts(dto);
    }

    public CompanyContactDto fetchContact(@PathVariable("id") Integer contactId) {
        return repo.fetchContact(contactId);
    }

    public List<CompanyContact> fetchAllContact() {
        return repo.fetchAllContact();
    }

    public CompanyContactDto updateContacts( Integer id, CompanyContactDto dto) {
        return repo.updateContacts(id, dto);
    }
}
