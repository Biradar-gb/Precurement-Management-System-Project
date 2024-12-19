package com.pms.sellercompany.user.service;

import com.pms.sellercompany.company.dto.CompanySignUpDto;
import com.pms.sellercompany.login.dto.LoginDto;
import com.pms.sellercompany.user.repository.SellerAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerAunthenticationService {
@Autowired
SellerAuthRepository sellerAuthRepository;

    public CompanySignUpDto createsellerSignup(CompanySignUpDto CompanySignUpDto) {

        return sellerAuthRepository.createsellerSignup(CompanySignUpDto);

    }


    public LoginDto userSignin(LoginDto loginDto) {

        return sellerAuthRepository.userSignin(loginDto);
    }
}
