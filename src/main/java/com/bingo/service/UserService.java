package com.bingo.service;

import com.bingo.model.User;
import com.bingo.repository.UserRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private final UserRepository usuarioRepository;

    @Autowired
    public UserService(UserRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<User> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<User> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public User guardarUsuario(User usuario) {
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
   
}
