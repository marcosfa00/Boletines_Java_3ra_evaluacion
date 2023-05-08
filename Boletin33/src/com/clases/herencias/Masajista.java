/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clases.herencias;

/**
 *
 * @author marcosfa
 */
public class Masajista extends SelecionFutbol{
    private String titulacion;
    private Integer aniosExperiencia;

    public Masajista(Integer id, String nombre, String apellidos, Integer edad,String titulacion,Integer anios) {
        super(id, nombre, apellidos, edad);
        this.titulacion = titulacion;
        this.aniosExperiencia = anios;
    }
    
    
    public void darMasaje(){
        System.out.println("Masajeando");
    }

    @Override
    public String toString() {
        return super.toString() + "Masajista{" + "titulacion=" + titulacion + ", aniosExperiencia=" + aniosExperiencia + '}';
    }
    
}
