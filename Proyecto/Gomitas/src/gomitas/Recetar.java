/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gomitas;

import javax.swing.table.DefaultTableModel;
import modelo.Receta;
import modelo.Stock;
import gomitas.Dao5;


/**
 *
 * @author lalqu
 */
public class Recetar extends javax.swing.JPanel {

    /**
     * Creates new form Recetar
     */
    public Recetar() {
      String[] nombresColumnas = {"Lote Stcok", "Paletas"};
        modelo1 = new DefaultTableModel(null, nombresColumnas);
        initComponents(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblReceta = new javax.swing.JTable();

        tblReceta.setModel(modelo1);
        jScrollPane1.setViewportView(tblReceta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void mostrarTblReceta()
    {
          Dao5 dao = new Dao5();
        String[] datos = new String[2];
        
        datos[0] = new String();
        datos[1] = new String();
        for (String[] l : dao.mostrarLaptops()) 
        {
            datos[0] = l[0];
            datos[1] = l[1];
            modelo1.addRow(datos);
        }
    }
DefaultTableModel modelo1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReceta;
    // End of variables declaration//GEN-END:variables
}
