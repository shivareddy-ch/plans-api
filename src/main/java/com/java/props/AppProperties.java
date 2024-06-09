package com.java.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@EnableConfigurationProperties
@ConfigurationProperties(prefix = "plan-api")
@Configuration
@Data
public class AppProperties {
    Map<String, String> messages = new HashMap<>();
}
