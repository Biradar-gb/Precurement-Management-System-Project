package com.pms.sellercompany.compnaycontact.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pms.sellercompany.company.model.Company;
import jakarta.persistence.*;

@Entity
@Table(name="Company_contact_Details")
public class CompanyContact {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="id")
     private Integer id;
     @Column(name="email")
     private String email;

     @Column(name="number")
     private String phone_Number;

     @JsonBackReference
     @ManyToOne(  targetEntity = Company.class,cascade =  CascadeType.MERGE, fetch = FetchType.LAZY)
     @JoinColumn(name="company_details_id",referencedColumnName = "id")
     private Company company_details;

     @Transient
     private String company_details_id;

     public Integer getId() {
          return id;
     }

     public void setId(Integer id) {
          this.id = id;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getPhone_Number() {
          return phone_Number;
     }

     public void setPhone_Number(String phone_Number) {
          this.phone_Number = phone_Number;
     }

     public Company getCompanyy_details() {
          return company_details;
     }

     public void setCompany_details(Company company_details) {
          this.company_details = company_details;
     }

}
