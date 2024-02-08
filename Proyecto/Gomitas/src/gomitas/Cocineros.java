/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gomitas;

import javax.swing.table.DefaultTableModel;
import modelo.PaletasInc;
import gomitas.Dao1;

/**
 *
 * @author lalqu
 */
public class Cocineros extends javax.swing.JPanel {

    /**
     * Creates new form Cocineros
     */
    public Cocineros() {
        
        String[] nombresColumnas = {"ID Empleado", "Nombre Empleado", "Apellido Empleado", "Area"};
        //jTable3.setEnabled(false);
        modelo1 = new DefaultTableModel(null, nombresColumnas);
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        jTable1.setModel(modelo1);
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(modelo1);
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(modelo1);
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void mostrarTblCocinerp()
    {
        //ConsultaSimp mltb = new ConsultaSimp();
        
        //DefaultTableModel modelo = mltb.Cocineros();
        //tblCocinero.setModel(modelo);

       Dao1 daoo = new Dao1();
       String [] datos = new String[4];
       
      for (PaletasInc l : daoo.mostrarLaptops()){
           
       datos[0] = String.valueOf(l.getID_Empleado());
       datos[1] = l.getNombre()+"";
       datos[2] = l.getApellidoP()+"";
       datos[3] = l.getFabrica()+"";
       modelo1.addRow(datos);   
    }
        
    }  
        
DefaultTableModel modelo1; 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
