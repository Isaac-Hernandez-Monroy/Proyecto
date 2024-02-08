/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gomitas;


import java.util.List;
import modelo.Clientesmenos;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Dao10 extends Conectar{
    public List<String[]> mostrarLaptops()         
    {
        List<String[]> datos = new ArrayList<>();
        try {
            ResultSet res;
            this.conectar1();
            
            String sql = "SELECT * FROM paletasinc.procantidad";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res = pre.executeQuery();
            
            while(res.next()){
                String[] fila = new String[4];
            fila[0] = res.getString("Nombre_proveedor") ;
            fila[1] = String.valueOf(res.getInt("Cantidad")); 
            datos.add(fila);
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao4.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
}