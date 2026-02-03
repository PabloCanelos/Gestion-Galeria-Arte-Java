/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainMenu;

import com.pcanelos.galeria.model.Critico;
import com.pcanelos.galeria.model.Cuadro;
import com.pcanelos.galeria.model.Evaluacion;
import com.pcanelos.galeria.model.Galeria;
import com.pcanelos.galeria.view.MenuGaleria;
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
            opcion = menuPrincipal.nextInt();
            menuPrincipal.nextLine();
            
            switch (opcion) {
                case 1:
                    MenuGaleria.menuGaleria();
                    
                    break;
                default:
                    throw new AssertionError();
            }
            
            
        } while (opcion != 5);
        

    }
    
}
