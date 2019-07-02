package com.service.demo.client.serviceauth;

import org.cloud.microservice.business.config.AuthFeignClientBeanConfiguration;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.GetMapping;

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
@FeignClient(value = "service-auth", configuration = AuthFeignClientBeanConfiguration.class)
public interface AuthServiceClient {

    /**
     * 返回User
     *
     * @return 返回@{@code User}
     */
    @GetMapping(value = "/oauth/users/current")
    Object getUser();
}
