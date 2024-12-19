package com.pms.sellercompany.user.dto;

import com.pms.sellercompany.login.dto.LoginDto;

public class UserDto {


    private String user_name;
    private String role;
    private LoginDto login;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LoginDto getLogin() {
        return login;
    }

    public void setLogin(LoginDto login) {
        this.login = login;
    }
}
