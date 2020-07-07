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
public class MarcaBD {
    
    private static final String  listado = "SELECT * from catalogo_marca";
    private static final String insertar = "INSERT INTO catalogo_marca SET id_marca=?, nom_marca=?";
    private static final String  nombre = "SELECT * from catalogo_marca WHERE id_marca=?";
    
    
    
    
    //Atributos de conexion
    PreparedStatement stmt = null;
    ResultSet rs = null;
    private Connection conexion = new Conexion().getConexion();
       
    public List<Marca> ListadoMarcas() throws SQLException{
    List<Marca> marcas=new ArrayList<>();
    this.stmt = this.conexion.prepareStatement(this.listado);
    this.rs = this.stmt.executeQuery();
    while (this.rs.next()){
        marcas.add(new Marca(this.rs.getInt("id_marca"),this.rs.getString("nom_marca")));
    }
    return marcas;
    }
    
    public boolean insertaMarca(Marca marca) throws SQLException{
        this.stmt = this.conexion.prepareStatement(this.insertar);
        this.stmt.setInt(1, marca.getId_marca());
        this.stmt.setString(2, marca.getNom_marca());
        
        if(this.stmt.executeUpdate() == 1){
            return true;
        }else{
             return false;
        }
    }
    
    public String dameNombre(Marca marca) throws SQLException{
        this.stmt = this.conexion.prepareStatement(this.nombre);
        this.stmt.setInt(1, marca.getId_marca());
        rs=this.stmt.executeQuery();
        if(rs.next()){
            String nombre = this.rs.getString("nom_marca");
            return nombre;
        }else{
             return "Nada";
        }
    }
    
}
