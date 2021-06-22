/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienvm.dtos;

import java.io.Serializable;

/**
 *
 * @author TienVM_PC
 */
public class UserDTO implements Serializable{
    private String userID;
    private String userName;
    private String address;
    private String phone;
    private String email;
    private String password;
    private String roleID;

    public UserDTO() {
    }
    
    public UserDTO(String userID, String userName, String roleID) {
        this.userID = userID;
        this.userName = userName;
        this.roleID = roleID;
    }
    
    public UserDTO(String userID, String userName, String address, String phone, String email, String roleID) {
        this.userID = userID;
        this.userName = userName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.roleID = roleID;
    }

    public UserDTO(String userID, String userName, String address, String phone, String email, String password, String roleID) {
        this.userID = userID;
        this.userName = userName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.roleID = roleID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", userName=" + userName + ", address=" + address + ", phone=" + phone + ", email=" + email + ", password=" + password + ", roleID=" + roleID + '}';
    }
    
    
}
