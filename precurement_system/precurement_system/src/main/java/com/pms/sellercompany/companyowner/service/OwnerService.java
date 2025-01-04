package com.pms.sellercompany.companyowner.service;

import com.pms.sellercompany.companyowner.dto.OwnerDto;
import com.pms.sellercompany.companyowner.model.CompanyOwner;
import com.pms.sellercompany.companyowner.repository.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class OwnerService {

    @Autowired
    OwnerRepo repo;

    public OwnerDto addOwner(@RequestBody OwnerDto dto) {

        return repo.addOwner(dto);
    }

    public CompanyOwner updateOwner(Integer id, OwnerDto dto) {
        return repo.updateOwner(id, dto);

    }
}
