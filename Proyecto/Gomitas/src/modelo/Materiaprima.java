/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Isaac
 */
public class Materiaprima {

    public int getLote_Compra() {
        return Lote_Compra;
    }

    public void setLote_Compra(int Lote_Compra) {
        this.Lote_Compra = Lote_Compra;
    }

    public String getIngrediente() {
        return Ingrediente;
    }

    public void setIngrediente(String Ingrediente) {
        this.Ingrediente = Ingrediente;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    
    private int Lote_Compra;
    private String Ingrediente;
    private int Cantidad;
    
}
