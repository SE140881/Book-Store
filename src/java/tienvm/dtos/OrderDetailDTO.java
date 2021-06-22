/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienvm.dtos;

/**
 *
 * @author TienVM_PC
 */
public class OrderDetailDTO {
    private int orderID;
    private String bookID;
    private float price;
    private int quantity;
    private String tittle;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int orderID, String bookID, float price, int quantity, String tittle) {
        this.orderID = orderID;
        this.bookID = bookID;
        this.price = price;
        this.quantity = quantity;
        this.tittle = tittle;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
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

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" + "orderID=" + orderID + ", bookID=" + bookID + ", price=" + price + ", quantity=" + quantity + ", tittle=" + tittle + '}';
    }
    
    
}
