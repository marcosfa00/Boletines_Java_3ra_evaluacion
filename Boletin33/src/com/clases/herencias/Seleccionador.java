/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clases.herencias;

/**
 *
 * @author marcosfa
 */
public class Seleccionador extends SelecionFutbol{
    private Integer idSelec;

    public Seleccionador(Integer id, String nombre, String apellidos, Integer edad) {
        super(id, nombre, apellidos, edad);
        idSelec = id;
    }

  
    
   
    public void seleccionarJugador(){
        System.out.println("Seleccionando jugador");
    }

    @Override
    public String toString() {
        return super.toString() + "Seleccionador{" + "idSelec=" + idSelec + '}';
    }
    
    
    
}
