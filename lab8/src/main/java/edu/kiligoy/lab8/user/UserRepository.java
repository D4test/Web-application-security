package edu.kiligoy.lab8.user;

/*
@author   Dtest
@project   lab8
@class  UserRepository
@version  1.0.0
@since 16.05.2025 - 02.28
*/

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
