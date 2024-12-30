package com.pms.sellercompany.companyowner.repository;

import com.pms.sellercompany.company.model.Company;
import com.pms.sellercompany.companyLegaldocuments.model.CompanyLegalDocuments;
import com.pms.sellercompany.companyaddress.model.CompanyAddress;
import com.pms.sellercompany.companybank.model.CompanyBank;
import com.pms.sellercompany.companyowner.dto.OwnerDto;
import com.pms.sellercompany.companyowner.model.CompanyOwner;
import com.pms.sellercompany.compnaycontact.model.CompanyContact;
import com.pms.sellercompany.location.model.Location;
import com.pms.sellercompany.login.model.Login;
import com.pms.sellercompany.user.model.User;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class OwnerRepo {


    public OwnerDto addOwner(@RequestBody OwnerDto dto) {


        CompanyOwner owner = new CompanyOwner();
        owner.setOwnerName(dto.getOwnerName());
        owner.setMobileNumber(dto.getMobileNumber());
        owner.setDinNumber(dto.getDinNumber());


        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(Login.class)
                .addAnnotatedClass(CompanyAddress.class)
                .addAnnotatedClass(CompanyBank.class)
                .addAnnotatedClass(CompanyLegalDocuments.class)
                .addAnnotatedClass(CompanyContact.class)
                .addAnnotatedClass(CompanyOwner.class)
                .addAnnotatedClass(Location.class)

                .configure("Hibernate.cfg.xml");

        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(sr);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        String hql = ("FROM Company WHERE id = :companyId");
        Query query = session.createQuery(hql, Company.class);
        query.setParameter("companyId", dto.getCompanyId());
        Company company = (Company) query.getSingleResult();

        owner.setCompany_details(company);
        session.persist(owner);
        tx.commit();


        dto.setId(owner.getId());
        dto.setCompanyId(dto.getCompanyId());
        return dto;
    }


    public CompanyOwner updateOwner(Integer id, OwnerDto dto) {

        CompanyOwner owner = new CompanyOwner();
        owner.setOwnerName(dto.getOwnerName());
        owner.setMobileNumber(dto.getMobileNumber());
        owner.setDinNumber(dto.getDinNumber());


        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(Login.class)
                .addAnnotatedClass(CompanyAddress.class)
                .addAnnotatedClass(CompanyBank.class)
                .addAnnotatedClass(CompanyLegalDocuments.class)
                .addAnnotatedClass(CompanyContact.class)
                .addAnnotatedClass(CompanyOwner.class)
                .addAnnotatedClass(Location.class)

                .configure("Hibernate.cfg.xml");

        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(sr);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        String hql = ("UPDATE CompanyOwner s SET s.ownerName= :name ,s.dinNumber= :dinNumber ,s.mobileNumber= :mobileNumber WHERE s.id = :companyId");
        Query query = session.createQuery(hql);
        query.setParameter("name", dto.getOwnerName());
        query.setParameter("dinNumber", dto.getDinNumber());
        query.setParameter("mobileNumber", dto.getMobileNumber());
        query.setParameter("companyId", id);
        Integer result = query.executeUpdate();

        tx.commit();
        if(result == 0) {
            return null;
        }
        return owner;

    }

}
