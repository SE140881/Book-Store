/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienvm.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import tienvm.Utils.MyConnection;
import tienvm.dtos.OrderDetailDTO;

/**
 *
 * @author TienVM_PC
 */
public class OrderDAO {
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    
    public void closeConnection() throws SQLException {
        if(conn != null)
            conn.close();
        if(pstm != null)
            pstm.close();
        if(rs != null)
            rs.close();
    }
    
    public boolean insertOrder(String userID, float total, String address) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            String sql = "INSERT INTO tbl_Order (UserID, Date, Total, Address) VALUES (?,?,?,?)";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, userID);
            pstm.setDate(2, Date.valueOf(LocalDate.now()));
            pstm.setFloat(3, total);
            pstm.setString(4, address);
            check = pstm.executeUpdate()==0?false:true;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public int getIDOrder(String userID) throws SQLException {
        int id = 0;
        try {
            String sql = "SELECT OrderID FROM tbl_Order WHERE userID = ?";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, userID);
            rs = pstm.executeQuery();
            while(rs.next())
                id = rs.getInt("OrderID");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return id;
    }
    
}
