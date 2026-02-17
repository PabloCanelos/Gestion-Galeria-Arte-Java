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
            return false;
        }
        String regex = "^[a-zA-ZÁéíóúÁÉÍÓÚñÑ ]{3,50}$";
        if(texto.trim().matches(regex)){
            return true;
        }
        //System.out.println("Formato no es valido");
        return false;
    }
    
    public static boolean validarRut(String rutString){
       
        if(rutString == null ) {         
            return false;
        }
        String rutLimpio= rutString.trim();
        if(rutLimpio.isEmpty()){
            System.out.println("este campo on puede quedar vacio");
            return false;          
        }
     
        if(!rutString.matches("^[0-9]{1,2}\\.?[0-9]{3}\\.?[0-9]{3}-[0-9kK]{1}$")){
            System.out.println("Formato del rut no es correcto ");
            return false;
        }
        return true;
        
    }
    
    public static boolean validarEsNumero(String entrada){
        if(entrada == null ||entrada.trim().isEmpty()){
        return false;        
         }
        //EPRESION REGULAR SOLO PERMITE NUMEROS(DIGITOS DEL 0 AL 9)
        //el sinbolo \\d+ significa "uno o mas digitos"
        if(!entrada.matches("\\d+")){
            System.out.println("Error: debes ingresar un numero valido");
        }
        //usamos parse luego de la validacion
        int numero = Integer.parseInt(entrada);
        if(numero<0 || numero>60){
            System.out.println("años de experiencia fuera de rango");
            return false;
        }
        return true;
      
    }
    
    public static void limpiarPantallaSaltos() {
    for (int i = 0; i < 15; i++) {
        System.out.println();
    }}
    public static void limpiarPantallaSout() {
    System.out.println("\n\n"); // Solo un par de espacios para respirar
    System.out.println("************************************************************");
    System.out.println("********** NUEVA OPERACIÓN CRÍTICA         **********");
    System.out.println("************************************************************");
}
    
}
