package com.aduilio.codechella.application.usecase;

import com.aduilio.codechella.application.gateway.UserRepository;
import com.aduilio.codechella.domain.entity.user.User;
import lombok.RequiredArgsConstructor;

/**
 * Use case to create a User.
 */
@RequiredArgsConstructor
public class CreateUser {

    private final UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }
}
