/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.db.clases;

import javax.swing.JOptionPane;

/**
 *
 * @author marcosfa
 */
public class MyException extends Exception{
        
    
    public MyException(String msg){
         JOptionPane.showMessageDialog(null, msg);
    }
    

    public static void conexionOk(){
        JOptionPane.showMessageDialog(null, "La conexion se ha realizado correctamente");
    }
    
    public static void conexionFallida(){
        JOptionPane.showMessageDialog(null, "Error en la conexión");
    }
    
    
    
    
    
    
}
