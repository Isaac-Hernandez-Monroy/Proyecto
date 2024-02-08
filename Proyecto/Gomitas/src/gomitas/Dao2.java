/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gomitas;


import java.util.List;
import modelo.PaletasInc;
import modelo.Materiaprima;
import modelo.Compra;
import modelo.Proveedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Dao2 extends Conectar{
    public List<String[]> mostrarLaptops()         
    {
        List<String[]> datos = new ArrayList<>();
        try {
            ResultSet res;
            this.conectar1();
            
            String sql = "SELECT * " +
        "FROM Materia_Prima MP " +
        "JOIN Compra C ON MP.Lote_Compra = C.Lot_Compra " +
        "JOIN Proveedores P ON C.I_Proveedor = P.ID_Proveedor " +
        "WHERE P.ID_Proveedor BETWEEN 0 AND 2000000 " +
        "ORDER BY P.Nombre_Proveedor ASC";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res = pre.executeQuery();
            
            while(res.next()){
                String[] fila = new String[3];
            fila[0] = String.valueOf(res.getInt("P.ID_Proveedor"));
            fila[1] = res.getString("P.Nombre_Proveedor");
            fila[2] = res.getString("MP.Ingrediente");
            datos.add(fila);
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
}

        
   
 



