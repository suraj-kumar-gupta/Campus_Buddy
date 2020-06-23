/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import dao.DatabaseDAO;
import entity.GatePass;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author xsura
 */
@WebServlet(name = "GenerateGatepass", urlPatterns = {"/GenerateGatepass"})
public class GenerateGatepass extends HttpServlet {

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
            
            
            HttpSession session = request.getSession();
            
            String gatepassId = null;
            String uid = request.getParameter("UID");
            String placeOfVisit = request.getParameter("placeofvisit");
            String startDate = request.getParameter("startdate");
            String endDate = request.getParameter("enddate");
            String issuedBy = (String) session.getAttribute("email");
            
            
            Random r = new Random( System.currentTimeMillis() );
            gatepassId = Integer.toString((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
            
            long millis=System.currentTimeMillis();  
            Timestamp issueDateTime = new java.sql.Timestamp(millis);
            Timestamp startDateTime = null;
            Timestamp endDateTime = null;
            
            StringTokenizer startDateTokens = new StringTokenizer(startDate,"T");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
            java.util.Date apptDay = null;
            try {
                apptDay = (java.util.Date) df.parse(startDateTokens.nextToken() + " " + startDateTokens.nextToken()+":00");
                System.out.println(apptDay);
            } catch (ParseException ex) {
                Logger.getLogger(GenerateGatepass.class.getName()).log(Level.SEVERE, null, ex);
            }
            startDateTime = new Timestamp(apptDay.getTime());
            
            StringTokenizer endDateTokens = new StringTokenizer(endDate,"T");
            try {
                apptDay = (java.util.Date) df.parse(endDateTokens.nextToken() + " " + endDateTokens.nextToken()+":00");
                System.out.println(apptDay);
            } catch (ParseException ex) {
                Logger.getLogger(GenerateGatepass.class.getName()).log(Level.SEVERE, null, ex);
            }
            endDateTime = new Timestamp(apptDay.getTime());
            
            GatePass gatepass = new GatePass();
            gatepass.setGatepassId(gatepassId);
            gatepass.setUid(uid);
            gatepass.setPlaceOfVisit(placeOfVisit);
            gatepass.setIssuedBy(issuedBy);
            gatepass.setIssueDateTime(issueDateTime);
            gatepass.setStartDateTime(startDateTime);
            gatepass.setEndDateTime(endDateTime);
            gatepass.setStatus("ACTIVE");
            
            System.out.println("start - " + startDate);
            System.out.println("end - " + endDate);
            System.out.println("issued date - " + issueDateTime);
            
            if(DatabaseDAO.generatepass(gatepass)){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Gatepass Generated Successfully');");
                out.println("location='WardenDashboard.jsp';");
                out.println("</script>");                
            }
            
            else{
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Gatepass Generation Failed');");
                out.println("location='GenerateGatepass.jsp';");
                out.println("</script>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GenerateGatepass.class.getName()).log(Level.SEVERE, null, ex);
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
