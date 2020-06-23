/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import dao.DatabaseDAO;
import entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AddStudent", urlPatterns = {"/AddStudent"})
public class AddStudent extends HttpServlet {

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
            String dept = request.getParameter("department");
            String mobile_no = request.getParameter("usrtel");
            String parent_no = request.getParameter("usrtel2");
            String hostel = request.getParameter("hostel");
            String room_no = request.getParameter("roomno");
            
            Student student = new Student();
            student.setUid(uid);
            student.setFullName(name);
            student.setDept(dept);
            student.setMobile_no(mobile_no);
            student.setParent_no(parent_no);
            student.setHostel(hostel);
            student.setRoom_no(room_no);
            
            if(DatabaseDAO.addStudent(student)){
                
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Student Added Successfully');");
                out.println("location='WardenDashboard.jsp';");
                out.println("</script>");
                    
                }
                else{
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Unable to add student');");
                    out.println("location='AddStudent.jsp';");
                    out.println("</script>");
                }

            
        } catch (SQLException ex) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
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
