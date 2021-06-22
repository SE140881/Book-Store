/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienvm.dtos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author TienVM_PC
 */
public class CartDTO {
    Map<String, Integer> cart;

    public Map<String, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<String, Integer> cart) {
        this.cart = cart;
    }
    
    public void addToCart(String bookID) {
        if(this.cart == null)
            cart = new HashMap<>();
        
        int quantity = 1;
        Set<String> listKeys = cart.keySet();
        for (String k : listKeys) {
            if(k.equals(bookID))
                quantity = this.cart.get(k) + 1;
        }
        this.cart.put(bookID, quantity);
    }
    
    public void deleteItemOnCart(String bookID) {
        int quantity;
        Iterator keys = this.cart.entrySet().iterator();
        while(keys.hasNext()) {
            Map.Entry book = (Map.Entry) keys.next();
            if (book.getKey().equals(bookID)) {
                if((Integer)book.getValue() > 1) {
                    quantity = (Integer) book.getValue() - 1;
                    book.setValue(quantity);
                }
                else {
                    keys.remove();
                }
            }
        }
    }
    
    public void deleteAllOnCart(String bookID) {
        Iterator keys = this.cart.entrySet().iterator();
        while(keys.hasNext()){
            Map.Entry book = (Map.Entry) keys.next();
            if(book.getKey().equals(bookID))
                keys.remove();
        }
    }
    
    public void updateCart(String bookID, int newQuantity) {
        Iterator keys = this.cart.entrySet().iterator();
        while(keys.hasNext()){
            Map.Entry book = (Map.Entry) keys.next();
            if(book.getKey().equals(bookID))
                book.setValue(newQuantity);
        }
    }
}
