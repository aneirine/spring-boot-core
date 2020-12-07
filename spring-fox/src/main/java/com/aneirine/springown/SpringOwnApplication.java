package com.aneirine.springown;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringOwnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringOwnApplication.class, args);
    }

}
