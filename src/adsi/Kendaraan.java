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
public class Kendaraan extends javax.swing.JFrame {
    koneksi dbsetting;
    String driver, database, user, pass;
    Object tabel;
    /**
     * Creates new form Kendaraan
     */
    public Kendaraan() {
        initComponents();
        
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");

        table_Kendaraan.setModel(tableModel);
        settableload();
    }
    
    private javax.swing.table.DefaultTableModel tableModel = getDefaultTableModel();

    private javax.swing.table.DefaultTableModel getDefaultTableModel() {
        //membuat judul header
        return new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Id Kendaraan", "Plat Nomor", "Merek Mobil", "Id Supir"}
        ) //disable perubahan pada grid
        {
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
    }

    String data[] = new String[4];

    private void settableload() {
        String atat = "";
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select * from kendaraan";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
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
            String SQL = "select * from kendaraan";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                data[0] = txt_Kendaraan.getText();
                data[1] = txt_Plat.getText();
                data[2] = (String) ComboBox_Kendaraan.getSelectedItem();
                data[3] = txt_Supir.getText();
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
         txt_Kendaraan.setText("");
         txt_Plat.setText("");
         ComboBox_Kendaraan.setSelectedIndex(0);
         txt_Supir.setText("");
         txt_Cari.setText("");
    }
    
    int row = 0;
    public void tampil_field()
    {
        row = table_Kendaraan.getSelectedRow();
        txt_Kendaraan.setText(tableModel.getValueAt(row, 0).toString());
        txt_Plat.setText(tableModel.getValueAt(row, 1).toString());
        ComboBox_Kendaraan.setSelectedItem(tableModel.getValueAt(row, 2).toString());
        txt_Supir.setText(tableModel.getValueAt(row, 3).toString());
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_Kendaraan = new javax.swing.JTextField();
        txt_Plat = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Kendaraan = new javax.swing.JTable();
        txt_Cari = new javax.swing.JTextField();
        btn_Cari = new javax.swing.JLabel();
        btn_Simpan = new javax.swing.JLabel();
        btn_Ubah = new javax.swing.JLabel();
        btn_Hapus = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        txt_Supir = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ComboBox_Kendaraan = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(189, 29, 73));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Corbel", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kendaraan");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 55, -1, -1));

        jLabel2.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Id Kendaraan");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 226, -1, -1));

        jLabel3.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Plat Nomor");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 298, -1, -1));

        jLabel4.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Merek");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 368, -1, -1));

        jLabel5.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Id Supir");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 444, -1, -1));

        txt_Kendaraan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txt_Kendaraan, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 229, 187, 29));

        txt_Plat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txt_Plat, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 187, 28));

        table_Kendaraan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Kendaraan", "Plat Nomor", "Merek", "Id Supir"
            }
        ));
        table_Kendaraan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_KendaraanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_Kendaraan);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 226, 683, 319));
        jPanel1.add(txt_Cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 586, 597, 29));

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
        jPanel1.add(btn_Cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 585, 50, 29));

        btn_Simpan.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        btn_Simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_Simpan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
        jPanel1.add(btn_Simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 678, 70, 24));

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
        jPanel1.add(btn_Ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(682, 678, 50, 24));

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
        jPanel1.add(btn_Hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 678, 61, 24));

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
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 71, -1, -1));

        txt_Supir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txt_Supir, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 446, 187, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh-flat.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 111, -1, -1));

        ComboBox_Kendaraan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ComboBox_Kendaraan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Avanza", "AVP" }));
        jPanel1.add(ComboBox_Kendaraan, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 190, -1));

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

    private void backMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMousePressed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/image/back3.png"));
        back.setIcon(II);
        
        Menu_Utama1 MU1 = new Menu_Utama1();
        MU1.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_backMousePressed

    private void btn_SimpanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SimpanMousePressed
        // TODO add your handling code here:
        ImageIcon a = new ImageIcon(getClass().getResource("/Button/Simpan3.png"));
        btn_Simpan.setIcon(a);
        
        String data[]=new String[4];

        if ((txt_Kendaraan.getText().isEmpty()) || (txt_Supir.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null,
                "data tidak boleh kosong, silahkan lengkapi");
            txt_Kendaraan.requestFocus();
        }
        else
        {
            try
            {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO kendaraan(Id_Kendaraan,"+ "Plat_Nomor,"+ "Merek_Mobil,"+ "Id_Supir)"
                + "VALUES"
                +"( '"+txt_Kendaraan.getText()+"',"
                +"'"+txt_Plat.getText()+"',"
                + "'" + ComboBox_Kendaraan.getSelectedItem() + "',"
                +"'"+txt_Supir.getText()+"')";
                stt.executeUpdate(SQL);
                data[0] = txt_Kendaraan.getText();
                data[1] = txt_Plat.getText();
                data[2] = (String) ComboBox_Kendaraan.getSelectedItem();
                data[3] = txt_Supir.getText();
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

    private void btn_UbahMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_UbahMousePressed
        // TODO add your handling code here:
        ImageIcon a = new ImageIcon(getClass().getResource("/Button/Edit3.png"));
        btn_Ubah.setIcon(a);
        
        String Kendaraan =txt_Kendaraan.getText();
        String Plat =txt_Plat.getText();
        String Merek =(String) ComboBox_Kendaraan.getSelectedItem();
        String Supir =txt_Supir.getText();

        if((Kendaraan.isEmpty()) | (Supir.isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong, Silahkan Dilengkapi");
            txt_Kendaraan.requestFocus();
        }

        else
        {
            try
            {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "UPDATE `kendaraan`"
                +"SET `Id_Kendaraan`='"+Kendaraan+"',"
                +"`Plat_Nomor`='"+Plat+"',"
                +"`Merek_Mobil`='"+Merek+"',"
                +"`Id_Supir`='"+Supir+"'"      
                +"WHERE"
                +"`Id_Kendaraan`='"+tableModel.getValueAt(row, 0).toString()+"';";
                data[0] = Kendaraan;
                data[1] = Plat;
                data[2] = Merek;
                data[3] = Supir;
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

    private void table_KendaraanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_KendaraanMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1)
        {
            tampil_field();
        }
    }//GEN-LAST:event_table_KendaraanMouseClicked

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
            String SQL = "Delete from `travel1`.`kendaraan`"
            +"where"
            +"`Id_Kendaraan`='"+tableModel.getValueAt(row, 0).toString()+"';";
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
            if ("Masukan id Kendaraan".equals(tampung) || "".equals(tampung)) {
                JOptionPane.showMessageDialog(null, "Anda Belum Memasukan Data Yang anda Cari");
                return;
            } else {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "select * from `travel1`.`kendaraan` WHERE `Id_Kendaraan`like '%" + txt_Cari.getText() + "%'OR `Plat_Nomor` like '%" + txt_Cari.getText() + "%'OR `Merek_Mobil` like '%" + txt_Cari.getText() + "%'OR `Id_Supir` like '%" + txt_Cari.getText() + "'";
                ResultSet res = stt.executeQuery(SQL);
                while (res.next()) {
                    data[0] = res.getString(1);
                    data[1] = res.getString(2);
                    data[2] = res.getString(3);
                    data[3] = res.getString(4);
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

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        // TODO add your handling code here:
        Kendaraan Ken = new Kendaraan();
        Ken.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MousePressed

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

    private void backMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseReleased
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/image/back2.png"));
        back.setIcon(II);
    }//GEN-LAST:event_backMouseReleased

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
            java.util.logging.Logger.getLogger(Kendaraan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kendaraan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kendaraan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kendaraan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kendaraan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBox_Kendaraan;
    private javax.swing.JLabel back;
    private javax.swing.JLabel btn_Cari;
    private javax.swing.JLabel btn_Hapus;
    private javax.swing.JLabel btn_Simpan;
    private javax.swing.JLabel btn_Ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_Kendaraan;
    private javax.swing.JTextField txt_Cari;
    private javax.swing.JTextField txt_Kendaraan;
    private javax.swing.JTextField txt_Plat;
    private javax.swing.JTextField txt_Supir;
    // End of variables declaration//GEN-END:variables
}