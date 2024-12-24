package com.pms.sellercompany.company.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pms.sellercompany.companyaddress.model.CompanyAddress;
import com.pms.sellercompany.companybank.model.CompanyBank;
import com.pms.sellercompany.companydocuments.model.CompanyDocuments;
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


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "company_leagal_details_id", referencedColumnName = "id")
    private CompanyDocuments legalDetails;

    @Transient
    private Integer company_legal_details_id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name ="company_details_id" , referencedColumnName = "id")
    private CompanyBank bank;

    @Transient
    private Integer bankId;

    @JsonManagedReference
    @OneToMany(targetEntity = User.class, cascade = CascadeType.MERGE ,fetch = FetchType.LAZY)
    @JoinColumn(name = "company_details_id" , referencedColumnName = "id")
    private List<User> user;

    @Transient
    private List<User> users;

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

    public CompanyDocuments getLegalDetails() {
        return legalDetails;
    }

    public void setLegalDetails(CompanyDocuments legalDetails) {
        this.legalDetails = legalDetails;
    }

    public Integer getCompany_legal_details_id() {
        return company_legal_details_id;
    }

    public void setCompany_legal_details_id(Integer company_legal_details_id) {
        this.company_legal_details_id = company_legal_details_id;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {

        this.user = user;
    }

    public CompanyBank getBank() {
        return bank;
    }

    public void setBank(CompanyBank bank) {
        this.bank = bank;
    }
}