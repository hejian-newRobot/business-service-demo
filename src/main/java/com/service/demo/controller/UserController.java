package com.service.demo.controller;

import com.service.demo.dao.UserDao;
import com.service.demo.dto.UserLoginParamDto;
import com.service.demo.entity.User;

import org.cloud.microservice.business.utils.BcryptPasswordEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Collections;

import javax.validation.Valid;

import io.swagger.annotations.Api;


/**
 * @author hejian
 */
@Api("hahahha")
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserDao userRepository;

    private final OAuth2ClientProperties oAuth2ClientProperties;

    private final OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails;

    private final RestTemplate restTemplate;

    @Autowired
    public UserController(UserDao userRepository,
                          OAuth2ClientProperties oAuth2ClientProperties,
                          OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails,
                          RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.oAuth2ClientProperties = oAuth2ClientProperties;
        this.oAuth2ProtectedResourceDetails = oAuth2ProtectedResourceDetails;
        this.restTemplate = restTemplate;
    }


    @RequestMapping("/login")
    public ResponseEntity<OAuth2AccessToken> login(@Valid UserLoginParamDto loginDto, BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            throw new Exception("登录信息错误，请确认后再试");
        }

        User user = userRepository.findByUserName(loginDto.getUsername());

        if (null == user) {
            throw new Exception("用户为空，出错了");
        }

        String encodePrefix = "{bcrypt}";
        if (!BcryptPasswordEncoderUtil.PASSWORD_ENCODER.matches(loginDto.getPassword(), user.getPassWord().replace(encodePrefix, ""))) {
            throw new Exception("密码不正确");
        }

        String clientSecret = oAuth2ClientProperties.getClientId() + ":" + oAuth2ClientProperties.getClientSecret();

        clientSecret = "Basic " + Base64.getEncoder().encodeToString(clientSecret.getBytes());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", clientSecret);

        //授权请求信息
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.put("username", Collections.singletonList(loginDto.getUsername()));
        map.put("password", Collections.singletonList(loginDto.getPassword()));
        map.put("grant_type", Collections.singletonList(oAuth2ProtectedResourceDetails.getGrantType()));

        map.put("scope", oAuth2ProtectedResourceDetails.getScope());
        //HttpEntity
        HttpEntity httpEntity = new HttpEntity<>(map, httpHeaders);
        //获取 Token
        return restTemplate.exchange(oAuth2ProtectedResourceDetails.getAccessTokenUri(), HttpMethod.POST, httpEntity, OAuth2AccessToken.class);
    }
}
