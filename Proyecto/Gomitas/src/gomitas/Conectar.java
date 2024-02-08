/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gomitas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lalqu
 */

public class Conectar {
    
    Connection con;
    String usuario = "root";
    String BD = "PaletasInc";
    String IP = "localhost";
    String puerto = "3306";
    String cadena = "jdbc:mysql://" + IP + ":" + puerto + "/" + BD;
    
    
    String contrasenia = "Isaachm31_22";
    
    public void conectar1() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Paletasinc", "root", "Isaachm31_22");        
    }
    public void desconectar() throws SQLException{
        con.close();
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
   
    
}
