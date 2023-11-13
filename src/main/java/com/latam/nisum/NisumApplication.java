package com.latam.nisum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.latam.nisum.repository")
@PropertySource("classpath:application.properties")
public class NisumApplication {

    public static void main(String[] args) {
        SpringApplication.run(NisumApplication.class, args);
    }

}
