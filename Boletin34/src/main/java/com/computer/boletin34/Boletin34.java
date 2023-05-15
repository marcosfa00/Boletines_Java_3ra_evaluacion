/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.computer.boletin34;

/**
 *
 * @author marcosfa
 */
public class Boletin34 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
         ListaEmpleados lista = new ListaEmpleados();
        
        GregorianCalendar dataIngreso1 = new GregorianCalendar(2020, 10, 15);
        EContratado empregado1 = new EContratado("12345678A", "Pepito", "Perez", dataIngreso1, 1000);
        lista.engadirEmpregado(empregado1);
        
        GregorianCalendar dataIngreso2 = new GregorianCalendar(2015, 3, 1);
        EContratado empregado2 = new EContratado("87654321B", "Juanita", "Gonzalez", dataIngreso2, 1500);
        lista.engadirEmpregado(empregado2);
        
        GregorianCalendar dataIngreso3 = new GregorianCalendar(2010, 6, 23);
        EDestajo empregado3 = new EDestajo("999888777C", "Pedro", "Rodriguez", dataIngreso3, 50, 5);
        lista.engadirEmpregado(empregado3);
        
        double soldoTotal = lista.calcularSoldoTotal();
        System.out.println("O soldo total dos empregados é: " + soldoTotal);
      
        
    }
}
