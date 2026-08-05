package com.mechanism.authentication_and_authorization.service;

import com.mechanism.authentication_and_authorization.dto.LoginRequest;
import com.mechanism.authentication_and_authorization.dto.LoginResponse;
import com.mechanism.authentication_and_authorization.entity.User;
import com.mechanism.authentication_and_authorization.repo.UserRepo;
import com.mechanism.authentication_and_authorization.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    UserRepo userRepo;

    @Autowired
    LoginService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public LoginResponse loginUser(LoginRequest loginRequest){

        try {
            User user = userRepo.getUserByEmail(loginRequest.getEmail());
            if (user == null) {
                throw new IllegalArgumentException("User does not Exist.");
            }

            if(!user.getPassword().equals(loginRequest.getPassword())){
                throw new IllegalArgumentException("Incorrect Password");
            }

            String token = TokenUtil.encodeToken(user.getEmail(), user.getRole());

            LoginResponse loginResponse = new LoginResponse(user.getEmail(), user.getRole());
            loginResponse.setJWT_TOKEN(token);

            return loginResponse;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
