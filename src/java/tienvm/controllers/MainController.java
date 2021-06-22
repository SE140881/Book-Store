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

/**
 *
 * @author TienVM_PC
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";
    private static final String LOGOUT = "LogoutController";
    private static final String SEARCH_BOOK = "SearchBookController";
    private static final String DELETE_BOOK = "DeleteBookController";
    private static final String UPDATE_BOOK = "UpdateBookController";
    private static final String LOAD_BOOK = "LoadBookByCategoryController";
    private static final String ADMIN_SEARCH_BOOK = "AdminSearchBookController";
    private static final String INSERT_BOOK = "CreateBookController";
    private static final String CREATE_USER = "CreateUserController";
    private static final String DELETE_USER = "DeleteUserController";
    private static final String UPDATE_USER = "UpdateUserController";
    private static final String SEARCH_USER = "SearchUserController";
    private static final String ADD_TO_CART = "AddToCartController";
    private static final String UPDATE_ON_CART = "UpdateOnCartController";
    private static final String REMOVE_ON_CART = "RemoveOnCartController";
    
    private static final String CREATE_VOUCHER = "CreateVoucherController";
    private static final String CHECK_VOUCHER = "CheckVoucherController";
    private static final String CHECK_LOGIN = "CartController";
    private static final String ORDER = "OrderController";

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
            String action = request.getParameter("action");
            if(action == null){
                url = "LoadBookController";
            }
            if(action.equals("Login"))
                url = LOGIN;
            if(action.equals("Logout"))
                url = LOGOUT;
            if(action.equals("DeleteBook"))
                url = DELETE_BOOK;
            if(action.equals("UpdateBook"))
                url = UPDATE_BOOK;
            if(action.equals("AdminSearchBook"))
                url = ADMIN_SEARCH_BOOK;
            if(action.equals("InsertBook"))
                url = INSERT_BOOK;
            if(action.equals("Register"))
                url = CREATE_USER;
            if(action.equals("InsertVoucher"))
                url = CREATE_VOUCHER;
            if(action.equals("AddToCart"))
                url = ADD_TO_CART;
            if(action.equals("InDe"))
                url = UPDATE_ON_CART;
            if(action.equals("Remove"))
                url = REMOVE_ON_CART;
            if(action.equals("apply"))
                url = CHECK_VOUCHER;
            if(action.equals("processToCheckout"))
                url = CHECK_LOGIN;
            if(action.equals("paypal"))
                url = ORDER;
            if(action.equals("searchBook"))
                url = SEARCH_BOOK;
            if(action.equals("loadBook"))
                url = LOAD_BOOK;
            if(action.equals("AdminSearchUser"))
                url = SEARCH_USER;
            if(action.equals("UpdateUser"))
                url = UPDATE_USER;
            if(action.equals("DeleteUser"))
                url = DELETE_USER;
        } catch (Exception e) {
            log("ERROR at MainController: " + e.getMessage());
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
