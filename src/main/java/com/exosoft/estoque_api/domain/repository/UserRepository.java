package com.exosoft.estoque_api.domain.repository;


import com.exosoft.estoque_api.usuario.domain.model.User;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(@Email(message = "Email inválido") String email);
}
