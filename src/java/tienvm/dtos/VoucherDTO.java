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
public class VoucherDTO {
    private String code;
    private String userID;
    private String name;
    private int value;
    private Date importDate;
    private Date beginDate;
    private Date closeDate;

    public VoucherDTO() {
    }

    public VoucherDTO(String code, String userID) {
        this.code = code;
        this.userID = userID;
    }

    public VoucherDTO(String name, int value, Date beginDate, Date closeDate) {
        this.name = name;
        this.value = value;
        this.beginDate = beginDate;
        this.closeDate = closeDate;
    }

    public VoucherDTO(String code, String userID, String name, int value, Date beginDate, Date closeDate) {
        this.code = code;
        this.userID = userID;
        this.name = name;
        this.value = value;
        this.beginDate = beginDate;
        this.closeDate = closeDate;
    }

    public VoucherDTO(String code, String userID, String name, int value, Date importDate, Date beginDate, Date closeDate) {
        this.code = code;
        this.userID = userID;
        this.name = name;
        this.value = value;
        this.importDate = importDate;
        this.beginDate = beginDate;
        this.closeDate = closeDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    @Override
    public String toString() {
        return "VoucherDTO{" + "code=" + code + ", userID=" + userID + ", name=" + name + ", value=" + value + ", importDate=" + importDate + ", beginDate=" + beginDate + ", closeDate=" + closeDate + '}';
    }

    
    
}
