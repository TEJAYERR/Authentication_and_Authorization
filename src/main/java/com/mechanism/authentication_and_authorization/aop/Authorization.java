package com.mechanism.authentication_and_authorization.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareAnnotation;
import org.springframework.stereotype.Component;

import java.text.Annotation;

@Aspect
@Component
public class Authorization {

    @Before("@annotation(com.mechanism.authentication_and_authorization.util.AdminOnly)")
    public void ex(){
        System.out.println("Hello");
    }
}
