package com.exosoft.estoque_api.usuario.adapter.out.persistence;


import jakarta.persistence.*;
import lombok.Data;

public class UserJpaEntity {


    @Entity
    @Table(name = "users") @Data
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String email;
    }


}
