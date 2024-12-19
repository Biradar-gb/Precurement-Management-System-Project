package com.pms.sellercompany.companyaddress.repository;


import com.pms.sellercompany.company.model.Company;
import com.pms.sellercompany.companyaddress.dtos.CompanyAddressDto;
import com.pms.sellercompany.companyaddress.model.CompanyAddress;
import com.pms.sellercompany.companybank.model.CompanyBank;
import com.pms.sellercompany.companydocuments.model.CompanyDocuments;
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
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyAddressRepo {

    public CompanyAddressDto postAddress(CompanyAddressDto companyAddressDto) {


        CompanyAddress companyAddress = new CompanyAddress();

        companyAddress.setAddress_L1(companyAddressDto.getAddress_L1());
        companyAddress.setAddress_L2(companyAddressDto.getAddress_L2());


        Location location1 = new Location();
//        location.setId(companyAddressDto.getLocation_id());
        companyAddress.setLocation(companyAddress.getLocation());

        location1.setId(companyAddressDto.getLocation().getId());
        companyAddress.setLocation(location1);


        Configuration configuration = new Configuration();
        configuration
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(Login.class)
                .addAnnotatedClass(CompanyAddress.class)
                .addAnnotatedClass(CompanyBank.class)
                .addAnnotatedClass(CompanyDocuments.class)
                .addAnnotatedClass(CompanyContact.class)
                .addAnnotatedClass(CompanyOwner.class)
                .addAnnotatedClass(Location.class)
                .configure("Hibernate.cfg.xml");

        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(sr);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(location1);

        companyAddress.setLocation(location1);

        session.persist(companyAddress);

        String hql = ("from Company where id = :company_details_id");
        Query query = session.createQuery(hql, Company.class);
        query.setParameter("company_details_id", companyAddressDto.getCompanyId());

        Company c = (Company) query.getSingleResult();
        c.setAddresssId(companyAddress);

        session.persist(c);


        tx.commit();
        return companyAddressDto;
    }

//    public CompanyAddressDto updateAddress(CompanyAddressDto companyAddressDto){
//
//
//        CompanyAddress companyAddress=new CompanyAddress();
//
//
//    }
}
