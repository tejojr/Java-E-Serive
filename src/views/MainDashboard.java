/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import components.DaftarService;
import components.DataService;
import components.DataType;
import components.PengambilanService;
import components.Teknisi;
import components.TeknisiService;
import components.User;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zeref
 */
public class MainDashboard extends javax.swing.JFrame {

    /**
     * Creates new form MainDashboard
     */
    public MainDashboard() {
        initComponents();
        setExtendedState(MainDashboard.MAXIMIZED_BOTH);
        if (Login1.role.equals("admin")) {
            m_service.setVisible(false);
            m_teknisi.setVisible(false);

        } else if (Login1.role.equals("user")) {
            m_pegawai.setVisible(false);
            m_laporan.setVisible(false);
            m_teknisi.setVisible(false);
        } else {
            m_pegawai.setVisible(false);
            m_laporan.setVisible(false);
            m_service.setVisible(false);
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

        Desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        m_file = new javax.swing.JMenu();
        mi_logout = new javax.swing.JMenuItem();
        m_service = new javax.swing.JMenu();
        mi_daftar = new javax.swing.JMenuItem();
        mi_dataservice = new javax.swing.JMenuItem();
        mi_pengambilan = new javax.swing.JMenuItem();
        mi_ditem = new javax.swing.JMenuItem();
        m_teknisi = new javax.swing.JMenu();
        mi_service = new javax.swing.JMenuItem();
        m_pegawai = new javax.swing.JMenu();
        mi_user = new javax.swing.JMenuItem();
        mi_teknisi = new javax.swing.JMenuItem();
        m_laporan = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FaZtService");
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        jMenuBar1.setName("Master"); // NOI18N

        m_file.setText("File");

        mi_logout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        mi_logout.setText("LogOut");
        mi_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_logoutActionPerformed(evt);
            }
        });
        m_file.add(mi_logout);

        jMenuBar1.add(m_file);

        m_service.setText("Service");

        mi_daftar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        mi_daftar.setText("Daftar");
        mi_daftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_daftarActionPerformed(evt);
            }
        });
        m_service.add(mi_daftar);

        mi_dataservice.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        mi_dataservice.setText("Data ");
        mi_dataservice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_dataserviceActionPerformed(evt);
            }
        });
        m_service.add(mi_dataservice);

        mi_pengambilan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        mi_pengambilan.setText("Pengambilan");
        mi_pengambilan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_pengambilanActionPerformed(evt);
            }
        });
        m_service.add(mi_pengambilan);

        mi_ditem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        mi_ditem.setText("Data Type Item");
        mi_ditem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_ditemActionPerformed(evt);
            }
        });
        m_service.add(mi_ditem);

        jMenuBar1.add(m_service);

        m_teknisi.setText("Teknisi");

        mi_service.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        mi_service.setText("Data Service");
        mi_service.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_serviceActionPerformed(evt);
            }
        });
        m_teknisi.add(mi_service);

        jMenuBar1.add(m_teknisi);

        m_pegawai.setText("Pegawai");

        mi_user.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        mi_user.setText("User");
        mi_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_userActionPerformed(evt);
            }
        });
        m_pegawai.add(mi_user);

        mi_teknisi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        mi_teknisi.setText("Teknisi");
        mi_teknisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_teknisiActionPerformed(evt);
            }
        });
        m_pegawai.add(mi_teknisi);

        jMenuBar1.add(m_pegawai);

        m_laporan.setText("Laporan");
        jMenuBar1.add(m_laporan);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mi_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_logoutActionPerformed
        this.dispose();
        new Login1().setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_mi_logoutActionPerformed

    private void mi_pengambilanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_pengambilanActionPerformed
        PengambilanService ps = new PengambilanService();
        Desktop.add(ps);
        ps.setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_mi_pengambilanActionPerformed

    private void mi_daftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_daftarActionPerformed
        DaftarService daftars = new DaftarService();
        Desktop.add(daftars);
        daftars.setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_mi_daftarActionPerformed

    private void mi_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_userActionPerformed
        User u = new User();
        Desktop.add(u);
        u.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_mi_userActionPerformed

    private void mi_teknisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_teknisiActionPerformed
        Teknisi t = new Teknisi();
        Desktop.add(t);
        t.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_mi_teknisiActionPerformed

    private void mi_serviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_serviceActionPerformed
        TeknisiService ts = new TeknisiService();
        Desktop.add(ts);
        ts.setVisible(true);
        try {
            ts.setMaximum(true);// TODO add your handling code here:
            // TODO add your handling code here:
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mi_serviceActionPerformed

    private void mi_dataserviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_dataserviceActionPerformed
        DataService datas = new DataService();
        Desktop.add(datas);
        datas.setVisible(true);
        try {
            datas.setMaximum(true);// TODO add your handling code here:
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mi_dataserviceActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void mi_ditemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_ditemActionPerformed
        DataType datap = new DataType();
        Desktop.add(datap);
        datap.setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_mi_ditemActionPerformed

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
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu m_file;
    private javax.swing.JMenu m_laporan;
    private javax.swing.JMenu m_pegawai;
    private javax.swing.JMenu m_service;
    private javax.swing.JMenu m_teknisi;
    private javax.swing.JMenuItem mi_daftar;
    private javax.swing.JMenuItem mi_dataservice;
    private javax.swing.JMenuItem mi_ditem;
    private javax.swing.JMenuItem mi_logout;
    private javax.swing.JMenuItem mi_pengambilan;
    private javax.swing.JMenuItem mi_service;
    private javax.swing.JMenuItem mi_teknisi;
    private javax.swing.JMenuItem mi_user;
    // End of variables declaration//GEN-END:variables
}
