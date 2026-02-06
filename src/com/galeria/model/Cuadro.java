package com.galeria.model;

/**
 * Clase Modelo para representar un Cuadro (Obra de Arte).
 */
public class Cuadro {
    // 1. Atributos privados (Mapean con id_cuadro, titulo, autor e id_galeria del SQL)
    private String idCuadro;
    private String titulo;
    private String autor;
    private String idGaleria; // FK hacia la tabla Galeria

    // 2. Constructor Vacío
    public Cuadro() {
    }

    // 3. Constructor con parámetros
    public Cuadro(String idCuadro, String titulo, String autor, String idGaleria) {
        this.idCuadro = idCuadro;
        this.titulo = titulo;
        this.autor = autor;
        this.idGaleria = idGaleria;
    }

    // 4. Getters y Setters
    public String getIdCuadro() {
        return idCuadro;
    }

    public void setIdCuadro(String idCuadro) {
        this.idCuadro = idCuadro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdGaleria() {
        return idGaleria;
    }

    public void setIdGaleria(String idGaleria) {
        this.idGaleria = idGaleria;
    }
}