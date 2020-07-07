/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AMD
 */
public class CocheBD {
    private static final String  listado = "SELECT * from coche";
    private static final String insertar = "INSERT INTO coche SET nume_serie=?, color=?, modelo=?, tipo_combustible=?, tipo=?, id_catalogo=?";
    
    
    
    
    //Atributos de conexion
    PreparedStatement stmt = null;
    ResultSet rs = null;
    private Connection conexion = new Conexion().getConexion();
       
    public List<Coche> ListadoCoches() throws SQLException{
    List<Coche> coches=new ArrayList<>();
    this.stmt = this.conexion.prepareStatement(this.listado);
    this.rs = this.stmt.executeQuery();
    while (this.rs.next()){
        coches.add(new Coche(this.rs.getInt("nume_serie"),this.rs.getString("color"),this.rs.getInt("modelo"),this.rs.getString("tipo_combustible"),this.rs.getString("tipo"),this.rs.getInt("id_catalogo")));
    }
    return coches;
    }
    
    public boolean insertaCoche(Coche coche) throws SQLException{
        this.stmt = this.conexion.prepareStatement(this.insertar);
        this.stmt.setInt(1, coche.getNume_serie());
        this.stmt.setString(2, coche.getColor());
        this.stmt.setInt(3, coche.getModelo());
        this.stmt.setString(4, coche.getTipo());
        this.stmt.setString(5, coche.getTipo_combustible());
        this.stmt.setInt(6, coche.getId_catalogo());
        
        if(this.stmt.executeUpdate() == 1){
            return true;
        }else{
             return false;
        }
    }
    public boolean modificarCoche(Coche coche) throws SQLException{
        this.stmt = this.conexion.prepareStatement(this.insertar);
        this.stmt.setInt(1, coche.getNume_serie());
        this.stmt.setString(2, coche.getColor());
        this.stmt.setInt(3, coche.getModelo());
        this.stmt.setString(4, coche.getTipo());
        this.stmt.setString(5, coche.getTipo_combustible());
        this.stmt.setInt(6, coche.getId_catalogo());
        
        if(this.stmt.executeUpdate() == 1){
            return true;
        }else{
             return false;
        }
    }
}
