package edu.kiligoy.lab9.security;

/*
@author   Dtest
@project   lab8
@class  UserDetailsServiceImpl
@version  1.0.0
@since 16.05.2025 - 02.29
*/

import edu.kiligoy.lab9.user.Role;
import edu.kiligoy.lab9.user.User;
import edu.kiligoy.lab9.user.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
 //
    //@PostConstruct
    //void init() {
   //     User user = User.builder()
   //             .firstName("John")
   //             .lastName("Lennon")
   //             .email("john@mail.com")
   //             .password(passwordEncoder.encode("password"))
   //             .enabled(true)
   //             .accountLocked(false)
   //             .roles(List.of(Role.USER))
   //             .build();
   //    repository.save(user);
   // }

            //User admin = User.builder()
            //                .firstName("Admin")
            //                .lastName("Admin")
            //                .email("admin@mail.com")
            //                .password(passwordEncoder.encode("admin123"))
            //                .enabled(true)
            //                .accountLocked(false)
            //                .roles(List.of(Role.ADMIN))
            //                .build();

            //User superadmin = User.builder()
            //                .firstName("Super")
            //                .lastName("Admin")
            //                .email("superadmin@mail.com")
            //                .password(passwordEncoder.encode("superadmin"))
            //                .enabled(true)
            //                .accountLocked(false)
            //                .roles(List.of(Role.SUPERADMIN))
            //                .build();

        //repository.save(superadmin);
        //    //repository.saveAll(List.of(admin, superadmin));
        //}

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return repository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}