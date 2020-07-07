/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author AMD
 */
public class Marca {
    private int id_marca = 0;
    private String nom_marca = "";

    public Marca() {
    }
    
    public Marca(int id_marca) {
        this.id_marca = id_marca;
    }
    
    public Marca(int id_marca, String nom_marca) {
        this.id_marca = id_marca;
        this.nom_marca = nom_marca;
    }
    

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getNom_marca() {
        return nom_marca;
    }

    public void setNom_marca(String nom_marca) {
        this.nom_marca = nom_marca;
    }

    @Override
    public String toString() {
        return "CocheBD{" + "id_marca=" + id_marca + ", nom_marca=" + nom_marca + '}';
    }
    
    
}
