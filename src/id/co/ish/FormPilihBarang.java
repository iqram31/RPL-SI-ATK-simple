/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ish;

import id.co.ish.dao.BarangDAO;
import id.co.ish.daoimpl.BarangDAOImpl;
import id.co.ish.entity.Barang;
import id.co.ish.tabelmodel.PilihBarangTM;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Iqram
 */
public class FormPilihBarang extends javax.swing.JDialog {

    /**
     * Creates new form FormPilihBarang
     */
    private Barang barang;
    private ArrayList<Barang> arrayBarang;

    public FormPilihBarang(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getData();
    }
    
    public Barang getBarang() {
        return barang;
    }    
    
    private void getData() {
        BarangDAO dao = new BarangDAOImpl();
        arrayBarang = dao.getBarang();
        
        PilihBarangTM tm = new PilihBarangTM();
        tm.setArrayBarang(arrayBarang);
        tabelPilihBarang.setModel(tm);
    }
    
    private void getData(String cari) {
        BarangDAO dao = new BarangDAOImpl();
        arrayBarang = dao.getBarang(cari);
        
        PilihBarangTM tm = new PilihBarangTM();
        tm.setArrayBarang(arrayBarang);
        tabelPilihBarang.setModel(tm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton13 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPilihBarang = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        fieldCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnPilih = new java.awt.Button();
        btnPilih1 = new java.awt.Button();

        jButton13.setBackground(new java.awt.Color(255, 0, 0));
        jButton13.setText("Refresh");
        jButton13.setBorder(null);
        jButton13.setBorderPainted(false);

        jButton12.setBackground(new java.awt.Color(255, 0, 0));
        jButton12.setText("Pilih");
        jButton12.setBorder(null);
        jButton12.setBorderPainted(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Tambah Transaksi Masuk");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 0, 0));

        label1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Daftar Barang");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tabelPilihBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelPilihBarang);

        jSeparator1.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 0, 0));

        fieldCari.setBackground(new java.awt.Color(255, 255, 255));
        fieldCari.setForeground(new java.awt.Color(0, 0, 0));
        fieldCari.setText("Pencarian");
        fieldCari.setBorder(null);
        fieldCari.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldCariFocusGained(evt);
            }
        });

        btnCari.setBackground(new java.awt.Color(255, 255, 255));
        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id/co/ish/images/Search_20px.png"))); // NOI18N
        btnCari.setBorder(null);
        btnCari.setContentAreaFilled(false);
        btnCari.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnPilih.setBackground(new java.awt.Color(255, 0, 0));
        btnPilih.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPilih.setForeground(new java.awt.Color(255, 255, 255));
        btnPilih.setLabel("Pilih");
        btnPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihActionPerformed(evt);
            }
        });

        btnPilih1.setBackground(new java.awt.Color(255, 0, 0));
        btnPilih1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPilih1.setForeground(new java.awt.Color(255, 255, 255));
        btnPilih1.setLabel("Refresh");
        btnPilih1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilih1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(fieldCari, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 46, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnPilih, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPilih1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCari)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(fieldCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPilih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPilih1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihActionPerformed
        int baris = tabelPilihBarang.getSelectedRow();
        if (baris >= 0) {
            barang = arrayBarang.get(baris);
            dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Silakan pilih barang");
        }
    }//GEN-LAST:event_btnPilihActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        String cari = fieldCari.getText();
        if (cari != null && !cari.isEmpty()) {
            getData(cari);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Silakan isi pada kolom pencarian");
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnPilih1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilih1ActionPerformed
        getData();
    }//GEN-LAST:event_btnPilih1ActionPerformed

    private void fieldCariFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldCariFocusGained
        fieldCari.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariFocusGained

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPilihBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPilihBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPilihBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPilihBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormPilihBarang dialog = new FormPilihBarang(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                 dialog.setResizable(false);
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private java.awt.Button btnPilih;
    private java.awt.Button btnPilih1;
    private javax.swing.JTextField fieldCari;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private java.awt.Label label1;
    private javax.swing.JTable tabelPilihBarang;
    // End of variables declaration//GEN-END:variables
}
