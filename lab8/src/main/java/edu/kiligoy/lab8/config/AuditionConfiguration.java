package edu.kiligoy.lab8.config;

/*
@author   Dtest
@project   lab7
@class  AuditionConfiguration
@version  1.0.0
@since 30.04.2025 - 23.26
*/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@Configuration
public class AuditionConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }


}
