package com.pms.sellercompany.login.dto;

import com.pms.sellercompany.login.model.Login;

public class LoginDto {
    private Integer id;
    private String user_name;
    private String password;

    public LoginDto() {

    }
   public LoginDto(Login login) {
       id = login.getId();
       user_name = login.getUser_name();
       password = login.getPassword();
   }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
