package com.example.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author:liuweif
 */
@MapperScan("com.example.account.mapper")
@SpringBootApplication
public class SpringbootTranfserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTranfserApplication.class, args);
        System.out.println("SpringbootTransferApplication web started!");
    }

}
