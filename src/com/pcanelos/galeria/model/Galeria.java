


package com.pcanelos.galeria.model;

/**
 * Clase Modelo para representar una Galería de Arte.
 */
public class Galeria {
    // 1. Atributos privados (Coinciden con id_galeria, nombre y ciudad del SQL)
    private String idGaleria;
    private String nombre;
    private String ciudad;

    // 2. Constructor Vacío
    public Galeria() {
    }

    // 3. Constructor con parámetros
    public Galeria(String idGaleria, String nombre, String ciudad) {
        this.idGaleria = idGaleria;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    // 4. Getters y Setters
    public String getIdGaleria() {
        return idGaleria;
    }

    public void setIdGaleria(String idGaleria) {
        this.idGaleria = idGaleria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
}
