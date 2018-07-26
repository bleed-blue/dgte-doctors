package com.dgtedr.project.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

import com.dgtedr.project.shared.client.ProjectClient;
import com.dgtedr.project.shared.client.config.FeignClientConfig;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses = ProjectClient.class)
@Import(FeignClientConfig.class)
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
