package com.example.demo.user.service;

import com.example.demo.user.domain.*;
import com.example.demo.user.repository.UserRepository;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.demo.user.constant.Message.*;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    //private final UserMapper userMapper;
    private static final long EXPIRATION_TIME = 86400000; // 24 hours in milliseconds

    @Override
    public PortfolioResponse getUser(PortfolioRequest portfolioRequest){
        try{
            UserEntity user = userRepository.findByName(portfolioRequest.getName());
            if (user != null) {
                return new PortfolioResponse(USER_FOUND.getMessage(), user);
            }
            else{
                return new PortfolioResponse(USER_DONT_EXIST.getMessage(), null);
            }
        }catch (Exception e){
            //throw new UserDontExistException();
            return new PortfolioResponse(USER_DONT_EXIST.getMessage(), null);
        }
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest){
        try{
            UserEntity user = userRepository.findByName(loginRequest.getName());
            if ((user != null) && user.getPassword().equals(loginRequest.getPassword())) {
                return new LoginResponse(LOGIN_SUCCESSFUL.getMessage(), generateJwtToken(loginRequest.getName(),loginRequest.getPassword()),user.getId());
            }
            else{
                return new LoginResponse(USER_DONT_EXIST.getMessage(), null,null);
            }
        }
        catch (Exception e){
            //throw new UserDontExistException();
            return new LoginResponse(USER_DONT_EXIST.getMessage(), null,null);
        }

    }

    @Override
    public SignupResponse signup(SignupRequest signupRequest){
        try{
            UserEntity user = userRepository.findByName(signupRequest.getName());
            if (user == null) {
                UserEntity userEntity= new UserEntity(signupRequest.getName(),signupRequest.getEmail(),signupRequest.getPassword());
                userRepository.save(userEntity);
                return new SignupResponse(SIGNUP_SUCCESSFUL.getMessage(), generateJwtToken(signupRequest.getName(),signupRequest.getPassword()), user.getId());
            }
            else{
                return new SignupResponse(NAME_ALREADY_TAKEN.getMessage(), null, null);
            }
        }
        catch (Exception e){
            //throw new UserDontExistException();
            return new SignupResponse(NAME_ALREADY_TAKEN.getMessage(), null, null);
        }

    }

    @Override
    public String generateJwtToken(String name, String password) {
        try {
            SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);


            Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);

            // Define the claims of the token
            Claims claims = Jwts.claims().setSubject(name);
            claims.put("password", password);

            // Generate the token
            String token = Jwts.builder()
                    .setClaims(claims)
                    .setExpiration(expirationDate)
                    .signWith(SignatureAlgorithm.HS256, secretKey)
                    .compact();

            return token;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
