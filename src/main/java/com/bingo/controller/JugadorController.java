package com.bingo.controller;

import com.bingo.service.JugadorService;
import com.bingo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/players")
public class JugadorController {

    private final JugadorService jugadorService;
//    private final UserService userService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
//        this.userService = userService;
    }

    //api que genera conteo de usuarios logueados
    @GetMapping("/count")
    public ResponseEntity<Map<String, Integer>> getContador() {
        int contador = jugadorService.getContador();
        Map<String, Integer> response = new HashMap<>();
        response.put("contador", contador);
        return ResponseEntity.ok(response);
    }
}
