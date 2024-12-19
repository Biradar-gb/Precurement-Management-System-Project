package com.pms.sellercompany.compnaycontact.model;

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

     @Column(name="numebr")
     private String number;

     @ManyToOne(  targetEntity = Company.class, fetch = FetchType.LAZY)
     @JoinColumn(name="company_details_id",referencedColumnName = "id")
     private Company compnay_details;

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

     public String getNumber() {
          return number;
     }

     public void setNumber(String number) {
          this.number = number;
     }

     public Company getCompnay_details() {
          return compnay_details;
     }

     public void setCompnay_details(Company compnay_details) {
          this.compnay_details = compnay_details;
     }

     public String getCompany_details_id() {
          return company_details_id;
     }

     public void setCompany_details_id(String company_details_id) {
          this.company_details_id = company_details_id;
     }
}
