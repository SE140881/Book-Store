/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienvm.dtos;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author TienVM_PC
 */
public class BookDTO implements Serializable{
    private String bookID;
    private String tittle;
    private String author;
    private String categoryID;
    private String image;
    private String description;
    private float price;
    private int quantity;
    private Date importDate;
    private boolean status;

    public BookDTO() {
    }

    public BookDTO(String bookID, String tittle, String author, String categoryID, String image, String description, float price, int quantity) {
        this.bookID = bookID;
        this.tittle = tittle;
        this.author = author;
        this.categoryID = categoryID;
        this.image = image;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public BookDTO(String bookID, String tittle, String author, String categoryID, String image, String description, float price, int quantity, Date importDate) {
        this.bookID = bookID;
        this.tittle = tittle;
        this.author = author;
        this.categoryID = categoryID;
        this.image = image;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.importDate = importDate;
    }

    public BookDTO(String bookID, String tittle, String author, String categoryID, String image, String description, float price, int quantity, Date importDate, boolean status) {
        this.bookID = bookID;
        this.tittle = tittle;
        this.author = author;
        this.categoryID = categoryID;
        this.image = image;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.importDate = importDate;
        this.status = status;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookDTO{" + "bookID=" + bookID + ", tittle=" + tittle + ", author=" + author + ", categoryID=" + categoryID + ", image=" + image + ", description=" + description + ", price=" + price + ", quantity=" + quantity + ", importDate=" + importDate + ", status=" + status + '}';
    }

    
    
}
