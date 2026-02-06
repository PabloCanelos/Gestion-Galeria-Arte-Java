/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.galeria.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Pavilion X360
 */
public class ConexionBD {
    private static ConexionBD instancia;
    private Connection conexion;
    
    private final String URL = "jdbc:mysql://localhost:3306/galeriadearte";
    private final String USER = "root";
    private final String PASS = "";

    private ConexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion = DriverManager.getConnection(URL,USER,PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar" + e.getMessage());
        }
    }
    
    
    public static ConexionBD getInstancia(){
        if(instancia == null){
            instancia = new ConexionBD();
        }
        return instancia;
    }
    
    public Connection getConnection(){
        try {
            if(conexion == null || conexion.isClosed()){
                this.conexion = DriverManager.getConnection(URL, USER, PASS);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al ibntenta r reconectar " + e.getMessage());
        }
        return conexion;
    }
    
}
