/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienvm.controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tienvm.daos.VoucherDAO;
import tienvm.dtos.VoucherDTO;

/**
 *
 * @author TienVM_PC
 */
@WebServlet(name = "CreateVoucherController", urlPatterns = {"/CreateVoucherController"})
public class CreateVoucherController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String FAIL = "adminDiscount.jsp";
    private static final String SUCCESS = "LoadVoucherController";

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
            String code = request.getParameter("txtNewCode");
            String userID = request.getParameter("txtNewUserID");
            String name = request.getParameter("txtNewName");
            String valueStr = request.getParameter("txtNewValue");
            String beginDateStr = request.getParameter("txtNewBeginDate");
            String closeDateStr = request.getParameter("txtNewCloseDate");
            int value = Integer.parseInt(valueStr);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date dateBegin = sdf.parse(beginDateStr);
            java.util.Date dateClose = sdf.parse(closeDateStr);
            
            java.sql.Date beginDate = new Date(dateBegin.getTime());
            java.sql.Date closeDate = new Date(dateClose.getTime());
            
            VoucherDTO vou = new VoucherDTO(code, userID, name, value, beginDate, closeDate);
            VoucherDAO dao = new VoucherDAO();
            boolean check = dao.insertVoucher(vou);
            if(check){
                url = SUCCESS;
                request.setAttribute("CREATESUCCESS", "Create voucher successfull!");
            }
            else {
                url = FAIL;
                request.setAttribute("CREATEFAIL", "Create voucher fail!");
            }
        } catch (Exception e) {
            log("ERROR at CreateVoucherController: " + e.getMessage());
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
