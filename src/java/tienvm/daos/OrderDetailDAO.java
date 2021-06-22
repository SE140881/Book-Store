/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienvm.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tienvm.Utils.MyConnection;
import tienvm.dtos.OrderDetailDTO;

/**
 *
 * @author TienVM_PC
 */
public class OrderDetailDAO {
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
    
    public boolean insertOrderDetail(OrderDetailDTO order) throws SQLException {
        boolean check = false;
        try {
            String sql = "INSERT INTO tbl_OrderDetail(OrderID, BookID, Price, Quantity, Tittle) VALUES(?,?,?,?,?)";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, order.getOrderID());
            pstm.setString(2, order.getBookID());
            pstm.setFloat(3, order.getPrice());
            pstm.setInt(4, order.getQuantity());
            pstm.setString(5, order.getTittle());
            check = pstm.executeUpdate()==0?false:true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }

}
