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

/**
 *
 * @author lalqu
 */
public class Cocinero extends javax.swing.JPanel {

    public void cocina()
    {
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            PreparedStatement Y = c.con.prepareStatement("{call  REmpleado (?,?,?,?)}");
                Y.setInt(1, Integer.parseInt(txtRID.getText()));
                Y.setString(2, txtNombre.getText());
                Y.setString(3, txtApellido.getText());
                Y.setString(4, cbTipo.getSelectedItem().toString());
            Y.execute();
            LbEstado.setText("Registro exitoso");
        }catch(Exception e){
            LbEstado.setText("Ocurrio un error...");
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
            String SQL =  "Select Nombre from Empleado where ID_Empleado=" + S;
            Statement stmt;
            ResultSet rs = null;
            stmt = c.con.createStatement();
            rs = stmt.executeQuery(SQL);
            
            String SQ =  "Select ApellidoP from Empleado where ID_Empleado=" + S;
            Statement stm;
            ResultSet r = null;
            stm = c.con.createStatement();
            r = stm.executeQuery(SQ);
            
            int o;
            String N="",A="";
            
            while(rs.next())
            {
                N =rs.getString("Nombre");
            }
            while(r.next())
            {
                A =r.getString("ApellidoP");
            }
            o = JOptionPane.showConfirmDialog(null,"ID: "+ S +"\nNombre: "+N+"\nApellido: "+A, "Confirme la edicion", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(o == 0)
            {
                N = JOptionPane.showInputDialog(null,"Nombre actual:     "+N+"\nIngrese el nombre del empleado","Nombre del empleado",JOptionPane.INFORMATION_MESSAGE);
                A = JOptionPane.showInputDialog(null,"Apellido actual:     "+A+"\nIngrese el Apellido del empleado","Apellido del empleado",JOptionPane.INFORMATION_MESSAGE);
                
                PreparedStatement Y = c.con.prepareStatement("{call  MEmpleado (?,?,?)}");
                Y.setInt(1, S);
                Y.setString(2, N);
                Y.setString(3, A);
                Y.execute();
                JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    
    public Cocinero() {
        
        modeloDeEnum = new DefaultComboBoxModel(Tipo.values());
        
        initComponents();
        
        LbBorrar.setVisible(false);
        cbEditar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LbRID = new javax.swing.JLabel();
        LbNombre = new javax.swing.JLabel();
        LbApellido = new javax.swing.JLabel();
        LbFabrica = new javax.swing.JLabel();
        txtRID = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        cbTipo = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        LbEstado = new javax.swing.JLabel();
        LbMuestra = new javax.swing.JLabel();
        LbBorrar = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        cbEditar = new javax.swing.JComboBox<>();
        btnRegistrar1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 250, 240));

        LbRID.setText("ID del empleado");

        LbNombre.setText("Nombre");

        LbApellido.setText("Apellido");

        LbFabrica.setText("Posicion");

        txtRID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRIDActionPerformed(evt);
            }
        });

        cbTipo.setModel(modeloDeEnum);
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        LbEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LbMuestra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cocina.jpg"))); // NOI18N

        LbBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/goma.jpg"))); // NOI18N
        LbBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LbBorrarblanco(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarmostrarCb(evt);
            }
        });

        cbEditar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEditarActionPerformed(evt);
            }
        });

        btnRegistrar1.setText("Eliminar");
        btnRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LbApellido)
                            .addComponent(LbNombre)
                            .addComponent(LbFabrica))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombre)
                                .addComponent(txtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                            .addComponent(cbTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LbRID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(txtRID, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(LbMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(LbEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(LbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addGap(35, 35, 35)
                .addComponent(btnRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrar1)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbFabrica)
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbApellido)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbRID)
                            .addComponent(txtRID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(LbMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(cbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditar)
                            .addComponent(btnRegistrar)
                            .addComponent(btnRegistrar1)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        if(null != cbTipo.getSelectedItem().toString())
        switch (cbTipo.getSelectedItem().toString()) {
            case "Seleccionar" -> {
                Icon ic = img("cocina.jpg");
                LbMuestra.setIcon(ic);
                }
            case "Paletas_leche" -> {
                Icon ic = img("gummy pop.jpg");
                txtRID.setText("40");
                LbMuestra.setIcon(ic);
                }
            case "Paletas_agua" -> {
                Icon ic = img("gummers.jpg");
                txtRID.setText("41");
                LbMuestra.setIcon(ic);
                }
            case "Vendedor" -> {
                Icon ic = img("panditas.jpg");
                txtRID.setText("50");
                LbMuestra.setIcon(ic);
                }
            case "Gerente" -> {
                Icon ic = img("frutas del bosque.png");
                txtRID.setText("99");
                LbMuestra.setIcon(ic);
                }
            case "Almacen" -> {
                Icon ic = img("malvabon.png");
                txtRID.setText("30");
                LbMuestra.setIcon(ic);
                }
            default -> {
            }
        }
    }//GEN-LAST:event_cbTipoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        cocina();
        LbBorrar.setVisible(true);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void LbBorrarblanco(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbBorrarblanco
        // TODO add your handling code here:
        txtNombre.setText("");
        txtApellido.setText("");
        txtRID.setText("");
        LbBorrar.setVisible(false);
        LbEstado.setText("");
        cbTipo.setSelectedIndex(0);
    }//GEN-LAST:event_LbBorrarblanco

    private void btnEditarmostrarCb(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarmostrarCb
        // TODO add your handling code here:
        cbEditar.setVisible(true);
        mostrarCb();
        JOptionPane.showMessageDialog(null,"Solo puede editar el nombre y apellido del Empleado","Advertencia",JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnEditarmostrarCb

    private void cbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEditarActionPerformed
        // TODO add your handling code here:
        muestra(Integer.parseInt(cbEditar.getSelectedItem().toString()));
    }//GEN-LAST:event_cbEditarActionPerformed

    private void btnRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar1ActionPerformed
        try
        {
            c.con = DriverManager.getConnection(c.cadena, c.usuario, c.contrasenia);
            PreparedStatement Y = c.con.prepareStatement("{call  BEmpleadp (?)}");
                Y.setInt(1, Integer.parseInt(txtRID.getText()));
            Y.execute();
            LbEstado.setText("Borrado exitoso");
        }catch(Exception e){
            LbEstado.setText("Ocurrio un error...");
            System.out.println(e);
        }
    }//GEN-LAST:event_btnRegistrar1ActionPerformed

    private void txtRIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRIDActionPerformed

    public void mostrarCb()
    {
        Combos mcb = new Combos();
        
        DefaultComboBoxModel cModel = mcb.ECocinero();
        cbEditar.setModel(cModel);
    }
    
    Conectar c = new Conectar();
    ComboBoxModel modeloDeEnum;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbApellido;
    private javax.swing.JLabel LbBorrar;
    private javax.swing.JLabel LbEstado;
    private javax.swing.JLabel LbFabrica;
    private javax.swing.JLabel LbMuestra;
    private javax.swing.JLabel LbNombre;
    private javax.swing.JLabel LbRID;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrar1;
    public javax.swing.JComboBox<String> cbEditar;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRID;
    // End of variables declaration//GEN-END:variables
}