/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienvm.dtos;

import java.sql.Date;

/**
 *
 * @author TienVM_PC
 */
public class OrderDTO {
    private String userID;
    private float total;
    private Date date;
    private String address;

    public OrderDTO() {
    }

    public OrderDTO(String userID, float total, Date date) {
        this.userID = userID;
        this.total = total;
        this.date = date;
    }

    public OrderDTO(String userID, float total, String address) {
        this.userID = userID;
        this.total = total;
        this.address = address;
    }

    public OrderDTO(String userID, float total, Date date, String address) {
        this.userID = userID;
        this.total = total;
        this.date = date;
        this.address = address;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
}
