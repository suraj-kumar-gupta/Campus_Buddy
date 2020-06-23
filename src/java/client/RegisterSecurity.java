/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import dao.DatabaseDAO;
import entity.Security;
import entity.Warden;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xsura
 */
@WebServlet(name = "RegisterSecurity", urlPatterns = {"/RegisterSecurity"})
public class RegisterSecurity extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String uid = request.getParameter("UID");
            String name = request.getParameter("fullname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
 
            
            Security security = new Security();
            security.setSecurityId(uid);
            security.setFullName(name);
            security.setEmail(email);
            security.setPassword(password);
            
            if(DatabaseDAO.addSecurity(security)){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Security Registered Successfully');");
                out.println("location='AdminDashboard.jsp';");
                out.println("</script>"); 
                //out.println("User added " + security.getFullName()+ " " + security.getSecurityId());
                
            }
            
            else{
                 out.println("<script type=\"text/javascript\">");
                out.println("alert('Unable to Register Security');");
                out.println("location='RegisterSecurity.jsp';");
                out.println("</script>");
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RegisterSecurity.class.getName()).log(Level.SEVERE, null, ex);
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
