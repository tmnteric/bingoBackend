/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bingo.service;

import com.bingo.model.Tarjeton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TarjetonService {
    
    public Tarjeton generarTarjeton(){
        
        Tarjeton tarjeton = new Tarjeton();
        
        tarjeton.setB(numeros(1, 15));
        tarjeton.setI(numeros(16,30));
        tarjeton.setN(numeros(31,45));
        tarjeton.setG(numeros(46,60));
        tarjeton.setO(numeros(61,75));
        return tarjeton;
    }
    
    // validacion de que no se repitan numeros
    private boolean filaCorrecta(List<Integer>fila){
        return new HashSet<>(fila).size() == fila.size();
    }
    
    private List<Integer> numeros(int start, int fin){
        List<Integer> numeros = new ArrayList<>();
        for (int i = start; i<= fin; i++){
            numeros.add(i);
        }
        
        //llamada a la funcion shuffle para mezclar los numeros
        Collections.shuffle(numeros);
        //llamada de la funcion sort para ordenar los numeros
//        Collections.sort(numeros);
        
        List<Integer> fila = new ArrayList<>(numeros.subList(0,5));
        
        //no permite repeticion de numeros al validar si la fila no esta correcta a lo cual vuelve a mezclar y ordenar
        while (!filaCorrecta(fila)){
            Collections.shuffle(numeros);
//            Collections.sort(numeros);
            fila = new ArrayList<>(numeros.subList(0, 5));
        }
        return fila;
    };
    
}
