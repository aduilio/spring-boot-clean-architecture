package com.aduilio.codechella.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Responsible class to execute the repository operations.
 */
public interface UserJpaRepository extends JpaRepository<UserJpaEntity, Long> {
}
