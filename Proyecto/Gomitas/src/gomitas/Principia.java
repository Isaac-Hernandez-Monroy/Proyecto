/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gomitas;

import java.awt.Image;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.PaletasInc;

/**
 *
 * @author lalqu
 */
public class Principia extends javax.swing.JFrame {
    
    public Icon img(String Ch)
    {
        ImageIcon image = new ImageIcon("src/Imagenes/"+Ch);
            Icon icon = new ImageIcon(image.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
            return icon;
    }
    
    public void conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Nos conectamos a la BD
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (c.con!=null){
                LbEstado.setText("Se ha logrado la conexion");
                MenuPrincipal.setVisible(true);
            }
        }
        // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (Exception e){
            LbEstado.setText("Ocurrio un error...");
            System.out.println(e);
        }
    }
    
    public Principia() {
        initComponents();
        MenuPrincipal.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlBienvenida = new javax.swing.JPanel();
        LbLogo = new javax.swing.JLabel();
        btnConectar = new javax.swing.JButton();
        LbEstado = new javax.swing.JLabel();
        MenuPrincipal = new javax.swing.JMenuBar();
        MAgregar = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PnlBienvenida.setBackground(new java.awt.Color(153, 0, 153));
        PnlBienvenida.setPreferredSize(new java.awt.Dimension(800, 700));

        LbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logomamalon2.0.jpg"))); // NOI18N

        btnConectar.setText("Conectar");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        LbEstado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LbEstado.setForeground(new java.awt.Color(255, 255, 255));
        LbEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout PnlBienvenidaLayout = new javax.swing.GroupLayout(PnlBienvenida);
        PnlBienvenida.setLayout(PnlBienvenidaLayout);
        PnlBienvenidaLayout.setHorizontalGroup(
            PnlBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlBienvenidaLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(LbLogo))
            .addComponent(LbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(PnlBienvenidaLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(btnConectar))
        );
        PnlBienvenidaLayout.setVerticalGroup(
            PnlBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlBienvenidaLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(LbLogo)
                .addGap(27, 27, 27)
                .addComponent(LbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnConectar))
        );

        MenuPrincipal.setBorder(new javax.swing.border.MatteBorder(null));

        MAgregar.setText("Accion");

        jMenuItem1.setText("Proveedor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioProveedor(evt);
            }
        });
        MAgregar.add(jMenuItem1);

        jMenuItem2.setText("Compra");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarCompra(evt);
            }
        });
        MAgregar.add(jMenuItem2);

        jMenuItem4.setText("Empleado");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarCocinero(evt);
            }
        });
        MAgregar.add(jMenuItem4);

        jMenuItem6.setText("Producir");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioReceta_Stock(evt);
            }
        });
        MAgregar.add(jMenuItem6);

        jMenuItem5.setText("Cliente");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarCliente(evt);
            }
        });
        MAgregar.add(jMenuItem5);

        jMenuItem7.setText("Venta");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioVenta(evt);
            }
        });
        MAgregar.add(jMenuItem7);

        jMenuItem21.setText("Division");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        MAgregar.add(jMenuItem21);

        MenuPrincipal.add(MAgregar);

        jMenu1.setText("Inventario");

        jMenuItem3.setText("Materia prima");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarBodega(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem8.setText("Stock");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarStock(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        MenuPrincipal.add(jMenu1);

        jMenu3.setText("Informacion");

        jMenuItem11.setText("Compra a proveedores");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem13.setText("Registro compra insumos");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem13);

        jMenuItem12.setText("Total clientes compras");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuItem14.setText("Materia prima");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem14);

        jMenuItem15.setText("Empleados fabrican");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem15);

        jMenuItem16.setText("Stock");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem16);

        jMenuItem18.setText("Lotes vendidos");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem18);

        jMenuItem17.setText("Cliente");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem17);

        jMenuItem10.setText("Venta");
        jMenuItem10.setToolTipText("");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        MenuPrincipal.add(jMenu3);

        jMenu2.setText("Registros");

        jMenuItem20.setText("Compra a proveedores");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem20);

        jMenuItem9.setText("Produccion de cocineros");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioCocinero_Produccion(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem19.setText("Compras de clientes");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem19);

        jMenuItem22.setText("Compras menores");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem22);

        jMenuItem23.setText("Compras mayores");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem23);

        jMenuItem24.setText("Proveedor/Insumos");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem24);

        jMenuItem25.setText("Compra insumos");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem25);

        MenuPrincipal.add(jMenu2);

        setJMenuBar(MenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlBienvenida, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlBienvenida, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        conectar();
        // 
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            PreparedStatement S = c.con.prepareStatement("{call RBodega (?,?,?,?)}");
                    S.setInt(1, 30);
                    S.setString(2, "Agua");
                    S.setNull(3, java.sql.Types.INTEGER);
                    S.setInt(4, 0);
                S.execute();
        }catch(Exception e){
        }
        // 
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            PreparedStatement S = c.con.prepareStatement("{call RBodega (?,?,?,?)}");
                    S.setInt(1, 31);
                    S.setString(2, "Leche");
                    S.setNull(3, java.sql.Types.INTEGER);
                    S.setInt(4, 0);
                S.execute();
        }catch(Exception e){
        }
        //  
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            PreparedStatement S = c.con.prepareStatement("{call RBodega (?,?,?,?)}");
                    S.setInt(1, 32);
                    S.setString(2, "Azucar");
                    S.setNull(3, java.sql.Types.INTEGER);
                    S.setInt(4, 0);
                S.execute();
        }catch(Exception e){
        }
        //  
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            PreparedStatement S = c.con.prepareStatement("{call RBodega (?,?,?,?)}");
                    S.setInt(1, 33);
                    S.setString(2, "Palitos_madera");
                    S.setNull(3, java.sql.Types.INTEGER);
                    S.setInt(4, 0);
                S.execute();
        }catch(Exception e){
        }
        //  
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            PreparedStatement S = c.con.prepareStatement("{call RBodega (?,?,?,?)}");
                    S.setInt(1, 34);
                    S.setString(2, "Saborizantes_agua");
                    S.setNull(3, java.sql.Types.INTEGER);
                    S.setInt(4, 0);
                S.execute();
        }catch(Exception e){
        }
        //  Jarabe_De_Maiz
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            PreparedStatement S = c.con.prepareStatement("{call RBodega (?,?,?,?)}");
                    S.setInt(1, 35);
                    S.setString(2, "Saborizantes_leche");
                    S.setNull(3, java.sql.Types.INTEGER);
                    S.setInt(4, 0);
                S.execute();
        }catch(Exception e){
        }
    }//GEN-LAST:event_btnConectarActionPerformed

    private void cambioProveedor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambioProveedor
        // TODO add your handling code here:\
        pnlP = new Proveedor();
        pnlP.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(pnlP);
        PnlBienvenida.updateUI();
    }//GEN-LAST:event_cambioProveedor

    private void cambiarCompra(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarCompra
        // TODO add your handling code here:
        pnlMP = new MateriaPrima();
        pnlMP.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(pnlMP);
        PnlBienvenida.updateUI();
    }//GEN-LAST:event_cambiarCompra

    private void cambiarBodega(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarBodega
        // TODO add your handling code here:
        pnlB.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(pnlB);
        PnlBienvenida.updateUI();
        pnlB.llenarBodega("Agua");
        pnlB.llenarBodega("Leche");
        pnlB.llenarBodega("Azucar");
        pnlB.llenarBodega("Palitos_madera");
        pnlB.llenarBodega("Saborizante_agua");
        pnlB.llenarBodega("Saborizante_leche");
    }//GEN-LAST:event_cambiarBodega

    private void cambiarCocinero(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarCocinero
        // TODO add your handling code here:
        pnlC.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(pnlC);
        PnlBienvenida.updateUI();
    }//GEN-LAST:event_cambiarCocinero

    private void cambiarCliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarCliente
        // TODO add your handling code here:
        pnlCli.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(pnlCli);
        PnlBienvenida.updateUI();
        if(pnlCli.cbEditar.getItemCount() == 1)
        {
            pnlCli.Editar();
        }
    }//GEN-LAST:event_cambiarCliente

    private void cambioReceta_Stock(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambioReceta_Stock
        // TODO add your handling code here:
        int Y;
        String S;
        
        Y = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese su ID:",JOptionPane.INFORMATION_MESSAGE));
        S = ConsultaSimp.Cocina(Y);
        if(null == S)
        {
            JOptionPane.showMessageDialog(null, "ID no registrado");
        }
        else switch (S) {
            case "Paletas_leche" -> {
                pnlRS.setBounds(PnlBienvenida.getBounds());
                PnlBienvenida.removeAll();
                PnlBienvenida.add(pnlRS);
                PnlBienvenida.updateUI();
                pnlRS.txtGomita.setText("Paletas_leche");
                pnlRS.txtLote.setText("50");
                pnlRS.txtIDC.setText(String.valueOf(Y));
                Icon ic = img("gummy pop.jpg");
                pnlRS.LbMuestra.setIcon(ic);
            }
            case "Paletas_agua" -> {
                pnlRS.setBounds(PnlBienvenida.getBounds());
                PnlBienvenida.removeAll();
                PnlBienvenida.add(pnlRS);
                PnlBienvenida.updateUI();
                pnlRS.txtGomita.setText("Paletas_agua");
                pnlRS.txtLote.setText("51");
                pnlRS.txtIDC.setText(String.valueOf(Y));
                Icon ic = img("gummers.jpg");
                pnlRS.LbMuestra.setIcon(ic);
            }

            default -> JOptionPane.showMessageDialog(null, "ID no registrado");
        }
        
    }//GEN-LAST:event_cambioReceta_Stock

    private void cambioVenta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambioVenta
        // TODO add your handling code here:
        pnlV.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(pnlV);
        PnlBienvenida.updateUI();
        pnlV.mostrarCbIDCliente();
        pnlV.mostrarCbLtStock();
    }//GEN-LAST:event_cambioVenta

    private void cambiarStock(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarStock
        // TODO add your handling code here:
        pnlS.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(pnlS);
        PnlBienvenida.updateUI();
        pnlS.mostrarCb();
    }//GEN-LAST:event_cambiarStock

    private void cambioCocinero_Produccion(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambioCocinero_Produccion
        // TODO add your handling code here:
        mtltabl.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(mtltabl);
        PnlBienvenida.updateUI();
        mtltabl.mostrarTblCo_Pro();
    }//GEN-LAST:event_cambioCocinero_Produccion

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        MCliente.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(MCliente);
        PnlBienvenida.updateUI();
        MCliente.mostrarCliente();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        Proveedr.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(Proveedr);
        PnlBienvenida.updateUI();
        Proveedr.mostrarTblPro();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        MMateria.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(MMateria);
        PnlBienvenida.updateUI();
        MMateria.mostrarTblMate();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        Compras.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(Compras);
        PnlBienvenida.updateUI();
        Compras.mostrarTblComp();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        Bodegar.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(Bodegar);
        PnlBienvenida.updateUI();
        Bodegar.mostrarTblBode();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
       Cocineros.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(Cocineros);
        PnlBienvenida.updateUI();
        Cocineros.mostrarTblCocinerp();
       
       
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
        Stocks.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(Stocks);
        PnlBienvenida.updateUI();
        Stocks.mostrarTblStock();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
        Recetar.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(Recetar);
        PnlBienvenida.updateUI();
        Recetar.mostrarTblReceta();
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        Venta.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(Venta);
        PnlBienvenida.updateUI();
        Venta.mostrarTblVenta();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
        Cliente_Compra.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(Cliente_Compra);
        PnlBienvenida.updateUI();
        Cliente_Compra.mostrarTblCli_Com();
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        // TODO add your handling code here:
        Proveedor_Material.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(Proveedor_Material);
        PnlBienvenida.updateUI();
        Proveedor_Material.mostrarTblPro_Mat();
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        pnlZ = new Division();
        pnlZ.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(pnlZ);
        PnlBienvenida.updateUI();        
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        pnlO = new Clientesmenos();
        pnlO.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(pnlO);
        PnlBienvenida.updateUI();
        pnlO.mostrarCliente();
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        pnlT = new Clientesmas();
        pnlT.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(pnlT);
        PnlBienvenida.updateUI();
        pnlT.mostrarCliente();
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        pnlCO = new Divisionvertical();
        pnlCO.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(pnlCO);
        PnlBienvenida.updateUI();
        pnlCO.mostrar();
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        PnlDiv = new Divprove();
        PnlDiv.setBounds(PnlBienvenida.getBounds());
        PnlBienvenida.removeAll();
        PnlBienvenida.add(PnlDiv);
        PnlBienvenida.updateUI();
        PnlDiv.mostrar();
    }//GEN-LAST:event_jMenuItem25ActionPerformed
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Principia().setVisible(true);
        });
    }
    
    Conectar c = new Conectar();
    Proveedor pnlP;
    Division pnlZ;
    Divprove PnlDiv;
    Clientesmas pnlT;
    Clientesmenos pnlO;
    MateriaPrima pnlMP;
    Divisionvertical pnlCO;
    Bodega pnlB = new Bodega();
    Cocinero pnlC = new Cocinero();
    Cliente pnlCli = new Cliente();
    Receta_Stock pnlRS = new Receta_Stock();
    Vender pnlV = new Vender();
    Stock pnlS = new Stock();
    Cocinero_Produccion mtltabl = new Cocinero_Produccion();
    MCliente MCliente = new MCliente();
    Proveedr Proveedr = new Proveedr();
    MMateria MMateria = new MMateria();
    Compras Compras = new Compras();
    Bodegar Bodegar = new Bodegar();
    Cocineros Cocineros  = new Cocineros();
    Stocks Stocks = new Stocks();
    Recetar Recetar = new Recetar();
    Venta Venta = new Venta();
    Cliente_Compra Cliente_Compra = new Cliente_Compra();
    Proveedor_Material Proveedor_Material = new Proveedor_Material();
    ConsultaSimp ConsultaSimp = new ConsultaSimp();
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbEstado;
    private javax.swing.JLabel LbLogo;
    private javax.swing.JMenu MAgregar;
    private javax.swing.JMenuBar MenuPrincipal;
    private javax.swing.JPanel PnlBienvenida;
    private javax.swing.JButton btnConectar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}