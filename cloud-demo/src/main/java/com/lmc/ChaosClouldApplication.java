package com.lmc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.lmc.demo.**.dao*"} )
public class ChaosClouldApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChaosClouldApplication.class, args);
    }
}