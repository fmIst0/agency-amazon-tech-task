package com.example.amazonagencytechtask.repository;

import com.example.amazonagencytechtask.model.db_collections.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
