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
public class Coche {
    private int nume_serie = 0;
    private String color = "";
    private int modelo = 0;
    private String tipo_combustible = "";
    private String tipo = "";
    private int id_catalogo = 0;

    public Coche() {
    }
    
     public Coche(int nume_serie) {
         this.nume_serie = nume_serie;
    } 
    
    public Coche(int nume_serie, String color, int modelo, String tipo_combustible, String tipo, int id_catalogo) {
        this.nume_serie = nume_serie;
        this.color = color;
        this.modelo = modelo;
        this.tipo_combustible = tipo_combustible;
        this.tipo = tipo;
        this.id_catalogo = id_catalogo;
    }
    
    public int getNume_serie() {
        return nume_serie;
    }

    public void setNume_serie(int nume_serie) {
        this.nume_serie = nume_serie;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getTipo_combustible() {
        return tipo_combustible;
    }

    public void setTipo_combustible(String tipo_combustible) {
        this.tipo_combustible = tipo_combustible;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId_catalogo() {
        return id_catalogo;
    }

    public void setId_catalogo(int id_catalogo) {
        this.id_catalogo = id_catalogo;
    }

    

    @Override
    public String toString() {
        return "Coche{" + "nume_serie=" + nume_serie + ", color=" + color + ", modelo=" + modelo + ", tipo_combustible=" + tipo_combustible + ", tipo=" + tipo + ", id_catalogo=" + id_catalogo + '}';
    }
            
    
}
