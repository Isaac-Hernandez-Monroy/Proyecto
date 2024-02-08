/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gomitas;


import java.util.List;
import modelo.Stock;
import modelo.Venta;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Dao3 extends Conectar{
    public List<String[]> mostrarLaptops()         
    {
        List<String[]> datos = new ArrayList<>();
        try {
            ResultSet res;
            this.conectar1();
            
            String sql = "SELECT b.Lote_Venta, b.I_Cliente, s.Lote, s.Cantidad, b.Total" +
                           " FROM Venta b" +
                            " JOIN Stock s ON s.Lote = b.Lot_Stock" +
                                " HAVING s.Cantidad = 0 ";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res = pre.executeQuery();
            
            while(res.next()){
                String[] fila = new String[4];
            fila[0] = String.valueOf(res.getInt("b.Lote_Venta"));
            fila[1] = res.getString("b.I_Cliente");
            fila[2] = res.getString("s.Lote");
            fila[3] = res.getString("b.Total");
            datos.add(fila);
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao3.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
}
