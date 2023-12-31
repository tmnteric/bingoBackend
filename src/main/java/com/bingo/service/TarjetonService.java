package com.bingo.service;

import com.bingo.model.Tarjeton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class TarjetonService {

    //metodo que genera un tarjeton de numero sin repetir
    public Tarjeton generarTarjetonSinRepetir() {
        Tarjeton tarjeton;
        do {
            tarjeton = generarTarjeton();
        } while (!tarjetonCorrecto(tarjeton));
        return tarjeton;
    }

    //metodo para validar que no se repita ningun numero en la posicion de las listas
    private boolean tarjetonCorrecto(Tarjeton tarjeton) {
        List<Integer> allNumbers = new ArrayList<>();
        List<List<Integer>> filas = obtenerFilas(tarjeton);
        for (List<Integer> fila : filas) {
            if (!Collections.disjoint(allNumbers, fila)) {
                return false;
            }
            allNumbers.addAll(fila);
        }
        return true;
    }

    private List<List<Integer>> obtenerFilas(Tarjeton tarjeton) {
        List<List<Integer>> filas = new ArrayList<>();
        filas.add(tarjeton.getB());
        filas.add(tarjeton.getI());
        filas.add(tarjeton.getN());
        filas.add(tarjeton.getG());
        filas.add(tarjeton.getO());
        return filas;
    }
    public Tarjeton generarTarjeton() {
        Tarjeton tarjeton = new Tarjeton();
        tarjeton.setB(numeros());
        tarjeton.setI(numeros());
        tarjeton.setN(numeros());
        tarjeton.setG(numeros());
        tarjeton.setO(numeros());
        return tarjeton;
    }

    private List<Integer> numeros() {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 75; i++) {
            numeros.add(i);
        }

        //llamada a la funcion shuffle para mezclar los numeros
        Collections.shuffle(numeros);

        List<Integer> fila = new ArrayList<>();
        fila.add(generarNumeroEnRango(1, 15));
        fila.add(generarNumeroEnRango(16, 30));
        fila.add(generarNumeroEnRango(31, 45));
        fila.add(generarNumeroEnRango(46, 60));
        fila.add(generarNumeroEnRango(61, 75));

//        while (!filaCorrecta(fila)) {
//            Collections.shuffle(numeros);
//            fila.set(0, generarNumeroEnRango(1, 15));
//            fila.set(1, generarNumeroEnRango(16, 30));
//            fila.set(2, generarNumeroEnRango(31, 45));
//            fila.set(3, generarNumeroEnRango(46, 60));
//            fila.set(4, generarNumeroEnRango(61, 75));
//        }
        return fila;
    }

//    private boolean filaCorrecta(List<Integer> fila) {
//        Set<Integer> uniqueNumbers = new HashSet<>(fila);
//        return uniqueNumbers.size() == fila.size();
//    }

    //metodo que genera el numero aleatorio en el rango especifico
    private int generarNumeroEnRango(int inicio, int fin) {
        return (int) (Math.random() * (fin - inicio + 1) + inicio);
    }
}
