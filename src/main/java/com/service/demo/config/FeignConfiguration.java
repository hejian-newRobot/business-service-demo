package com.service.demo.config;

import com.service.demo.client.serviceauth.AuthServiceClient;
import com.service.demo.interceptor.FeignInterceptor;

import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;

/**
 * 项目名称：SimpleSpringCloudGateway
 * 包名称:com.service.demo.config
 * 类描述：
 * 创建人：hejian
 * 创建时间：2019/6/25 14:17
 * 修改人：hejian
 * 修改时间：2019/6/25 14:17
 * 修改备注：
 *
 * @author hejian
 */
@Configuration
public class FeignConfiguration {

    @Bean
    public AuthServiceClient getFeignClient() {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .requestInterceptor(new FeignInterceptor())
                .target(AuthServiceClient.class, "http://localhost:9098/");
    }
}
