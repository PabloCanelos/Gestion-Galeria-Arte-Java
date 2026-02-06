/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainMenu;

import com.galeria.model.Critico;
import com.galeria.model.Cuadro;
import com.galeria.model.Evaluacion;
import com.galeria.model.Galeria;
import com.galeria.view.MenuGaleria;
import java.util.Scanner;

/**
 *
 * @author Pavilion X360
 */
public class MenuPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner menuPrincipal = new Scanner(System.in);
        int opcion = 0;
        
        
        do {  
            System.out.println("1)Gestion galeria");
            System.out.println("2)Gestion cuadro");
            System.out.println("3)Gestion critico");
            System.out.println("4)Gestion evaluaciones");
            System.out.println("5)Salir");
            System.out.println("Escoja una opcion del menu");
            
            
                // VALIDACIÓN DE NÚMERO
            if (menuPrincipal.hasNextInt()) {
                opcion = menuPrincipal.nextInt();
                menuPrincipal.nextLine(); // Limpiar el buffer
            } else {
                System.out.println("❌ Error: Por favor, ingrese un número, no letras.");
                menuPrincipal.nextLine(); // Limpiar el error del buffer
                opcion =0;
                continue; // Salta al inicio del do para mostrar el menú de nuevo
            }

            
            switch (opcion) {
                
                    
                    
                case 1:
                    MenuGaleria.menuGaleria();
                    
                    break;
                    
                    
                case 5:
                    System.out.println("Presiona ENTER para salir del menu...");
                    //menuPrincipal.nextInt();
                    //menuPrincipal.nextLine();
                   
                    break;
                default:
                    System.out.println("Opcion no existe");;
            }
            
            
            
        } while (opcion != 5);
        

    }
    
}
