/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.galeria.utils;
import com.galeria.dao.CriticoDAO;
import java.util.Scanner;
import com.galeria.model.Critico;
import java.util.ArrayList;
import java.util.List;
import com.galeria.model.Critico;
import com.sun.source.tree.ContinueTree;
/**
 *
 * @author Pavilion X360
 */
public class ValidadorMenuCritico {
    
    /* EL VALIDADOR CON SU SINGLETON ES EL PRIMERO PASO ANTES DE CREAR EL MENU CRITICO
    **EL MENU CRITICO SOLO CAPTURARA DATOS, DEBE IMPORTAR ESTE VALIDADOR. no SE PUEDE CREAR EL MENU SIN
    **ANTESTENER LISTO EL VALIDADOR DE LOS DATOS COMO PRIMER PASO
    */
    private static ValidadorMenuCritico instancia;
    
    private ValidadorMenuCritico(){}
    
    public static  ValidadorMenuCritico getInstance(){
        if(instancia==null){
            instancia = new ValidadorMenuCritico();
        }
        return instancia;
    }
    
    //metodo validadorMenuCritico de la clase completa de todo lo necesario para verificar el correcto ingreso de datos
    //Consume vtodas las validaciones necesarias para crear modificar o actualizar un objeto
   public boolean validarCriticoCompleto(Critico c) {
        if (c == null) return false;

        // Reutilizamos la lógica que ya tienes
        boolean rutOk = ValidacionDatos.validarRut(c.getRut()); // El que ya escribiste
        boolean nombreOk = c.getNombreCritico().length() >= 3;
        boolean expOk = c.getAniosExperiencia()>= 0 && c.getAniosExperiencia()<= 60;

        return rutOk && nombreOk && expOk;
    }
    /**
     * RUT CRITICO TIENE UN VALIDADOR EL CUAL PERTENECE AL MISMO PACKAGE PERO A UNA CLASE LLAMADA ValidacionDatos
     * @param sc Scanner para lectura de teclado
     * @return El rut validado es = "0" si el usuario cancela
    */
    public String validarRutCritico(Scanner sc){
        String rutString = "";
        
        while (true) {  
            System.out.println("Ingresa rut del critico  (EJ: 12.345.678-0) o escribe 'salir' para cancelar");
            rutString = sc.nextLine().trim();
            //1-OPCION DE SALIDA
            if(rutString.equalsIgnoreCase("salir")){
                return "0";
            }
            //2DA VALIDACION
            if(rutString.isEmpty() || !ValidacionDatos.validarRut(rutString)){
               // System.out.println("ERROR: formato del rut no es valido.Intente de nuevo");
                continue;
            }
            System.out.println("RUT validado corectamente");
            return rutString;
           
        }
    }
    
    
    /**aplicamos validacion  , validaciones es una clase que esta en el mismo package , se aplica reget
     * para validar formato del nombre
     * @param sc
     * @return nombreString(nombre del critico)
     */
    
    public String validarNombreCritico(Scanner sc){
        String nombreCritico ="";
        while (true) {
            System.out.println("Ingresa nomrbe del critico o escribe 'salir' para volver al menu anterior");
            nombreCritico = sc.nextLine().trim();
            if(nombreCritico.equalsIgnoreCase("salir")){
                System.out.println("volviendo al menu principal");
                return "salir";
            }
            if(!ValidacionDatos.validarTexto(nombreCritico)){
                System.out.println("nombre formato no es valido, no puede tener caracteres "
                        + "especiales y no puede quedar vacio");
                continue;
            }else{
                System.out.println("Nombre ingresado correctamente");
                return nombreCritico;
            }
            
            
        }
        
    }
    
    public String validarEspecialidad(Scanner sc){
        String especialidadCritico="";
        while (true) {          
            System.out.println("Ingresa la especialidad del critico o escribe 'salir");
            especialidadCritico= sc.nextLine().trim();
            if(especialidadCritico.isEmpty()){
                System.out.println("este campo non puede quedar vacio");
                continue;
            } 
            if(especialidadCritico.equalsIgnoreCase("salir")){
                return "salir";
            }
            
            if(!ValidacionDatos.validarTexto(especialidadCritico)){
                System.out.println("Formato no es compatible, vuelve a intentarlo");
                continue;
            }else{
                System.out.println("especialidad ingresada correctamente");
                return especialidadCritico;
            }
        
        }
        
    }
    
    
 /**=================================================================================
  * ===============================================================================
  */       
    
/**CREAMOS UN METODO VALIDADOR PARA AÑOS DE EXPERIENCIA, VALIDARA QUE NO ENTRE
     *TEXTO EL METODO AGREGAR AÑOS DE EXPERIENCIA, DICHO METODO SE ENCUENTRA EN CLASE
     * VALIDADOR DE DATOS
     * @params String entrada    sera parseado a int
     * @return true
     */
    
    
    public static int capturarAniosExperiencia(){
        Scanner leer = new Scanner(System.in);
        int resultado =-1;
        while (true) {
            System.out.println("Ingrese años de experiencia (0-60) o escribe 'salir: ");
            String entrada= leer.next().trim();
            
            if(entrada.equals("salir")){
                return resultado;
            }
           if(ValidacionDatos.validarEsNumero(entrada)){
               int valor= Integer.parseInt(entrada);
               if(valor >=0 && valor<=60){
                   return valor;
               }
           }
            System.out.println("Intenta nuevamente ...");
           
            
        }
    
    }
    //============================================================================================
    //=============================================================================================
    
    //OPCION 2 DELMENU CRITICO, MOSTRAR LISTA
    
    public static void mostarListaCriticos(){
        List<Critico>listaCriticos= CriticoDAO.getInstancia().listar();
        if(listaCriticos == null){
            System.out.println("Error : no se pudo conectar a la base de datos");
            System.out.println("asegunrate que la base de datos este disponible");
            return;
        }
        if(listaCriticos.isEmpty()){
            System.out.println("\n la lista esta disponible pero esta vacia");
            return;
        }
        System.out.println("\n===========================================================");
        System.out.println("               LISTADO DE CRITICOS                 ");
        System.out.println("\n===========================================================");
        
        System.out.printf("%-10s | %-20s | %-15s%n", "RUT", "NOMBRE", "ESPECIALIDAD");
        System.out.println("------------------------------------------");
        
        for (Critico lista : listaCriticos) {
            System.out.printf("%-10s | %-20s | %-15s%n", 
            lista.getRut(), lista.getNombreCritico(), lista.getEspecialidad());
            
        }
        System.out.println("===============================================================");
        
        
    }
    
    
    
    //=======================================================================
    //============CRUD ELIMINAR CRITICO ==============================
    public static boolean eliminarCritico(Scanner sc){
        String rutEliminar;
        System.out.println("\n --- ELIMINAR CRITICO ---");
        
        while (true) {
            System.out.println("Ingrese rut del critico a eliminar o escribe 'salir' para volver al menu");
            rutEliminar = sc.nextLine().trim();
            if(rutEliminar.equalsIgnoreCase("salir"))break;
            if(rutEliminar.isEmpty()){
                System.out.println("debe ingresar un rut valido");
                continue;
            }
            boolean exito = CriticoDAO.getInstancia().eliminarCritico(rutEliminar);
            if(exito){
                System.out.println("Registro " + rutEliminar+ " eliminado de la bade de datos");
            }else{
                System.out.println("Error: No se encontro el rut en la base de datos o fallo la conexion");
            }
           
        }
        return true;
      
    }
    
    public static void actualizarDatosCritico(Scanner sc){
        String rutCriticoActualizar ="";
        
        System.out.println("--- ACTUALIZAR DATOS DE CRITICO ---");
        ValidadorMenuCritico.mostarListaCriticos();
        
        while (true) {
            
            System.out.println("ingresa rut del critico del cual deseas modificar datos o escribe 'salir' ");
            rutCriticoActualizar = sc.nextLine().trim();
            if(rutCriticoActualizar.equalsIgnoreCase("salir")) return;
            
            if(!ValidacionDatos.validarRut(rutCriticoActualizar)){
                System.out.println("debe ingresar el rut del critico ");
                continue;
            }
            if(CriticoDAO.getInstancia().buscarPorRut(rutCriticoActualizar) == null){
                System.out.println("El rut no existe en el sistema");
                continue;
            }
            break;  
        }
            // BLOQUE 2: Capturar nuevos datos (Fuera del bucle del RUT)
        System.out.println("Ingrese nuevo nombre del critico:");
        String nuevoNombre = sc.nextLine().trim();

        System.out.println("Ingrese nueva especialidad:");
        String nuevaEspecialidad = sc.nextLine().trim();

        int aniosExp = 0;
        while (true) {
            try {
                System.out.println("Ingrese años de experiencia:");
                aniosExp = Integer.parseInt(sc.nextLine()); // Tu estándar de Parse
                break; 
            } catch (NumberFormatException e) {
                System.out.println("Error: este campo es numérico.");
            }
        }

        // BLOQUE 3: Persistencia
        Critico critico = new Critico(rutCriticoActualizar,nuevoNombre, nuevaEspecialidad, aniosExp);

        if (CriticoDAO.getInstancia().actualizarCritico(critico)) {
            System.out.println("¡Registro actualizado con éxito!");
        } else {
            System.out.println("Error al actualizar en la base de datos." );
        }
        
    }}
   
