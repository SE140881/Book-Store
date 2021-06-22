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
public class CartDetailDTO {
    private int quantity;
    private String bookID;
    private String cartID;

    public CartDetailDTO() {
    }

    public CartDetailDTO(int quantity, String bookID, String cartID) {
        this.quantity = quantity;
        this.bookID = bookID;
        this.cartID = cartID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }
    
    
}
