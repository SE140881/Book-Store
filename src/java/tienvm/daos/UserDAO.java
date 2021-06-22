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
import java.util.ArrayList;
import java.util.List;
import tienvm.Utils.MyConnection;
import tienvm.dtos.UserDTO;

/**
 *
 * @author TienVM_PC
 */
public class UserDAO {
    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    
    public void closeConnection() throws SQLException{
        if(conn != null)
            conn.close();
        if(pstm != null)
            pstm.close();
        if(rs != null)
            rs.close();
    }
    
    public UserDTO checkLogin(String userID, String password) throws SQLException{
        UserDTO user = null;
        try {
            String sql = "SELECT UserName, Address, Phone, Email, RoleID, UserID FROM tbl_Users WHERE UserID = ? AND Password = ?";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, userID);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            if(rs.next()){
                String userName = rs.getString("UserName");
                String id = rs.getString("UserID");
                String roleID = rs.getString("RoleID");
                String address = rs.getString("Address");
                String phone = rs.getString("Phone");
                String email = rs.getString("Email");
                user = new UserDTO(userID, userName, address, phone, email, roleID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return user;
    }
    
    public List<UserDTO> listUser() throws SQLException{
        List<UserDTO> list = null;
        UserDTO user = null;
        try {
            String sql = "SELECT UserID, UserName, Address, Email, Phone, RoleID FROM tbl_Users";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            list = new ArrayList<>();
            while(rs.next()){
                String userID = rs.getString("UserID");
                String userName = rs.getString("UserName");
                String address = rs.getString("Address");
                String email = rs.getString("Email");
                String phone = rs.getString("Phone");
                String roleID = rs.getString("RoleID");
                user = new UserDTO(userID, userName, address, phone, email, roleID);
                list.add(user);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public List<UserDTO> findUserByName(String search) throws SQLException{
        List<UserDTO> list = null;
        UserDTO user = null;
        try {
            String sql = "SELECT UserID, UserName, Address, Email, Phone, RoleID FROM tbl_Users WHERE UserName LIKE ?";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, "%" + search + "%");
            rs = pstm.executeQuery();
            list = new ArrayList<>();
            while(rs.next()){
                String userID = rs.getString("UserID");
                String userName = rs.getString("UserName");
                String address = rs.getString("Address");
                String email = rs.getString("Email");
                String phone = rs.getString("Phone");
                String roleID = rs.getString("RoleID");
                user = new UserDTO(userID, userName, address, phone, email, roleID);
                list.add(user);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public boolean createUser(UserDTO user) throws SQLException, ClassNotFoundException{
        boolean check = false;
        try {
            String sql = "INSERT into tbl_Users(UserID, UserName, Address, Phone, Email, Password, RoleID) "
                    + "VALUES (?,?,?,?,?,?,'US')";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getUserID());
            pstm.setString(2, user.getUserName());
            pstm.setString(3, user.getAddress());
            pstm.setString(4, user.getPhone());
            pstm.setString(5, user.getEmail());
            pstm.setString(6, user.getPassword());
            check = pstm.executeUpdate()==0?false:true;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean updateUser(UserDTO user) throws SQLException{
        boolean check = false;
        try {
            String sql = "UPDATE tbl_Users SET UserName = ?, Address = ?, Phone = ?, Email = ?, RoleID = ? WHERE UserID = ?";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getUserName());
            pstm.setString(2, user.getAddress());
            pstm.setString(3, user.getPhone());
            pstm.setString(4, user.getEmail());
            pstm.setString(5, user.getRoleID());
            pstm.setString(6, user.getUserID());
            check = pstm.executeUpdate()==0?false:true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteUser(String userID) throws SQLException{
        boolean check = false;
        try {
            String sql = "DELETE FROM tbl_Users WHERE userID = ?";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, userID);
            check = pstm.executeUpdate()==0?false:true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
}
