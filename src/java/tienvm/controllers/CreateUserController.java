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
import tienvm.daos.UserDAO;
import tienvm.dtos.BShopErrorObject;
import tienvm.dtos.UserDTO;

/**
 *
 * @author TienVM_PC
 */
@WebServlet(name = "CreateUserController", urlPatterns = {"/CreateUserController"})
public class CreateUserController extends HttpServlet {
    private static final String FAIL = "register.jsp";
    private static final String SUCCESS = "login.jsp";
    private static final String ERROR = "error.jsp";

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
            String userID = request.getParameter("txtUserID");
            String userName = request.getParameter("txtUserName");
            String password = request.getParameter("txtPassword");
            String confirm = request.getParameter("txtConfirm");
            String phone = request.getParameter("txtPhone");
            String email = request.getParameter("txtEmail");
            String address = request.getParameter("txtAddress");
            
            boolean valid = true;
            BShopErrorObject errObj = new BShopErrorObject();
            if(userID.length() == 0){
                valid = false;
                errObj.setUserIDError("User ID can't be blank!");
            }
            if(userName.length() == 0){
                valid = false;
                errObj.setUserNameError("What your name?");
            }
            if(password.length() == 0){
                valid = false;
                errObj.setPasswordError("Password is blank!");
            }
            if(confirm.length() == 0 || !confirm.equals(password)){
                valid = false;
                errObj.setConfirmError("Confirm not match!");
            }
            if(phone.length() ==0 ){
                valid = false;
                errObj.setPhoneError("Phone is blank!");
            }
            else if(!phone.matches("[0-9]{10}$")){
                valid = false;
                errObj.setPhoneError("Phone must be 10 number!");
            }
            if(email.length() == 0){
                valid = false;
                errObj.setEmailError("Email is blank!");
            }
            else if(!email.matches("^[\\w]{1,}+@([\\w]{1,}\\.[\\w]{1,}+|[\\w]{1,}\\.[\\w]{1,}\\.[\\w]{1,})$")){
                valid = false;
                errObj.setEmailError("Email invalid!");
            }
            if(address.length() == 0){
                valid = false;
                errObj.setAddressError("Address can't be blank!");
            }
            
            UserDTO user = new UserDTO(userID, userName, address, phone, email, password, "");
            if(valid){
                UserDAO dao = new UserDAO();
                boolean check = dao.createUser(user);
                if(check){
                    url = SUCCESS;
                    request.setAttribute("REGISTER", "You are ready to login!");
                }
                else {
                    url = FAIL;
                    request.setAttribute("REGISTERFAIL", "Have an error when register");
                }
            }
            else {
                url = FAIL;
                request.setAttribute("CREATEFAIL", errObj);
            }
        } catch (Exception e) {
            log("ERROR at CreateUserController: " + e.getMessage());
            if(e.getMessage().contains("duplicate")){
                url = FAIL;
                BShopErrorObject errObj = new BShopErrorObject();
                errObj.setUserIDError("Account already exists!");
                request.setAttribute("CREATEFAIL", errObj);
            }
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
