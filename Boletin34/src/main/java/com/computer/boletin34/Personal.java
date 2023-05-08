/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computer.boletin34;

import java.util.GregorianCalendar;

/**
 *
 * @author marcosfa
 */
public class Personal {
   private String dni;
   private String nombre;
   private String apellido;
   private GregorianCalendar fechaIngreso;
   
   public Personal(String dni,String nombre,String apellido,int dia,int mes,int anho){
       this.dni = dni;
       this.nombre = nombre;
       this.apellido = apellido;
       validarFecha(anho,mes,dia);
   }
   public Personal(){
       
   }
   
   private void validarFecha(int year, int month, int day) {
     fechaIngreso = new GregorianCalendar(year, month-1, day);
     
   }
   
   public GregorianCalendar getFechaIngreso(){
       return fechaIngreso;
   }
   
}
