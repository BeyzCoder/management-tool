package com.springcode.basicdashboard;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springcode.basicdashboard.Models.Admin;

@Configuration
public class AccountConfig {

    @Bean
    CommandLineRunner commandLineRunner(AdminRepository repository) {
        return args -> {
            Admin steven = new Admin("steven", "stevenbaes@yahoo.com");

            repository.saveAll(
                List.of(steven)
            );
        };
    }
}
