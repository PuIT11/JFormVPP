/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form;


import Data.DBConnection;
import Data.UserAccount;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kimdo
 */
public class FPhanQuyen extends javax.swing.JFrame {

    private UserAccount loggedInUser;
    
    public FPhanQuyen(UserAccount loggedInUser) {
        initComponents();
        Connection connection = DBConnection.getConnection();  
        setLocationRelativeTo(null);
        this.loggedInUser = loggedInUser;
        this.dispose();
        FillMH(connection);
    }

    private FPhanQuyen() {
        
    }
    
    public void FillMH(Connection connection){
        DefaultTableModel modelQuanLy = (DefaultTableModel) tblQuanLy.getModel();
        DefaultTableModel modelNV = (DefaultTableModel) tbNV.getModel();
    
        modelQuanLy.setRowCount(0); 
        modelNV.setRowCount(0); 
    
        String sql = "SELECT * FROM NHAN_VIEN";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String MaNhanVien = resultSet.getString("MaNhanVien");
                String TenDangNhap = resultSet.getString("TenDangNhap");
                String sdt = resultSet.getString("sdt"); 
                String diachi = resultSet.getString("diachi");
                boolean LaQuanLy = resultSet.getBoolean("LAQUANLY");

                Object[] rowData = {
                    MaNhanVien,
                    TenDangNhap,
                    sdt,
                    diachi,
                    LaQuanLy,
                };

                 if (!LaQuanLy ) {
                     modelNV.addRow(rowData); 
                 }else {
                     modelQuanLy.addRow(rowData); 
                 }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FMatHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblQuanLy = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNV = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btXacNhan2 = new javax.swing.JButton();
        btXacNhan1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Danh sách nhân viên");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblQuanLy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Số điện thoại", "Địa chỉ", "Quản lý"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblQuanLy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanLyMouseClicked(evt);
            }
        });
        tblQuanLy.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblQuanLyPropertyChange(evt);
            }
        });
        jScrollPane5.setViewportView(tblQuanLy);
        if (tblQuanLy.getColumnModel().getColumnCount() > 0) {
            tblQuanLy.getColumnModel().getColumn(4).setPreferredWidth(65);
            tblQuanLy.getColumnModel().getColumn(4).setMaxWidth(65);
        }

        tbNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Số diện thoại", "Địa chỉ", "Quản lý"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbNV.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbNVPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tbNV);
        if (tbNV.getColumnModel().getColumnCount() > 0) {
            tbNV.getColumnModel().getColumn(4).setPreferredWidth(65);
            tbNV.getColumnModel().getColumn(4).setMaxWidth(65);
        }

        jLabel1.setText("Nhân viên ");

        jLabel2.setText("Nhân viên quản lý");

        btXacNhan2.setText("Xác nhận ");
        btXacNhan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXacNhan2ActionPerformed(evt);
            }
        });

        btXacNhan1.setText("Xác nhận");
        btXacNhan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXacNhan1ActionPerformed(evt);
            }
        });

        jButton1.setText("Trở lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btXacNhan1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(53, 53, 53)
                            .addComponent(btXacNhan2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btXacNhan1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btXacNhan2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void tblQuanLyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanLyMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblQuanLyMouseClicked

    private void tbNVPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbNVPropertyChange
        // TODO add your handling code here:
                                                
    }//GEN-LAST:event_tbNVPropertyChange

    public void XacNhanMKQuanLY() {
        Connection connection = DBConnection.getConnection();

        int selectedRow = tblQuanLy.getSelectedRow();

        if (selectedRow != -1) {
            String maNhanVien = (String) tblQuanLy.getValueAt(selectedRow, 0);
            String tenNhanVien = (String) tblQuanLy.getValueAt(selectedRow, 1);
            String SDT = (String) tblQuanLy.getValueAt(selectedRow, 2);
            String diachi = (String) tblQuanLy.getValueAt(selectedRow,3);
            boolean LAQUANLY = (boolean) tblQuanLy.getValueAt(selectedRow, 4);

            String updateSQL = "UPDATE NHAN_VIEN SET LAQUANLY = ? WHERE MaNhanVien = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
                preparedStatement.setBoolean(1, LAQUANLY);
                preparedStatement.setString(2, maNhanVien);
              
                int rowsUpdated = preparedStatement.executeUpdate();

                if (rowsUpdated > 0) {
                    FillMH(connection);
                }
            } catch (SQLException ex) {
                Logger.getLogger(FMatHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void XacNhanMKNhanVien() {
        Connection connection = DBConnection.getConnection();

        int selectedRow = tbNV.getSelectedRow();

        if (selectedRow != -1) {
            String maNhanVien = (String) tbNV.getValueAt(selectedRow, 0);
            String tenNhanVien = (String) tbNV.getValueAt(selectedRow, 1);
            String SDT = (String) tbNV.getValueAt(selectedRow, 2);
            String diachi = (String) tbNV.getValueAt(selectedRow,3);
            boolean LAQUANLY = (boolean) tbNV.getValueAt(selectedRow, 4);

            String updateSQL = "UPDATE NHAN_VIEN SET LAQUANLY = ? WHERE MaNhanVien = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
                preparedStatement.setBoolean(1, LAQUANLY);
                preparedStatement.setString(2, maNhanVien);
              
                int rowsUpdated = preparedStatement.executeUpdate();

                if (rowsUpdated > 0) {
                    FillMH(connection);
                }
            } catch (SQLException ex) {
                Logger.getLogger(FMatHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    private void btXacNhan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXacNhan2ActionPerformed
        FXacNhan matkhau = new FXacNhan(loggedInUser);
        matkhau.setVisible(true);
        XacNhanMKNhanVien();    
    }//GEN-LAST:event_btXacNhan2ActionPerformed

    private void btXacNhan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXacNhan1ActionPerformed
        FXacNhan matkhau = new FXacNhan(loggedInUser);
        matkhau.setVisible(true);  
        XacNhanMKQuanLY();
    }//GEN-LAST:event_btXacNhan1ActionPerformed

    private void tblQuanLyPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblQuanLyPropertyChange
        // TODO add your handling code here:
   
    }//GEN-LAST:event_tblQuanLyPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FPhanQuyen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPhanQuyen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPhanQuyen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPhanQuyen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FPhanQuyen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btXacNhan1;
    private javax.swing.JButton btXacNhan2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tbNV;
    private javax.swing.JTable tblQuanLy;
    // End of variables declaration//GEN-END:variables
}
