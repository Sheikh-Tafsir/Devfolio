package com.example.demo.user.controller;
import com.example.demo.common.controller.ApiResponse;
import com.example.demo.common.controller.ResponseUtil;
import com.example.demo.user.domain.LoginRequest;
import com.example.demo.user.domain.LoginResponse;
import com.example.demo.user.domain.PortfolioRequest;
import com.example.demo.user.domain.PortfolioResponse;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.project.constant.Message.PROJECTS_FOUND;

@CrossOrigin(origins="*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @PostMapping("/portfolio")
    public ResponseEntity<ApiResponse<PortfolioResponse>> getUser(@RequestBody PortfolioRequest portfolioRequest) {
        PortfolioResponse portfolioResponse = userService.getUser(portfolioRequest);
        return ResponseUtil.createResponse(HttpStatus.OK,portfolioResponse.getResponseMessage(),portfolioResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> getUser(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = userService.login(loginRequest);
        if(loginResponse.getToken() != null){
            return ResponseUtil.createResponse(HttpStatus.OK,loginResponse.getRespMessage(),loginResponse);
        }
        else return ResponseUtil.createResponse(HttpStatus.UNAUTHORIZED,loginResponse.getRespMessage(),null);

    }

}
