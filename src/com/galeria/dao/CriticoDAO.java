package com.galeria.dao;
import com.mysql.cj.jdbc.result.ResultSetImpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.galeria.dao.CriticoDAO;
import com.galeria.model.Critico;
import com.galeria.db.ConexionBD;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Pavilion X360
 */
public class CriticoDAO {
    private static CriticoDAO instancia;
    
    private CriticoDAO(){};
    
    public static CriticoDAO getInstancia(){
        if(instancia == null){
            instancia = new CriticoDAO();
        }
        return instancia;
    }
    
    public boolean crearCritico(Critico g){
        String query = "INSERT INTO critico ( rut, nombre_critico, especialidad, anios_experiencia) VALUES (?,?,?,?)";
        
        try ( Connection cn = ConexionBD.getInstancia().getConnection();
              PreparedStatement ps = cn.prepareStatement(query)){
            
            ps.setString(1, g.getRut());
            ps.setString(2, g.getNombreCritico());
            ps.setString(3, g.getEspecialidad());
            ps.setInt(4, g.getAniosExperiencia());
            
            return ps.executeUpdate()>0;
            
        } catch (SQLException e) {
            System.out.println("Error al crear " + e.getMessage());
           
        }
        return false;
        
    }
    
    public List<Critico> listar(){
        List<Critico>listaCriticos= new ArrayList<>();
        String query = "SELECT * FROM critico";
        
        try(Connection cn = ConexionBD.getInstancia().getConnection();
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            
            while(rs.next()){
                Critico critico = new Critico();
                critico.setRut(rs.getString("rut"));
                critico.setNombreCritico(rs.getString("nombre_critico"));
                critico.setEspecialidad(rs.getString("especialidad"));
                critico.setAniosExperiencia(rs.getInt("anios_experiencia"));
                listaCriticos.add(critico);
            }
            return listaCriticos;
            
            
        } catch (SQLException e) {
            System.out.println("Error de conexion con la base de datos " + e.getMessage());
        }
        return null;
    }
    
    public Critico buscarPorRut(String rutBuscado){
        String query = "SELECT * FROM critico WHERE rut = ?";
        Critico criticoEncontrado = null;
        try(Connection cn = ConexionBD.getInstancia().getConnection();
            PreparedStatement ps = cn.prepareStatement(query)) {
            
            ps.setString(1, rutBuscado.trim());
            
            try(ResultSet rs = ps.executeQuery() ) {
                if(rs.next()){
                    String rut = rs.getString("rut");
                    String nombre = rs.getString("nombre_critico");
                    String especialidad = rs.getString("especialidad");
                    int anios_experiencia = rs.getInt("anios_experiencia");
                    criticoEncontrado= new Critico(rut, nombre, especialidad, anios_experiencia);
                }
                
            }
      
        } catch (SQLException e) {
            System.out.println("ERROR enla consulta: " + e.getMessage());
        }
        return criticoEncontrado;
    }
     /* este metodo y todos los crud sql necesitan el puente}
    *que los conecte a la base de datos y ese es un metodo eliminar galeria el
    *cual se encuentra en validar galeria package 
    */
    public boolean eliminarCritico(String rutEliminar){
        String query = "DELETE FROM critico WHERE rut = ?";
        
        try(Connection cn = ConexionBD.getInstancia().getConnection();
            PreparedStatement ps = cn.prepareStatement(query)) {
            
            ps.setString(1, rutEliminar.trim());
            int filasAfectadas= ps.executeUpdate();
            return filasAfectadas>0;
            
        } catch (SQLException e) {
            System.out.println("Error en la base de datos, revisar conexion" + e.getMessage());
        }
        return false;      
    }
    
    
    public boolean actualizarCritico(Critico critico){
        
        String query ="UPDATE critico SET nombre_critico=?, especialidad =?, anios_experiencia=? WHERE rut =?";
        try(Connection cn = ConexionBD.getInstancia().getConnection();
            PreparedStatement ps = cn.prepareStatement(query)) {
            
            ps.setString(1, critico.getNombreCritico());
            ps.setString(2, critico.getEspecialidad());
            ps.setInt(3, critico.getAniosExperiencia());
            ps.setString(4, critico.getRut());
            
            int filasAfcetadas = ps.executeUpdate();
            return filasAfcetadas >0;
            
        } catch (SQLException e) {
            System.out.println("Error en la base de datos " +e.getMessage());
        }
        return false;
        
    }
    
    
    
}
