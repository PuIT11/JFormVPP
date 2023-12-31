/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form;

import Data.DBConnection;
import Data.MatHang;
import Data.UserAccount;
import java.beans.Statement;
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
public class FLoaiMH extends javax.swing.JFrame {
    
    public FLoaiMH() {
        initComponents(); 
        setLocationRelativeTo(null);
        
        try{          
            Connection connection = DBConnection.getConnection();
            FillLH(connection);
            connection.close();
        }catch (SQLException ex) {
            Logger.getLogger(FMatHang.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Lỗi kết nối đến cơ sở dữ liệu.");
        }   
    }
    
    public void FillLH(Connection connection){
        DefaultTableModel model = (DefaultTableModel) tblLoai.getModel();
        model.setRowCount(0);
        
        String sql = "SELECT * FROM LOAI_MAT_HANG";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while(resultSet.next()){
                String MaLoai = resultSet.getString("MaLoai");
                String TenLoai = resultSet.getString("TenLoai");
                boolean VoHieuHoa = resultSet.getBoolean("VoHieuHoa");
                
                Object[] rowData = {
                    MaLoai,  
                    TenLoai,   
                    VoHieuHoa  
                };
                model.addRow(rowData);
            }
        }catch (SQLException ex) {
            Logger.getLogger(FMatHang.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblLoai = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenLoai = new javax.swing.JTextField();
        cbVoHieuHoa = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnThem = new javax.swing.JMenu();
        btnSua = new javax.swing.JMenu();
        btnXoa = new javax.swing.JMenu();
        btnQuayLai = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Danh sách loại mặt hàng");
        setBackground(new java.awt.Color(0, 102, 102));

        tblLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã loại", "Tên loại", "Vô hiệu hóa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLoai);
        if (tblLoai.getColumnModel().getColumnCount() > 0) {
            tblLoai.getColumnModel().getColumn(2).setPreferredWidth(85);
            tblLoai.getColumnModel().getColumn(2).setMaxWidth(85);
        }

        jLabel1.setText("Mã loại mặt hàng ");

        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        jLabel2.setText("Mặt hàng ");

        cbVoHieuHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVoHieuHoaActionPerformed(evt);
            }
        });

        jLabel3.setText("Vô hiệu hóa");

        jMenuBar1.setBackground(new java.awt.Color(0, 102, 102));

        btnThem.setText("Thêm");
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnThem);

        btnSua.setText("Sửa");
        btnSua.setFocusTraversalPolicyProvider(true);
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnSua);

        btnXoa.setText("Xóa");
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnXoa);

        btnQuayLai.setText("Quay lại");
        btnQuayLai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnQuayLai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuayLaiMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnQuayLai);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(cbVoHieuHoa))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(txtTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 104, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbVoHieuHoa)
                    .addComponent(jLabel3))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    private void tblLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiMouseClicked
        int selectRow = tblLoai.getSelectedRow();
        
        if(selectRow >= 0 ){           
            String MaLoai = (String) tblLoai.getValueAt(selectRow, 0);
            String TenLoai = (String) tblLoai.getValueAt(selectRow, 1);
            boolean VoHieuHoa = (boolean) tblLoai.getValueAt(selectRow, 2);
            
            txtMa.setText(MaLoai);
            txtTenLoai.setText(TenLoai);
            cbVoHieuHoa.setSelected(VoHieuHoa);
        }
    }//GEN-LAST:event_tblLoaiMouseClicked

    private void cbVoHieuHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVoHieuHoaActionPerformed
        
    }//GEN-LAST:event_cbVoHieuHoaActionPerformed

    public void reloadTable(Connection connection){
        DefaultTableModel model = (DefaultTableModel) tblLoai.getModel();
        model.setRowCount(0);
        FillLH(connection);
    }

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
        Connection connection = DBConnection.getConnection();
        int selectRow = tblLoai.getSelectedRow();
                
        String MaLoai = txtMa.getText();
        String TenLoai = txtTenLoai.getText();
        boolean VoHieuHoa = cbVoHieuHoa.isSelected();
        
        if (selectRow >=0){
            int option = JOptionPane.showConfirmDialog(this, "Bạn nuốn thêm loại hàng không ?");
            System.out.println("option : " + option);
            
            String sqlInsert = "INSERT INTO LOAI_MAT_HANG (MaLoai, TenLoai,VoHieuHoa) VALUES (?, ?, ?)";
            
            if(option == 0){
                try (PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert)) {
                    preparedStatement.setString(1, MaLoai);
                    preparedStatement.setString(2, TenLoai);
                    preparedStatement.setBoolean(3, VoHieuHoa);
                    int rowsInserted = preparedStatement.executeUpdate();
                        if (rowsInserted > 0) {
                            reloadTable(connection);

                            txtMa.setText("");
                            txtTenLoai.setText("");                        
                            cbVoHieuHoa.setSelected(false);
                        }
                } catch (SQLException ex) {
                    Logger.getLogger(FMatHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }   
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        Connection connection = DBConnection.getConnection();
        int selectRow = tblLoai.getSelectedRow();

        if (selectRow >= 0) {
            String MaLoai = txtMa.getText();
            int option = JOptionPane.showConfirmDialog(this, "Muốn xóa loại mặt hàng này không ?");

            if (option == 0) {
                deleteLoaiMatHang(connection, MaLoai);
                reloadTable(connection);
            }
        }
    }//GEN-LAST:event_btnXoaMouseClicked
    
    private void deleteLoaiMatHang(Connection connection, String MaLoai) {
        String sqlDelete = "DELETE FROM LOAI_MAT_HANG WHERE MaLoai = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete)) {
            preparedStatement.setString(1, MaLoai);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Xóa thành công.");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa không thành công.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FLoaiMH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseClicked
        Connection connection = DBConnection.getConnection();   
        int selectRow = tblLoai.getSelectedRow();

        String MaLoai = txtMa.getText();
        String TenLoai = txtTenLoai.getText();
        boolean VoHieuHoa = cbVoHieuHoa.isSelected();

        if (selectRow >= 0){
            int option = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa thông tin không ?");

            if (option == 0){
                String sqlUpdate = "UPDATE LOAI_MAT_HANG SET TenLoai = ?, VoHieuHoa = ? WHERE MaLoai = ?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate)) {
                    preparedStatement.setString(1, TenLoai);
                    preparedStatement.setBoolean(2, VoHieuHoa);
                    preparedStatement.setString(3, MaLoai); 

                    int rowsUpdated = preparedStatement.executeUpdate();

                    if (rowsUpdated > 0) {
                        reloadTable(connection);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FMatHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }         
    }//GEN-LAST:event_btnSuaMouseClicked

    private void btnQuayLaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuayLaiMouseClicked
        // TODO add your handling code here:
        FMatHang frm = new  FMatHang();
        frm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnQuayLaiMouseClicked

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
            java.util.logging.Logger.getLogger(FLoaiMH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FLoaiMH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FLoaiMH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FLoaiMH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FLoaiMH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnQuayLai;
    private javax.swing.JMenu btnSua;
    private javax.swing.JMenu btnThem;
    private javax.swing.JMenu btnXoa;
    private javax.swing.JCheckBox cbVoHieuHoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLoai;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTenLoai;
    // End of variables declaration//GEN-END:variables
}
