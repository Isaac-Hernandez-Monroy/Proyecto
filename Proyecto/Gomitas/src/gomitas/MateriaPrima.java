/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gomitas;

import java.awt.Image;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author lalqu
 */
public class MateriaPrima extends javax.swing.JPanel {

    /**
     * Creates new form MateriaPrima
     */
    
    public void compra()
    {
        
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            PreparedStatement Y = c.con.prepareStatement("{call Comprar (?,?,?)}");
                Y.setInt(1, Integer.parseInt(txtLote.getText()));
                Y.setString(2, cbMateria.getSelectedItem().toString());
                Y.setInt(3, Integer.parseInt(txtCantidad.getText()));
            Y.execute();
            PreparedStatement F = c.con.prepareStatement("{call  MBodega (?,?)}");
                F.setInt(1, Integer.parseInt(txtCantidad.getText()));
                F.setString(2, cbMateria.getSelectedItem().toString());
                F.execute();
            LbEstado.setText("Registro exitoso");
            ///////////////////////////////////////////////////////////////////////////
            LbProveedor.setVisible(true);
            cbProveedor.setVisible(true);
            btnAsignar.setVisible(true);
            LbNoc.setVisible(true);
            
            LbMateria.setVisible(false);
            txtLote.setEditable(false);
            LbCantidad.setVisible(false);
            cbMateria.setVisible(false);
            btnGuardar.setVisible(false);
            txtCantidad.setVisible(false);
            
            Icon ic = img("compra.jpg");
            LbMuestra.setIcon(ic);
            
        }catch(Exception e){
            LbBorrar1.setVisible(true);
            LbEstado.setText("Ocurrio un error...");
            System.out.println(e);
        }
    }
    
   
    public void completar()
    {
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
                
             PreparedStatement Y = c.con.prepareStatement("{call ACompra (?,?)}");
                    Y.setInt(1, Integer.parseInt(cbProveedor.getSelectedItem().toString()));
                    Y.setInt(2, Integer.parseInt(txtLote.getText()));
                Y.execute();
                LbEstado.setText("Registro exitoso");
        }catch(Exception e){
            LbEstado.setText("Ocurrio un error...");
            System.out.println(e);
        }
    }
    
    public Icon img(String Ch)
    {
        ImageIcon image = new ImageIcon("src/Imagenes/"+Ch);
            Icon icon = new ImageIcon(image.getImage().getScaledInstance(LbMuestra.getWidth(), LbMuestra.getHeight(), Image.SCALE_DEFAULT));
            return icon;
    }
    
    public void muestra(int S)
    {
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            String SQL =  "Select Ingrediente from Materia_Prima where Lote_Compra=" + S;
            Statement stmt;
            ResultSet rs = null;
            stmt = c.con.createStatement();
            rs = stmt.executeQuery(SQL);
            
            String SQ =  "Select Cantidad from Materia_Prima where Lote_Compra=" + S;
            Statement stm;
            ResultSet r = null;
            stm = c.con.createStatement();
            r = stm.executeQuery(SQ);
            
          
            
            int o, C=0,N=0;
            String I="";
           
            while(rs.next())
            {
                I =rs.getString("Ingrediente");
            }
            while(r.next())
            {
                C =Integer.parseInt(r.getString("Cantidad"));
            }
            o = JOptionPane.showConfirmDialog(null, "Lote: "+S +"\nIngediente: "+ I+"\nCantidad: ", "Confirme la edicion", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(o == 0)
            {
                C = Integer.parseInt(JOptionPane.showInputDialog(null,"Cantidad actual:     "+C+"\nIngrese la cantidad","Cantidad adquirida",JOptionPane.INFORMATION_MESSAGE));
          
                
                PreparedStatement Y = c.con.prepareStatement("{call  MCompra (?,?,?)}");
                Y.setInt(1, S);
                Y.setInt(2, C);
                Y.execute();
                JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public MateriaPrima() {
        
        modeloDeEnum = new DefaultComboBoxModel(Materia.values());
        
        initComponents();
        
        LbProveedor.setVisible(false);
        cbProveedor.setVisible(false);
        btnAsignar.setVisible(false);
        LbNoc.setVisible(false);
        LbBorrar1.setVisible(false);
        LbPasa.setVisible(false);
        txtLote.setText("2");
        cbEditar.setVisible(false);
        LbProv.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LbMateria = new javax.swing.JLabel();
        LbCantidad = new javax.swing.JLabel();
        LbFecha = new javax.swing.JLabel();
        LbLote = new javax.swing.JLabel();
        cbMateria = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        txtLote = new javax.swing.JTextField();
        LbMuestra = new javax.swing.JLabel();
        LbEstado = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        LbProveedor = new javax.swing.JLabel();
        cbProveedor = new javax.swing.JComboBox<>();
        btnAsignar = new javax.swing.JButton();
        LbNoc = new javax.swing.JLabel();
        LbBorrar1 = new javax.swing.JLabel();
        LbPasa = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        cbEditar = new javax.swing.JComboBox<>();
        LbProv = new javax.swing.JLabel();
        LbLote1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LbMateria.setText("Ingrediente");
        add(LbMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        LbCantidad.setText("Cantidad");
        add(LbCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));
        add(LbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));
        add(LbLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        cbMateria.setModel(modeloDeEnum);
        cbMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMateriaActionPerformed(evt);
            }
        });
        add(cbMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 131, -1));
        add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 131, -1));

        txtLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoteActionPerformed(evt);
            }
        });
        add(txtLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 131, -1));

        LbMuestra.setBackground(new java.awt.Color(255, 255, 255));
        LbMuestra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/compra.jpg"))); // NOI18N
        add(LbMuestra, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        LbEstado.setBackground(new java.awt.Color(255, 255, 255));
        LbEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(LbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 400, 30));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        LbProveedor.setText("Proveedor");
        LbProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(LbProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        cbProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        cbProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Limpia(evt);
            }
        });
        cbProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProveedorActionPerformed(evt);
            }
        });
        add(cbProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 130, -1));

        btnAsignar.setText("Asignar");
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignarProveedor(evt);
            }
        });
        add(btnAsignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        LbNoc.setText("Relacionar compra con un proveedor");
        add(LbNoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        LbBorrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/goma.jpg"))); // NOI18N
        LbBorrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LbBorrar1blanco(evt);
            }
        });
        add(LbBorrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        LbPasa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pasa.jpg"))); // NOI18N
        LbPasa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LbPasaok(evt);
            }
        });
        add(LbPasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 30, 30));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarmostrarCb(evt);
            }
        });
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        cbEditar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEditarActionPerformed(evt);
            }
        });
        add(cbEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 80, -1));
        add(LbProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        LbLote1.setText("Lote de compra");
        add(LbLote1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cbMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMateriaActionPerformed

        if("Seleccionar".equals(cbMateria.getSelectedItem().toString()))
        {
            Icon ic = img("compra.jpg");
            LbMuestra.setIcon(ic);
        }
        else if("Agua".equals(cbMateria.getSelectedItem().toString()))
        {
            Icon ic = img("awa.jpg");
            txtLote.setText("20");
            LbMuestra.setIcon(ic);
        }
        else if("Leche".equals(cbMateria.getSelectedItem().toString()))
        {
            Icon ic = img("almidon.jpg");
            txtLote.setText("21");
            LbMuestra.setIcon(ic);
        }
        else if("Azucar".equals(cbMateria.getSelectedItem().toString()))
        {
            Icon ic = img("azucar.jpg");
            txtLote.setText("22");
            LbMuestra.setIcon(ic);
        }
        else if("Palitos_madera".equals(cbMateria.getSelectedItem().toString()))
        {
            Icon ic = img("ceradeabeja.jpg");
            txtLote.setText("23");
            LbMuestra.setIcon(ic);
        }
        else if("Paletas_agua".equals(cbMateria.getSelectedItem().toString()))
        {
            Icon ic = img("grenetina.jpg");
            txtLote.setText("24");
            LbMuestra.setIcon(ic);
        }
        else if("Paletas_leche".equals(cbMateria.getSelectedItem().toString()))
        {
            Icon ic = img("jarabe.jpg");
            txtLote.setText("25");
            LbMuestra.setIcon(ic);
        }
    }//GEN-LAST:event_cbMateriaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        JOptionPane.showMessageDialog(null, "Por favor revise la informacion introducida\nDe ser erronea, coloque el cursor sobre la goma para editar\nCaso contrario, use la palomita :D");
        LbBorrar1.setVisible(true);
        LbPasa.setVisible(true);
        cbMateria.setEnabled(false);
        txtLote.setEditable(false);
        txtCantidad.setEditable(false);
        btnGuardar.setVisible(false);
        btnEditar.setVisible(false);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void Limpia(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Limpia
        // TODO add your handling code here:
        LbEstado.setText("");
    }//GEN-LAST:event_Limpia

    private void asignarProveedor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignarProveedor
        // TODO add your handling code here:
        completar();
        LbBorrar1.setVisible(true);
    }//GEN-LAST:event_asignarProveedor

    private void LbBorrar1blanco(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbBorrar1blanco
        // TODO add your handling code here:
        LbMateria.setVisible(true);
        cbMateria.setVisible(true);
        cbMateria.setEnabled(true);
        cbMateria.setSelectedIndex(0);
        LbLote.setVisible(true);
        txtLote.setVisible(true);
        txtLote.setText("");
        txtLote.setEditable(true);
        LbCantidad.setVisible(true);
        txtCantidad.setVisible(true);
        txtCantidad.setEditable(true);
        txtCantidad.setText("");
        btnGuardar.setVisible(true);
        btnEditar.setVisible(true);
        LbEstado.setText("");
        
        LbBorrar1.setVisible(false);
        LbPasa.setVisible(false);
        LbNoc.setVisible(false);
        LbProveedor.setVisible(false);
        cbProveedor.setVisible(true);
        btnAsignar.setVisible(true);
        
        LbProv.setVisible(false);
    }//GEN-LAST:event_LbBorrar1blanco

    private void LbPasaok(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbPasaok
        // TODO add your handling code here:
        compra();
        mostrarCbProveedor();
        LbBorrar1.setVisible(false);
        LbPasa.setVisible(false);
        btnAsignar.setEnabled(false);
      
        LbProv.setVisible(true);
    }//GEN-LAST:event_LbPasaok

    private void cbProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProveedorActionPerformed
        // TODO add your handling code here:
        btnAsignar.setEnabled(true);
        String S;
        S = ConsultaSimp.Name(Integer.parseInt(cbProveedor.getSelectedItem().toString()));
       
    }//GEN-LAST:event_cbProveedorActionPerformed

    private void btnEditarmostrarCb(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarmostrarCb
        // TODO add your handling code here:
        cbEditar.setVisible(true);
        mostrarCbEditar();
        JOptionPane.showMessageDialog(null,"Solo puede editar la cantidad y fecha adquiridas","Advertencia",JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnEditarmostrarCb

    private void cbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEditarActionPerformed
        // TODO add your handling code here:
         muestra(Integer.parseInt(cbEditar.getSelectedItem().toString()));
    }//GEN-LAST:event_cbEditarActionPerformed

    private void txtLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoteActionPerformed

    public void mostrarCbEditar()
    {
        Combos mcb = new Combos();
        
        DefaultComboBoxModel cModel = mcb.ECompra();
        cbEditar.setModel(cModel);
    }
    
    public void mostrarCbProveedor()
    {
        Combos mcb = new Combos();
        
        DefaultComboBoxModel cModel = mcb.VenMateria();
        cbProveedor.setModel(cModel);
    }
    
    Conectar c = new Conectar();
    ComboBoxModel modeloDeEnum;
    ConsultaSimp ConsultaSimp = new ConsultaSimp();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbBorrar1;
    private javax.swing.JLabel LbCantidad;
    private javax.swing.JLabel LbEstado;
    private javax.swing.JLabel LbFecha;
    private javax.swing.JLabel LbLote;
    private javax.swing.JLabel LbLote1;
    private javax.swing.JLabel LbMateria;
    private javax.swing.JLabel LbMuestra;
    private javax.swing.JLabel LbNoc;
    private javax.swing.JLabel LbPasa;
    private javax.swing.JLabel LbProv;
    private javax.swing.JLabel LbProveedor;
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    public javax.swing.JComboBox<String> cbEditar;
    private javax.swing.JComboBox<String> cbMateria;
    private javax.swing.JComboBox<String> cbProveedor;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtLote;
    // End of variables declaration//GEN-END:variables
}
