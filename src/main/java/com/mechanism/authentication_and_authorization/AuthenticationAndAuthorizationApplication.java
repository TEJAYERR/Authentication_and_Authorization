package com.mechanism.authentication_and_authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AuthenticationAndAuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationAndAuthorizationApplication.class, args);
		System.out.println("Hello World");
	}

}
