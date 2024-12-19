package com.pms.sellercompany.user.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pms.sellercompany.company.model.Company;
import jakarta.persistence.*;


@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="user_name")
    private String  user_name ;

//    @Column(name="user_password")
//    private String user_password;

    @Column(name="role")
    private String role;

    @JsonBackReference
    @ManyToOne(targetEntity = Company.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_details_id" , referencedColumnName = "id")
    private  Company  Company_detail;

    @Transient
    private Integer  company_details;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

//    public String getUser_password() {
//        return user_password;
//    }
//
//    public void setUser_password(String user_password) {
//        this.user_password = user_password;
//    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Company getCompany_detail() {
        return Company_detail;
    }

    public void setCompany_detail(Company company_detail) {
        Company_detail = company_detail;
    }

    public Integer getCompany_details() {
        return company_details;
    }

    public void setCompany_details(Integer company_details) {
        this.company_details = company_details;
    }

    @Override
    public String toString() {
        return "User{" +
                ", role='" + role + '\'' +
                ", Company_detail=" + Company_detail +
                ", company_details=" + company_details +
                ", id=" + id +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
