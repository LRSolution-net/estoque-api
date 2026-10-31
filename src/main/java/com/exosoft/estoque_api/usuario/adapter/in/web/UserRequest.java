package com.exosoft.estoque_api.usuario.adapter.in.web;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank(message = "Nome é obrigatório") String name,
        @Email(message = "Email inválido") String email
) {}
