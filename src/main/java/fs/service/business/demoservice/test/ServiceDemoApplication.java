package fs.service.business.demoservice.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hejian
 */
@EnableCircuitBreaker
@EnableFeignClients(basePackages = {"client.*"})
@SpringBootApplication(scanBasePackages = {"fs.service.business.demoservice"})
@EnableEurekaClient
public class ServiceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDemoApplication.class, args);
    }
}
