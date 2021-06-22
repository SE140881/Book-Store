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
import javax.servlet.http.HttpSession;
import tienvm.daos.UserDAO;
import tienvm.dtos.BShopErrorObject;
import tienvm.dtos.UserDTO;

/**
 *
 * @author TienVM_PC
 */
@WebServlet(name = "UpdateUserController", urlPatterns = {"/UpdateUserController"})
public class UpdateUserController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String UPDATE = "LoadUserController";
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
            HttpSession session = request.getSession();
            
            String newUserID = request.getParameter("txtUserIDUp");
            String newUserName = request.getParameter("txtUserNameUp");
            String newPhone = request.getParameter("txtPhoneUp");
            String newEmail = request.getParameter("txtEmailUp");
            String newAddress = request.getParameter("txtAddressUp");
            String newRole = request.getParameter("cbxRoleUp");
            BShopErrorObject errorObj = new BShopErrorObject();
            
            boolean valid = true;
            if(newUserName.trim().length() == 0){
                valid = false;
                errorObj.setNewUserNameError("User name can't be blank!");
            }
            if (!newEmail.trim().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)$")) {
                valid = false;
                errorObj.setNewEmailError("Email is not in the correct format!");
            }
            if (newPhone.trim().length() == 0 || !newPhone.trim().matches("^[0-9]{10}$")) {
                valid = false;
                errorObj.setNewPhoneError("Phone can't be blank!");
            }
            if(newAddress.trim().length() == 0){
                valid = false;
                errorObj.setAddressError("Address can't be blank!");
            }
            UserDTO user = new UserDTO(newUserID, newUserName, newAddress, newPhone, newEmail, newRole);
            if(valid){
                UserDAO dao = new UserDAO();
                boolean check = dao.updateUser(user);
                if(check){
                    url = UPDATE;
                    session.setAttribute("UPDATE_USER", "User information has been changed!");
                }
                else
                    session.setAttribute("UPDATE_USERFAIL", "Change user information fail!");
            } else {
                url = UPDATE;
                session.setAttribute("INVALID", errorObj);
            }
        } catch (Exception e) {
            log("ERROR at UpdateUserController: " + e.toString());
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
