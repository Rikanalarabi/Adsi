/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adsi;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Menu_Utama2 extends javax.swing.JFrame {

    /**
     * Creates new form Menu_Utama2
     */
    public Menu_Utama2() {
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

        jPanel1 = new javax.swing.JPanel();
        Transaksi = new javax.swing.JLabel();
        Pelanggan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(46, 14, 55));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trasaksi.jpg"))); // NOI18N
        Transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TransaksiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TransaksiMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TransaksiMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TransaksiMouseReleased(evt);
            }
        });
        jPanel1.add(Transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, -1, -1));

        Pelanggan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Pelanggan.jpg"))); // NOI18N
        Pelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PelangganMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PelangganMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PelangganMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PelangganMouseReleased(evt);
            }
        });
        jPanel1.add(Pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button/keluarr.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel3MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 710, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Travel Duta Prima Padang");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 1130, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PelangganMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PelangganMouseReleased
        // TODO add your handling code here:
        //ImageIcon a = new ImageIcon(getClass().getResource("/image/Pelanggan2.png"));
        //Pelanggan.setIcon(a);
        
        Pelanggan Pel =new Pelanggan();
        Pel.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PelangganMouseReleased

    private void TransaksiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransaksiMouseReleased
        // TODO add your handling code here
        //ImageIcon a = new ImageIcon(getClass().getResource("/image/trasaksi2.png"));
        //Transaksi.setIcon(a);
        
        Transaksi Tra = new Transaksi();
        Tra.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_TransaksiMouseReleased

    private void jLabel3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseReleased
        // TODO add your handling code here:
        int keluar = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Akan Keluar?","Peringatan!", JOptionPane.YES_NO_OPTION);
        if (keluar==0){
            Login k = new Login();
            k.setVisible(true); 
            dispose();
        }else{
            return;
        }
    }//GEN-LAST:event_jLabel3MouseReleased

    private void PelangganMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PelangganMouseEntered
        // TODO add your handling code here:
        //ImageIcon a = new ImageIcon(getClass().getResource("/image/Pelanggan2.png"));
        //Pelanggan.setIcon(a);
    }//GEN-LAST:event_PelangganMouseEntered

    private void PelangganMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PelangganMouseExited
        // TODO add your handling code here:
        //ImageIcon a = new ImageIcon(getClass().getResource("/image/Pelanggan.png"));
        //Pelanggan.setIcon(a);
    }//GEN-LAST:event_PelangganMouseExited

    private void PelangganMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PelangganMousePressed
        // TODO add your handling code here:
        //ImageIcon a = new ImageIcon(getClass().getResource("/image/Pelanggan3.png"));
        //Pelanggan.setIcon(a);
    }//GEN-LAST:event_PelangganMousePressed

    private void TransaksiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransaksiMouseEntered
        // TODO add your handling code here:
        //ImageIcon a = new ImageIcon(getClass().getResource("/image/trasaksi2.png"));
        //Transaksi.setIcon(a);
    }//GEN-LAST:event_TransaksiMouseEntered

    private void TransaksiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransaksiMouseExited
        // TODO add your handling code here:
        //ImageIcon a = new ImageIcon(getClass().getResource("/image/trasaksi.png"));
        //Transaksi.setIcon(a);
    }//GEN-LAST:event_TransaksiMouseExited

    private void TransaksiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransaksiMousePressed
        // TODO add your handling code here:
        //ImageIcon a = new ImageIcon(getClass().getResource("/image/trasaksi3.png"));
        //Transaksi.setIcon(a);
    }//GEN-LAST:event_TransaksiMousePressed

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
            java.util.logging.Logger.getLogger(Menu_Utama2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Utama2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Pelanggan;
    private javax.swing.JLabel Transaksi;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
