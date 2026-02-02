package com.pcanelos.galeria.model;

/**
 * Clase Modelo para representar la Evaluación de un Cuadro por un Crítico.
 */
public class Evaluacion {
    // 1. Atributos privados (Mapean con la tabla 'evaluacion' de tu SQL)
    private int idEvaluacion; // PK en la base de datos
    private String rutCritico; // FK hacia Critico
    private String idCuadro;   // FK hacia Cuadro
    private int calificacion;  // Valor numérico

    // 2. Constructor Vacío
    public Evaluacion() {
    }

    // 3. Constructor con parámetros
    public Evaluacion(int idEvaluacion, String rutCritico, String idCuadro, int calificacion) {
        this.idEvaluacion = idEvaluacion;
        this.rutCritico = rutCritico;
        this.idCuadro = idCuadro;
        this.calificacion = calificacion;
    }

    // 4. Getters y Setters
    public int getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public String getRutCritico() {
        return rutCritico;
    }

    public void setRutCritico(String rutCritico) {
        this.rutCritico = rutCritico;
    }

    public String getIdCuadro() {
        return idCuadro;
    }

    public void setIdCuadro(String idCuadro) {
        this.idCuadro = idCuadro;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}