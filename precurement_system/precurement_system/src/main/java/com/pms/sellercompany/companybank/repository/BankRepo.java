package com.pms.sellercompany.companybank.repository;


import com.pms.sellercompany.company.model.Company;
import com.pms.sellercompany.companyaddress.model.CompanyAddress;
import com.pms.sellercompany.companybank.dto.BankDto;
import com.pms.sellercompany.companybank.model.CompanyBank;
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

@Repository
public class BankRepo {

    public BankDto addBank(BankDto bankDto) {

        CompanyBank companyBank = new CompanyBank();

        companyBank.setName(bankDto.getName());
        companyBank.setBranch(bankDto.getBranch());
        companyBank.setAccountNumber(bankDto.getAccountNumber());
        companyBank.setPanNumber(bankDto.getPanNumber());
        companyBank.setIfscCode(bankDto.getIfscCode());
        companyBank.setCompanyDetails(bankDto.getCompanyDetails());

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

        String hql = ("from Company where id= :companyId");
        Query query = session.createQuery(hql, Company.class);
        query.setParameter("companyId", bankDto.getCompanyId());
        Company company = (Company) query.getSingleResult();


        companyBank.setCompanyDetails(company);
        session.persist(companyBank);

        tx.commit();
        bankDto.setId(companyBank.getId());

        return bankDto;

    }

    public BankDto fetchBank(Integer id) {
        BankDto dto = new BankDto();
        Transaction tx = null;
        CompanyBank bank = null;

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

            String hql = ("from CompanyBank b where b.id =:id");
            Query query = session.createQuery(hql, CompanyBank.class);
            query.setParameter("id", id);
            bank = (CompanyBank) query.getSingleResult();


        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace();
            }
        }
        tx.commit();

        dto.setId(bank.getId());
        dto.setName(bank.getName());
        dto.setAccountNumber(bank.getAccountNumber());
        dto.setBranch(bank.getBranch());
        dto.setIfscCode(bank.getIfscCode());
        dto.setPanNumber(bank.getPanNumber());

        return dto;
    }


    public BankDto updateBankDetails(Integer bankId, BankDto bankDto) {

        CompanyBank bank = new CompanyBank();
        bank.setName(bankDto.getName());
        bank.setAccountNumber(bankDto.getAccountNumber());
        bank.setBranch(bankDto.getBranch());
        bank.setIfscCode(bankDto.getIfscCode());
        bank.setPanNumber(bankDto.getPanNumber());

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class)
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
        String hql = ("UPDATE  CompanyBank b SET b.name=:bankName , b.accountNumber=:acc_Number , b.branch=:branch ," +
                "b.ifscCode=:ifscCode,b.panNumber=:pan_number WHERE id=:bankId");
        Query query = session.createQuery(hql);
        query.setParameter("bankName", bankDto.getName());
        query.setParameter("acc_Number", bankDto.getAccountNumber());
        query.setParameter("branch", bankDto.getBranch());
        query.setParameter("ifscCode", bankDto.getIfscCode());
        query.setParameter("pan_number", bankDto.getPanNumber());
        query.setParameter("bankId", bankId);
        Integer updatedId = query.executeUpdate();

        tx.commit();

        bankDto.setId(bankId);
        return bankDto;
    }
}
