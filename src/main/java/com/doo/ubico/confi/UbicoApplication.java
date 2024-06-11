package com.doo.ubico.confi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.doo.ubico.api.controller",
        "com.doo.ubico.Interface",
        "com.doo.ubico.business.usecase",
        "com.doo.ubico.confi"
})
public class UbicoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UbicoApplication.class, args);

    }

}
