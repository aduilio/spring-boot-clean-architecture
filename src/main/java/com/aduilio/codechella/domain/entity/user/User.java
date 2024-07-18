package com.aduilio.codechella.domain.entity.user;

import com.aduilio.codechella.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Represents the business logic User.
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String cpf;
    private String name;
    private LocalDate birthDate;
    private String email;
    private Address address;

    public void validate() {
        if (name == null) {
            throw new IllegalArgumentException("Invalid name");
        }

        validateCpf();
        validateEmail();
    }

    private void validateCpf() {
        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new IllegalArgumentException("Invalid CPF");
        }
    }

    private void validateEmail() {
        if (email == null || !email.matches("^[a-z0-9._-]+@[a-z0-9]+(\\.[a-z]+)+$")) {
            throw new IllegalArgumentException("Invalid e-mail");
        }
    }
}
