/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gomitas;


import java.util.List;
import modelo.Cliente;
import modelo.Venta;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Dao7 extends Conectar{
    public List<String[]> mostrarLaptops()         
    {
        List<String[]> datos = new ArrayList<>();
        try {
            ResultSet res;
            this.conectar1();
            
            String sql = "SELECT c.ID_Cliente, c.Nombre_Cliente, c.Apellido_Cliente, SUM(v.Total) AS Suma_Total " +
                            "FROM Cliente c " +
                            "JOIN Venta v ON c.ID_Cliente = v.I_Cliente " +
                            "GROUP BY c.ID_Cliente, c.Nombre_Cliente, c.Apellido_Cliente ORDER BY Suma_Total DESC";
            
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res = pre.executeQuery();
            
            while(res.next()){
                String[] fila = new String[4];
            fila[0] = String.valueOf(res.getInt("c.ID_Cliente"));
            fila[1] = res.getString("C.Nombre_Cliente");  
            fila[2] = res.getString("C.Apellido_Cliente");  
            fila[3] = String.valueOf(res.getInt("Suma_Total"));  

            datos.add(fila);
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao4.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
}

