package com.aduilio.codechella.infra.mapper;

import com.aduilio.codechella.domain.entity.user.User;
import com.aduilio.codechella.infra.dto.user.UserRequest;
import com.aduilio.codechella.infra.dto.user.UserResponse;
import com.aduilio.codechella.infra.persistence.UserJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Maps the User entities.
 */
@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract UserJpaEntity mapUserJpaEntityFrom(User user);

    public abstract User mapUserFrom(UserJpaEntity userJpaEntity);

    public abstract List<User> mapUserFrom(List<UserJpaEntity> userJpaEntities);

    public abstract User mapUserFrom(UserRequest userRequest);

    public abstract UserResponse mapUserResponseFrom(User user);

    public abstract List<UserResponse> mapUserResponseFrom(List<User> users);
}
