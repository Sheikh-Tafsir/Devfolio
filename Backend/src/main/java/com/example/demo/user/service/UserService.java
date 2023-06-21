package com.example.demo.user.service;

import com.example.demo.user.domain.LoginRequest;
import com.example.demo.user.domain.LoginResponse;
import com.example.demo.user.domain.PortfolioRequest;
import com.example.demo.user.domain.PortfolioResponse;

public interface UserService {
    PortfolioResponse getUser(PortfolioRequest portfolioRequest);
    LoginResponse login(LoginRequest loginRequest);


    String generateJwtToken(String username, String password);
}
