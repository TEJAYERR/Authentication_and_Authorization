package com.mechanism.authentication_and_authorization.service;

import com.mechanism.authentication_and_authorization.dto.UserProfileResponse;
import com.mechanism.authentication_and_authorization.entity.User;
import com.mechanism.authentication_and_authorization.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEndPointService {

    UserRepo userRepo;

    @Autowired
    UserEndPointService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public UserProfileResponse userProfile(String email){

        User user = userRepo.getUserByEmail(email);
        if(user == null){
            throw new RuntimeException("Invalid User Token");
        }

        UserProfileResponse userProfileResponse = new UserProfileResponse();
        userProfileResponse.setName(user.getName());
        userProfileResponse.setEmail(user.getEmail());

        return userProfileResponse;
    }
}
