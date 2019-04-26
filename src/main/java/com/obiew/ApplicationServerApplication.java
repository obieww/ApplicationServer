package com.obiew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.obiew.Controllers", "com.obiew.Entities", "com.obiew.Repositories"})
@EnableSwagger2
public class ApplicationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationServerApplication.class, args);
    }

}
