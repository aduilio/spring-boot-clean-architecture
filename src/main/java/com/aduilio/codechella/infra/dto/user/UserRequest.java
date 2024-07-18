package com.aduilio.codechella.infra.dto.user;

import java.time.LocalDate;

/**
 * Represents the request to create a user.
 */
public record UserRequest(
        String cpf,
        String name,
        LocalDate birthDate,
        String email
) {
}
