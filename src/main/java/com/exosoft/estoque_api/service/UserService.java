package com.exosoft.estoque_api.service;

import com.exosoft.estoque_api.domain.entity.User;
import com.exosoft.estoque_api.domain.repository.UserRepository;
import com.exosoft.estoque_api.dto.UserRequest;
import com.exosoft.estoque_api.exception.BusinessException;
import com.exosoft.estoque_api.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public com.exosoft.estoque_api.domain.entity.User create(UserRequest req) {
        if (repository.existsByEmail(req.email())) {
            throw new BusinessException("Email já cadastrado!");
        }
        com.exosoft.estoque_api.domain.entity.User user = new com.exosoft.estoque_api.domain.entity.User();
        user.setName(req.name());
        user.setEmail(req.email());
        return repository.save(user);
    }

    public com.exosoft.estoque_api.domain.entity.User find(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

    public List<User> getUsuarios(){
        return  repository.findAll();
    }

}
