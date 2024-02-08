/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gomitas;

import java.sql.PreparedStatement;
import java.sql.DriverManager;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

/**
 *
 * @author lalqu
 */
public class Multitabla {
    
    public DefaultTableModel Cocinero_Produccion()
    {
        Conectar c = new Conectar();
        String [] nombresColumnas = {"Empleado","Producido","Lote stock"};
        String [] registros = new String[3];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String SQL = "SELECT Empleado.Nombre, Receta.Paleta, Stock.Lote " +
        "FROM Empleado " +
        "JOIN Receta ON Empleado.ID_Empleado = Receta.I_Empleado " +
        "JOIN Stock ON Receta.Lot_Stock = Stock.Lote";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                registros[0] = rs.getString("Nombre");
                registros[1] = rs.getString("Paleta");
                registros[2] = rs.getString("Lote");
                
                modelo.addRow(registros);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        finally
        {
            try
            {
                
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(c.con != null) c.con.close();
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        
        return modelo;
        
    }

    public DefaultTableModel Cliente_Compra()
    {
        Conectar c = new Conectar();
        String [] nombresColumnas = {"Cliente","Paleta comprada","Factura","Total de compra"};
        String [] registros = new String[4];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String SQL = "Select Nombre_Cliente,Paleta,Lote_Venta,Total  from Cliente,Stock,Venta where I_Cliente=ID_Cliente and Lot_Stock=Lote";
        
        

        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                registros[0] = rs.getString("Nombre_Cliente");
                registros[1] = rs.getString("Paleta");
                registros[2] = rs.getString("Lote_Venta");
                registros[3] = rs.getString("Total");
                
                modelo.addRow(registros);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        finally
        {
            try
            {
                
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(c.con != null) c.con.close();
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        
        return modelo;
        
    }
    
    public DefaultTableModel Proveedor_Material()
    {
        Conectar c = new Conectar();
        String [] nombresColumnas = {"Proveedor","Ingrediente","Cantida"};
        String [] registros = new String[4];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String SQL = "Select Nombre_Proveedor,Ingrediente,Cantidad  from Proveedores,Materia_Prima,Compra where I_Proveedor=ID_Proveedor and Lot_Compra=Lote_Compra";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                registros[0] = rs.getString("Nombre_Proveedor");
                registros[1] = rs.getString("Ingrediente");
                registros[2] = rs.getString("Cantidad");
                modelo.addRow(registros);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        finally
        {
            try
            {
                
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(c.con != null) c.con.close();
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        
        return modelo;
        
    }
}
