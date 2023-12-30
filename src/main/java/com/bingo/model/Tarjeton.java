/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bingo.model;

import java.util.List;
import lombok.Data;

@Data
public class Tarjeton {
    
    // se crean 5 listas que asumen cada letra del carton de un bingo 
    private List<Integer> b;
    private List<Integer> i;
    private List<Integer> n;
    private List<Integer> g;
    private List<Integer> o;
    
}
