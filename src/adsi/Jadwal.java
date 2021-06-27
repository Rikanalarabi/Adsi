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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Jadwal extends javax.swing.JFrame {
    koneksi dbsetting;
    String driver, database, user, pass;
    Object tabel;
    /**
     * Creates new form Jadwal
     */
    public Jadwal() {
        initComponents();
        
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");

        table_Jadwal.setModel(tableModel);
        settableload();
    }
    
    private javax.swing.table.DefaultTableModel tableModel = getDefaultTableModel();

    private javax.swing.table.DefaultTableModel getDefaultTableModel() {
        //membuat judul header
        return new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"No Keberangkatan", "No Booking", "Id Karyawan", "Id Supir", "Jam Keberangkatan", "Tanggal Keberangkatan", "No_Tempat_Duduk", "Tujuan_Keberangkatan"}
        ) //disable perubahan pada grid
        {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
    }

    String data[] = new String[8];

    private void settableload() {
        String atat = "";
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select * from jadwal";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                data[4] = res.getString(5);
                data[5] = res.getString(6);
                data[6] = res.getString(7);
                data[7] = res.getString(8);
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String atat = "";
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select * from jadwal";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                data[0] = txt_Kendaraan.getText();
                data[1] = txt_Booking.getText();
                data[2] = txt_Karyawan.getText();
                data[3] = txt_Supir.getText();
                data[4] = (String) ComboBox_Jam.getSelectedItem();
                data[5] = sdf.format(Tgl_Keberangkatan.getDate());
                data[6] = (String) ComboBox_Tempat.getSelectedItem();
                data[7] = (String) ComboBox_Tujuan.getSelectedItem();
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
         txt_Booking.setText("");
         txt_Karyawan.setText("");
         txt_Supir.setText("");
         ComboBox_Jam.setSelectedIndex(0);
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         ComboBox_Tempat.setSelectedIndex(0);
         ComboBox_Tujuan.setSelectedIndex(0);
         txt_Cari.setText("");
    }
    
     int row = 0;
     public void tampil_field() throws ParseException {
        row = table_Jadwal.getSelectedRow();
        txt_Kendaraan.setText(tableModel.getValueAt(row, 0).toString());
        txt_Booking.setText(tableModel.getValueAt(row, 1).toString());
        txt_Karyawan.setText(tableModel.getValueAt(row, 2).toString());
        txt_Supir.setText(tableModel.getValueAt(row, 3).toString());
        ComboBox_Jam.setSelectedItem(tableModel.getValueAt(row, 4).toString());
        String date = tableModel.getValueAt(row, 5).toString();
        java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        Tgl_Keberangkatan.setDate(date2);
        ComboBox_Tempat.setSelectedItem(tableModel.getValueAt(row, 6).toString());
        ComboBox_Tujuan.setSelectedItem(tableModel.getValueAt(row, 7).toString());
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
        txt_Booking = new javax.swing.JTextField();
        txt_Karyawan = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Jadwal = new javax.swing.JTable();
        txt_Cari = new javax.swing.JTextField();
        btn_Cari = new javax.swing.JLabel();
        btn_Simpan = new javax.swing.JLabel();
        btn_Ubah = new javax.swing.JLabel();
        btn_Hapus = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        txt_Supir = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Tgl_Keberangkatan = new com.toedter.calendar.JDateChooser();
        ComboBox_Tujuan = new javax.swing.JComboBox();
        ComboBox_Tempat = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        ComboBox_Jam = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 145, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Corbel", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Jadwal");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 55, 125, -1));

        jLabel2.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("No Kendaraan");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 202, -1, -1));

        jLabel3.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("No Booking");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 271, -1, -1));

        jLabel4.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Id Karyawan");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 338, -1, -1));

        jLabel5.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Id Supir");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 412, -1, -1));
        jPanel1.add(txt_Kendaraan, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 200, 187, 29));
        jPanel1.add(txt_Booking, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 269, 187, 28));
        jPanel1.add(txt_Karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 336, 187, 29));

        table_Jadwal.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        table_Jadwal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Keberangkatan", "No Booking", "Id Karyawan", "Id Supir", "Jam Keberangkatan", "Tanggal Keberangkatan", "No Tempat Duduk", "Tujuan Keberangkatan"
            }
        ));
        table_Jadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_JadwalMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_Jadwal);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 200, 790, 319));
        jPanel1.add(txt_Cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(637, 540, 610, 29));

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
        jPanel1.add(btn_Cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 540, 50, 29));

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
        jPanel1.add(btn_Simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 640, 70, 24));

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
        jPanel1.add(btn_Ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 640, 50, 24));

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
        jPanel1.add(btn_Hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 640, 61, 24));

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
        jPanel1.add(txt_Supir, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 409, 187, 30));

        jLabel11.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Jam Keberangkatan");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 485, -1, -1));

        jLabel12.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tanggal Keberangkatan");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 543, -1, -1));

        jLabel13.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("No Tempat Dudu");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 609, -1, -1));

        jLabel14.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Tujuan Keberangkatan");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 682, -1, -1));

        Tgl_Keberangkatan.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(Tgl_Keberangkatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 538, 187, 28));

        ComboBox_Tujuan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Padang - Lubuk Basung", "Lubuk Basung - Padang" }));
        jPanel1.add(ComboBox_Tujuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 680, 187, 28));

        ComboBox_Tempat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A2", "A3", "A4", "A5", "A6", "A7" }));
        jPanel1.add(ComboBox_Tempat, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 600, 187, 28));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh-flat.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 90, -1, -1));

        ComboBox_Jam.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        ComboBox_Jam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "09:00:00", "10:00:00", "11:00:00", "12:00:00", "13:00:00", "14:00:00", "15:00:00", "16:00:00", "17:00:00", "18:00:00" }));
        jPanel1.add(ComboBox_Jam, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 480, 180, -1));

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

    private void backMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseReleased
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/image/back2.png"));
        back.setIcon(II);
        
        Menu_Utama1 MU1 = new Menu_Utama1();
        MU1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseReleased

    private void table_JadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_JadwalMouseClicked
        // TODO add your handling code here:
         if(evt.getClickCount()==1)
        {
             try {
                 tampil_field();
             } catch (ParseException ex) {
                 Logger.getLogger(Jadwal.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }//GEN-LAST:event_table_JadwalMouseClicked

    private void btn_SimpanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SimpanMousePressed
        // TODO add your handling code here:
        ImageIcon a = new ImageIcon(getClass().getResource("/Button/Simpan3.png"));
        btn_Simpan.setIcon(a);
        
        String data[]=new String[8];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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
                String SQL = "INSERT INTO jadwal(No_Keberangkatan,"+ "No_Booking,"+ "Id_Karyawan,"+ "Id_Supir,"+ " Jam_Keberangkatan,"+ "Tanggal_Keberangkatan,"+"No_Tempat_Duduk,"+ "Tujuan_Keberangkatan)"
                + "VALUES"
                +"( '"+txt_Kendaraan.getText()+"',"
                +"'"+txt_Booking.getText()+"',"
                +"'"+txt_Karyawan.getText()+"',"
                +"'"+txt_Supir.getText()+"',"
                +"'"+ComboBox_Jam.getSelectedItem()+"',"
                +"'"+sdf.format(Tgl_Keberangkatan.getDate())+" ',"
                + "'" + ComboBox_Tempat.getSelectedItem() + "',"
                + "'" + ComboBox_Tujuan.getSelectedItem() + "')";
                /*String SQL = "";*/
                stt.executeUpdate(SQL);
                data[0] = txt_Kendaraan.getText();
                data[1] = txt_Booking.getText();
                data[2] = txt_Karyawan.getText();
                data[3] = txt_Supir.getText();
                data[4] = (String) ComboBox_Jam.getSelectedItem();
                data[5] = sdf.format(Tgl_Keberangkatan.getDate());
                data[6] = (String) ComboBox_Tempat.getSelectedItem();
                data[7] = (String) ComboBox_Tujuan.getSelectedItem();
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
        
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        String No_Keberangkatan =txt_Kendaraan.getText();
        String Booking =txt_Booking.getText();
        String Id_Karyawan =txt_Karyawan.getText();
        String Id_Supir =txt_Supir.getText();
        String Jam_Keberangkatan =(String) ComboBox_Jam.getSelectedItem();
        String Tanggal_Keberangkatan =sdf.format(Tgl_Keberangkatan.getDate());
        String No_Tempat_Duduk = (String) ComboBox_Tempat.getSelectedItem();
        String Tujuan = (String) ComboBox_Tujuan.getSelectedItem();

        if((No_Keberangkatan.isEmpty()) | (Tujuan.isEmpty()))
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
                String SQL = "UPDATE `jadwal`"
                +"SET `No_Keberangkatan`='"+No_Keberangkatan+"',"
                +"`No_Booking`='"+Booking+"',"
                +"`Id_Karyawan`='"+Id_Karyawan+"',"
                +"`Id_Supir`='"+Id_Supir+"',"
                +"`Jam_Keberangkatan`='"+Jam_Keberangkatan+"',"
                +"`Tanggal_Keberangkatan`='"+Tanggal_Keberangkatan+"',"
                +"`No_Tempat_Duduk`='"+No_Tempat_Duduk+"',"
                +"`Tujuan_Keberangkatan`='"+Tujuan+"'"      
                +"WHERE"
                +"`No_Keberangkatan`='"+tableModel.getValueAt(row, 0).toString()+"';";
                data[0] = No_Keberangkatan;
                data[1] = Booking;
                data[2] = Id_Karyawan;
                data[3] = Id_Supir;
                data[4] = Jam_Keberangkatan;
                data[5] = Tanggal_Keberangkatan;
                data[6] = No_Tempat_Duduk;
                data[7] = Tujuan;
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

    private void btn_CariMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CariMousePressed
        // TODO add your handling code here:
        ImageIcon a = new ImageIcon(getClass().getResource("/Button/Cari3.png"));
        btn_Cari.setIcon(a);

        tableModel.setRowCount(0);
        //gunakan query untuk mencari
        String tampung = txt_Cari.getText();
        try {
            if ("Masukan No Kendaraan/Tujuan Keberangkatan".equals(tampung) || "".equals(tampung)) {
                JOptionPane.showMessageDialog(null, "Anda Belum Memasukan Data Yang anda Cari");
                return;
            } else 
            {
                   Class.forName(driver);
                    Connection kon = DriverManager.getConnection(database, user, pass);
                    Statement stt = kon.createStatement();
                    String SQL = "select * from `travel1`.`jadwal` WHERE `No_Keberangkatan`like '%" + txt_Cari.getText() + "%'OR `No_Tempat_Duduk` like '%" + txt_Cari.getText() + "%'OR `Tujuan_Keberangkatan` like '%" + txt_Cari.getText() + "'";
                    ResultSet res = stt.executeQuery(SQL);
                    while (res.next()) {
                        data[0] = res.getString(1);
                        data[1] = res.getString(2);
                        data[2] = res.getString(3);
                        data[3] = res.getString(4);
                        data[4] = res.getString(5);
                        data[5] = res.getString(6);
                        data[6] = res.getString(7);
                        data[7] = res.getString(8);
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
            String SQL = "Delete from `travel1`.`jadwal`"
            +"where"
            +"`No_Keberangkatan`='"+tableModel.getValueAt(row, 0).toString()+"';";
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

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        Jadwal Jad = new Jadwal();
        Jad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

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
            java.util.logging.Logger.getLogger(Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jadwal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBox_Jam;
    private javax.swing.JComboBox ComboBox_Tempat;
    private javax.swing.JComboBox ComboBox_Tujuan;
    private com.toedter.calendar.JDateChooser Tgl_Keberangkatan;
    private javax.swing.JLabel back;
    private javax.swing.JLabel btn_Cari;
    private javax.swing.JLabel btn_Hapus;
    private javax.swing.JLabel btn_Simpan;
    private javax.swing.JLabel btn_Ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_Jadwal;
    private javax.swing.JTextField txt_Booking;
    private javax.swing.JTextField txt_Cari;
    private javax.swing.JTextField txt_Karyawan;
    private javax.swing.JTextField txt_Kendaraan;
    private javax.swing.JTextField txt_Supir;
    // End of variables declaration//GEN-END:variables
}