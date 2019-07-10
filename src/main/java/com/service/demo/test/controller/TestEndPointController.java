package com.service.demo.test.controller;

import org.cloud.microservice.business.utils.BcryptPasswordEncoderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import client.serviceauth.AuthServiceClient;

/**
 * @author hejian
 */
@RestController
public class TestEndPointController {

    private Logger logger = LoggerFactory.getLogger(TestEndPointController.class);


    private final AuthServiceClient authServiceClient;

    @Autowired
    public TestEndPointController(AuthServiceClient authServiceClient) {
        this.authServiceClient = authServiceClient;
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {

        String dbpasswor = "$2a$10$HBX6q6TndkgMxhSEdoFqWOUtctaJEMoXe49NWh8Owc.4MTunv.wXa";

        logger.info("判断两个密码是否相等 " + (BcryptPasswordEncoderUtil.PASSWORD_ENCODER.matches("123456", dbpasswor)));

        return "product id : " + id;
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id) {
        return "order id : " + id;
    }

    @GetMapping("/getPrinciple")
    public OAuth2Authentication getPrinciple(OAuth2Authentication oAuth2Authentication, Principal principal, Authentication authentication) {
        logger.info(oAuth2Authentication.getUserAuthentication().getAuthorities().toString());
        logger.info(oAuth2Authentication.toString());
        logger.info("principal.toString() " + principal.toString());
        logger.info("principal.getName() " + principal.getName());
        logger.info("authentication: " + authentication.getAuthorities().toString());

        return oAuth2Authentication;
    }
    public String test(){
        return "";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @RequestMapping("/hello")
    public String hello() {
        return "hello you";
    }

    @GetMapping("/getUser")
    public Object getUser() {
        return authServiceClient.getUser();
    }
}
