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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import tienvm.Utils.MyConnection;
import tienvm.dtos.VoucherDTO;

/**
 *
 * @author TienVM_PC
 */
public class VoucherDAO {
    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    
    public void closeConnection() throws SQLException {
        if(conn != null)
            conn.close();
        if(pstm != null)
            pstm.close();
        if(rs != null)
            rs.close();
    }
    
    public List<VoucherDTO> listVoucher() throws SQLException {
        List<VoucherDTO> list = new ArrayList<>();
        try {
            String sql = "SELECT Code, UserID, Value, Name, ImportDate, BeginDate, CloseDate "
                    + "From tbl_Voucher WHERE Status = 'True'";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
                String code = rs.getString("Code");
                String userID = rs.getString("UserID");
                int value = rs.getInt("Value");
                String name = rs.getString("Name");
                Date importDate = rs.getDate("ImportDate");
                Date beginDate = rs.getDate("BeginDate");
                Date closeDate = rs.getDate("CloseDate");
                
                VoucherDTO vou = new VoucherDTO(code, userID, name, value, importDate, beginDate, closeDate);
                list.add(vou);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public VoucherDTO checkVoucher(String code, String userID) throws SQLException {
        VoucherDTO voucher = new VoucherDTO();
        try {
            String sql = "SELECT Code, UserID, Value, Name, BeginDate, CloseDate FROM tbl_Voucher "
                    + "WHERE UserID = ? AND Code = ? AND Status = '1'";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, userID);
            pstm.setString(2, code);
            rs = pstm.executeQuery();
            while (rs.next()) {
                code = rs.getString("Code");
                userID = rs.getString("UserID");
                int value = rs.getInt("Value");
                String name = rs.getString("Name");
                Date beginDate = rs.getDate("BeginDate");
                Date closeDate = rs.getDate("CloseDate");
                voucher = new VoucherDTO(code, userID, name, value, beginDate, closeDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return voucher;
    }
    
    public boolean insertVoucher(VoucherDTO vou) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            String sql = "INSERT INTO tbl_Voucher(Code, UserID, Value, Name, ImportDate, BeginDate, CloseDate, Status) "
                    + "VALUES(?,?,?,?,?,?,?,'True')";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, vou.getCode());
            pstm.setString(2, vou.getUserID());
            pstm.setInt(3, vou.getValue());
            pstm.setString(4, vou.getName());
            pstm.setDate(5, Date.valueOf(LocalDate.now()));
            pstm.setDate(6, vou.getBeginDate());
            pstm.setDate(7, vou.getCloseDate());
            check = pstm.executeUpdate()==0?false:true;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public void disableVoucher(String code, String userID) throws SQLException {
//        boolean check = false;
        try {
            String sql = "UPDATE tbl_Voucher SET Status = 0 WHERE Code = ? AND UserID = ?";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, code);
            pstm.setString(2, userID);
            int check = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
    
    public boolean deleteVoucher(String code, String userID) throws SQLException {
        boolean check = false;
        try {
            String sql = "UPDATE tbl_Voucher SET Status = 0 WHERE Code = ? AND UserID = ?";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, code);
            pstm.setString(2, userID);
            check = pstm.executeUpdate()==0?false:true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean updateVoucher(VoucherDTO vou) throws SQLException {
        boolean check = false;
        try {
            String sql = "UPDATE tbl_Voucher SET Value = ?, Name = ?, BeginDate = ?, CloseDate = ?, ImportDate = ? "
                    + "WHERE Code = ? AND UserID = ?";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, vou.getValue());
            pstm.setString(2, vou.getName());
            pstm.setDate(3, vou.getBeginDate());
            pstm.setDate(4, vou.getCloseDate());
            pstm.setDate(5, Date.valueOf(LocalDate.now()));
            pstm.setString(6, vou.getCode());
            pstm.setString(7, vou.getUserID());
            check = pstm.executeUpdate()==0?false:true;
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    
}
