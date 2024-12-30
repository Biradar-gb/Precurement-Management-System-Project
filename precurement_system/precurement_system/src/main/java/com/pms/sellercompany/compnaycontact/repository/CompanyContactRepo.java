package com.pms.sellercompany.compnaycontact.repository;

import com.pms.sellercompany.company.model.Company;
import com.pms.sellercompany.companyLegaldocuments.model.CompanyLegalDocuments;
import com.pms.sellercompany.companyaddress.model.CompanyAddress;
import com.pms.sellercompany.companybank.model.CompanyBank;
import com.pms.sellercompany.companyowner.model.CompanyOwner;
import com.pms.sellercompany.compnaycontact.dto.CompanyContactDto;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyContactRepo {

    public CompanyContactDto addContacts(CompanyContactDto dto) {
        CompanyContact companyContact = new CompanyContact();
        companyContact.setEmail(dto.getEmail());
        companyContact.setPhone_Number(dto.getPhone_Number());

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

        companyContact.setCompany_details(company);
        session.persist(companyContact);

        tx.commit();
        dto.setId(companyContact.getId());
        return dto;
    }

    public CompanyContactDto fetchContact(Integer contactId) {

        Transaction tx = null;

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


        CompanyContact contact = null;
        try {
            Session session = sessionFactory.openSession();
            tx = session.beginTransaction();

            String hql = ("From CompanyContact b where b.id= :ContactId");
            Query query = session.createQuery(hql, CompanyContact.class);
            // Query query= session.createQuery(hql , Company.class);
            query.setParameter("ContactId", contactId);

            contact = (CompanyContact) query.getSingleResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace();
            }
        }


        CompanyContactDto dto = new CompanyContactDto();
        dto.setId(contact.getId());
        dto.setCompanyId(contact.getCompanyy_details().getId());
        dto.setEmail(contact.getEmail());
        dto.setPhone_Number(contact.getPhone_Number());
        return dto;
    }

    public List<CompanyContact> fetchAllContact() {

        Transaction tx = null;

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

        List<CompanyContact> contacts = null;
        ArrayList<CompanyContact> contactList = new ArrayList<>();

        try {
            Session session = sessionFactory.openSession();
            tx = session.beginTransaction();

            String hql = ("From CompanyContact");
            Query query = session.createQuery(hql, CompanyContact.class);

            contacts = query.getResultList();

            for (CompanyContact companyContact : contacts) {

                CompanyContact c = new CompanyContact();

                c.setId(companyContact.getId());
                c.setPhone_Number(companyContact.getPhone_Number());
                c.setEmail(companyContact.getEmail());

                contactList.add(c);  //>>>>>>>>>> adding contacts to ArrayList

            }

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace();
            }
        }
        tx.commit();
        return contactList;

    }


    public CompanyContactDto updateContacts(Integer id, CompanyContactDto dto) {


        CompanyContact contact = new CompanyContact();
        contact.setEmail(dto.getEmail());
        contact.setPhone_Number(dto.getPhone_Number());
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

        String hql = ("UPDATE CompanyContact c SET c.phone_Number= :phoneNumber, c.email= :email WHERE id=:id");

        Query query = session.createQuery(hql);
        query.setParameter("phoneNumber", dto.getPhone_Number());
        query.setParameter("email", dto.getEmail());
        query.setParameter("id", id);

        Integer result = query.executeUpdate();
        tx.commit();

        dto.setId(id);
        return dto;
    }
}