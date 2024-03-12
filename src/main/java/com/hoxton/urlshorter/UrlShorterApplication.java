package com.hoxton.urlshorter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.hoxton.urlshorter.mapper")
public class UrlShorterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UrlShorterApplication.class, args);
    }

}
