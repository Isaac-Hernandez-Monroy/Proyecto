/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Isaac
 */
public class Venta {

    public int getLote_Venta() {
        return Lote_Venta;
    }

    public void setLote_Venta(int Lote_Venta) {
        this.Lote_Venta = Lote_Venta;
    }

    public int getI_Cliente() {
        return I_Cliente;
    }

    public void setI_Cliente(int I_Cliente) {
        this.I_Cliente = I_Cliente;
    }

    public int getLot_Stock() {
        return Lot_Stock;
    }

    public void setLot_Stock(int Lot_Stock) {
        this.Lot_Stock = Lot_Stock;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }
    
    private int Lote_Venta;
    private int I_Cliente;
    private int Lot_Stock;
    private int Total;
    
}
