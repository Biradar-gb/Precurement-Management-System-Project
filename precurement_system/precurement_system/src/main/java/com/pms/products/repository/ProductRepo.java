package com.pms.products.repository;

import com.pms.products.dtos.ProductDto;
import com.pms.products.models.*;
import com.pms.sellercompany.company.model.Company;
import com.pms.sellercompany.companyLegaldocuments.model.CompanyLegalDocuments;
import com.pms.sellercompany.companyaddress.model.CompanyAddress;
import com.pms.sellercompany.companybank.model.CompanyBank;
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

import java.util.List;

@Repository
public class ProductRepo {


    public ProductDto addProducts(@RequestBody ProductDto dto) {


        Product p = new Product();
        p.setProductName(dto.getProductName());
        p.setDecription(dto.getDecription());
        p.setUnitPrice(dto.getUnitPrice());




        Brand b = new Brand();
        b.setBrandName(dto.getBrandDto().getBrandName());

        Model m = new Model();
        m.setModelName(dto.getModelDto().getModelName());

        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration
                .addAnnotatedClass(Brand.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Colour.class)
                .addAnnotatedClass(Image.class)
                .addAnnotatedClass(Model.class)
                .addAnnotatedClass(Offer.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Size.class)

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

//        String hql = ("FROM Company WHERE id = :companyId");
//        Query query = session.createQuery(hql, Company.class);
//        query.setParameter("companyId", dto.getCompanyId());
//        Company company = (Company) query.getSingleResult();

        session.persist(b);
        session.persist(m);
        session.persist(p);
        return dto;
    }
}
