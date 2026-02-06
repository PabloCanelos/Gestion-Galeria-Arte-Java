/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.galeria.view;

import com.galeria.dao.GaleriaDAO;
import java.util.ArrayList;
import java.util.Scanner;
import com.galeria.model.Galeria;
import com.galeria.utils.ValidacionDatos;
import com.galeria.utils.ValidadorMenuGaleria;
import mainMenu.MenuPrincipal;

/**
 *
 * @author Pavilion X360
 */
public class MenuGaleria {
    
    public static void menuGaleria(){
       // ArrayList<Galeria> listaGalerias = new ArrayList<>();
        
        Scanner sc = new Scanner(System.in);
        

        int opcion = 0;
        
        do {       
            System.out.println("--- SUBMENU GESTIÓN GALERÍA ---");
            System.out.println("1)Registrar galeria");
            System.out.println("2)Listar galerias");
            System.out.println("3)Eliminar galeria");
            System.out.println("4)Modificar galeria");
            System.out.println("5)Buscar Galeria por id");
            System.out.println("6))Volver al menu principal");
            
            
            
            opcion =sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
                case 1:
                    
                    /* registrar nombre, id y ciudad de galeria con sus respetivas validaciones
                    estas validaciones estan en package utils
                    */
                    //obtenemos singleton del menu galeria
                    ValidadorMenuGaleria validador =ValidadorMenuGaleria.getInstance();
                    
                    //pedir id
                    String id = validador.leerIdValido(sc);
                    if(id.equals("0")) break;
                    
                    //pedir nombre
                    String nombreGaleria = validador.validarNombreGaleria(sc);
                    if(nombreGaleria.equals("0")) break;
                    
                    //ingresar nombre de la ciudad donde pertenece la galeria
                    String ciudadGaleria = validador.validarCiudadGalerio(sc);
                    if(ciudadGaleria.equals("0")) break;;
                    Galeria nuevaGaleria = new Galeria(id, nombreGaleria,ciudadGaleria);
                    
                    boolean insertado = GaleriaDAO.getInstancia().crearGaleria(nuevaGaleria);
                    if(insertado){
                        System.out.println("\n REGISTRO EXITOSO: la galeria se guardo en la base de datos");
                    }else{
                        System.out.println("ERROR: No se pudo guardar la galeria. Revisa la conexion");
                    }
//                    nuevaGaleria.setIdGaleria(id);
//                    nuevaGaleria.setNombre(nombreGaleria);
//                    nuevaGaleria.setCiudad(ciudadGaleria);
                    break;
                   
                    
                case 2:
                    System.out.println("--- LISTA DE GALERIAS REGISTRADAS ---");
                    ValidadorMenuGaleria.mostrarListaGalerias();
                    break;
                    
                case 3:
                    System.out.println("A continuacion lista de galerias para que elimine alguna");
                    break;
                    
                case 5:
                    System.out.println("BUSQUEDA GALERIA");
                    
                    ValidadorMenuGaleria validadorID = ValidadorMenuGaleria.getInstance();
                    String idBuscar=validadorID.leerIdValido(sc);
                    if(idBuscar.equals("0")){
                        System.out.println("Busqueda cancelada");
                        break;
                    }
                    boolean encontrado = GaleriaDAO.getInstancia().buscarPorId(idBuscar);
                    if(!encontrado){
                        System.out.println("NO existen registros con ese id");
                    }
                    break;
                case 6:
                    System.out.println("Volviendo al menu principal, presiona ENTER...");
                    return;

           
                default:
                    System.out.println("opcion no existe");
            }
            
            
        } while (opcion != 7);
        
    }
    
}

