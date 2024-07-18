package com.aduilio.codechella.infra.mapper;

import com.aduilio.codechella.domain.entity.user.User;
import com.aduilio.codechella.infra.persistence.UserJpaEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UserMapperTest {

    @Test
    public void mapUserToUserJpaRepository() {
        User user = new User(1L, "cpf", "name", LocalDate.now(), "e-mail", null);

        UserJpaEntity result = UserMapper.INSTANCE.mapUserJpaEntityFrom(user);

        Assertions.assertEquals(user.getId(), result.getId());
        Assertions.assertEquals(user.getCpf(), result.getCpf());
        Assertions.assertEquals(user.getName(), result.getName());
        Assertions.assertEquals(user.getBirthDate(), result.getBirthDate());
        Assertions.assertEquals(user.getEmail(), result.getEmail());
    }

}
