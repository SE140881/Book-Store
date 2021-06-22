/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienvm.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tienvm.daos.BookDAO;
import tienvm.dtos.BShopErrorObject;
import tienvm.dtos.BookDTO;

/**
 *
 * @author TienVM_PC
 */
@WebServlet(name = "CreateBookController", urlPatterns = {"/CreateBookController"})
public class CreateBookController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String FAIL = "BookController";
    private static final String SUCCESS = "BookController";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = FAIL;
        try {
            String bookID = request.getParameter("newBookID");
            String tittle = request.getParameter("newTittle");
            String author = request.getParameter("newAuthor");
            String description = request.getParameter("newDescription");
            String image = request.getParameter("newImage");
            String categoryID = request.getParameter("cbxNewCategory");
            String quantityStr = request.getParameter("newQuantity");
            String priceStr = request.getParameter("newPrice");
            float price = 0;
            int quantity = 0;
            
            BShopErrorObject errObj = new BShopErrorObject();
            boolean valid = true;
            if(bookID.length() == 0) {
                errObj.setBookIDError("can't be blank!");
                valid = false;
            }
            if(tittle.length() == 0) {
                errObj.setTittleError("can't be blank!");
                valid = false;
            }
            if(author.length() == 0) {
                errObj.setAuthorError("can't be blank!");
                valid = false;
            }
            if(description.length() == 0) {
                errObj.setDescriptionError("can't be blank!");
                valid = false;
            }
            if(image.length() == 0) {
                errObj.setImageError("can't be blank!");
                valid = false;
            }
            if(quantityStr.length() == 0) {
                errObj.setQuantityError("can't be blank!");
                valid = false;
            }
            else if(!quantityStr.matches("[0-9]{1,}")) {
                errObj.setQuantityError("is positive integer!");
                valid = false;
            } 
            else {
                quantity = Integer.parseInt(quantityStr);
            }
            if(priceStr.length() == 0) {
                errObj.setPriceError("can't be blank!");
                valid = false;
            }
            else if(!priceStr.matches("^\\d*\\.?\\d*$")) {
                errObj.setPriceError("is positive number");
                valid = false;
            }
            else {
                price = Float.parseFloat(priceStr);
            }
            
            BookDTO book = new BookDTO(bookID, tittle, author, categoryID, image, description, price, quantity);
            if(valid) {
                BookDAO dao = new BookDAO();
                boolean check = dao.insertBook(book);
                if(check) {
                    url = SUCCESS;
                    request.setAttribute("CREATESUCCESS", "The book has been inserted!");
                }
                else{
                    request.setAttribute("CREATEFAIL", "Insert book failed!");
                }
            }
            else {
                url = FAIL;
                request.setAttribute("VALIDFAL", errObj);
            }
        } catch (Exception e) {
            log("ERROR at CreateBookController: " + e.getMessage());
            if(e.getMessage().contains("duplicate")) {
                BShopErrorObject errObj = new BShopErrorObject();
                errObj.setBookIDError("Duplicate");
                request.setAttribute("VALIDFAL", errObj);
            }
        }
        finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
