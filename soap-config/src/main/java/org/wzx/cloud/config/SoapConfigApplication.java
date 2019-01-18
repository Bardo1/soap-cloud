package org.wzx.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SoapConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapConfigApplication.class, args);
    }

}

