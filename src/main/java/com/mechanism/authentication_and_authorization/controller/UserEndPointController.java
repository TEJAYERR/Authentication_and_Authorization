package com.mechanism.authentication_and_authorization.controller;

import com.mechanism.authentication_and_authorization.dto.UserProfileResponse;
import com.mechanism.authentication_and_authorization.service.UserEndPointService;
import com.mechanism.authentication_and_authorization.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserEndPointController {

    UserEndPointService userEndPointService;

    @Autowired
    UserEndPointController(UserEndPointService userEndPointService){
        this.userEndPointService = userEndPointService;
    }

    @GetMapping
    public String userAccess(@RequestHeader("Authorization") String authorization){

        if(authorization == null || !authorization.startsWith("Bearer ")){
            throw new RuntimeException("Invalid Token!");
        }

        String token = authorization.substring(7);
        String[] data = TokenUtil.decodeToken(token);

        if(data.length < 2){
            throw new RuntimeException("Misformed token");
        }

        String email = data[0];
        String role = data[1];

        if(role.equalsIgnoreCase("user") || role.equalsIgnoreCase("admin")){
            return "access granted";
        }

        return "Invalid user";
    }

    @GetMapping("/profile")
    public UserProfileResponse userProfile(@RequestHeader("Authorization") String authorization){

        System.out.println("Entered Profile Method");

        if(authorization == null || !authorization.startsWith("Bearer ")){
            throw new RuntimeException("Invalid Token!");
        }

        String token = authorization.substring(7);
        String[] data = TokenUtil.decodeToken(token);

        if(data.length < 2){
            throw new RuntimeException("Misformed token");
        }

        String email = data[0];
        String role = data[1];

        return userEndPointService.userProfile(email);
    }
}
