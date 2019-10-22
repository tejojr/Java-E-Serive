/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import configs.dbconfig;
import configs.functions;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import report.printNow;
import views.Login1;

/**
 * Touch me https://github.com/tejojr
 *
 * @author Zeref
 */
public class DaftarService extends javax.swing.JInternalFrame {

    functions f = new functions();

    private void autonumber() {
        try {
            String sql = "SELECT MAX(RIGHT(id,6)) AS NO FROM service";
            Statement st = dbconfig.Con().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if (rs.first() == false) {
                    t_idservice.setText("SRV-000001");
                } else {
                    rs.last();
                    int auto_id = rs.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int NomorSer = no.length();
                    for (int j = 0; j < 6 - NomorSer; j++) {
                        no = "0" + no;
                    }
                    t_idservice.setText("SRV-" + no);
                }
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void tampil() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Tanggal masuk");
        model.addColumn("Status");
        model.addColumn("Id Pelanggan");
        model.addColumn("Nama Pelanggan");
        model.addColumn("Id Item");
        model.addColumn("Merk");
        model.addColumn("Jenis");
        try {
            f.select("SELECT service.id, service.tgl_masuk,service.status,service.id_pelanggan, pelanggan.nama,item.id as id_item,item.merk,jenis.name as jenis FROM `item` INNER join service on item.id_service = service.id INNER join jenis on item.id_jenis = jenis.id INNER JOIN pelanggan on pelanggan.id = service.id_pelanggan where service.id = '" + t_idservice.getText() + "' ");
            int no = 1;
            while (f.rs.next()) {
                model.addRow(new Object[]{
                    no++,
                    f.rs.getString("id"),
                    f.rs.getString("tgl_masuk"),
                    f.rs.getString("status"),
                    f.rs.getString("id_pelanggan"),
                    f.rs.getString("nama"),
                    f.rs.getString("id_item"),
                    f.rs.getString("merk"),
                    f.rs.getString("jenis"),});

            }
            tabel.setModel(model);
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void tampil_combo() {
        try {
            Statement stt = dbconfig.Con().createStatement();
            String sql = "select * from jenis order by id asc";      // disini saya menampilkan NIM, anda dapat menampilkan
            ResultSet res = stt.executeQuery(sql);                                // yang anda ingin kan

            while (res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);
                ob[1] = res.getString(2);
                cmb_jenis.addItem(ob[0] + " - " + ob[1]);                                      // fungsi ini bertugas menampung isi dari database
            }
            res.close();
            stt.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void clear() {
        autonumber();
        t_idpel.setText("");
        t_namapel.setText("");
        t_alamatpel.setText("");
        t_hppel.setText("");
        t_merk.setText("");
        t_keluhan.setText("");
        t_kelengkapan.setText("");

    }

    private void mati() {
        cmb_jenis.setEnabled(false);
        t_merk.setEnabled(false);
        t_keluhan.setEnabled(false);
        t_kelengkapan.setEnabled(false);
        b_check.setEnabled(false);
        b_simpan.setEnabled(false);
        b_reset.setEnabled(false);

    }

    private void hidup() {
        cmb_jenis.setEnabled(true);
        t_merk.setEnabled(true);
        t_keluhan.setEnabled(true);
        t_kelengkapan.setEnabled(true);
        b_simpan.setEnabled(true);
        b_reset.setEnabled(true);
        b_check.setEnabled(true);

    }

    /**
     * Creates new form DaftarService
     */
    public DaftarService() {
        initComponents();
        DateFormat dateFormat = new SimpleDateFormat("dd MMMMM yyyy");
        Date date = new Date();
        datetoday.setText(dateFormat.format(date));
        autonumber();
        tampil_combo();
        b_cetak.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        t_idservice = new javax.swing.JTextField();
        t_alamatpel = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        t_hppel = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        t_idpel = new javax.swing.JTextField();
        b_check = new javax.swing.JButton();
        t_namapel = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        t_kelengkapan = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        t_merk = new javax.swing.JTextField();
        t_keluhan = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmb_jenis = new javax.swing.JComboBox<>();
        b_simpan = new javax.swing.JButton();
        b_reset = new javax.swing.JButton();
        b_cetak = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        datetoday = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Daftar Service");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Pelanggan"));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("Id Pelanggan :");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Id Service :");

        t_idservice.setEditable(false);
        t_idservice.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        t_idservice.setEnabled(false);

        t_alamatpel.setEditable(false);
        t_alamatpel.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        t_alamatpel.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setText("Alamat :");

        t_hppel.setEditable(false);
        t_hppel.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        t_hppel.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setText("No Telp :");

        t_idpel.setEditable(false);
        t_idpel.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        t_idpel.setEnabled(false);

        b_check.setText("...");
        b_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_checkActionPerformed(evt);
            }
        });

        t_namapel.setEditable(false);
        t_namapel.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        t_namapel.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setText("Nama :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(t_idpel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(b_check, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(t_namapel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_alamatpel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_hppel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(t_idservice, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(t_idservice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(t_idpel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_check))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(t_namapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(t_alamatpel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(t_hppel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Item"));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setText("Merk :");

        t_kelengkapan.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel14.setText("Kelengkapan :");

        t_merk.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        t_keluhan.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel16.setText("Keluhan : ");

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel13.setText("Jenis :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(jLabel12))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(t_keluhan)
                    .addComponent(t_kelengkapan)
                    .addComponent(t_merk)
                    .addComponent(cmb_jenis, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cmb_jenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(t_merk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(t_keluhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(t_kelengkapan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        b_simpan.setText("Simpan");
        b_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_simpanActionPerformed(evt);
            }
        });

        b_reset.setText("Clear");
        b_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_resetActionPerformed(evt);
            }
        });

        b_cetak.setText("Cetak");
        b_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cetakActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabel);

        datetoday.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(575, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(b_simpan)
                        .addGap(18, 18, 18)
                        .addComponent(b_reset)
                        .addGap(18, 18, 18)
                        .addComponent(b_cetak)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(datetoday)
                        .addGap(191, 191, 191))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(datetoday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_simpan)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_reset)
                        .addComponent(b_cetak)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(52, 152, 219));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Daftar Service");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_checkActionPerformed
        DialogPelanggan dp = new DialogPelanggan(null, true);
        dp.setVisible(true);
        t_idpel.setText(dp.id);
        t_namapel.setText(dp.nama);// TODO add your handling code here:
        t_alamatpel.setText(dp.alamat);// TODO add your handling code here:
        t_hppel.setText(dp.notelp);// TODO add your handling code here:
// TODO add your handling code here:
    }//GEN-LAST:event_b_checkActionPerformed

    private void b_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_simpanActionPerformed
        mati();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        f.cud1("INSERT into service values ('" + t_idservice.getText()
                + "','" + dateFormat.format(date)
                + "',null,'diterima',0,'"
                + Login1.id + "','"
                + t_idpel.getText() + "')");
        String[] jenis = cmb_jenis.getSelectedItem().toString().split("-");
        f.cud("INSERT into item value (null,'" + jenis[0]
                + "','" + t_merk.getText()
                + "','" + t_keluhan.getText()
                + "','" + t_kelengkapan.getText()
                + "',0,0,0,'diterima','" + t_idservice.getText() + "')", "Transaksi berhasil ditambahkan");

        tampil();
        b_cetak.setEnabled(true);

// TODO add your handling code here:
    }//GEN-LAST:event_b_simpanActionPerformed

    private void b_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_resetActionPerformed
        clear();        // TODO add your handling code here:
    }//GEN-LAST:event_b_resetActionPerformed

    private void b_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cetakActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String[] jenis = cmb_jenis.getSelectedItem().toString().split("-");
        String header
                = "***************Nota Terima Service***************;"
                + "Fazt Service \n;"
                + "Jln. Maju Mundur, Kota/Kab. Sims City \n;"
                + "Telp. 085712345678  \n;"
                + "-------------------------------------------------\n;"
                + "Date   : " + dateFormat.format((date)) + "       " + "Time:" + timeFormat.format(date) + "\n;"
                + "Id     : " + t_idpel.getText() + "\n;"
                + "Nama   : " + t_namapel.getText() + "\n;"
                + "Alamat : " + t_alamatpel.getText() + "\n;"
                + "Telepon: " + t_hppel.getText() + "\n;"
                + "-------------------------------------------------\n;"
                + "Detail Barang \n;"
                + "-------------------------------------------------\n;"
                + "No Service    : " + t_idservice.getText() + "\n;"
                + "Merk/Type     : " + t_merk.getText() + "/" + jenis[1] + "\n;"
                + "Kelengkapan   : " + t_kelengkapan.getText() + "\n;"
                + "Keluhan       : " + t_keluhan.getText() + "\n;";
        String footer
                = "-------------------------------------------------\n;"
                + "-------------------------------------------------\n;"
                + "          Melayani Service 24 jam      \n ;"
                + "          Dijamin Joss!!!!!!!!!!!      \n;"
                + "**************************************************\n;"
                + "               Thank You             \n;"
                + "___________________________________________________\n;";
        String a = header + footer;
        printNow pn = new printNow();
        pn.printCard(a);
        clear();
        hidup();
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        model.setRowCount(0);        // TODO add your handling code here:
    }//GEN-LAST:event_b_cetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cetak;
    private javax.swing.JButton b_check;
    private javax.swing.JButton b_reset;
    private javax.swing.JButton b_simpan;
    private javax.swing.JComboBox<String> cmb_jenis;
    private javax.swing.JLabel datetoday;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t_alamatpel;
    private javax.swing.JTextField t_hppel;
    private javax.swing.JTextField t_idpel;
    private javax.swing.JTextField t_idservice;
    private javax.swing.JTextField t_kelengkapan;
    private javax.swing.JTextField t_keluhan;
    private javax.swing.JTextField t_merk;
    private javax.swing.JTextField t_namapel;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
