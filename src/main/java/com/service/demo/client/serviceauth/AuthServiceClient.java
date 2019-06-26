package com.service.demo.client.serviceauth;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Objects;

/**
 * 项目名称：SimpleSpringCloudGateway
 * 包名称:com.service.demo.client.serviceauth
 * 类描述：
 * 创建人：hejian
 * 创建时间：2019/6/25 11:22
 * 修改人：hejian
 * 修改时间：2019/6/25 11:22
 * 修改备注：
 *
 * @author hejian
 */
@FeignClient("service-auth")
public interface AuthServiceClient {

    @GetMapping(value = "/oauth/users/current")
    Object getUser();
}
