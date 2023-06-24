package com.example.demo.user.service;

import com.example.demo.user.domain.*;

public interface UserService {
    PortfolioResponse getUser(PortfolioRequest portfolioRequest);

    SignupResponse signup(SignupRequest signupRequest);
    LoginResponse login(LoginRequest loginRequest);


    String generateJwtToken(String username, String password);


}
