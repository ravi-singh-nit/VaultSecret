package com.sammu.learning.springbootDemo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SecretFromVault {
//    @Value("${db.name}")
//    String dbName;
//
//    @Value("${db.password}")
//    String password;

    @PostConstruct
    void init(){
//        System.out.println("userName fetched from vault is "+dbName);
//        System.out.println("Db passowrod fetcxhed from vault is "+ password);
    }
}
