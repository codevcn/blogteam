package com.example.demo.configs.props;

import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.application")
@Getter
public class AppInfoProps {

    @Getter(AccessLevel.NONE)
    private String name;

    public String getAppName() {
        return name;
    }
}
