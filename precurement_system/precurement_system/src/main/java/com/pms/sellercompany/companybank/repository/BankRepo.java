package com.pms.sellercompany.companybank.repository;


import com.pms.sellercompany.company.model.Company;
import com.pms.sellercompany.companybank.dto.BankDto;
import com.pms.sellercompany.companybank.model.CompanyBank;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

@Repository
public class BankRepo {

    public BankDto addBank(BankDto bankDto) {

        CompanyBank companyBank = new CompanyBank();
        companyBank.setName(bankDto.getName());
        companyBank.setBranch(bankDto.getBranch());
        companyBank.setAccountNumber(bankDto.getAccountNumber());
        companyBank.setPanNumber(bankDto.getPanNumber());
        companyBank.setIfscCode(bankDto.getIfscCode());
//        companyBank.setCompanyDetails(bankDto.getCompanyDetails());

        org.hibernate.cfg.Configuration configuration = new Configuration();
        configuration
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(CompanyBank.class)
                .configure("Hibernate.cfg.xml");

        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(sr);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(companyBank);
        String hql= ("from Company where id= :companyId");
        Query query=session.createQuery(hql,Company.class);
        query.setParameter("companyId" , BankDto.getCompany);
        bankDto.setCompanyDetails(companyBank.getCompanyDetails());

        return bankDto;


    }


}
