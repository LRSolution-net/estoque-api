package com.exosoft.estoque_api.usuario.application.port.service;

import com.exosoft.estoque_api.usuario.domain.model.User;
import com.exosoft.estoque_api.domain.repository.UserRepository;
import com.exosoft.estoque_api.usuario.adapter.in.web.UserRequest;
import com.exosoft.estoque_api.shared.domain.exception.BusinessException;
import com.exosoft.estoque_api.shared.domain.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public User create(UserRequest req) {
        if (repository.existsByEmail(req.email())) {
            throw new BusinessException("Email já cadastrado!");
        }
        User user = new User();
        user.setName(req.name());
        user.setEmail(req.email());
        return repository.save(user);
    }

    public User find(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

    public List<User> getUsuarios(){
        return  repository.findAll();
    }

}
