package edu.kiligoy.lab5.config;

/*
@author   Dtest
@project   lab5
@class  AuditorAwareImpl
@version  1.0.0
@since 08.04.2025 - 13.13
*/

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(System.getProperty("user.name"));
    }
}
