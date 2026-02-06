/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.galeria.utils;
import java.util.Scanner;
import com.galeria.model.Galeria;
import java.util.ArrayList;
import java.util.List;
import com.galeria.dao.GaleriaDAO;
/**
 *
 * @author Pavilion X360
 */

public class ValidadorMenuGaleria {
    
    //singleton menu galeria
    private static ValidadorMenuGaleria instancia;

    private ValidadorMenuGaleria() {}

    public static ValidadorMenuGaleria getInstance(){
        if(instancia == null){
            instancia = new ValidadorMenuGaleria();
        }
        return instancia;
    }
    
    public String leerIdValido(Scanner sc){
        String id="";
        boolean esValido = false;
        while (!esValido) {   
            System.out.println("ingresa id (formato ejemplo GAL-000) o escribe '0' para cancelar");
            id = sc.nextLine();
            if(id.equalsIgnoreCase("0")){
                System.out.println("volviendo al menu anterior");
                return "0";
            }
            if(!ValidacionDatos.validarID(id)){
                System.out.println("Error: Formato del id no es compatible. Intenta nuevamente");
            }else{
                System.out.println("Id validado correctamente");
                esValido = true;
            }
            
        }
        return id;
        
        
    }
    
    public String validarNombreGaleria(Scanner sc){
        String nombreGal = "";
  
        while (true) { 
            System.out.println("Ingrese nombre de la galeria, minimo 3 caracteres o escribe '0' para cancelar");
            nombreGal = sc.nextLine();
            if(nombreGal.equals("0")){
                return "0";
            }
            
            if(!ValidacionDatos.validarTexto(nombreGal)){
                System.out.println("Nombre no es validado correctamente");
                
            }else{
                System.out.println("nombre correcto");
                return nombreGal;
                        
               
            }
        }
        
    }
    
    public String validarCiudadGalerio(Scanner sc){
        String ciudadGaleria = "";
        while (true) {
            System.out.println("Ingrese nombre de la ciudad a donde pertenece la galeria o escribe '0' para volver al menu anterior)");
            ciudadGaleria = sc.nextLine();
            if(ciudadGaleria.equals("0"))break;
            if(ValidacionDatos.validarTexto(ciudadGaleria)){
                return ciudadGaleria;
            }else{
                System.out.println("Dato ingresado nocumple con el formato");
                
            }
            
        } 
        return null;
            
        }
    
    //SEGUNDA OPCION DEL SUBMENU DE GALERIAS LISTAR GALERIAS validadores
    public static void mostrarListaGalerias(){
        List<Galeria> lista = GaleriaDAO.getInstancia().listar();
        if(lista == null ){
            System.out.println("Error no se pudo conectar con la base de datos");
            System.out.println("asegurate dq ue la base de datos este disponible");
            return;
        }
        if(lista.isEmpty()){
            System.out.println("\n La lista esta disponible, pero no hay registros");
            return;
        }
        System.out.println("\n===========================================================");
        System.out.println("               LISTADO DE GALERIAS                  ");
        System.out.println("\n===========================================================");
        // %-15s define un ancho fijo de 15 caracteres
        System.out.printf("%-10s | %-20s | %-15s%n", "ID", "NOMBRE", "CIUDAD");
        System.out.println("------------------------------------------");
        for (Galeria g : lista) {
            System.out.printf("%-10s | %-20s | %-15s%n", 
            g.getIdGaleria(), g.getNombre(), g.getCiudad());
        }
        System.out.println("=====================================================================");
    }
    
//    public boolean eliminarGaleria(String idEliminar){
//        if(idEliminar == null || idEliminar.trim().isEmpty()){
//            System.out.println("Debe ingrresar un id valido");
//            return false;
//        }
//        for (Object object : col) {
//            
//        }
//        
//        
//    }
    
    
    
        
 }