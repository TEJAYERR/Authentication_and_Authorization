package com.mechanism.authentication_and_authorization.controller;

import com.mechanism.authentication_and_authorization.util.AdminOnly;
import com.mechanism.authentication_and_authorization.util.TokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

@RestController
@RequestMapping("/admin")
public class AdminEndPoint {

    @GetMapping
    @AdminOnly
    public String adminAccess(@RequestHeader("Authorization") String authorization){

        if(authorization == null || !authorization.startsWith("Bearer ")){
            throw new RuntimeException("Invalid Token");
        }

        String token = authorization.substring(7);
        String[] details = TokenUtil.decodeToken(token);

        if(details[1].equalsIgnoreCase("admin")){
            return "welcome admin";
        }

        return "access denied";
    }
}
