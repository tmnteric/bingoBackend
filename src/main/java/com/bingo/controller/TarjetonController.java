/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bingo.controller;

import com.bingo.model.Tarjeton;
import com.bingo.service.TarjetonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tarjeton")
public class TarjetonController {
    
    private final TarjetonService tarjetonService;

    @Autowired
    public TarjetonController(TarjetonService tarjetonService) {
        this.tarjetonService = tarjetonService;
    }

    @GetMapping("/generar")
    public Tarjeton generarTarjeton() {
        return tarjetonService.generarTarjetonSinRepetir();
    }
}
