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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import tienvm.Utils.MyConnection;
import tienvm.dtos.BookDTO;

/**
 *
 * @author TienVM_PC
 */
public class BookDAO {
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
    
    public List<BookDTO> listBook() throws SQLException{
        List<BookDTO> list = new ArrayList<>();
        BookDTO book = null;
        try {
            String sql = "SELECT BookID, Tittle, Price, Author, ImportDate, Quantity, CategoryID, image, Description"
                    + " FROM tbl_Books WHERE Status = 'True'";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                String bookID = rs.getString("BookID");
                String tittle = rs.getString("Tittle");
                float price = rs.getFloat("Price");
                String author = rs.getString("Author");
                Date importDate = rs.getDate("ImportDate");
                int quantity = rs.getInt("Quantity");
                String categoryID = rs.getString("CategoryID");
                String image = rs.getString("image");
                String description = rs.getString("Description");
                
                book = new BookDTO(bookID, tittle, author, categoryID, image, description, price, quantity, importDate);
                list.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public List<BookDTO> listBookShop() throws SQLException{
        List<BookDTO> list = new ArrayList<>();
        BookDTO book = null;
        try {
            String sql = "SELECT BookID, Tittle, Price, Author, ImportDate, Quantity, CategoryID, image, Description"
                    + " FROM tbl_Books WHERE Status = 'True' AND Quantity > 0";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                String bookID = rs.getString("BookID");
                String tittle = rs.getString("Tittle");
                float price = rs.getFloat("Price");
                String author = rs.getString("Author");
                Date importDate = rs.getDate("ImportDate");
                int quantity = rs.getInt("Quantity");
                String categoryID = rs.getString("CategoryID");
                String image = rs.getString("image");
                String description = rs.getString("Description");
                
                book = new BookDTO(bookID, tittle, author, categoryID, image, description, price, quantity, importDate);
                list.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public List<BookDTO> listBookByCategory(String cateID) throws SQLException{
        List<BookDTO> list = new ArrayList<>();
        BookDTO book = null;
        try {
            String sql = "SELECT BookID, Tittle, Price, Author, ImportDate, Quantity, CategoryID, image, Description"
                    + " FROM tbl_Books WHERE Status = 'True' AND Quantity > 0 AND CategoryID = ?";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cateID);
            rs = pstm.executeQuery();
            while(rs.next()){
                String bookID = rs.getString("BookID");
                String tittle = rs.getString("Tittle");
                float price = rs.getFloat("Price");
                String author = rs.getString("Author");
                Date importDate = rs.getDate("ImportDate");
                int quantity = rs.getInt("Quantity");
                String categoryID = rs.getString("CategoryID");
                String image = rs.getString("image");
                String description = rs.getString("Description");
                
                book = new BookDTO(bookID, tittle, author, categoryID, image, description, price, quantity, importDate);
                list.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public List<BookDTO> findByName(String search) throws SQLException{
        List<BookDTO> list = new ArrayList<>();
        BookDTO book = null;
        try {
            String sql = "SELECT BookID, Tittle, Price, Author, ImportDate, Quantity, CategoryID, image, Description "
                    + "FROM tbl_Books WHERE Tittle LIKE ? AND Status = 1";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, "%" + search + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                String bookID = rs.getString("BookID");
                String tittle = rs.getString("Tittle");
                float price = rs.getFloat("Price");
                String author = rs.getString("Author");
                Date importDate = rs.getDate("ImportDate");
                int quantity = rs.getInt("Quantity");
                String categoryID = rs.getString("CategoryID");
                String image = rs.getString("image");
                String description = rs.getString("Description");
                
                book = new BookDTO(bookID, tittle, author, categoryID, image, description, price, quantity, importDate);
                list.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
    
    public BookDTO findByBookID(String bookID, List<BookDTO> list) {
        for (BookDTO book : list) {
            if(book.getBookID().trim().equals(bookID.trim()))
                return book;
        }
        return null;
    }
    
    public boolean insertBook(BookDTO book) throws SQLException, ClassNotFoundException{
        boolean check = false;
        
        try {
            String sql = "INSERT INTO tbl_Books (BookID, Tittle, Price, Author, ImportDate, Quantity, CategoryID, image, Description, Status) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,1)";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, book.getBookID());
            pstm.setString(2, book.getTittle());
            pstm.setFloat(3, book.getPrice());
            pstm.setString(4, book.getAuthor());
            pstm.setDate(5, Date.valueOf(LocalDate.now()));
            pstm.setInt(6, book.getQuantity());
            pstm.setString(7, book.getCategoryID());
            pstm.setString(8, book.getImage());
            pstm.setString(9, book.getDescription());
            check = pstm.executeUpdate()==0?false:true;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean deleteBook(String bookID) throws SQLException{
        boolean check = false;
        try {
            String sql = "UPDATE tbl_Books SET Status = 0 WHERE BookID = ?";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, bookID);
            check = pstm.executeUpdate()==0?false:true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean updateBook(BookDTO book) throws SQLException{
        boolean check = false;
        try {
            String sql = "UPDATE tbl_Books SET Tittle = ?, Price = ?, Author = ?, ImportDate = ?, "
                    + "Quantity = ?, CategoryID = ?, image = ?, Description = ? WHERE BookID = ?";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, book.getTittle());
            pstm.setFloat(2, book.getPrice());
            pstm.setString(3, book.getAuthor());
            pstm.setDate(4, Date.valueOf(LocalDate.now()));
            pstm.setInt(5, book.getQuantity());
            pstm.setString(6, book.getCategoryID());
            pstm.setString(7, book.getImage());
            pstm.setString(8, book.getDescription());
            pstm.setString(9, book.getBookID());
            check = pstm.executeUpdate()==0?false:true;
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean updateQuantity(String bookID, int quantity) throws SQLException {
        boolean check = false;
        try {
            String sql = "UPDATE tbl_Books SET Quantity = Quantity - ? WHERE BookID = ?";
            conn = MyConnection.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, quantity);
            pstm.setString(2, bookID);
            check = pstm.executeUpdate()==0?false:true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    
}
