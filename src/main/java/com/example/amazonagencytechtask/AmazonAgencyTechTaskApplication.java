package com.example.amazonagencytechtask;

import com.example.amazonagencytechtask.model.db_collections.User;
import com.example.amazonagencytechtask.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AmazonAgencyTechTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmazonAgencyTechTaskApplication.class, args);
    }
}
