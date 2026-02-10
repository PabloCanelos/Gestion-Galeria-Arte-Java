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
import java.util.concurrent.SubmissionPublisher;
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
            System.out.println("ingresa id (formato ejemplo GAL-000) o escribe 'salir' para cancelar");
            id = sc.nextLine().trim();
            if(id.trim().equalsIgnoreCase("salir")){
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
            nombreGal = sc.nextLine().trim();
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
            ciudadGaleria = sc.nextLine().trim();
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
    
    public static void prepararEliminacionGaleria(Scanner sc){//1_ recibe bjeto scanner
        String idEliminar;
        System.out.println("\n--- ELIMINAR GALERIA ---");
        while (true) {
            //2- captura y limpia el dato
            System.out.println("Ingrese id a eliminar o escribe 'salir'");
            
            idEliminar = sc.nextLine().trim().toUpperCase();
            if(idEliminar.equals("SALIR"))break;
            
            //3- validciones basicas
            if(idEliminar.isEmpty()){
                System.out.println("Debe ingresar el ID valido");
                continue ;
            }
            /*4-) CONEXION DE PIEZAS : llamamos al singleton del DAO, el que tiene la quiery, no al singleton principal que va a la base de datos
            */
            boolean exito = GaleriaDAO.getInstancia().eliminarGaleria(idEliminar);
            //5- RESPUESTA AL USUARIO
            if(exito){
                System.out.println("Registro " + idEliminar + "  eliminado de la base de datos");
                break;
            }else{
                System.out.println("Error: No se encontro el ID o fallo la conexion");
            }
            
        }
        
    }
    
    //=====================================================================================
    //===================INICIO METODO ACTULAIZR CON SU METODO AUXILIAR=========================0
    //METODO ACTUALIZAR CONTENDRA UN METODO PARA VALIDAR EXITENCIA DEL OBJETO 
    
    // Método para validar el objeto completo según tu estándar profesional
    public boolean validarObjetoCompleto(Galeria g) {
        if (g == null) return false;

        // Verificamos que no haya campos vacíos y reglas de longitud
        boolean idOk = !g.getIdGaleria().isEmpty();
        boolean nombreOk = g.getNombre().length() >= 3;
        boolean ciudadOk = !g.getCiudad().isEmpty();

        return idOk && nombreOk && ciudadOk;
    }
    //metodo que toma el validador del objeto y proceder a actualizar
    public static void prepararActualizacionGaleria(Scanner sc){
        String buscarIdActualizar ="";
        System.out.println("---ACTUALIZAR GALERIA---");
        while (true) {
            System.out.println("Ingrese el id de la galeria que actualizara o escribe 'salir");
            buscarIdActualizar= sc.nextLine();
            
            if(buscarIdActualizar.equals("salir")) break;
            
            if(buscarIdActualizar.isEmpty()){
                System.out.println("debe ingresar el id correctamente");
                continue;
            }
            System.out.println("Ingrese nuevo nombre");
            String nuevoNombre = sc.nextLine().trim();
            
            System.out.println("Ingrese nueva ciudad");
            String nuevaCiudad = sc.nextLine().trim();
            
            //crear objeto nuevo
            Galeria g = new Galeria(buscarIdActualizar, nuevoNombre, nuevaCiudad);
            
            // VALIDACIONES
            if(!ValidadorMenuGaleria.getInstance().validarObjetoCompleto(g)){
                System.out.println("Error : Los datos no cumplen con el formato establecido");
                continue;
            }
            
            //PERSISTENCIA EN LA BD
            boolean exito = GaleriaDAO.getInstancia().actualizarGaleria(g);
            
            if(exito){
                System.out.println("¡Registri actualizado con exito en la base de datos");
                break;
            }else{
                System.out.println("No se encontro el id o fallo la conexion");
            }
          
        }
      
    }
        
    //====================================================================================
//=======================FIN DEL METODO ACTUALIZAR ============================================    
    
    
    
    
        
 }