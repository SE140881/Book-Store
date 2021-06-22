/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienvm.controllers;

import java.io.IOException;
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
@WebServlet(name = "UpdateBookController", urlPatterns = {"/UpdateBookController"})
public class UpdateBookController extends HttpServlet {
    private static final String ERROR = "adminProduct.jsp";
    private static final String SUCCESS = "BookController";
    private static final String INVALID = "BookController";
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
        String url = ERROR;
        try {
            String bookID = request.getParameter("txtNewBookID");
            String title = request.getParameter("txtNewTittle");
            String author = request.getParameter("txtNewAuthor");
            String description = request.getParameter("txtNewDescription");
            String image = request.getParameter("txtNewImage");
            String categoryID = request.getParameter("cbxNewCategory");
            String priceString = request.getParameter("txtNewPrice");
            float price = 0;
            String quantityString = request.getParameter("txtNewQuantity");
            int quantity = 0;
            
            BShopErrorObject errObj = new BShopErrorObject();
            boolean valid = true;
            if(title.length() == 0){
                valid = false;
                errObj.setTittleError(" can't be blank!");
            }
            if(author.length() == 0){
                valid = false;
                errObj.setAuthorError(" can't be blank!");
            }
            if(description.length() == 0){
                valid = false;
                errObj.setDescriptionError(" can't be blank!");
            }
            if(image.length() == 0){
                valid = false;
                errObj.setImageError(" can't be blank!");
            }
            if(quantityString.length() == 0){
                valid = false;
                errObj.setQuantityError(" can't be blank!");
            } 
            else if(!quantityString.matches("[0-9]{1,}")){
                valid = false;
                errObj.setQuantityError(" is postitive integer!");
            }
            else {
                quantity = Integer.parseInt(quantityString);
            }
            if(!priceString.matches("^\\d*\\.?\\d*$")){
                valid = false;
                errObj.setPriceError(" is positive number!");
            }
            else if(priceString.length() == 0){
                valid = false;
                errObj.setPriceError(" can't be blank!");
            }
            else{
                price = Float.parseFloat(priceString);
            }
            BookDTO book = new BookDTO(bookID, title, author, categoryID, image, description, price, quantity);
            if(valid){
                BookDAO dao = new BookDAO();
                boolean check = dao.updateBook(book);
                if(check){
                    url = SUCCESS;
                    request.setAttribute("UPDATESUCCESS", "The book has been updated!");
                }
                else {
                    request.setAttribute("UPDATEFAIL", "Update book failed!");
                }
            } 
            else {
                url = INVALID;
                request.setAttribute("INVALID", errObj);
            }
        } catch (Exception e) {
            log("ERROR at UpdateBookController: " + e.getMessage());
        } finally {
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
