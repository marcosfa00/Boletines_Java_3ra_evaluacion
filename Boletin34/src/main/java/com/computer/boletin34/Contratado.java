/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computer.boletin34;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author marcosfa
 */
public class Contratado extends Personal {
    private float Sueldo;
    private float plus;
    
    
    private float plus(){
        
       GregorianCalendar hoy = (GregorianCalendar) GregorianCalendar.getInstance();
        int anios = hoy.get(GregorianCalendar.YEAR) - super.getFechaIngreso().get(GregorianCalendar.YEAR);
       
      return anios;
        
        
        
    }
    
}
 