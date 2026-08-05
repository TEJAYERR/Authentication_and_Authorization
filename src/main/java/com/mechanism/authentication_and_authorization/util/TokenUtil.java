package com.mechanism.authentication_and_authorization.util;

import java.util.Base64;

public class TokenUtil {

//    private static final String SECRET_KEY = "very_secret";

    public static String encodeToken(String email, String role){
        String token = email + ":" + role;
        byte[] bytes = token.getBytes();

        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String[] decodeToken(String encodedToken){
        byte[] bytes = Base64.getDecoder().decode(encodedToken);
        return new String(bytes).split(":");
    }
}
