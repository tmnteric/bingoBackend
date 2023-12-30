/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bingo.service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

@Service
public class JugadorService {
    
//    private final Set<WebSocketSession> jugadoresConectados = new HashSet<>();
//    
//    public void agregarJugador(WebSocketSession jugador){
//        jugadoresConectados.add(jugador);
//    }
//    
//    public void removerJugador(WebSocketSession jugador){
//        jugadoresConectados.remove(jugador);
//    }
//    
//    public int getContador(){
//        return jugadoresConectados.size();
//    }
    private static int contadorJugadores = 0;

    public void incrementarContador() {
        contadorJugadores++;
    }

    public void decrementarContador() {
        contadorJugadores--;
    }

    public int getContador() {
        return contadorJugadores;
    }
}
