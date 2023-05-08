/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clases.herencias;

import com.clases.interfaz.IntegranteSeleccionFutbol;

/**
 *
 * @author marcosfa
 */
public abstract class SelecionFutbol implements IntegranteSeleccionFutbol {
    private Integer id;
    private String nombre;
    private String apellidos;
    private Integer edad;

    public SelecionFutbol(Integer id, String nombre, String apellidos, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "SelecionFutbol{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + '}';
    }
   

    @Override
    public void concentrarse() {
        System.out.println("Me concentro");
    }

    @Override
    public void viajar() {
        System.out.println("viajo");
    }

    @Override
    public void entrenar() {
        System.out.println("Entreno");
    }

    @Override
    public void jugarPartido() {
        System.out.println("Juego el Partido");
    }
    
}
