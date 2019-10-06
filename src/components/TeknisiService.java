/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import configs.functions;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import views.Login1;

/**
 *
 * @author Zeref
 */
public class TeknisiService extends javax.swing.JInternalFrame {

    functions f = new functions();
    String jenis,id_item;

    private void tampil() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Barang");
        model.addColumn("Service ID");
        model.addColumn("Merk");
        model.addColumn("Keluhan");
        model.addColumn("Kelengkapan");
        model.addColumn("Jenis");
        model.addColumn("Biaya Spare Part");
        model.addColumn("Biaya Service");
        model.addColumn("Total Biaya Service");
        model.addColumn("Status");
        model.addColumn("Tanggal Masuk");

        try {
            String cari = this.cari.getText();
            String basicQuery = "SELECT item.id as idbarang,service.id, item.merk, item.keluhan, item.kelengkapan, jenis.name as jenis, item.biaya_service,item.totbiaya_spare_part,item.total_biaya,item.status,service.tgl_masuk FROM item INNER JOIN service on item.id_service = service.id INNER join  jenis on item.id_jenis = jenis.id where jenis.name = '" + jenis + "'";
            if (r_diproses.isSelected()) {
                if (cari.length() > 0) {
                    f.select(basicQuery + " and item.status = 'diproses' and service.id like '%"
                            + cari + "%' or item.merk like '%"
                            + cari + "%' or jenis.name like '%"
                            + cari + "%' or or service.tgl_masuk like '%"
                            + cari + "%' order by tgl_masuk asc ");
                } else {
                    f.select(basicQuery + " and item.status = 'diproses' order by tgl_masuk asc");

                }
            } else if (r_diterima.isSelected()) {
                if (cari.length() > 0) {
                    f.select(basicQuery + " and item.status = 'diterima'and service.id like '%"
                            + cari + "%' or item.merk like '%"
                            + cari + "%' or jenis.name like '%"
                            + cari + "%' or or service.tgl_masuk like '%"
                            + cari + "%' order by tgl_masuk asc ");
                } else {
                    f.select(basicQuery + " and item.status = 'diterima' order by tgl_masuk asc");

                }
            } else if (r_selesai.isSelected()) {
                if (cari.length() > 0) {
                    f.select(basicQuery + " and item.status = 'selesai' and service.id like '%"
                            + cari + "%' or item.merk like '%"
                            + cari + "%' or jenis.name like '%"
                            + cari + "%' or or service.tgl_masuk like '%"
                            + cari + "%' order by tgl_masuk asc ");
                } else {
                    f.select(basicQuery + " and item.status = 'selesai' order by tgl_masuk asc");

                }
            } else {
                if (cari.length() > 0) {
                    f.select(basicQuery + " and service.id like '%"
                            + cari + "%' or item.merk like '%"
                            + cari + "%' or jenis.name like '%"
                            + cari + "%' or or service.tgl_masuk like '%"
                            + cari + "%' order by tgl_masuk asc ");
                } else {
                    f.select(basicQuery + " order by tgl_masuk asc");

                }

            }

            int no = 1;
            while (f.rs.next()) {
                model.addRow(new Object[]{
                    f.rs.getString("idbarang"),
                    f.rs.getString("id"),
                    f.rs.getString("merk"),
                    f.rs.getString("keluhan"),
                    f.rs.getString("kelengkapan"),
                    f.rs.getString("jenis"),
                    f.rs.getString("totbiaya_spare_part"),
                    f.rs.getString("biaya_service"),
                    f.rs.getString("total_biaya"),
                    f.rs.getString("status"),
                    f.rs.getString("tgl_masuk"),});

            }
            tabel.setModel(model);
        } catch (SQLException e) {
            System.out.println(e);

        }

    }

    private void checkJenis() {

        try {
            f.select("SELECT * from jenis where id_teknisi = '" + Login1.id + "'");
            if (f.rs.next()) {
                jenis = f.rs.getString("name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeknisiService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void Clear(){
        id_item = "";
        t_idservice2.setText("");
        t_merk.setText("");
        t_keluhan.setText("");
        t_kelengkapan.setText("");
        t_jenis.setText("");
        t_biaya_service.setText("");
        t_sparepart.setText("");
        t_total_biaya.setText("");
        cmb_status.setSelectedItem("");
        t_tgl.setText("");
    }
    /**
     * Creates new form TeknisiService
     */
    public TeknisiService() {
        initComponents();
        r_all.setSelected(true);
        Clear();
        DateFormat dateFormat = new SimpleDateFormat("dd MMMMM yyyy");
        Date date = new Date();
        datetoday.setText(dateFormat.format(date));
        checkJenis();
        tampil();
        jLabel1.setText("Data Service " + jenis.toUpperCase());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        datetoday = new javax.swing.JLabel();
        b_refresh = new javax.swing.JButton();
        cari = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        r_selesai = new javax.swing.JRadioButton();
        r_diterima = new javax.swing.JRadioButton();
        r_diproses = new javax.swing.JRadioButton();
        r_all = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        show = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        t_idservice2 = new javax.swing.JTextField();
        t_sparepart = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        t_merk = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        t_keluhan = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        t_kelengkapan = new javax.swing.JTextField();
        t_jenis = new javax.swing.JTextField();
        cmb_status = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        t_biaya_service = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        t_total_biaya = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        t_tgl = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        b_check2 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        b_clear = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Teknisi Service");

        jPanel1.setBackground(new java.awt.Color(52, 152, 219));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Service");

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
                .addContainerGap(23, Short.MAX_VALUE))
        );

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

        datetoday.setText("jLabel2");

        b_refresh.setText("Refresh");
        b_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_refreshActionPerformed(evt);
            }
        });

        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter"));

        buttonGroup1.add(r_selesai);
        r_selesai.setText("Selesai");

        buttonGroup1.add(r_diterima);
        r_diterima.setText("Diterima");
        r_diterima.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                r_diterimaItemStateChanged(evt);
            }
        });

        buttonGroup1.add(r_diproses);
        r_diproses.setText("Diproses");

        buttonGroup1.add(r_all);
        r_all.setText("All");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(r_diterima)
                .addGap(18, 18, 18)
                .addComponent(r_diproses)
                .addGap(18, 18, 18)
                .addComponent(r_selesai)
                .addGap(18, 18, 18)
                .addComponent(r_all)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_diterima)
                    .addComponent(r_diproses)
                    .addComponent(r_selesai)
                    .addComponent(r_all))
                .addContainerGap())
        );

        jLabel2.setText("Cari");

        show.setText("Show");
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Item Detail"));

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel17.setText("Biaya Spare Part :");

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel18.setText("Id Service :");

        t_idservice2.setEditable(false);
        t_idservice2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        t_idservice2.setEnabled(false);
        t_idservice2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_idservice2ActionPerformed(evt);
            }
        });

        t_sparepart.setEditable(false);
        t_sparepart.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        t_sparepart.setEnabled(false);

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel25.setText("Jenis :");

        jLabel22.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel22.setText("Merk :");

        t_merk.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        t_merk.setEnabled(false);

        jLabel24.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel24.setText("Keluhan : ");

        t_keluhan.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        t_keluhan.setEnabled(false);

        jLabel23.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel23.setText("Kelengkapan :");

        t_kelengkapan.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        t_kelengkapan.setEnabled(false);

        t_jenis.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        t_jenis.setEnabled(false);

        cmb_status.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmb_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "diterima", "diproses", "selesai" }));

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel19.setText("Status :");

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel26.setText("Biaya Service : ");

        t_biaya_service.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel27.setText("Total Biaya : ");

        t_total_biaya.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        t_total_biaya.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel28.setText("Tanggal masuk : ");

        t_tgl.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        t_tgl.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel22)
                    .addComponent(jLabel18))
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(t_keluhan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(t_merk, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(t_idservice2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(t_jenis, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(t_kelengkapan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel17)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_total_biaya, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(t_biaya_service)
                                .addComponent(cmb_status, 0, 201, Short.MAX_VALUE)
                                .addComponent(t_sparepart))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(t_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(t_idservice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(t_jenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(t_sparepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(t_merk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(t_biaya_service, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(t_keluhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(t_total_biaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(t_kelengkapan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(t_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));

        b_check2.setText("Add Spare Part");
        b_check2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_check2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(b_check2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(b_check2)
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Action"));

        jButton1.setText("Update");

        b_clear.setText("Clear");
        b_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(b_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(b_refresh)
                                    .addComponent(show, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(datetoday)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(datetoday)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(b_refresh)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(show))))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_refreshActionPerformed
        tampil();        // TODO add your handling code here:
    }//GEN-LAST:event_b_refreshActionPerformed

    private void cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyReleased
        tampil();        // TODO add your handling code here:
    }//GEN-LAST:event_cariKeyReleased

    private void r_diterimaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_r_diterimaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_r_diterimaItemStateChanged

    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed
        tampil();        // TODO add your handling code here:
    }//GEN-LAST:event_showActionPerformed

    private void b_check2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_check2ActionPerformed
        DialogPelanggan dp = new DialogPelanggan(null, true);
        dp.setVisible(true);
        t_idpel.setText(dp.id);
        t_namapel.setText(dp.nama);// TODO add your handling code here:
        t_alamatpel.setText(dp.alamat);// TODO add your handling code here:
        t_hppel.setText(dp.notelp);// TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_b_check2ActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int row = tabel.getSelectedRow();
        id_item = tabel.getModel().getValueAt(row, 0).toString();
        t_idservice2.setText(tabel.getModel().getValueAt(row, 1).toString());
        t_merk.setText( tabel.getModel().getValueAt(row, 2).toString());
        t_keluhan.setText(tabel.getModel().getValueAt(row, 3).toString());
        t_kelengkapan.setText(tabel.getModel().getValueAt(row, 4).toString());
        t_jenis.setText(tabel.getModel().getValueAt(row, 5).toString());
        t_biaya_service.setText(tabel.getModel().getValueAt(row, 6).toString());
        t_sparepart.setText(tabel.getModel().getValueAt(row, 7).toString());
        t_total_biaya.setText(tabel.getModel().getValueAt(row, 8).toString());
        cmb_status.setSelectedItem(tabel.getModel().getValueAt(row, 9).toString());
        t_tgl.setText(tabel.getModel().getValueAt(row, 10).toString());
// TODO add your handling code here:
    }//GEN-LAST:event_tabelMouseClicked

    private void t_idservice2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_idservice2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_idservice2ActionPerformed

    private void b_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_clearActionPerformed
        Clear();        // TODO add your handling code here:
    }//GEN-LAST:event_b_clearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_check;
    private javax.swing.JButton b_check1;
    private javax.swing.JButton b_check2;
    private javax.swing.JButton b_check3;
    private javax.swing.JButton b_clear;
    private javax.swing.JButton b_refresh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cari;
    private javax.swing.JComboBox<String> cmb_status;
    private javax.swing.JLabel datetoday;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton r_all;
    private javax.swing.JRadioButton r_diproses;
    private javax.swing.JRadioButton r_diterima;
    private javax.swing.JRadioButton r_selesai;
    private javax.swing.JButton show;
    private javax.swing.JTextField t_alamatpel;
    private javax.swing.JTextField t_alamatpel1;
    private javax.swing.JTextField t_biaya_service;
    private javax.swing.JTextField t_hppel;
    private javax.swing.JTextField t_hppel1;
    private javax.swing.JTextField t_idpel;
    private javax.swing.JTextField t_idpel1;
    private javax.swing.JTextField t_idservice;
    private javax.swing.JTextField t_idservice1;
    private javax.swing.JTextField t_idservice2;
    private javax.swing.JTextField t_jenis;
    private javax.swing.JTextField t_kelengkapan;
    private javax.swing.JTextField t_keluhan;
    private javax.swing.JTextField t_merk;
    private javax.swing.JTextField t_namapel;
    private javax.swing.JTextField t_namapel1;
    private javax.swing.JTextField t_sparepart;
    private javax.swing.JTextField t_tgl;
    private javax.swing.JTextField t_total_biaya;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
