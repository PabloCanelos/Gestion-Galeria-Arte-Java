
package com.galeria.dao;
import com.mysql.cj.jdbc.result.ResultSetImpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.galeria.model.Galeria;
import com.galeria.db.ConexionBD;


/**
 *
 * @author Pavilion X360
 */
public class GaleriaDAO {
    private  static GaleriaDAO instancia;
    
    private GaleriaDAO(){};
    
    public static GaleriaDAO getInstancia(){
        if(instancia == null){
            instancia = new GaleriaDAO();
        }
        return instancia;
    }
       
    public  boolean crearGaleria(Galeria g){
        String sql = "INSERT INTO galeria (id_galeria, nombre, ciudad) VALUES (?,?,?)";
        try (Connection cn = ConexionBD.getInstancia().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setString(1, g.getIdGaleria());
            ps.setString(2, g.getNombre());
            ps.setString(3, g.getCiudad());
            return ps.executeUpdate()>0;
            
            
        } catch (SQLException e) {
            System.out.println("Error al crear " + e.getMessage());
            return false;
        }
        
    }
    public  List<Galeria> listar(){
        List<Galeria> lista = new ArrayList<>();
        String sql = "SELECT * FROM galeria";
        
        try(Connection cn = ConexionBD.getInstancia().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet  rs = ps.executeQuery()) {
            while (rs.next()) {
                Galeria g = new Galeria();
                g.setIdGaleria(rs.getString("id_galeria"));
                g.setNombre(rs.getString("nombre"));
                g.setCiudad(rs.getString("ciudad"));
                lista.add(g);
                
            }
            return lista;
            
        } catch (Exception e) {
            System.out.println("Error de conexion con la base de datos" + e.getMessage());
            return null ;
        }
        
    }
    
    public boolean buscarPorId(String idBuscado){
        String sql = "SELECT * FROM galeria WHERE id_galeria = ?";
        try(Connection conn = ConexionBD.getInstancia().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, idBuscado);
            
            //extraer los datos con result set
            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()){
                    String nombre =rs.getString( "nombre");
                    String ciudad = rs.getString("ciudad");
                    System.out.println("REGISTRO ENCONTRADO");
                    System.out.println("NOmbre : " + nombre + " | ciudad : " + ciudad);
                    return true;
                }else{
                    System.out.println("no se encontro registro");
                    return false;
                }
                
            } catch (SQLException e) {
                System.out.println("Error enla consulta" + e.getMessage());
            }
            
        } catch (SQLException e) {
            System.out.println("No se encontro el id" + idBuscado);
            return false;
        }
        return true;
    }
    
    
    
}
