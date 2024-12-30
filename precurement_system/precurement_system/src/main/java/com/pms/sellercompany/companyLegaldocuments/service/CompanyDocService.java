package com.pms.sellercompany.companyLegaldocuments.service;

import com.pms.sellercompany.companyLegaldocuments.dto.CompanyDocDto;
import com.pms.sellercompany.companyLegaldocuments.model.CompanyLegalDocuments;
import com.pms.sellercompany.companyLegaldocuments.repository.CompanyDocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CompanyDocService {

    @Autowired
    CompanyDocRepo repo;

    public CompanyLegalDocuments addDocuments(CompanyDocDto companyDocDto) {

        return repo.addDocuments(companyDocDto);
    }

    public CompanyLegalDocuments getAll(Integer legalId){

        return repo.getAll(legalId);
    }

    public CompanyDocDto updateDocuments(@PathVariable("id") Integer legalId , CompanyDocDto dto){

        return repo.updateDocuments(legalId,dto);

    }
}
