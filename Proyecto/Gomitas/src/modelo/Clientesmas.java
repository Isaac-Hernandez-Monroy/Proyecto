/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Isaac
 */
public class Clientesmas {
    
     public String getPaleta() {
        return Paleta;
    }

    public void setPaleta(String Paleta) {
        this.Paleta = Paleta;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String Nombre_Cliente) {
        this.Nombre_Cliente = Nombre_Cliente;
    }

    public int getLote_Venta() {
        return Lote_Venta;
    }

    public void setLote_Venta(int Lote_Venta) {
        this.Lote_Venta = Lote_Venta;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }
    
    private String Paleta;
    private String Nombre_Cliente;
    private int Lote_Venta;
    private int Total;

}
