/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adsi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Transaksi extends javax.swing.JFrame {
    koneksi dbsetting;
    String driver, database, user, pass;
    Object tabel;
    /**
     * Creates new form Transaksi
     */
    public Transaksi() {
        initComponents();
        
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");

        table_Transaksi.setModel(tableModel);
        settableload();
    }
    
    private javax.swing.table.DefaultTableModel tableModel = getDefaultTableModel();

    private javax.swing.table.DefaultTableModel getDefaultTableModel() {
        //membuat judul header
        return new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"No Pembayaran", "No Booking", "Id Karyawan", "Tujuan Kendaraan", "Harga Tiket"}
        ) //disable perubahan pada grid
        {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
    }

    String data[] = new String[5];

    private void settableload() {
        String atat = "";
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select * from transaksi";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                data[4] = res.getString(5);
                tableModel.addRow(data);
           }
            res.close();
            stt.close();
            kon.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    private void settableload1() {
        String atat = "";
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select * from transaksi";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                data[0] = txt_Pembayaran.getText();
                data[1] = txt_Booking.getText();
                data[2] = txt_Karyawan.getText();
                data[3] = (String) ComboBox_Tujuan.getSelectedItem();
                data[4] = txt_Tiket.getText();
                tableModel.insertRow(0, data);
                }
            res.close();
            stt.close();
            kon.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    public void bersihkan_teks(){
         txt_Pembayaran.setText("");
         txt_Booking.setText("");
         txt_Karyawan.setText("");
         ComboBox_Tujuan.setSelectedIndex(0);
         txt_Tiket.setText("");
         txt_Cari.setText("");
    }
    
    int row = 0;
    public void tampil_field()
    {
        row = table_Transaksi.getSelectedRow();
        txt_Pembayaran.setText(tableModel.getValueAt(row, 0).toString());
        txt_Booking.setText(tableModel.getValueAt(row, 1).toString());
        txt_Karyawan.setText(tableModel.getValueAt(row, 2).toString());
        ComboBox_Tujuan.setSelectedItem(tableModel.getValueAt(row, 3).toString());
        txt_Tiket.setText(tableModel.getValueAt(row, 4).toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txt_Pembayaran = new javax.swing.JTextField();
        txt_Booking = new javax.swing.JTextField();
        txt_Karyawan = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_Transaksi = new javax.swing.JTable();
        txt_Cari = new javax.swing.JTextField();
        btn_Cari = new javax.swing.JLabel();
        btn_Ubah = new javax.swing.JLabel();
        btn_Hapus = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        txt_Tiket = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        ComboBox_Tujuan = new javax.swing.JComboBox();
        btn_Simpan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel4.setBackground(new java.awt.Color(148, 66, 142));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Corbel", 0, 36)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Transaksi");
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 55, -1, -1));

        jLabel32.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("No Pembayaran");
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 202, -1, -1));

        jLabel33.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("No Booking");
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 271, -1, -1));

        jLabel34.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Id Karyawan");
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 338, -1, -1));

        jLabel35.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Tujuan Kendaraan");
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 412, -1, -1));
        jPanel4.add(txt_Pembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 200, 187, 29));
        jPanel4.add(txt_Booking, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 269, 187, 28));
        jPanel4.add(txt_Karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 336, 187, 29));

        table_Transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Pembayaran", "No Booking", "Id Karyawan", "Tujuan Kendaraan", "Harga tiket"
            }
        ));
        table_Transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_TransaksiMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(table_Transaksi);

        jPanel4.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 200, 683, 319));
        jPanel4.add(txt_Cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(667, 556, 597, 29));

        btn_Cari.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        btn_Cari.setForeground(new java.awt.Color(255, 255, 255));
        btn_Cari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button/Cari.png"))); // NOI18N
        btn_Cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_CariMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_CariMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_CariMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_CariMouseReleased(evt);
            }
        });
        jPanel4.add(btn_Cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 555, 50, 29));

        btn_Ubah.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        btn_Ubah.setForeground(new java.awt.Color(255, 255, 255));
        btn_Ubah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button/Edit.png"))); // NOI18N
        btn_Ubah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_UbahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_UbahMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_UbahMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_UbahMouseReleased(evt);
            }
        });
        jPanel4.add(btn_Ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(682, 648, 50, 24));

        btn_Hapus.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        btn_Hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_Hapus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button/Hapus.png"))); // NOI18N
        btn_Hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_HapusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_HapusMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_HapusMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_HapusMouseReleased(evt);
            }
        });
        jPanel4.add(btn_Hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 648, 61, 24));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backMouseReleased(evt);
            }
        });
        jPanel4.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 71, -1, -1));

        txt_Tiket.setText("50.000");
        txt_Tiket.setEnabled(false);
        jPanel4.add(txt_Tiket, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 489, 187, 30));

        jLabel41.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Harga Tiket");
        jPanel4.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 492, -1, -1));

        ComboBox_Tujuan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Padang - Lubuk Basung", "Lubuk Basung - Padang" }));
        jPanel4.add(ComboBox_Tujuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 407, 187, 28));

        btn_Simpan.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        btn_Simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_Simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button/Simpan.png"))); // NOI18N
        btn_Simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_SimpanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_SimpanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_SimpanMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_SimpanMouseReleased(evt);
            }
        });
        jPanel4.add(btn_Simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 650, 90, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh-flat.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 90, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseReleased
        // TODO add your handling code here:
         ImageIcon II = new ImageIcon(getClass().getResource("/image/back2.png"));
        back.setIcon(II);
        
        Menu_Utama2 MU1 = new Menu_Utama2();
        MU1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseReleased

    private void table_TransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_TransaksiMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1)
        {
            tampil_field();
        }
    }//GEN-LAST:event_table_TransaksiMouseClicked

    private void btn_SimpanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SimpanMousePressed
        // TODO add your handling code here:
         ImageIcon a = new ImageIcon(getClass().getResource("/Button/Simpan3.png"));
         btn_Simpan.setIcon(a);
        
         String data[]=new String[5];

        if ((txt_Pembayaran.getText().isEmpty()) || (txt_Tiket.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null,
                "data tidak boleh kosong, silahkan lengkapi");
            txt_Pembayaran.requestFocus();
        }
        else
        {
            try
            {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO transaksi(No_Pembayaran,"+ "No_Booking,"+ " Id_Karyawan,"+ "Tujuan_Keberangkatan,"+ "Harga_Tiket)"
                + "VALUES"
                +"( '"+txt_Pembayaran.getText()+"',"
                +"'"+txt_Booking.getText()+"',"
                +"'"+txt_Karyawan.getText()+"',"
                +"'"+ComboBox_Tujuan.getSelectedItem() + "',"
                +"'"+txt_Tiket.getText()+"')";
                /*String SQL = "";*/
                stt.executeUpdate(SQL);
                data[0] = txt_Pembayaran.getText();
                data[1] = txt_Booking.getText();
                data[2] = txt_Karyawan.getText();
                data[3] = (String) ComboBox_Tujuan.getSelectedItem();
                data[4] = txt_Tiket.getText();
                tableModel.insertRow(0, data);
                stt.close();
                kon.close();
                bersihkan_teks();
                JOptionPane.showMessageDialog(null, "Data Telah Disimpan..!","<< BERHASIL >>",JOptionPane.PLAIN_MESSAGE);
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_SimpanMousePressed

    private void btn_HapusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HapusMousePressed
        // TODO add your handling code here:
        ImageIcon a = new ImageIcon(getClass().getResource("/Button/Hapus3.png"));
        btn_Hapus.setIcon(a);
        
        int pilih = JOptionPane.showConfirmDialog(null, "Anda Yakin Ingin Menghapus Data Ini ..?","Pertanyaan",JOptionPane.YES_NO_OPTION);
        if(pilih == JOptionPane.YES_OPTION)
        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "Delete from `travel1`.`transaksi`"
            +"where"
            +"`No_Pembayaran`='"+tableModel.getValueAt(row, 0).toString()+"';";
            stt.executeUpdate(SQL);
            tableModel.removeRow(row);
            stt.close();
            kon.close();
            bersihkan_teks();
            JOptionPane.showMessageDialog(null, "Data Telah DiHapus..!","<< BERHASIL >>",JOptionPane.PLAIN_MESSAGE);
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_btn_HapusMousePressed

    private void btn_CariMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CariMousePressed
        // TODO add your handling code here:
        ImageIcon a = new ImageIcon(getClass().getResource("/Button/Cari3.png"));
        btn_Cari.setIcon(a);

        tableModel.setRowCount(0);
        //gunakan query untuk mencari
        String tampung = txt_Cari.getText();
        try {
            if ("Masukan No Pembayaran/No Booking".equals(tampung) || "".equals(tampung)) {
                JOptionPane.showMessageDialog(null, "Anda Belum Memasukan Data Yang anda Cari");
                return;
            } else {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "select * from `travel1`.`transaksi` WHERE `No_Pembayaran`like '%" + txt_Cari.getText() + "%'OR `No_Booking` like '%" + txt_Cari.getText() + "%'OR `Id_Karyawan` like '%" + txt_Cari.getText() + "%'OR `Tujuan_Keberangkatan` like '%" + txt_Cari.getText() + "'";
                ResultSet res = stt.executeQuery(SQL);
                while (res.next()) {
                    data[0] = res.getString(1);
                    data[1] = res.getString(2);
                    data[2] = res.getString(3);
                    data[3] = res.getString(4);
                    data[4] = res.getString(5);
                    tableModel.addRow(data);
                }
                res.close();
                stt.close();
                kon.close();
                bersihkan_teks();
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);

        }
    }//GEN-LAST:event_btn_CariMousePressed

    private void btn_UbahMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_UbahMousePressed
        // TODO add your handling code here:
        ImageIcon a = new ImageIcon(getClass().getResource("/Button/Edit3.png"));
        btn_Ubah.setIcon(a);
        
        String No_Pembayaran =txt_Pembayaran.getText();
        String No_Booking =txt_Booking.getText();
        String Id_Karyawan =txt_Karyawan.getText();
        String Tujuan = (String) ComboBox_Tujuan.getSelectedItem();
        String Harga_Tiket =txt_Tiket.getText();
        

        if((No_Pembayaran.isEmpty()) | (Harga_Tiket.isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong, Silahkan Dilengkapi");
            txt_Pembayaran.requestFocus();
        }

        else
        {
            try
            {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "UPDATE `transaksi`"
                +"SET `No_Pembayaran`='"+No_Pembayaran+"',"
                +"`No_Booking`='"+No_Booking+"',"
                +"`Id_Karyawan`='"+Id_Karyawan+"',"
                +"`Tujuan_Keberangkatan='"+Tujuan+"',"
                +"`Harga_Tiket`='"+Harga_Tiket+"'"      
                +"WHERE"
                +"`No_Pembayaran`='"+tableModel.getValueAt(row, 0).toString()+"';";
                data[0] = No_Pembayaran;
                data[1] = No_Booking;
                data[2] = Id_Karyawan;
                data[3] = Tujuan;
                data[4] = Harga_Tiket;
                tableModel.removeRow(row);
                tableModel.insertRow(row, data);
                stt.close();
                kon.close();
                bersihkan_teks();
                JOptionPane.showMessageDialog(null, "Data Telah DiUbah..!", "<< BERHASIL >>", JOptionPane.PLAIN_MESSAGE);
            }
            catch (Exception ex)
            {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btn_UbahMousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // TODO add your handling code here:
        Transaksi Tr = new Transaksi();
        Tr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MousePressed

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/image/back2.png"));
         back.setIcon(II);
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/image/back.png"));
        back.setIcon(II);
    }//GEN-LAST:event_backMouseExited

    private void backMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMousePressed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/image/back3.png"));
        back.setIcon(II);
    }//GEN-LAST:event_backMousePressed

    private void btn_SimpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SimpanMouseEntered
        // TODO add your handling code here:
        ImageIcon a = new ImageIcon(getClass().getResource("/Button/Simpan2.png"));
        btn_Simpan.setIcon(a);
    }//GEN-LAST:event_btn_SimpanMouseEntered

    private void btn_SimpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SimpanMouseExited
        // TODO add your handling code here:
        ImageIcon a = new ImageIcon(getClass().getResource("/Button/Simpan.png"));
        btn_Simpan.setIcon(a);
    }//GEN-LAST:event_btn_SimpanMouseExited

    private void btn_SimpanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SimpanMouseReleased
        // TODO add your handling code here:
         ImageIcon a = new ImageIcon(getClass().getResource("/Button/Simpan2.png"));
         btn_Simpan.setIcon(a);
    }//GEN-LAST:event_btn_SimpanMouseReleased

    private void btn_UbahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_UbahMouseEntered
        // TODO add your handling code here:
        ImageIcon a = new ImageIcon(getClass().getResource("/Button/Edit2.png"));
        btn_Ubah.setIcon(a);
    }//GEN-LAST:event_btn_UbahMouseEntered

    private void btn_UbahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_UbahMouseExited
        // TODO add your handling code here:
        ImageIcon a = new ImageIcon(getClass().getResource("/Button/Edit.png"));
        btn_Ubah.setIcon(a);
    }//GEN-LAST:event_btn_UbahMouseExited

    private void btn_UbahMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_UbahMouseReleased
        // TODO add your handling code here:
         ImageIcon a = new ImageIcon(getClass().getResource("/Button/Edit.png"));
        btn_Ubah.setIcon(a);
    }//GEN-LAST:event_btn_UbahMouseReleased

    private void btn_HapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HapusMouseEntered
        // TODO add your handling code here:
        ImageIcon a = new ImageIcon(getClass().getResource("/Button/Hapus2.png"));
        btn_Hapus.setIcon(a);
    }//GEN-LAST:event_btn_HapusMouseEntered

    private void btn_HapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HapusMouseExited
        // TODO add your handling code here:
        ImageIcon a = new ImageIcon(getClass().getResource("/Button/Hapus.png"));
        btn_Hapus.setIcon(a);
    }//GEN-LAST:event_btn_HapusMouseExited

    private void btn_HapusMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HapusMouseReleased
        // TODO add your handling code here:
        ImageIcon a = new ImageIcon(getClass().getResource("/Button/Edit.png"));
        btn_Hapus.setIcon(a);
    }//GEN-LAST:event_btn_HapusMouseReleased

    private void btn_CariMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CariMouseEntered
        // TODO add your handling code here:
        ImageIcon a = new ImageIcon(getClass().getResource("/Button/Cari2.png"));
        btn_Cari.setIcon(a);
    }//GEN-LAST:event_btn_CariMouseEntered

    private void btn_CariMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CariMouseExited
        // TODO add your handling code here:
        ImageIcon a = new ImageIcon(getClass().getResource("/Button/Cari.png"));
        btn_Cari.setIcon(a);
    }//GEN-LAST:event_btn_CariMouseExited

    private void btn_CariMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CariMouseReleased
        // TODO add your handling code here:
        ImageIcon a = new ImageIcon(getClass().getResource("/Button/Cari2.png"));
        btn_Cari.setIcon(a);
    }//GEN-LAST:event_btn_CariMouseReleased

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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBox_Tujuan;
    private javax.swing.JLabel back;
    private javax.swing.JLabel btn_Cari;
    private javax.swing.JLabel btn_Hapus;
    private javax.swing.JLabel btn_Simpan;
    private javax.swing.JLabel btn_Ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable table_Transaksi;
    private javax.swing.JTextField txt_Booking;
    private javax.swing.JTextField txt_Cari;
    private javax.swing.JTextField txt_Karyawan;
    private javax.swing.JTextField txt_Pembayaran;
    private javax.swing.JTextField txt_Tiket;
    // End of variables declaration//GEN-END:variables
}
