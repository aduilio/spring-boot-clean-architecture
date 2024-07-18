package com.aduilio.codechella.application.gateway;

import com.aduilio.codechella.domain.entity.user.User;

import java.util.List;

/**
 * The interaction between the domain and infra.
 */
public interface UserRepository {

    User save(User user);

    List<User> list();
}
