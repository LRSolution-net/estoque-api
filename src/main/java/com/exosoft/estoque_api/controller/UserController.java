package com.exosoft.estoque_api.controller;

import com.exosoft.estoque_api.domain.entity.User;
import com.exosoft.estoque_api.dto.UserRequest;
import com.exosoft.estoque_api.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") @RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("Sistema Estoque-API - API está funcionando corretamente!");
    }

    @PostMapping
    public ResponseEntity<com.exosoft.estoque_api.domain.entity.User> create(@Valid @RequestBody UserRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(req));
    }

    @GetMapping("/list")
    public ResponseEntity<?> listUsuario(){
        List<User> users = service.getUsuarios();
        if(users.isEmpty()){
            String mensagem ="Lista Vazia!!!";
            return ResponseEntity.ok(mensagem);
        }
        return ResponseEntity.ok(users);

    }

    @GetMapping("/{id}")
    public ResponseEntity<com.exosoft.estoque_api.domain.entity.User> find(@PathVariable Long id) {
        return ResponseEntity.ok(service.find(id));
    }
}
