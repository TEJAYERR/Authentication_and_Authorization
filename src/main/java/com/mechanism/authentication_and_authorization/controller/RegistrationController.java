package com.mechanism.authentication_and_authorization.controller;

import com.mechanism.authentication_and_authorization.dto.RegisterRequest;
import com.mechanism.authentication_and_authorization.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    RegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request){
        try {
            System.out.println("Registration Controller");
            return new ResponseEntity<>(registrationService.registerUser(request),HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
