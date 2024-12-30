package com.pms.sellercompany.companyLegaldocuments.repository;

import com.pms.sellercompany.company.model.Company;
import com.pms.sellercompany.companyaddress.model.CompanyAddress;
import com.pms.sellercompany.companybank.model.CompanyBank;
import com.pms.sellercompany.companyLegaldocuments.dto.CompanyDocDto;
import com.pms.sellercompany.companyLegaldocuments.model.CompanyLegalDocuments;
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
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public class CompanyDocRepo {

    public CompanyLegalDocuments addDocuments(CompanyDocDto companyDocDto) {

        CompanyLegalDocuments companyDocuments = new CompanyLegalDocuments();
        companyDocuments.setCinNum(companyDocDto.getCinNum());
        companyDocuments.setDunNum(companyDocDto.getDunNum());
        companyDocuments.setGstNum(companyDocDto.getGstNum());
        companyDocuments.setRegistrationNum(companyDocDto.getRegistrationNum());

        Configuration configuration = new Configuration();
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


        session.persist(companyDocuments);
        tx.commit();

        return companyDocuments;
    }

    public CompanyLegalDocuments getAll(Integer legalId) {

        Transaction tx = null;
        CompanyLegalDocuments companyLegalDocuments = null;

        Configuration configuration = new Configuration();
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

        try {
            Session session = sessionFactory.openSession();
            tx = session.beginTransaction();
            String hql = ("FROM CompanyLegalDocuments where id= :id");
            Query query = session.createQuery(hql, CompanyLegalDocuments.class);
            query.setParameter("id", legalId);
            companyLegalDocuments = (CompanyLegalDocuments) query.getSingleResult();

        } catch (Exception e) {
            if (tx != null) {

                tx.rollback();
                e.printStackTrace();

            }
            tx.commit();

        }
        return companyLegalDocuments;
    }

    public CompanyDocDto updateDocuments(@PathVariable("id") Integer legalId, CompanyDocDto dto) {



        Configuration configuration = new Configuration();
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

        String hql = ("UPDATE CompanyLegalDocuments s SET s.registrationNum= :rgNumber ,s.cinNum= :cinNum ,s.dunNum= :dunNum ," +
                "s.gstNum = :gstNum WHERE id= :legalId");
        Query query = session.createQuery(hql);
        query.setParameter("rgNumber", dto.getRegistrationNum());
        query.setParameter("cinNum", dto.getCinNum());
        query.setParameter("dunNum", dto.getDunNum());
        query.setParameter("gstNum", dto.getGstNum());
        query.setParameter("legalId", legalId);
        Integer id = query.executeUpdate();

        tx.commit();
        dto.setId(dto.getId());
        return dto;

    }


}
