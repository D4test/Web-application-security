package edu.kiligoy.lab6.config;

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
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//       UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//       String username = userDetails.getUsername();
        return Optional.of(System.getProperty("user.name"));
    }
}
