/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Data.DBConnection;
import Data.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Lenovo
 */
public class DBTaiKhoan {
     public UserAccount getUserAccountFromDatabase(String username) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        UserAccount user = null;

        try {
            connection = DBConnection.getConnection(); 
            String sql = "SELECT * FROM NHAN_VIEN WHERE TENDANGNHAP = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String userId = resultSet.getString("ID"); 
                String userName = resultSet.getString("TENDANGNHAP");
                String password = resultSet.getString("MATKHAU");
                boolean isLaQuanLy = resultSet.getBoolean("LAQUANLY"); 

                user = new UserAccount(userId, userName, password, isLaQuanLy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection); 
        }

        return user;
    }
  
}
