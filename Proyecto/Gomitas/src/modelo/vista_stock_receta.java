/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Isaac
 */
public class vista_stock_receta {

    public int getLot_Stock() {
        return Lot_Stock;
    }

    public void setLot_Stock(int Lot_Stock) {
        this.Lot_Stock = Lot_Stock;
    }

    public String getPaleta() {
        return Paleta;
    }

    public void setPaleta(String Paleta) {
        this.Paleta = Paleta;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

            private int Lot_Stock;
            private String Paleta;
            private int Cantidad;
}
