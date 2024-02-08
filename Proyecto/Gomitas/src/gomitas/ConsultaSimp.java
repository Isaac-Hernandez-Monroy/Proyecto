/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gomitas;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lalqu
 */
public class ConsultaSimp {
    
    /*public DefaultTableModel Proveedor()
    {
        
        Conectar c = new Conectar();
        String[] nombresColumnas = {"ID Proveedor", "Nombre Proveedor","Ingrediente"};
        String[] registros = new String[3];
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String SQL = "SELECT * " +
        "FROM Materia_Prima MP " +
        "JOIN Compra C ON MP.Lote_Compra = C.Lot_Compra " +
        "JOIN Proveedores P ON C.I_Proveedor = P.ID_Proveedor " +
        "WHERE P.ID_Proveedor BETWEEN ? AND ? " +
        "ORDER BY P.Nombre_Proveedor ASC";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);

            stmt = c.con.prepareStatement(SQL);

            // Especifica los valores para el rango de ID_Proveedor (ejemplo: de 100 a 200)
            int minIDProveedor = 00;
            int maxIDProveedor = 20000000;
            stmt.setInt(1, minIDProveedor);
            stmt.setInt(2, maxIDProveedor);

            rs = stmt.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("P.ID_Proveedor");
                registros[1] = rs.getString("P.Nombre_Proveedor");
                registros[2] = rs.getString("MP.Ingrediente");
                modelo.addRow(registros);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (c.con != null) c.con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return modelo;

        
    }*/
    
    public DefaultTableModel Materia()
    {
        Conectar c = new Conectar();
        String [] nombresColumnas = {"Lote compra","Ingredeinte","Cantidad"};
        String [] registros = new String[3];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String SQL = "Select * from Materia_Prima";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                registros[0] = rs.getString("Lote_Compra");
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
    
    public DefaultTableModel Compra()
    {
        Conectar c = new Conectar();
        String[] nombresColumnas = {"Paleta", "Cantidad Total"};
        String[] registros = new String[2];
        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String SQL = "SELECT Paleta, SUM(Cantidad) AS Cantidad_Total FROM Stock GROUP BY Paleta ORDER BY Cantidad_Total DESC";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);

            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("Paleta");
                registros[1] = rs.getString("Cantidad_Total");

                modelo.addRow(registros);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (c.con != null) c.con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return modelo;

        
    }
    
    public DefaultTableModel Bodega()
    {
        Conectar c = new Conectar();
        String [] nombresColumnas = {"Lote","Ingrediente","Cantidad"};
        String [] registros = new String[3];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String SQL = "Select Lote,Ingrediente,Cantidad from Bodega";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                registros[0] = rs.getString("Lote");
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
    
    /*public DefaultTableModel Cocineros()
    {
        Conectar c = new Conectar();
        String[] nombresColumnas = {"ID Empleado", "Nombre Empleado", "Apellido Empleado", "Area"};
        String[] registros = new String[4];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String SQL = "SELECT * FROM Empleado WHERE Fabrica LIKE 'Paletas_agua' OR Fabrica LIKE 'Paletas_leche'";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);

            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                registros[0] = rs.getString("ID_Empleado");
                registros[1] = rs.getString("Nombre");
                registros[2] = rs.getString("ApellidoP");
                registros[3] = rs.getString("Fabrica");

                modelo.addRow(registros);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (c.con != null) c.con.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return modelo;

    }*/
    
    public DefaultTableModel Stock()
    {
        Conectar c = new Conectar();
        String [] nombresColumnas = {"Lote","Paleta","Cantidad"};
        String [] registros = new String[3];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String SQL = "Select * from Stock HAVING Cantidad > 0";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                registros[0] = rs.getString("Lote");
                registros[1] = rs.getString("Paleta");
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
    
    public DefaultTableModel Receta()
    {
      
        Conectar c = new Conectar();
        String [] nombresColumnas = {"Lote","Paleta","Cantidad"};
        String [] registros = new String[3];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String SQL = "SELECT * FROM Stock";
 
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                registros[0] = rs.getString("Lote");
                registros[1] = rs.getString("Paleta");
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
    
    public DefaultTableModel Cliente()
    {
        Conectar c = new Conectar();
        String [] nombresColumnas = {"ID Cliente","Nombre Cliente","Apellido Cliente"};
        String [] registros = new String[3];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String SQL = "Select * from Cliente";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                registros[0] = rs.getString("ID_Cliente");
                registros[1] = rs.getString("Nombre_Cliente");
                registros[2] = rs.getString("Apellido_Cliente");
                
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
    
   /* public DefaultTableModel Venta()
    {
        Conectar c = new Conectar();
        String [] nombresColumnas = {"Lote venta","ID cliente","Lote stock","Total pagado"};
        String [] registros = new String[4];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String SQL = "SELECT b.Lote_Venta, b.I_Cliente, s.Lote, s.Cantidad, b.Total" +
" FROM Venta b" +
" JOIN Stock s ON s.Lote = b.Lot_Stock" +
" HAVING s.Cantidad = 0 ";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                registros[0] = rs.getString("b.Lote_Venta");
                registros[1] = rs.getString("b.I_Cliente");
                registros[2] = rs.getString("s.Lote");
                registros[3] = rs.getString("b.Total");
                
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
        
    }*/
    
    public String Cocina(int F)
    {
        String S ="";
        
        Conectar c = new Conectar();
        
        String SQL = "Select Fabrica from Empleado where ID_Empleado="+F;
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                S = rs.getString("Fabrica");
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        return S;
    }
    
    public String Name(int F)
    {
        String S ="";
        
        Conectar c = new Conectar();
        
        String SQL = "Select Nombre_Proveedor from Proveedores where ID_Proveedor="+F;
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            
            stmt = c.con.prepareStatement(SQL);
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                S = rs.getString("Nombre_Proveedor");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return S;
    }
}
