package com.pms.sellercompany.company.dto;

import com.pms.sellercompany.login.dto.LoginDto;
import com.pms.sellercompany.user.dto.UserDto;

public class CompanySignUpDto {

    private Integer id;
    private String name;
    private String register_number;


    private UserDto user;
    private LoginDto login;

//    public CompanyDto(Company company) {
//        id = company.getId();
//        name = company.getName();
//        register_number = company.getRegister_Number();
//
//    }
    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getRegister_number() {

        return register_number;
    }

    public void setRegister_number(String register_number) {

        this.register_number = register_number;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public LoginDto getLogin() {
        return login;
    }

    public void setLogin(LoginDto login) {
        this.login = login;
    }
}
