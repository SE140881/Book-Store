/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienvm.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tienvm.daos.BookDAO;
import tienvm.daos.UserDAO;
import tienvm.daos.VoucherDAO;
import tienvm.dtos.BShopErrorObject;
import tienvm.dtos.BookDTO;
import tienvm.dtos.UserDTO;
import tienvm.dtos.VoucherDTO;

/**
 *
 * @author TienVM_PC
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    private static final String INVALID = "login.jsp";
    private static final String USER = "shop.jsp";
    private static final String ADMIN = "adminProduct.jsp";

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
        String url = INVALID;
        try {
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            BShopErrorObject errObj = new BShopErrorObject();
            boolean valid = true;
            if(userName.length() == 0){
                errObj.setUserIDError("User name can't be blank!");
                valid = false;
            }
            if(password.length() == 0){
                errObj.setPasswordError("Password can't be blank!");
                valid = false;
            }
            if(valid) {
                UserDAO dao = new UserDAO();
                BookDAO bookDAO = new BookDAO();
                VoucherDAO vouDAO = new VoucherDAO();
                UserDTO user = dao.checkLogin(userName, password);
                List<UserDTO> listUser = dao.listUser();
                List<BookDTO> listBook = bookDAO.listBook();
                List<VoucherDTO> listVou = vouDAO.listVoucher();
                if(user == null){
                    request.setAttribute("ERROR", "Invalid user name or password not correct!");
                }
                else {
                    HttpSession session = request.getSession();
                    if(user.getRoleID().trim().equals("US")){
                        session.setAttribute("USER", user);
                        url = USER;
                    }
                    else if(user.getRoleID().trim().equals("AD")){
                        session.setAttribute("USERLIST", listUser);
                        session.setAttribute("USER", user);
                        session.setAttribute("BOOKLIST", listBook);
                        session.setAttribute("LISTVOUCHER", listVou);
                        url = ADMIN;
                    }
                }
            }
            else {
                url = INVALID;
                request.setAttribute("INVALID", errObj);
            }
        } catch (Exception e) {
            log("ERROR at LoginController: " + e.getMessage());
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
