/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clases.herencias;

/**
 *
 * @author marcosfa
 */
public class Futbolista extends SelecionFutbol{
    private Integer dorsal;
    private String demarcacion;

    public Futbolista(Integer id, String nombre, String apellidos, Integer edad, Integer dorsal,String demarcacion) {
        super(id, nombre, apellidos, edad);
        this.dorsal = dorsal;
        this.demarcacion = demarcacion;
    }

    @Override
    public String toString() {
        return super.toString() + "Futbolista{" + "dorsal=" + dorsal + ", demarcacion=" + demarcacion + '}';
    }

   
    

    
    public void entrevista(){
        System.out.println("soy entrevistado");
    }
}
