/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.galeria.utils;

/**
 *
 * @author Pavilion X360
 */
public class RegetMasUsados {
    
    /*A CONTINUACIOJN LISTA DE REGET MAS USADOS
    
    --REGET PARA VALIDAR RUT CHILENO
    ^[0-9]{1,2}\.?[0-9]{3}\.?[0-9]{3}-[0-9kK]{1}$
    
    ---Permite letras, tildes y espacios. Ideal para el Nombre de la Galería.---
    solo letras
    ^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$
    
    ----------------------------------
    Obliga a un formato tipo GAL-001. (3 letras, guion, 3 números).
    ID Alfanumérico	^[A-Z]{3}-[0-9]{3}$
    _______________________________________
    Valida que solo haya dígitos. Útil para años o cantidades.
    Solo Números	^[0-9]+$
    _____________________________________
    El estándar para validar correos electrónicos.
    Email	^[\w.-]+@[\w.-]+\.[a-zA-Z]{2,6}$
    _________________________________________________
    Valida números de 9 a 15 dígitos, opcionalmente con un +.
    Teléfono	^\+?[0-9]{9,15}$
    
    __________________________________________________-
    Valida que el campo no esté vacío ni tenga solo espacios.
    No Vacío	^(?!\s*$).+
    _____________________________________________
    
    Este patrón permite letras (con tildes y ñ), números y espacios, 
    pero bloquea automáticamente símbolos como #$%&"!)(/&:
    ^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]+$
    */
   

    //
    //plantilla de separacion nivel pro
    //System.out.printf("%-10s | %-20s | %-15s%n", "ID", "NOMBRE", "CIUDAD");
    
}
