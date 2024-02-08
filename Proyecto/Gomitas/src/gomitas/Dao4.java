/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gomitas;


import java.util.List;
import modelo.Compra;
import modelo.Materiaprima;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Dao4 extends Conectar{
    public List<String[]> mostrarLaptops()         
    {
        List<String[]> datos = new ArrayList<>();
        try {
            ResultSet res;
            this.conectar1();
            
            String sql = "SELECT P.ID_Proveedor, P.Nombre_Proveedor, COUNT(C.Lot_Compra) AS TotalCompras " +
                "FROM Proveedores P " +
                "JOIN Compra C ON P.ID_Proveedor = C.I_Proveedor " +
                "GROUP BY P.ID_Proveedor, P.Nombre_Proveedor " +
                "ORDER BY TotalCompras DESC;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res = pre.executeQuery();
            
            while(res.next()){
                String[] fila = new String[3];
            fila[0] = String.valueOf(res.getInt("P.ID_Proveedor"));
            fila[1] = res.getString("P.Nombre_Proveedor");
            fila[2] = res.getString("TotalCompras");   
            datos.add(fila);
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao4.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
}
