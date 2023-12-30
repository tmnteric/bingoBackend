package com.bingo.service;

import com.bingo.model.User;
import com.bingo.repository.UserRepository;
import java.util.*;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private final UserRepository usuarioRepository;
    private static final Logger logger = Logger.getLogger(UserService.class.getName());

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
   
    public Optional<User> iniciarSesion(String email, String password){
        logger.info("Intento de inicio de sesión con email: " + email);
        return usuarioRepository.findByEmail(email).filter(usuario -> usuario.verificarCredenciales(email, password));
    }
    
    private final Set<User> usuariosLogueados = new HashSet<>();

    public void iniciarSesion(User usuario) {
        usuariosLogueados.add(usuario);
    }

    public void cerrarSesion(User usuario) {
        usuariosLogueados.remove(usuario);
    }

    public int obtenerContadorUsuariosLogueados() {
        return usuariosLogueados.size();
    }
}
