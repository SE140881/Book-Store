/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienvm.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tienvm.daos.BookDAO;
import tienvm.daos.OrderDAO;
import tienvm.daos.OrderDetailDAO;
import tienvm.daos.VoucherDAO;
import tienvm.dtos.BookDTO;
import tienvm.dtos.OrderDetailDTO;
import tienvm.dtos.UserDTO;
import tienvm.dtos.VoucherDTO;

/**
 *
 * @author TienVM_PC
 */
@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {

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
        try {
            HttpSession session = request.getSession();
            OrderDAO dao = new OrderDAO();
//            String codeDisable = request.getParameter("codeDisable");
//            String userDisable = request.getParameter("userDisable");
            String code = request.getParameter("voucherCode");
            String userID = request.getParameter("userIDOrder");
            String address = request.getParameter("addressOrder");
            String totalStr = request.getParameter("totalOrder");
            float total = Float.parseFloat(totalStr);
            boolean check = dao.insertOrder(userID, total, address);
            VoucherDAO vouDAO = new VoucherDAO();
            
            if(check) {
                int orderID = dao.getIDOrder(userID);
                BookDAO bookDAO = new BookDAO();
                List<BookDTO> list = bookDAO.listBook();
                HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("LIST_CART");
                Set<String> listKeys = cart.keySet();
                bookDAO.listBook();
                boolean insertDetail = false;
                vouDAO.deleteVoucher(code, userID);
                for (String item : listKeys) {
                    BookDTO book = bookDAO.findByBookID(item, list);
                    OrderDetailDTO detailDTO = new OrderDetailDTO(orderID, item, (book.getPrice()), cart.get(item), book.getTittle());
                    OrderDetailDAO detailDAO = new OrderDetailDAO();
                    insertDetail = detailDAO.insertOrderDetail(detailDTO);
                    if(insertDetail){
                        
                        bookDAO.updateQuantity(item, cart.get(item));
                        session.removeAttribute("LIST_CART");
                        session.removeAttribute("CART");
                    }
                }
            }
            
        } catch (Exception e) {
            log("ERROR at OrderController: " + e.getMessage());
        } finally {
            response.sendRedirect("shop.jsp");
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
