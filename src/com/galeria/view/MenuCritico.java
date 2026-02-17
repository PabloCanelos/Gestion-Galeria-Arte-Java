/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.galeria.view;

import com.galeria.dao.CriticoDAO;
import java.util.Scanner;
import com.galeria.utils.ValidacionDatos;
import com.galeria.utils.ValidadorMenuCritico;
import com.galeria.model.Critico;
/**
 *
 * @author Pavilion X360
 */
public class MenuCritico {
    
    
    public static void menuCritico(){
        
        Scanner sc = new Scanner(System.in);
        int opcion =0;
        
        do {  
            
            //LIMPIADOR DE PANTALLA DESPUES DE CADA CICLO PARA QUE EL MENU SALGA ARRIBA
            
            try {
                System.out.println("--- SUBMENU GESTION CRITICO ---");
                System.out.println("1)Registrar critico");
                System.out.println("2)Mostrar lista de criticos");
                System.out.println("3)Eliminar critico");
                System.out.println("4)Modificar datos");
                System.out.println("5)Buscar critico por rut");
                System.out.println("6)Volver al menu principal");
                System.out.println("***ELIJE UNA OPCION***");
                
                opcion= sc.nextInt();
                sc.nextLine();
                switch (opcion){
                    case 1:
                        /** IMPORTAMOS Y UTILIZAMOS EL VALIDADOR DE RUT QUE SE ENCUNTRA EN VALIDADOR DE DATOS en el  MISMO PACKAGE
                         * @param sc scanner
                         * @return
                         */
                        //importamos el validador y su singleton
                        ValidadorMenuCritico validador = ValidadorMenuCritico.getInstance();
                        
                        //  PEDIR RUT
                        String rutCritico= validador.validarRutCritico(sc);      
                        if(rutCritico.equals("0")) break;
                        
                        // PEDIR NOMBRE
                        
                        String nombreCritico = validador.validarNombreCritico(sc);
                        if(nombreCritico.trim().equalsIgnoreCase("salir"))break;
                        
                        //PEDIR ESPECIALIDAD
                        String especialidadCrString= validador.validarEspecialidad(sc);
                        if(especialidadCrString.equalsIgnoreCase("salir"))break;
                        
                        int aniosExperiencia = validador.capturarAniosExperiencia();
                        
                        Critico nuevoCritico = new Critico(rutCritico, nombreCritico, especialidadCrString, aniosExperiencia);
                        if(validador.validarCriticoCompleto(nuevoCritico)){
                        boolean insertado = CriticoDAO.getInstancia().crearCritico(nuevoCritico);
                        
                        if(insertado){
                            System.out.println("\n REGISTRO EXITOSO: El critico ha sido guardado en la base de datos ");
                            System.out.println("Presione enter para continuar");
                        }else{
                            System.out.println("ERROR: No se uedo guardar el critico enla base de datos");
                            
                        }
                        sc.nextLine();
                        //
                        
                        
                        }

                        break;
                        
                    case 2:
                        System.out.println("--- LISTA DE CRITICOS ---");
                        ValidadorMenuCritico.mostarListaCriticos();
                        System.out.println("Presione ENTER para volver al menu principal");
                        sc.nextLine();
                        break;
                    
                    case 3:
                        System.out.println("--- PARA ELIMINAR AL CRITICO DEBE BUSCARLO POR SU RUT ---");
                        ValidadorMenuCritico.eliminarCritico(sc);
                        System.out.println("Presione ENTER para volver al menu principal");
                        sc.nextLine();
                        break;
                    case 4:
                        System.out.println("--- MODIFICAR DATOS ---");
                        ValidadorMenuCritico.actualizarDatosCritico(sc);
                        System.out.println("presione ENTER para volver al menu principal");
                        sc.nextLine();
                        break;
                        
                    case 6:
                        System.out.println("volviendo al menu principal");
                        return;
                        
                    default:
                        System.out.println("Opcion no existe");
                        
                }      
                 // Este cierra el switch

            } catch (Exception e) {
                System.out.println("❌ ERROR: Este campo debe ser numérico.");
                sc.nextLine(); // Limpiamos el buffer para evitar el bucle infinito
                opcion = 0;    // Reseteamos la opción
            }
            
        } while (opcion != 6); // Este cierra el do-while
        
    } // Este cierra el método menuCritico
    
} // Este cierra la clase MenuCritico
                
     
      
    

