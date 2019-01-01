package org.wzx.cloud.soapeuraka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SoapEurakaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapEurakaApplication.class, args);
    }

}

