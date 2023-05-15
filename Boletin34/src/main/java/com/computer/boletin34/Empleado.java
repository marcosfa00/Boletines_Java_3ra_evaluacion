/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computer.boletin34;

/**
 *
 * @author marcosfa
 */
public class Empleado {
    protected String dni;
    protected String nome;
    protected String apelidos;
    protected GregorianCalendar dataIngreso;

    public Empleado(String dni, String nome, String apelidos, GregorianCalendar dataIngreso) {
        this.dni = dni;
        this.nome = nome;
        this.apelidos = apelidos;
        this.dataIngreso = dataIngreso;
    }

    public abstract double calcularSueldo();

    public String getDNI() {
        return this.dni;
    }

    public String getName() {
        return this.nome;
    }

    public String getApellidos() {
        return this.apelidos;
    }

    public GregorianCalendar getDateIngreso() {
        return this.dataIngreso;
    }
    
}
