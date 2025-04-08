package edu.kiligoy.lab5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/*
@author   Dtest
@project   lab5
@class  AuditionConfig
@version  1.0.0
@since 08.04.2025 - 13.12
*/

@EnableMongoAuditing
@Configuration
public class AuditionConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }

}
