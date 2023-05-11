/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.marcosfa.app;

import com.clases.herencias.Entrenador;
import com.clases.herencias.Futbolista;
import com.clases.herencias.Masajista;
import com.clases.herencias.Seleccionador;
import com.clases.herencias.SelecionFutbol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author marcosfa
 */
public class Aplicacion {
    
    public class Metodos{
        public static ArrayList anhadir(SelecionFutbol obj,ArrayList<SelecionFutbol> lista){
            lista.add(obj);
            return lista;
        }
        
        public static void show(ArrayList<SelecionFutbol> lista){
            for (SelecionFutbol selecionFutbol : lista) {
                System.out.println(selecionFutbol + " ");
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<SelecionFutbol> lista = new ArrayList<>();
        SelecionFutbol obj1 = new Entrenador(33,"Manolo","Lama",41);
        SelecionFutbol obj2 = new Futbolista(34,"Juan","Manuel",39,4,"Barcelona");
        SelecionFutbol obj3 = new Masajista(35,"Julia","Mandela",60,"Dra Masajista",5);
        SelecionFutbol obj4 = new Seleccionador(36,"Marcos","Fernandez",23);
        Metodos.anhadir(obj1, lista);
        Metodos.anhadir(obj2, lista);
        Metodos.anhadir(obj3, lista);
        Metodos.anhadir(obj4, lista);
        
        obj1.concentrarse();
       
        
        Metodos.show(lista);
        
        
        
        int [] numeros = {5,2,1,4,3};
        int aux = 0;
        
         for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]+" ");
            
        }
         System.out.println("\n-----");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i]== 8) {
                aux = numeros[i];
                numeros[i] = numeros[1];
                numeros[1]= aux;
            }
            
        }
        System.out.println("-----");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]+" ");
            
        }
        
        
      
         System.out.println("\n-----");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]+" ");
            
        }
        
        
        Arrays.sort(numeros);
        
     
        System.out.println("\n-----");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]+" ");
            
        }
        
        Scanner sc = new Scanner(System.in);
        
        int [] numeros2 = new int[5];
        for (int i = 0; i < 5; i++) {
            
            System.out.println("Introduce un numero");
            numeros2[i] = sc.nextInt();
            
        }
        
       
        
        System.out.println("\n-----");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros2[i]+" ");
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       
    }
    
    
    
    
    
    
}
