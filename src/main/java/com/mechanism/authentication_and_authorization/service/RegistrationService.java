package com.mechanism.authentication_and_authorization.service;

import com.mechanism.authentication_and_authorization.dto.RegisterRequest;
import com.mechanism.authentication_and_authorization.entity.User;
import com.mechanism.authentication_and_authorization.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    UserRepo userRepo;

    @Autowired
    RegistrationService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public User registerUser(RegisterRequest request){
        if(userRepo.existsByName(request.getName()) || userRepo.existsByEmail((request.getEmail()))){
            throw new IllegalArgumentException("Username or email is already taken.");
        }
        else{
            User newUser = new User();
            newUser.setName(request.getName());
            newUser.setEmail(request.getEmail());
            newUser.setPassword(request.getPassword());

            return userRepo.save(newUser);
        }
    }
}
