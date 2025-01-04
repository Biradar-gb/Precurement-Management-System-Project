package com.pms.sellercompany.company.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pms.products.models.Product;
import com.pms.sellercompany.companyaddress.model.CompanyAddress;
import com.pms.sellercompany.companyLegaldocuments.model.CompanyLegalDocuments;
import com.pms.sellercompany.companyowner.model.CompanyOwner;
import com.pms.sellercompany.compnaycontact.model.CompanyContact;
import com.pms.sellercompany.user.model.User;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "company_details")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "register_num")
    private String register_Number;


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "company_address_id", referencedColumnName = "id")
    private CompanyAddress addresssId;

    @Transient
    private String address_id;


    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_leagal_details_id", referencedColumnName = "id")
    private CompanyLegalDocuments legalDetails;

    @Transient
    private Integer company_legal_details_id;

    @JsonManagedReference
    @OneToMany(targetEntity = User.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_details_id", referencedColumnName = "id")
    private List<User> user;

    @Transient
    private List<User> users;

    @JsonManagedReference
    @OneToMany(targetEntity = CompanyContact.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_details_id")
    private List<CompanyContact> companyContact;

    @Transient
    CompanyContact contact;


    @OneToMany(targetEntity = CompanyOwner.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "company_details_id", referencedColumnName = "id")
    private List<CompanyOwner> companyOwner;

    @Transient
    private CompanyOwner owner;

    @OneToMany(targetEntity = Product.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "company_details_id")
    private List<Product> products;

    @Transient
    private List<Product> p;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegister_Number() {
        return register_Number;
    }


    public void setRegister_Number(String register_Number) {
        this.register_Number = register_Number;
    }

    public CompanyAddress getAddresssId() {
        return addresssId;
    }

    public void setAddresssId(CompanyAddress addresssId) {
        this.addresssId = addresssId;
    }

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public CompanyLegalDocuments getLegalDetails() {
        return legalDetails;
    }

    public void setLegalDetails(CompanyLegalDocuments legalDetails) {
        this.legalDetails = legalDetails;
    }


    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {

        this.user = user;
    }

    public Integer getCompany_legal_details_id() {
        return company_legal_details_id;
    }

    public void setCompany_legal_details_id(Integer company_legal_details_id) {
        this.company_legal_details_id = company_legal_details_id;
    }

    public List<CompanyContact> getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(List<CompanyContact> companyContact) {
        this.companyContact = companyContact;
    }

    public List<CompanyOwner> getCompanyOwner() {
        return companyOwner;
    }

    public void setCompanyOwner(List<CompanyOwner> companyOwner) {
        this.companyOwner = companyOwner;
    }

    public CompanyContact getContact() {
        return contact;
    }

    public void setContact(CompanyContact contact) {
        this.contact = contact;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}