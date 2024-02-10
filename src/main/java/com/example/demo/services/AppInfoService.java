package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class AppInfoService {

    @Autowired
    private Environment environment;

    public String getAppName() {
        return environment.getProperty("spring.application.name");
    }
}
