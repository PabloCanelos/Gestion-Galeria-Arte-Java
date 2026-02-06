/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.galeria.utils;

/**
 *
 * @author Pavilion X360
 */
public class ValidacionDatos {
    
    //VALIDAR ID QUE TENGA UN FORMATO (ej GAL-001)
    public static boolean validarID(String id){
        if(id == null || id.trim().isEmpty()){
            System.out.println("este campo no puede quedar vacio");
            return false;
        }
        return  id.matches("^GAL-\\d{3}$");
        
    }
    
    //validar nombre (Solo letras, espacios y longitud entre 3 y 50)
    
    public static boolean validarTexto (String texto){
        if(texto == null || texto.trim().isEmpty()){
            System.out.println("este campo no puede quedar vacio");
            return false;
        }
        String regex = "^[a-zA-ZÁéíóúÁÉÍÓÚñÑ ]{3,50}$";
        if(texto.trim().matches(regex) && texto.length() >=3){
            return true;
        }
        System.out.println("Formato no es valido");
        return false;
    }
    
}
