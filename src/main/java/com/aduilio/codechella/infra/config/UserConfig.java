package com.aduilio.codechella.infra.config;

import com.aduilio.codechella.application.gateway.UserRepository;
import com.aduilio.codechella.application.usecase.CreateUser;
import com.aduilio.codechella.application.usecase.ListUsers;
import com.aduilio.codechella.infra.gateway.UserRepositoryImpl;
import com.aduilio.codechella.infra.persistence.UserJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Responsible to instantiate the beans.
 */
@Configuration
public class UserConfig {

    @Bean
    public UserRepository userRepository(final UserJpaRepository userJpaRepository) {
        return new UserRepositoryImpl(userJpaRepository);
    }

    @Bean
    public CreateUser createUser(final UserRepository userRepository) {
        return new CreateUser(userRepository);
    }

    @Bean
    public ListUsers listUsers(final UserRepository userRepository) {
        return new ListUsers(userRepository);
    }
}
