package com.bingo.controller;

import com.bingo.model.User;
import com.bingo.service.UserService;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {
    
    private final UserService usuarioService;
    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    public UserController(UserService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<User>> obtenerTodosUsuarios() {
        List<User> usuarios = usuarioService.obtenerTodosUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> obtenerUsuarioPorId(@PathVariable Long id) {
        return usuarioService.obtenerUsuarioPorId(id)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<User> guardarUsuario(@RequestBody User usuario) {
        logger.info("Recibiendo solicitud para guardar usuario: " + usuario.toString());
        User nuevoUsuario = usuarioService.guardarUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PostMapping("/login")
    public ResponseEntity<User> iniciarSesion(@RequestParam String email, @RequestParam String password) {
        
        logger.info("Recibiendo solicitud para iniciar sesión con email: " + email + " y contraseña: " + password);
        return usuarioService.iniciarSesion(email, password)
            .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
}

}
