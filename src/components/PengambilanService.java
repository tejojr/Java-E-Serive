/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import configs.functions;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import report.printNow;

/**
 * Touch me https://github.com/tejojr
 *
 * @author Zeref
 */
public class PengambilanService extends javax.swing.JInternalFrame {

    functions f = new functions();
    String iditem = "";

    /**
     * Creates new form PengambilanService
     */
    public PengambilanService() {
        initComponents();
        Clear();
        DateFormat dateFormat = new SimpleDateFormat("dd MMMMM yyyy");
        Date date = new Date();
        datetoday.setText(dateFormat.format(date));
    }

    private void Clear() {
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        model.setRowCount(0);
        DefaultTableModel model1 = (DefaultTableModel) tabel3.getModel();
        model1.setRowCount(0);
        t_idservice.setText("");
        t_idpel.setText("");
        t_namapel.setText("");
        t_alamatpel.setText("");
        t_hppel.setText("");
//        t_biayaservice.setText("0");
        t_tglmasuk.setText("");
//        t_biayasparepart.setText("0");
        t_bayar.setText("0");
        t_totalbiaya.setText("0");
        t_kembalian.setText("0");
        iditem = "";
        t_idservice.requestFocus();

    }

    private void tampilSparepart() {
        DefaultTableModel model3 = new DefaultTableModel();
        model3.addColumn("No");
        model3.addColumn("ID");
        model3.addColumn("Name");
        model3.addColumn("Price");
        model3.addColumn("Qty");
        model3.addColumn("Sub Total");

        try {
            f.select("select * from sparepart where id_item =  '" + iditem + "' ");
            int no = 1;
            while (f.rs.next()) {
                model3.addRow(new Object[]{
                    no++,
                    f.rs.getString(1),
                    f.rs.getString(2),
                    f.rs.getString(3),
                    f.rs.getString(4),
                    f.rs.getString(5)
                });

            }
            tabel3.setModel(model3);
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    private void tampilItem() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Barang");
        model.addColumn("Merk");
        model.addColumn("Keluhan");
        model.addColumn("Kelengkapan");
        model.addColumn("Jenis");
        model.addColumn("Biaya Service");
        model.addColumn("Biaya Spare Part");
        model.addColumn("Total Biaya");
        try {
            f.select(" SELECT item.id, item.merk, item.keluhan, item.kelengkapan, jenis.name as jenis, item.biaya_service,item.totbiaya_spare_part,item.total_biaya,item.status FROM item INNER JOIN jenis on item.id_jenis = jenis.id where id_service = '" + t_idservice.getText() + "'");
            int no = 1;
            while (f.rs.next()) {
                model.addRow(new Object[]{
                    no++,
                    f.rs.getString(1),
                    f.rs.getString(2),
                    f.rs.getString(3),
                    f.rs.getString(4),
                    f.rs.getString(5),
                    f.rs.getString(6),
                    f.rs.getString(7),
                    f.rs.getString(8),});
            }
            tabel.setModel(model);
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    private int hitungTotal() {
        int biaya = Integer.parseInt(t_totalbiaya.getText());
        int bayar;
        if (t_bayar.getText().isEmpty()) {
            bayar = 0;
        } else {
            bayar = Integer.parseInt(t_bayar.getText());

        }
        int result = bayar - biaya;
        return result;
    }

    private void cariPelanggan() {
        f.select("SELECT service.id, service.tgl_masuk,service.status,service.total_biaya,service.id_pelanggan, pelanggan.nama, pelanggan.alamat,pelanggan.no_telp FROM service INNER JOIN pelanggan on pelanggan.id = service.id_pelanggan where service.id = '" + t_idservice.getText() + "'");
        try {
            if (f.rs.next()) {
                String status = f.rs.getString("status");
                if (status.equals("selesai")) {
                    t_idpel.setText(f.rs.getString("id_pelanggan"));
                    t_namapel.setText(f.rs.getString("nama"));
                    t_alamatpel.setText(f.rs.getString("alamat"));
                    t_hppel.setText(f.rs.getString("no_telp"));
                    t_tglmasuk.setText(f.rs.getString("tgl_masuk"));
                    t_totalbiaya.setText(f.rs.getString("total_biaya"));
                    tampilItem();
                    t_bayar.requestFocus();
                } else if (status.equals("diambil")) {
                    JOptionPane.showMessageDialog(null, "SUdah Diambil");
                } else {
                    JOptionPane.showMessageDialog(null, "Service Belum Selesai");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PengambilanService.class.getName()).log(Level.SEVERE, null, ex);
        }

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
        t_bayar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        t_tglmasuk = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        t_totalbiaya = new javax.swing.JTextField();
        datetoday = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        b_reset = new javax.swing.JButton();
        b_cetak = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        t_kembalian = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabel3 = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pengambilan Service");

        jPanel1.setBackground(new java.awt.Color(52, 152, 219));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pengambilan Service");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Pelanggan"));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("Id Pelanggan :");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Id Service :");

        t_idservice.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

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

        b_check.setText("Cari");
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(t_namapel)
                    .addComponent(t_alamatpel)
                    .addComponent(t_hppel)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(t_idservice, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_check, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(t_idpel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(t_idservice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_check))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(t_idpel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Transaksi"));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setText("Tanggal Masuk :");

        t_bayar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        t_bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_bayarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_bayarKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel14.setText("Bayar :");

        t_tglmasuk.setEditable(false);
        t_tglmasuk.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        t_tglmasuk.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel17.setText("Total Biaya:");

        t_totalbiaya.setEditable(false);
        t_totalbiaya.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        t_totalbiaya.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel12)
                .addGap(27, 27, 27)
                .addComponent(t_tglmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel14))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t_totalbiaya)
                    .addComponent(t_bayar))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(t_tglmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_totalbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        datetoday.setText("jLabel2");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));

        b_reset.setText("Clear");
        b_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_resetActionPerformed(evt);
            }
        });

        b_cetak.setText("Print");
        b_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(b_cetak, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(b_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(b_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(b_cetak, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Item"));

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
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel13.setText("*Klik Item untuk melihat detail sparepart");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kembalian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        t_kembalian.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        t_kembalian.setText("0");

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel15.setText("Rp. ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(t_kembalian)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(t_kembalian))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Sparepart"));

        tabel3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tabel3);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(datetoday))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(datetoday)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cetakActionPerformed
        if (t_idservice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Isi Id Service terlebih dahulu");
        } else {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            f.cud("update service set tgl_keluar = '" + dateFormat.format(date)
                    + "', status= 'diambil' where id = '" + t_idservice.getText()
                    + "'", "Kembalian : '" + t_kembalian.getText() + "'");
            DateFormat timeFormat = new SimpleDateFormat("HH:mm");
            String header
                    = "***************Pengambilan Service***************;"
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
                    + "Merk/Type     : " + tabel.getModel().getValueAt(0, 2).toString() + "/" + tabel.getModel().getValueAt(0, 5).toString() + "\n;"
                    + "Kelengkapan   : " + tabel.getModel().getValueAt(0, 4).toString() + "\n;"
                    + "Keluhan       : " + tabel.getModel().getValueAt(0, 3).toString() + "\n;"
                    + "Biaya Service : " + tabel.getModel().getValueAt(0, 6).toString() + "\n;";
            String sparePart = "";
            String detailSparepat = "";
            try {
                f.select("select * from sparepart where id_item =  '" + tabel.getModel().getValueAt(0, 1).toString() + "' ");
                System.out.println(tabel.getModel().getValueAt(0, 1).toString());
                if (!f.rs.isBeforeFirst()) {
                    sparePart = "";
                    System.out.println("No data sparepart");

                } else {
                    sparePart = "-------------------------------------------------\n;"
                            + "Sparepart\n;"
                            + "-------------------------------------------------\n;"
                            + "Name             Qty    Amount      Total   \n;"
                            + "+++++++++++++++++++++++++++++++++++++++++++++++++\n;";
                    while (f.rs.next()) {
                        detailSparepat += f.rs.getString("name")
                                + "             "
                                + f.rs.getString("qty")
                                + "       "
                                + f.rs.getString("price")
                                + "         " + f.rs.getString("sub_price") + "\n;";
                    }
                    detailSparepat
                            += "\n;+++++++++++++++++++++++++++++++++++++++++++++++++\n;"
                            + "Total SparePart:                 Rp." + tabel.getModel().getValueAt(0, 7).toString() + "\n;";
                }

                System.out.println(detailSparepat);
            } catch (Exception e) {
                System.out.println(e);

            }

            String footer
                    = "Total         : Rp." + tabel.getModel().getValueAt(0, 8).toString() + "\n;"
                    + "-------------------------------------------------\n;"
                    + "-------------------------------------------------\n;"
                    + "          Melayani Service 24 jam      \n ;"
                    + "          Dijamin Joss!!!!!!!!!!!      \n;"
                    + "**************************************************\n;"
                    + "               Thank You             \n;"
                    + "___________________________________________________\n;";
            String a = header + sparePart + detailSparepat + footer;
            printNow pn = new printNow();
            pn.printCard(a);
            Clear();
            detailSparepat = "";

        }
    }//GEN-LAST:event_b_cetakActionPerformed

    private void b_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_resetActionPerformed
        Clear();
    }//GEN-LAST:event_b_resetActionPerformed

    private void b_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_checkActionPerformed
        cariPelanggan();


    }//GEN-LAST:event_b_checkActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int row = tabel.getSelectedRow();
        iditem = tabel.getModel().getValueAt(row, 1).toString();
        System.out.println(iditem);
        tampilSparepart();
// TODO add your handling code here:
    }//GEN-LAST:event_tabelMouseClicked

    private void t_bayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_bayarKeyReleased
        t_kembalian.setText(Integer.toString(hitungTotal()));
//    t_total_biaya.setText(Integer.toString(result));

        // TODO add your handling code here:
    }//GEN-LAST:event_t_bayarKeyReleased

    private void t_bayarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_bayarKeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
                || (vChar == KeyEvent.VK_BACK_SPACE)
                || (vChar == KeyEvent.VK_DELETE))) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_t_bayarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cetak;
    private javax.swing.JButton b_check;
    private javax.swing.JButton b_reset;
    private javax.swing.JLabel datetoday;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField t_alamatpel;
    private javax.swing.JTextField t_bayar;
    private javax.swing.JTextField t_hppel;
    private javax.swing.JTextField t_idpel;
    private javax.swing.JTextField t_idservice;
    private javax.swing.JLabel t_kembalian;
    private javax.swing.JTextField t_namapel;
    private javax.swing.JTextField t_tglmasuk;
    private javax.swing.JTextField t_totalbiaya;
    private javax.swing.JTable tabel;
    private javax.swing.JTable tabel3;
    // End of variables declaration//GEN-END:variables
}
