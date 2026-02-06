/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.galeria.model;

/**
 *
 * @author Pavilion X360
 */
public class Critico {
    private String rut;
    private String nombreCritico; // En SQL es nombre_critico
    private String especialidad;
    private int aniosExperiencia; // En SQL es anios_experiencia

    // 2. Constructor Vacío (Obligatorio para muchos frameworks profesionales)
    public Critico() {
    }

    // 3. Constructor con todos los parámetros
    public Critico(String rut, String nombreCritico, String especialidad, int aniosExperiencia) {
        this.rut = rut;
        this.nombreCritico = nombreCritico;
        this.especialidad = especialidad;
        this.aniosExperiencia = aniosExperiencia;
    }

    // 4. Getters y Setters (Puertas de acceso controladas)
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombreCritico() {
        return nombreCritico;
    }

    public void setNombreCritico(String nombreCritico) {
        this.nombreCritico = nombreCritico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }
    
}
