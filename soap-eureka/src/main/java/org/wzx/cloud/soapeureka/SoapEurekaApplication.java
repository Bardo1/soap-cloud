package org.wzx.cloud.soapeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SoapEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapEurekaApplication.class, args);
    }

}

