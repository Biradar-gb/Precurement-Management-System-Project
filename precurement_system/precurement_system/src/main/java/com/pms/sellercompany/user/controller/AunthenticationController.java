package com.pms.sellercompany.user.controller;

import com.pms.sellercompany.company.dto.CompanySignUpDto;
import com.pms.sellercompany.login.dto.LoginDto;
import com.pms.sellercompany.user.service.SellerAunthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class AunthenticationController {

    @Autowired
    SellerAunthenticationService sellerAunthenticationService;

    @PostMapping("/signup")
    public CompanySignUpDto createsellerSignup(@RequestBody CompanySignUpDto companyDto) {
        return sellerAunthenticationService.createsellerSignup(companyDto);

    }
    @PostMapping("/usersignin")
    public LoginDto userSignin(@RequestBody LoginDto loginDto) {
        return sellerAunthenticationService.userSignin(loginDto);

    }

}