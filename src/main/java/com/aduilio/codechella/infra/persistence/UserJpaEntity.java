package com.aduilio.codechella.infra.persistence;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * Represents the database user entity.
 */
@Entity
@Data
@Table(name = "users")
public class UserJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String name;
    private LocalDate birthDate;
    private String email;
}
