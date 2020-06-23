/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import dao.DatabaseDAO;
import entity.GatePass;
import entity.Security;
import entity.Student;
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
@WebServlet(name = "RequestProcessor", urlPatterns = {"/RequestProcessor"})
public class RequestProcessor extends HttpServlet {

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
        String actionId = request.getParameter("actionId");
        String fieldNames = request.getParameter("fieldNames");
        String fieldValues = request.getParameter("fieldValues");
        
        String status;
        String message;
        String responseXML;
      
        
        System.out.println("Action id" + actionId);
        System.out.println("Field names" + fieldNames);
        System.out.println("Field values" + fieldValues);
        
        
      
        if(actionId.equals("GETSTUDENT")){
                Student student = new Student();
                student.setUid(fieldValues);
            try {

                
                if(DatabaseDAO.getStudentByUid(student)){                
                    if(student.getUid() != null){
                        status = "SUCCESS";
                        message = "Student record found";
                    } else{
                        status = "FAILURE";
                        message = "Student record not found";
                        
                    }
                
                
                }else{
                    status = "FAILURE";
                    message = "Error occured while fetching detail of student";
                }
            } catch (SQLException ex) {
                Logger.getLogger(RequestProcessor.class.getName()).log(Level.SEVERE, null, ex);
                status = "FAILURE";
                message = "Error occured while fetching detail of student";
              }
            
            if(status.equals("SUCCESS")){
                System.out.println("Success Response");
                responseXML = "<RESPONSE>";
                responseXML = responseXML + "<STATUS>" + status + "</STATUS>";
                responseXML = responseXML + "<MESSAGE>" + message + "</MESSAGE>";
                responseXML = responseXML + "<UID>" + student.getUid() + "</UID>";
                responseXML = responseXML + "<FULLNAME>" + student.getFullName() + "</FULLNAME>";
                responseXML = responseXML + "<DEPT>" + student.getDept() + "</DEPT>";
                responseXML = responseXML + "<MOBILE>" + student.getMobile_no() + "</MOBILE>";
                responseXML = responseXML + "<PARENT>" + student.getParent_no() + "</PARENT>";
                responseXML = responseXML + "<HOSTEL>" + student.getHostel() + "</HOSTEL>";
                responseXML = responseXML + "<ROOM>" + student.getRoom_no() + "</ROOM>";
                responseXML = responseXML + "</RESPONSE>";
                
                
            }else{
                System.out.println("Failure response");
                responseXML = "<RESPONSE>";
                responseXML = responseXML + "<STATUS>" + status + "</STATUS>";
                responseXML = responseXML + "<MESSAGE>" + message + "</MESSAGE>";
                responseXML = responseXML + "</RESPONSE>";
            }
            
           try (PrintWriter out = response.getWriter()) {
               out.println(responseXML);
               System.out.println("responseXML " + responseXML);
           }
           
        }
        
        
        else if(actionId.equals("GETWARDEN")){
                Warden warden = new Warden();
                warden.setWardenUid(fieldValues);
            try {

                
                if(DatabaseDAO.getWardenByUid(warden)){                
                    if(warden.getWardenUid() != null){
                        status = "SUCCESS";
                        message = "Warden record found";
                    } else{
                        status = "FAILURE";
                        message = "Warden record not found";
                        
                    }
                
                
                }else{
                    status = "FAILURE";
                    message = "Error occured while fetching detail of warden";
                }
            } catch (SQLException ex) {
                Logger.getLogger(RequestProcessor.class.getName()).log(Level.SEVERE, null, ex);
                status = "FAILURE";
                message = "Error occured while fetching detail of warden";
              }
            
            if(status.equals("SUCCESS")){
                System.out.println("Success Response");
                responseXML = "<RESPONSE>";
                responseXML = responseXML + "<STATUS>" + status + "</STATUS>";
                responseXML = responseXML + "<MESSAGE>" + message + "</MESSAGE>";
                
                responseXML = responseXML + "<FULLNAME>" + warden.getFullName() + "</FULLNAME>";
                responseXML = responseXML + "<MOBILE>" + warden.getMobileNo() + "</MOBILE>";
                responseXML = responseXML + "<HOSTEL>" + warden.getHostel() + "</HOSTEL>";
                responseXML = responseXML + "<EMAIL>" + warden.getEmail() + "</EMAIL>";
                responseXML = responseXML + "<PASSWORD>" + warden.getPassword() + "</PASSWORD>";
                
                responseXML = responseXML + "</RESPONSE>";
                
                
            }else{
                System.out.println("Failure response");
                responseXML = "<RESPONSE>";
                responseXML = responseXML + "<STATUS>" + status + "</STATUS>";
                responseXML = responseXML + "<MESSAGE>" + message + "</MESSAGE>";
                responseXML = responseXML + "</RESPONSE>";
            }
            
           try (PrintWriter out = response.getWriter()) {
               out.println(responseXML);
               System.out.println("responseXML " + responseXML);
           }
           
        }
        
        
        else if(actionId.equals("GETSECURITY")){
                Security security = new Security();
                security.setSecurityId(fieldValues);
            try {
                
                if(DatabaseDAO.getSecurityByUid(security)){                
                    if(security.getSecurityId() != null){
                        status = "SUCCESS";
                        message = "Security record found";
                    } else{
                        status = "FAILURE";
                        message = "Security record not found";
                        
                    }
                
                
                }else{
                    status = "FAILURE";
                    message = "Error occured while fetching detail of student";
                }
            } catch (SQLException ex) {
                Logger.getLogger(RequestProcessor.class.getName()).log(Level.SEVERE, null, ex);
                status = "FAILURE";
                message = "Error occured while fetching detail of student";
              }
            
            if(status.equals("SUCCESS")){
                System.out.println("Success Response");
                responseXML = "<RESPONSE>";
                responseXML = responseXML + "<STATUS>" + status + "</STATUS>";
                responseXML = responseXML + "<MESSAGE>" + message + "</MESSAGE>";
                responseXML = responseXML + "<FULLNAME>" + security.getFullName() + "</FULLNAME>";
                responseXML = responseXML + "<EMAIL>" + security.getEmail() + "</EMAIL>";
                responseXML = responseXML + "<PASSWORD>" + security.getPassword() + "</PASSWORD>";
                responseXML = responseXML + "<UID>" + security.getSecurityId() + "</UID>";
                responseXML = responseXML + "</RESPONSE>";
                
                
            }else{
                System.out.println("Failure response");
                responseXML = "<RESPONSE>";
                responseXML = responseXML + "<STATUS>" + status + "</STATUS>";
                responseXML = responseXML + "<MESSAGE>" + message + "</MESSAGE>";
                responseXML = responseXML + "</RESPONSE>";
            }
            
           try (PrintWriter out = response.getWriter()) {
               out.println(responseXML);
               System.out.println("responseXML " + responseXML);
           }
           
        }
        
        
        
        
        
        else if(actionId.equals("GETGATEPASS")){
            GatePass gatepass = new GatePass();
                gatepass.setUid(fieldValues);
            try {

                if(DatabaseDAO.getGatePassByUid(gatepass)){                
                    if(gatepass.getUid() != null){
                        status = "SUCCESS";
                        message = "Gatepass record found";
                    } else{
                        status = "FAILURE";
                        message = "Gatepass record not found";
                        
                    }
                
                
                }else{
                    status = "FAILURE";
                    message = "Error occured while fetching detail of gatepass";
                }
            } catch (SQLException ex) {
                Logger.getLogger(RequestProcessor.class.getName()).log(Level.SEVERE, null, ex);
                status = "FAILURE";
                message = "Error occured while fetching detail of student";
              }
        
            
            if(status.equals("SUCCESS")){
                System.out.println("Success Response");
                responseXML = "<RESPONSE>";
                responseXML = responseXML + "<STATUS>" + status + "</STATUS>";
                responseXML = responseXML + "<MESSAGE>" + message + "</MESSAGE>";
                responseXML = responseXML + "<UID>" + gatepass.getUid() + "</UID>";
                responseXML = responseXML + "<GATEPASSID>" + gatepass.getGatepassId() + "</GATEPASSID>";
                responseXML = responseXML + "<PLACE>" + gatepass.getPlaceOfVisit() + "</PLACE>";
                responseXML = responseXML + "<ISSUEDBY>" + gatepass.getIssuedBy() + "</ISSUEDBY>";
                responseXML = responseXML + "<STARTDATE>" + gatepass.getStartDateTime().toString() + "</START>";
                responseXML = responseXML + "<ENDDATE>" + gatepass.getEndDateTime().toString() + "</ENDDATE>";
                responseXML = responseXML + "<STATUS>" + gatepass.getStatus() + "</STATUS>";
                responseXML = responseXML + "<ISSUEDDATE>" + gatepass.getIssueDateTime()+ "</ISSUEDDATE>";
                responseXML = responseXML + "</RESPONSE>";
                
                
            }else{
                System.out.println("Failure response");
                responseXML = "<RESPONSE>";
                responseXML = responseXML + "<STATUS>" + status + "</STATUS>";
                responseXML = responseXML + "<MESSAGE>" + message + "</MESSAGE>";
                responseXML = responseXML + "</RESPONSE>";
            }
            
           try (PrintWriter out = response.getWriter()) {
               out.println(responseXML);
               System.out.println("responseXML " + responseXML);
           }
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
