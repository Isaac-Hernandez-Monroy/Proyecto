/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gomitas;

/**
 *
 * @author Isaac
 */

import java.util.List;
import modelo.PaletasInc;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Dao1 extends Conectar{
    public List<PaletasInc> mostrarLaptops(){
        List listapaletas = new ArrayList();
        try {
            ResultSet res;
            this.conectar1();
            
            String sql = "SELECT * FROM Empleado WHERE Fabrica LIKE 'Paletas_agua' OR Fabrica LIKE 'Paletas_leche'";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res = pre.executeQuery();
            while(res.next()){
                PaletasInc lap = new PaletasInc();
                lap.setID_Empleado(res.getInt("ID_Empleado"));
                lap.setNombre(res.getString("Nombre"));
                lap.setApellidoP(res.getString("ApellidoP"));
                lap.setFabrica(res.getString("Fabrica"));
                listapaletas.add(lap);
            }
        } catch (Exception ex) {
            Logger.getLogger(Dao1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listapaletas;
    }
}
