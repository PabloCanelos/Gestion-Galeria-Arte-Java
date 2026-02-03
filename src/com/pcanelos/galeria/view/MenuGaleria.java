/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pcanelos.galeria.view;

import com.pcanelos.galeria.controller.GaleriaControler;
import java.util.ArrayList;
import java.util.Scanner;
import com.pcanelos.galeria.model.Galeria;

/**
 *
 * @author Pavilion X360
 */
public class MenuGaleria {
    
    public static void menuGaleria(){
       // ArrayList<Galeria> listaGalerias = new ArrayList<>();
        
        Scanner sc = new Scanner(System.in);
        GaleriaControler controler = new GaleriaControler();
        int opcion = 0;
        
        do {       
            System.out.println("--- SUBMENU GESTIÓN GALERÍA ---");
            System.out.println("1)Registrar galeria");
            System.out.println("2)Listar galerias");
            System.out.println("3)Eliminar galeria");
            System.out.println("4)Modificar galeria");
            System.out.println("5)Buscar Galeria por id");
            System.out.println("6))Volver al menu principal");
            System.out.println("7)Salir");
            
            
            opcion =sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.println("--- RELLENE LOS CAMPOS CONN LOS DATOS DE LA GALERIA QUE DESEA REGISTRAR ---");
                    System.out.println("Ingrese id");
                    String id = sc.nextLine();
                    System.out.println("Nombre de la galeria");
                    String nombreGaleria = sc.nextLine();
                    System.out.println("Ciudad");
                    String ciudad = sc.nextLine();
                    
                    Galeria galeria = new Galeria(id,nombreGaleria,ciudad);
                    controler = new GaleriaControler();
                    boolean exito = controler.crearGaleria(galeria);
                    if(exito){
                        System.out.println("Datos inyectados correctamente");
                    }
                  
                    break;
                case 2:
                    System.out.println("--- LISTA DE GALERIAS ---");
                    
                    controler.listar();
                    break;
                    
                case 5:
                    System.out.println("Ingrese id de la galeria");
                    String idGaleria = sc.nextLine();
                    if(idGaleria == null || idGaleria.isEmpty()){
                        System.out.println("este campo no puede quedar vacio");
                        
                    }
                    controler  = new GaleriaControler();
                    controler.buscarPorId(idGaleria);
                    break;
                default:
                    System.out.println("opcion no existe");
            }
            
            
        } while (opcion != 7);
        
    }
    
}

