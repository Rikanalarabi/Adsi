/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adsi;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Karyawan extends javax.swing.JFrame {
    koneksi dbsetting;
    String driver, database, user, pass;
    Object tabel;
    /**
     * Creates new form Karyawan
     */
    public Karyawan() {
        initComponents();
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");

        table_Karyawan.setModel(tableModel);
        settableload();
    }
    
    private javax.swing.table.DefaultTableModel tableModel = getDefaultTableModel();

    private javax.swing.table.DefaultTableModel getDefaultTableModel() {
        //membuat judul header
        return new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Id Karyawan", "Nama", "Username", "Password", "Alamat", "No_Hp", "Bagian"}
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

    String data[] = new String[7];

    private void settableload() {
        String atat = "";
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select * from karyawan";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                data[4] = res.getString(5);
                data[5] = res.getString(6);
                data[6] = res.getString(7);
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
            String SQL = "select * from karyawan";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                data[0] = txt_Id.getText();
                data[1] = txt_Nama.getText();
                data[2] = txt_user.getText();
                data[3] = txt_Pass.getText();
                data[4] = txt_Alamat.getText();
                data[5] = txt_Hp.getText();
                data[6] = (String) ComboBox_Bagian.getSelectedItem();
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
    
    void filterhuruf(KeyEvent a){
        if(Character.isAlphabetic(a.getKeyChar())){
            a.consume();
            JOptionPane.showMessageDialog(null,"Pada Kolom Hanya Bisa Memasukan Karakter Angka.!");
        }
    }
    
    void filterangka(KeyEvent b){
        if(Character.isDigit(b.getKeyChar())){
            b.consume();
            JOptionPane.showMessageDialog(null,"Pada Kolom Hanya Bisa Memasukan Karakter Huruf.!");
        }
    }
    
    public void bersihkan_teks(){
         txt_Id.setText("");
         txt_Nama.setText("");
         txt_user.setText("");
         txt_Pass.setText("");
         txt_Alamat.setText("");
         txt_Hp.setText("");
         ComboBox_Bagian.setSelectedIndex(0);
         txt_Cari.setText("");
    }
    
    int row = 0;
    public void tampil_field()
    {
        row = table_Karyawan.getSelectedRow();
        txt_Id.setText(tableModel.getValueAt(row, 0).toString());
        txt_Nama.setText(tableModel.getValueAt(row, 1).toString());
        txt_user.setText(tableModel.getValueAt(row, 2).toString());
        txt_Pass.setText(tableModel.getValueAt(row, 3).toString());
        txt_Alamat.setText(tableModel.getValueAt(row, 4).toString());
        txt_Hp.setText(tableModel.getValueAt(row, 5).toString());
        ComboBox_Bagian.setSelectedItem(tableModel.getValueAt(row, 6).toString());
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_Id = new javax.swing.JTextField();
        txt_Nama = new javax.swing.JTextField();
        txt_user = new javax.swing.JTextField();
        txt_Pass = new javax.swing.JPasswordField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_Alamat = new javax.swing.JTextArea();
        txt_Hp = new javax.swing.JTextField();
        ComboBox_Bagian = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Karyawan = new javax.swing.JTable();
        btn_Simpan = new javax.swing.JLabel();
        btn_Ubah = new javax.swing.JLabel();
        btn_Hapus = new javax.swing.JLabel();
        btn_Cari = new javax.swing.JLabel();
        txt_Cari = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        L_back_barang = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 158, 171));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Id Karyawan");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 99, -1, -1));

        jLabel2.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 167, -1, -1));

        jLabel3.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 231, -1, -1));

        jLabel4.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 301, -1, -1));

        jLabel5.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Alamat");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 364, -1, -1));

        jLabel6.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("No Handphone");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 501, -1, -1));

        jLabel7.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Bagian");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 567, -1, -1));
        jPanel1.add(txt_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 101, 140, 30));

        txt_Nama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NamaKeyTyped(evt);
            }
        });
        jPanel1.add(txt_Nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 167, 140, 30));
        jPanel1.add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 233, 140, 30));
        jPanel1.add(txt_Pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 303, 140, 30));

        txt_Alamat.setColumns(20);
        txt_Alamat.setRows(5);
        jScrollPane2.setViewportView(txt_Alamat);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 364, 233, 119));

        txt_Hp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_HpKeyTyped(evt);
            }
        });
        jPanel1.add(txt_Hp, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 503, 140, 30));

        ComboBox_Bagian.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Kasir" }));
        jPanel1.add(ComboBox_Bagian, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 567, 140, 30));

        table_Karyawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Karyawan", "Nama", "Username", "Password", "Alamat", "No Handphone", "Bagian"
            }
        ));
        table_Karyawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_KaryawanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_Karyawan);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(524, 99, 772, 498));

        btn_Simpan.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
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
        jPanel1.add(btn_Simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 683, 70, 25));

        btn_Ubah.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
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
        jPanel1.add(btn_Ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(609, 683, 39, 25));

        btn_Hapus.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
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
        jPanel1.add(btn_Hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(684, 683, 46, 25));

        btn_Cari.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
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
        jPanel1.add(btn_Cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 622, 50, 30));
        jPanel1.add(txt_Cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 622, 687, 30));

        jLabel9.setFont(new java.awt.Font("Corbel", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Pegawai");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 11, -1, -1));

        L_back_barang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        L_back_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                L_back_barangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                L_back_barangMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L_back_barangMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                L_back_barangMouseReleased(evt);
            }
        });
        jPanel1.add(L_back_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 27, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh-flat.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel10MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1157, 31, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SimpanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SimpanMousePressed
        // TODO add your handling code here:
        ImageIcon a = new ImageIcon(getClass().getResource("/Button/Simpan3.png"));
        btn_Simpan.setIcon(a);
        
        String data[]=new String[7];

        if ((txt_Id.getText().isEmpty()) || (txt_Hp.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null,
                "data tidak boleh kosong, silahkan lengkapi");
            txt_Id.requestFocus();
        }
        else
        {
            try
            {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO karyawan(Id_Karawan,"+ "Nama,"+ " Username,"+ " Password,"+ " Alamat,"+ " No_Hp,"+"Bagian)"
                + "VALUES"
                +"( '"+txt_Id.getText()+"',"
                +"'"+txt_Nama.getText()+"',"
                +"'"+txt_user.getText()+"',"
                +"'"+txt_Pass.getText()+"',"
                +"'"+txt_Alamat.getText()+"',"
                +"'"+txt_Hp.getText()+"',"
                + "'" + ComboBox_Bagian.getSelectedItem() + "')";
                /*String SQL = "";*/
                stt.executeUpdate(SQL);
                data[0] = txt_Id.getText();
                data[1] = txt_Nama.getText();
                data[2] = txt_user.getText();
                data[3] = txt_Pass.getText();
                data[4] = txt_Alamat.getText();
                data[5] = txt_Hp.getText();
                data[6] = (String) ComboBox_Bagian.getSelectedItem();
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
            String SQL = "Delete from `travel1`.`karyawan`"
            +"where"
            +"`Id_Karawan`='"+tableModel.getValueAt(row, 0).toString()+"';";
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

    private void table_KaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_KaryawanMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1)
        {
            tampil_field();
        }
    }//GEN-LAST:event_table_KaryawanMouseClicked

    private void btn_UbahMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_UbahMousePressed
        // TODO add your handling code here:
        ImageIcon a = new ImageIcon(getClass().getResource("/Button/Edit3.png"));
        btn_Ubah.setIcon(a);
        
        String Id_Supir =txt_Id.getText();
        String Nama =txt_Nama.getText();
        String User =txt_user.getText();
        String Pass =txt_Pass.getText();
        String No_Telp =txt_Hp.getText();
        String Alamat =txt_Alamat.getText();
        String Bagian = (String) ComboBox_Bagian.getSelectedItem();

        if((Id_Supir.isEmpty()) | (Bagian.isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong, Silahkan Dilengkapi");
            txt_Id.requestFocus();
        }

        else
        {
            try
            {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "UPDATE `karyawan`"
                +"SET `Id_Karawan`='"+Id_Supir+"',"
                +"`Nama`='"+Nama+"',"
                +"`Username`='"+User+"',"
                +"`Password`='"+Pass+"',"
                +"`Alamat`='"+Alamat+"',"
                +"`No_Hp`='"+No_Telp+"',"
                +"`Bagian`='"+Bagian+"'"      
                +"WHERE"
                +"`Id_Karawan`='"+tableModel.getValueAt(row, 0).toString()+"';";
                data[0] = Id_Supir;
                data[1] = Nama;
                data[2] = User;
                data[3] = Pass;
                data[4] = Alamat;
                data[5] = No_Telp;
                data[6] = Bagian;
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
            if ("Masukan id Karyawan/nama/Bagian".equals(tampung) || "".equals(tampung)) {
                JOptionPane.showMessageDialog(null, "Anda Belum Memasukan Data Yang anda Cari");
                return;
            } else {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "select * from `travel1`.`karyawan` WHERE `Id_Karawan`like '%" + txt_Cari.getText() + "%'OR `Nama` like '%" + txt_Cari.getText() + "%'OR `Bagian` like '%" + txt_Cari.getText() + "'";
                ResultSet res = stt.executeQuery(SQL);
                while (res.next()) {
                    data[0] = res.getString(1);
                    data[1] = res.getString(2);
                    data[2] = res.getString(3);
                    data[3] = res.getString(4);
                    data[4] = res.getString(5);
                    data[5] = res.getString(6);
                    data[6] = res.getString(7);
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

    private void L_back_barangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L_back_barangMouseEntered
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/image/back2.png"));
        L_back_barang.setIcon(II);
    }//GEN-LAST:event_L_back_barangMouseEntered

    private void L_back_barangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L_back_barangMouseExited
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/image/back.png"));
        L_back_barang.setIcon(II);
    }//GEN-LAST:event_L_back_barangMouseExited

    private void L_back_barangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L_back_barangMousePressed
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/image/back3.png"));
        L_back_barang.setIcon(II);
    }//GEN-LAST:event_L_back_barangMousePressed

    private void L_back_barangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L_back_barangMouseReleased
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/image/back2.png"));
        L_back_barang.setIcon(II);
        
        Menu_Utama1 MU1 = new Menu_Utama1();
        MU1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_L_back_barangMouseReleased

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

    private void jLabel10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseReleased
        // TODO add your handling code here:
        Karyawan Kar = new Karyawan();
        Kar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseReleased

    private void txt_NamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NamaKeyTyped
        // TODO add your handling code here:
        filterangka(evt);
    }//GEN-LAST:event_txt_NamaKeyTyped

    private void txt_HpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_HpKeyTyped
        // TODO add your handling code here:
        filterhuruf(evt);
    }//GEN-LAST:event_txt_HpKeyTyped

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
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Karyawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBox_Bagian;
    private javax.swing.JLabel L_back_barang;
    private javax.swing.JLabel btn_Cari;
    private javax.swing.JLabel btn_Hapus;
    private javax.swing.JLabel btn_Simpan;
    private javax.swing.JLabel btn_Ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_Karyawan;
    private javax.swing.JTextArea txt_Alamat;
    private javax.swing.JTextField txt_Cari;
    private javax.swing.JTextField txt_Hp;
    private javax.swing.JTextField txt_Id;
    private javax.swing.JTextField txt_Nama;
    private javax.swing.JPasswordField txt_Pass;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}