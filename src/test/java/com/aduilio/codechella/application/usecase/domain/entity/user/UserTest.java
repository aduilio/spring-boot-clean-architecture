package com.aduilio.codechella.application.usecase.domain.entity.user;

import com.aduilio.codechella.domain.entity.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class UserTest {

    @ParameterizedTest
    @NullAndEmptySource
    @CsvSource({"abc.def.ghi-jk", "12334678900", "123.456.789"})
    public void invalidCpfShouldThrowException(String cpf) {
        User user = User.builder()
                .name("name")
                .cpf(cpf)
                .build();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, user::validate);

        Assertions.assertEquals(exception.getMessage(), "Invalid CPF");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @CsvSource({"email@", "email@server", "email"})
    public void invalidEmailShouldThrowException(String email) {
        User user = User.builder()
                .name("name")
                .cpf("123.456.789-00")
                .email(email)
                .build();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, user::validate);

        Assertions.assertEquals(exception.getMessage(), "Invalid e-mail");
    }
}
