package com.pms.sellercompany.user.repository;

import com.pms.sellercompany.company.model.Company;
import com.pms.sellercompany.companyaddress.model.CompanyAddress;
import com.pms.sellercompany.companybank.model.CompanyBank;
import com.pms.sellercompany.companydocuments.model.CompanyDocuments;
import com.pms.sellercompany.companyowner.model.CompanyOwner;
import com.pms.sellercompany.compnaycontact.model.CompanyContact;
import com.pms.sellercompany.location.model.Location;
import com.pms.sellercompany.login.model.Login;
import com.pms.sellercompany.company.dto.CompanySignUpDto;
import com.pms.sellercompany.login.dto.LoginDto;
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
public class SellerAuthRepository {


    public CompanySignUpDto createsellerSignup(CompanySignUpDto companyDto) {

        Login login = new Login();
        login.setPassword(companyDto.getUser().getLogin().getPassword());
        login.setUser_name(companyDto.getUser().getLogin().getUser_name());


        Company company = new Company();
        company.setName(companyDto.getName());
        company.setRegister_Number(companyDto.getRegister_number());

        User user = new User();
        user.setUser_name((companyDto.getUser().getUser_name()));
        user.setRole(companyDto.getUser().getRole());

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

        session.persist(company);


        user.setCompany_detail(company);

        session.persist(user);

        login.setUser(user);

        session.persist(login);
        tx.commit();
        companyDto.setId(company.getId());
        return companyDto;

    }

    public LoginDto userSignin(LoginDto loginDto) {


        Transaction tx = null;

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Login.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(CompanyContact.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(CompanyAddress.class);
        configuration.addAnnotatedClass(CompanyOwner.class);
        configuration.addAnnotatedClass(CompanyDocuments.class);
        configuration.addAnnotatedClass(CompanyBank.class);
        configuration.addAnnotatedClass(Location.class);
        configuration.configure("Hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        try {
            Session session = sessionFactory.openSession();
            tx = session.beginTransaction();

            String hql = ("from Login where  user_name = :user_name and  password = :password");
            Query query = session.createQuery(hql, Login.class);
            query.setParameter("user_name", loginDto.getUser_name());
            query.setParameter("password", loginDto.getPassword());


            Login login = (Login) query.getSingleResult();
            loginDto.setId(login.getId());

            tx.commit();


        } catch (Exception e) {

            if (tx != null) {

                tx.rollback();

            }
            e.printStackTrace();

        }
        return loginDto;

    }
}
