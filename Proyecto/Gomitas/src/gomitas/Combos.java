/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gomitas;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;

public class Combos {
    
    public DefaultComboBoxModel EProveedor()
    {
        Conectar c = new Conectar();
        
        DefaultComboBoxModel cModel = new DefaultComboBoxModel();
        
        String SQL = "Select ID_Proveedor from Proveedores";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                cModel.addElement(rs.getString("ID_Proveedor"));
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
        
        return cModel;
    }
     
    public DefaultComboBoxModel ECompra()
    {
        Conectar c = new Conectar();
        
        DefaultComboBoxModel cModel = new DefaultComboBoxModel();
        
        String SQL = "Select Lote_Compra from Materia_Prima";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                cModel.addElement(rs.getString("Lote_Compra"));
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
        
        return cModel;
    }
    
    public DefaultComboBoxModel VenMateria()
    {
        Conectar c = new Conectar();
        
        DefaultComboBoxModel cModel = new DefaultComboBoxModel();
        
        String SQL = "Select ID_Proveedor from Proveedores";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                cModel.addElement(rs.getString("ID_Proveedor"));
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
        
        return cModel;
    }
    
    public DefaultComboBoxModel ECocinero()
    {
        Conectar c = new Conectar();
        
        DefaultComboBoxModel cModel = new DefaultComboBoxModel();
        
        String SQL = "Select ID_Empleado from Empleado";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                cModel.addElement(rs.getString("ID_Empleado"));
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
        
        return cModel;
    }
    
    public DefaultComboBoxModel EProducto()
    {
        Conectar c = new Conectar();
        
        DefaultComboBoxModel cModel = new DefaultComboBoxModel();
        
        String SQL = "Select Lot_Stock from Receta";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                cModel.addElement(rs.getString("Lot_Stock"));
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
        
        return cModel;
    }
    
    public DefaultComboBoxModel IDCoProducto()
    {
        Conectar c = new Conectar();
        
        DefaultComboBoxModel cModel = new DefaultComboBoxModel();
        
        String SQL = "Select ID_Empleado from Empleado";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                cModel.addElement(rs.getString("ID_Empleado"));
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
        
        return cModel;
    }
    
    public DefaultComboBoxModel LtBoProducto()
    {
        Conectar c = new Conectar();
        
        DefaultComboBoxModel cModel = new DefaultComboBoxModel();
        
        String SQL = "Select Lote from Bodega";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                cModel.addElement(rs.getString("Lote"));
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
        
        return cModel;
    }
    
    public DefaultComboBoxModel IDCliVenta()
    {
        Conectar c = new Conectar();
        
        DefaultComboBoxModel cModel = new DefaultComboBoxModel();
        
        String SQL = "Select ID_Cliente from Cliente";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                cModel.addElement(rs.getString("ID_Cliente"));
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
        
        return cModel;
    }
    
    public DefaultComboBoxModel LtStVenta()
    {
        Conectar c = new Conectar();
        
        DefaultComboBoxModel cModel = new DefaultComboBoxModel();
        
        String SQL = "Select Lote from Stock where Cantidad > 0";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                cModel.addElement(rs.getString("Lote"));
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
        
        return cModel;
    }
    
    public DefaultComboBoxModel Stock()
    {
        Conectar c = new Conectar();
        
        DefaultComboBoxModel cModel = new DefaultComboBoxModel();
        
        String SQL = "Select Lote from Stock";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                cModel.addElement(rs.getString("Lote"));
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
        
        return cModel;
    }
    
    public DefaultComboBoxModel Apellido()
    {
        Conectar c = new Conectar();
        
        DefaultComboBoxModel cModel = new DefaultComboBoxModel();
        
        String SQL = "Select ApellidoP from Empleado";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                cModel.addElement(rs.getString("ApellidoP"));
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
        
        return cModel;
    }
    
}
