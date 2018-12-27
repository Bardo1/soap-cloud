package org.wzx.cloud.fictionprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FictionProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FictionProviderApplication.class, args);
    }

}

