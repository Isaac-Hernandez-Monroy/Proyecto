/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Isaac
 */
public class Receta {

    public int getI_Empleado() {
        return I_Empleado;
    }

    public void setI_Empleado(int I_Empleado) {
        this.I_Empleado = I_Empleado;
    }

    public int getLot_Material() {
        return Lot_Material;
    }

    public void setLot_Material(int Lot_Material) {
        this.Lot_Material = Lot_Material;
    }

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

    public int getCantida() {
        return Cantida;
    }

    public void setCantida(int Cantida) {
        this.Cantida = Cantida;
    }
    
    private int I_Empleado;
    private int Lot_Material;
    private int Lot_Stock;
    private String Paleta;
    private int Cantida;
    
}
