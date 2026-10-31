package com.exosoft.estoque_api.usuario.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users") @Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}
