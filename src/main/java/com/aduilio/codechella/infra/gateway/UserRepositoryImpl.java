package com.aduilio.codechella.infra.gateway;

import com.aduilio.codechella.application.gateway.UserRepository;
import com.aduilio.codechella.domain.entity.user.User;
import com.aduilio.codechella.infra.mapper.UserMapper;
import com.aduilio.codechella.infra.persistence.UserJpaEntity;
import com.aduilio.codechella.infra.persistence.UserJpaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Implementation of the application repository.
 */
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Override
    public User save(User user) {
        UserJpaEntity userJpaEntity = UserMapper.INSTANCE.mapUserJpaEntityFrom(user);
        UserJpaEntity result = userJpaRepository.save(userJpaEntity);

        return userMapper.mapUserFrom(result);
    }

    @Override
    public List<User> list() {
        List<UserJpaEntity> result = userJpaRepository.findAll();

        return userMapper.mapUserFrom(result);
    }
}
