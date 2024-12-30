package com.pms.sellercompany.companyaddress.repository;


import com.pms.sellercompany.company.model.Company;
import com.pms.sellercompany.companyaddress.dtos.CompanyAddressDto;
import com.pms.sellercompany.companyaddress.model.CompanyAddress;
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
public class CompanyAddressRepo {

    public CompanyAddressDto postAddress(CompanyAddressDto companyAddressDto) {


        CompanyAddress companyAddress = new CompanyAddress();
        companyAddress.setAddress_L1(companyAddressDto.getAddress_L1());
        companyAddress.setAddress_L2(companyAddressDto.getAddress_L2());

        Location location1 = new Location();
        location1.setCity(companyAddressDto.getLocation().getCity());
        location1.setState(companyAddressDto.getLocation().getState());
        location1.setCountry(companyAddressDto.getLocation().getCountry());

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

        session.persist(location1);
        companyAddress.setLocation(location1);

        session.persist(companyAddress);

        String hql = ("from Company where id = :company_details_id");
        Query query = session.createQuery(hql, Company.class);
        query.setParameter("company_details_id", companyAddressDto.getCompanyId());

        Company c = (Company) query.getSingleResult();

        c.setAddresssId(companyAddress);

        session.persist(c);
        companyAddressDto.setId(companyAddress.getId());
        companyAddressDto.getLocation().setId(companyAddress.getLocation().getId());

        tx.commit();


        return companyAddressDto;
    }


    public CompanyAddressDto updateAddress(Integer addressId, CompanyAddressDto companyAddressDto) {


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


        String hql = ("UPDATE CompanyAddress s  SET s.address_L1 =:address_L1 , s.address_L2 =:address_L2  WHERE id =:addressId");
        Query query = session.createQuery(hql);
//        query.setParameter("city", companyAddressDto.getLocation().getCity());
//        query.setParameter("state", companyAddressDto.getLocation().getState());
        query.setParameter("address_L1", companyAddressDto.getAddress_L1());
        query.setParameter("address_L2", companyAddressDto.getAddress_L2());
        query.setParameter("addressId", addressId);
        //query.setParameter("compnayId", companyAddressDto.getCompanyId());

        Integer address1 = query.executeUpdate();

        //  CompanyAddress address = new CompanyAddress();
//        address.setAddress_L1(address1.getAddress_L1());
//        address.setAddress_L2(address1.getAddress_L2());
////
//        Location location = new Location();
//        location.setCity(companyAddressDto.getLocation().getCity());
//        location.setCountry(companyAddressDto.getLocation().getCountry());
//        location.setState(companyAddressDto.getLocation().getState());

        //session.persist(address1);
        tx.commit();
        companyAddressDto.setAddresId(companyAddressDto.getAddresId());
        return companyAddressDto;


    }

    public CompanyAddress getAddress(Integer id) {
        Transaction tx = null;
        CompanyAddress address = null;
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
            String hql = ("FROM CompanyAddress WHERE id= :addressId");
            Query query = session.createQuery(hql, CompanyAddress.class);
            query.setParameter("addressId", id);
            address = (CompanyAddress) query.getSingleResult();
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace();
            }
        }
        tx.commit();
     return address;
    }

}
