package com.aduilio.codechella.application.usecase;

import com.aduilio.codechella.application.gateway.UserRepository;
import com.aduilio.codechella.domain.entity.user.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Use case to list all users.
 */
@RequiredArgsConstructor
public class ListUsers {

    private final UserRepository userRepository;

    public List<User> list() {
        return userRepository.list();
    }
}
