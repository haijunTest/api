package com.example.api.config.logging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * class $classname
 *
 * @author haijun
 * @date 2018/5/28, 14:40
 */
@Configuration
public class LoggingAspectConfig {

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

}
