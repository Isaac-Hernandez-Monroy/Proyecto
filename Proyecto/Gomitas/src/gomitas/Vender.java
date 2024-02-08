/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gomitas;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author lalqu
 */
public class Vender extends javax.swing.JPanel {

    public void vendimia()
    {
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            PreparedStatement Y = c.con.prepareStatement("{call  RVenta (?,?,?,?)}");
                Y.setInt(1, Integer.parseInt(txtIDVenta.getText()));
                Y.setInt(2, Integer.parseInt(cbIDCliente.getSelectedItem().toString()));
                Y.setInt(3, Integer.parseInt(cbLStock.getSelectedItem().toString()));
                
                Y.setInt(4, Integer.parseInt(txtTotal.getText()));
            Y.execute();
            LbEstado.setText("Registro exitoso");
        }catch(Exception e){
            LbEstado.setText("Ocurrio un error...");
            System.out.println(e);
        }
    }
    
    public void vista()
    {
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            String sql = "drop view vista_stock_receta";
            LbEstado.setText("Registro exitoso");
        }catch(Exception e){
            LbEstado.setText("Ocurrio un error...");
            System.out.println(e);
        }
    }
    
    public void vista2()
    {
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            String sql = "CREATE VIEW vista_stock_receta AS " +
            "SELECT  R.Lot_Stock, R.Paleta, S.Cantidad " +
            "FROM Receta R " +
            "JOIN Stock S ON R.Lot_Stock = S.Lote";
            LbEstado.setText("Registro exitoso");
        }catch(Exception e){
            LbEstado.setText("Ocurrio un error...");
            System.out.println(e);
        }
    }
    
    public void rCantidad(int S)
    {
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            String SQL = "Select Cantidad from Stock where Lote = '" + S + "'";
            Statement stmt;
            ResultSet rs = null;
            stmt = c.con.createStatement();
            rs = stmt.executeQuery(SQL);
            
            String SQ = "Select Paleta from Stock where Lote = '" + S + "'";
            Statement stm;
            ResultSet r = null;
            stm = c.con.createStatement();
            r = stm.executeQuery(SQ);
            
            String f ="";
            int c = 0,t=0;
            
            while(rs.next())
            {
                c=Integer.parseInt(rs.getString("Cantidad"));
                
            }
            while(r.next())
            {
                f=r.getString("Paleta");
            }
            txtStock.setText(String.valueOf(c));
            txtGoma.setText(f);
            
            if("Paletas_agua".equals(f))
            {
                t = c*500;
                txtTotal.setText(String.valueOf(t));
            }
            else if("Paletas_leche".equals(f))
            {
                t = c*1000;
                txtTotal.setText(String.valueOf(t));
            }
           
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void nCliente(int S)
    {
        try
        {
            String SQL =  "Select Nombre_Cliente from Cliente where ID_Cliente = " + S;
            Statement stmt;
            ResultSet rs = null;
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            stmt = c.con.createStatement();
            rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                txtNCliente.setText(rs.getString("Nombre_Cliente"));
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    /**
     * Creates new form Vender
     */
    public Vender() {
        initComponents();
        txtIDVenta.setText("70");
        LbBorrar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LbLVenta = new javax.swing.JLabel();
        LBIDCliente = new javax.swing.JLabel();
        LbStock = new javax.swing.JLabel();
        txtIDVenta = new javax.swing.JTextField();
        cbIDCliente = new javax.swing.JComboBox<>();
        cbLStock = new javax.swing.JComboBox<>();
        btnVenta = new javax.swing.JButton();
        LbEstado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        LbBorrar = new javax.swing.JLabel();
        txtNCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtGoma = new javax.swing.JTextField();
        txtIDVenta1 = new javax.swing.JTextField();
        LbStock1 = new javax.swing.JLabel();
        btnVenta1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(202, 213, 242));

        LbLVenta.setText("Lote de venta");

        LBIDCliente.setText("ID del cliente");

        LbStock.setText("Lote del stock");

        cbIDCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIDClienteActionPerformed(evt);
            }
        });

        cbLStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLStockActionPerformed(evt);
            }
        });

        btnVenta.setText("Vender");
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vender(evt);
            }
        });

        LbEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("Cantidad del stock");

        txtStock.setEditable(false);

        LbBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/goma.jpg"))); // NOI18N
        LbBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LbBorrarblanco(evt);
            }
        });

        txtNCliente.setEditable(false);

        jLabel2.setText("Total a pagar");

        txtTotal.setEditable(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        txtGoma.setEditable(false);

        txtIDVenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDVenta1ActionPerformed(evt);
            }
        });

        LbStock1.setText("Transcriba lote del stock");

        btnVenta1.setText("Eliminar");
        btnVenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenta1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LBIDCliente)
                                .addGap(77, 77, 77)
                                .addComponent(cbIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LbLVenta)
                                .addGap(73, 73, 73)
                                .addComponent(txtIDVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LbStock)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTotal)
                                .addComponent(cbLStock, 0, 100, Short.MAX_VALUE)
                                .addComponent(txtStock))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LbStock1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LbEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtGoma)
                            .addComponent(txtNCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                        .addGap(28, 28, 28))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(217, 217, 217)
                        .addComponent(btnVenta))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtIDVenta1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnVenta1)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbLVenta)
                    .addComponent(txtIDVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBIDCliente)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LbStock)
                            .addComponent(cbLStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtGoma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbStock1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIDVenta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVenta1))
                .addGap(78, 78, 78))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void vender(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vender
        // TODO add your handling code here:
        Icon icono = new ImageIcon(getClass().getResource("loli-vendiendo-gomitas.png"));
        vendimia();
        vista();
        vista2();
        LbBorrar.setVisible(true);
        mostrarCbLtStock();

        JOptionPane.showMessageDialog(null, null,"Vendido !", JOptionPane.INFORMATION_MESSAGE,icono);
    }//GEN-LAST:event_vender

    private void cbLStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLStockActionPerformed
        // TODO add your handling code here:
        int S = Integer.parseInt(cbLStock.getSelectedItem().toString());
        rCantidad(S);
    }//GEN-LAST:event_cbLStockActionPerformed

    private void LbBorrarblanco(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbBorrarblanco
        // TODO add your handling code here:
        txtIDVenta.setText("70");
        txtStock.setText("");
        cbIDCliente.setSelectedItem("Seleccionar");
        LbBorrar.setVisible(false);
        LbEstado.setText("");
        cbLStock.setSelectedIndex(0);
    }//GEN-LAST:event_LbBorrarblanco

    private void cbIDClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIDClienteActionPerformed
        // TODO add your handling code here:
        nCliente(Integer.parseInt(cbIDCliente.getSelectedItem().toString()));
    }//GEN-LAST:event_cbIDClienteActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtIDVenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDVenta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDVenta1ActionPerformed

    private void btnVenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenta1ActionPerformed
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            PreparedStatement Y = c.con.prepareStatement("{call  BCompra (?)}");
                Y.setInt(1, Integer.parseInt(txtIDVenta1.getText()));
            Y.execute();
            LbEstado.setText("Borrado exitoso");
        }catch(Exception e){
            LbEstado.setText("Ocurrio un error...");
            System.out.println(e);
        }
    }//GEN-LAST:event_btnVenta1ActionPerformed

    public void mostrarCbIDCliente()
    {
        Combos mcb = new Combos();
        
        DefaultComboBoxModel cModel = mcb.IDCliVenta();
        cbIDCliente.setModel(cModel);
    }
    
    public void mostrarCbLtStock()
    {
        Combos mcb = new Combos();
        
        DefaultComboBoxModel cModel = mcb.LtStVenta();
        cbLStock.setModel(cModel);
    }
    
    Conectar c = new Conectar();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBIDCliente;
    private javax.swing.JLabel LbBorrar;
    private javax.swing.JLabel LbEstado;
    private javax.swing.JLabel LbLVenta;
    private javax.swing.JLabel LbStock;
    private javax.swing.JLabel LbStock1;
    private javax.swing.JButton btnVenta;
    private javax.swing.JButton btnVenta1;
    public javax.swing.JComboBox<String> cbIDCliente;
    public javax.swing.JComboBox<String> cbLStock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtGoma;
    private javax.swing.JTextField txtIDVenta;
    private javax.swing.JTextField txtIDVenta1;
    private javax.swing.JTextField txtNCliente;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}