package com.exosoft.estoque_api.domain.repository;


import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<com.exosoft.estoque_api.domain.entity.User, Long> {
    boolean existsByEmail(@Email(message = "Email inválido") String email);
}
