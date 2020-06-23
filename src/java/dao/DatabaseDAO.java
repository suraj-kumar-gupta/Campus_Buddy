package dao;

import static dao.DatabaseDAO.getConnection;
import entity.Admin;
import entity.GatePass;
import entity.Security;
import entity.Student;
import entity.Warden;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseDAO {
   // private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    //private static String userName = "ADMIN";
   // private static String password = "chandigarh";
    
   
private static String url = "jdbc:oracle:thin:@campusbuddy.cobq4isl2ziw.us-east-1.rds.amazonaws.com:1521:ORCL";
private static String userName = "campusbuddy";
private static String password = "campusbuddy123";
    
   //static Properties props = new Properties();  
   //static InputStream inputStream; 
   //static {
     //  System.out.println("My name is Suraj");
       // inputStream = ClassLoader.class.getResourceAsStream("campusbuddy.properties");

       // System.out.println("InputStream is: " + inputStream);

       //try {
           // load the inputStream using the Properties
         //  props.load(inputStream);
       //} catch (Exception ex) {
         //  Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
       //}
    //}
   
    //private static String url = props.getProperty("url");
    //private static String userName = props.getProperty("userName");
    //private static String password = props.getProperty("password");
    
    
    public static Connection getConnection(){
        Connection connection = null;
      //  System.out.println(url + " " + userName  + " " + password);
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                connection = DriverManager.getConnection(url,userName,password);
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    
}
    
    public static boolean validateWarden(Warden warden ) throws SQLException {
      
        PreparedStatement pst = null;
        Connection connection = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            connection = getConnection();
            String sql = ("select fname,mobile,hostel,email,password from warden where email = ?");
            pst = connection.prepareStatement(sql);
            pst.setString(1, warden.getEmail());
            rs = pst.executeQuery();
            
            while(rs.next()){
                if((warden.getPassword()).equals(rs.getString(5))){
                    flag = true;
                    warden.setFullName(rs.getString(1));
                    warden.setMobileNo(rs.getString(2));
                    warden.setHostel(rs.getString(3));
                    warden.setEmail(rs.getString(4));
                }          
            }

            pst.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            if(pst != null){
                pst.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        
        return flag;
        
    }

    public static boolean validateSecurity(Security security ) throws SQLException {
      
        PreparedStatement pst = null;
        Connection connection = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            connection = getConnection();
            String sql = ("select fname,email,password from security where email = ?");
            pst = connection.prepareStatement(sql);
            pst.setString(1, security.getEmail());
            rs = pst.executeQuery();
            
            while(rs.next()){
                if((security.getPassword()).equals(rs.getString(3))){
                    flag = true;
                    security.setFullName(rs.getString(1));
                    security.setEmail(rs.getString(2));
                }          
            }

            pst.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            if(pst != null){
                pst.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        
        return flag;
        
    }
    
    
    
    public static boolean addStudent(Student student) throws SQLException {
        PreparedStatement pst = null;
        Connection connection = null;
        boolean flag = true;
        
        try {
            connection = getConnection();
            String sql = ("insert into student values(?,?,?,?,?,?,?)");
            pst = connection.prepareStatement(sql);
            pst.setString(1, student.getUid());
            pst.setString(2, student.getFullName());
            pst.setString(3, student.getDept());
            pst.setString(4, student.getMobile_no());
            pst.setString(5, student.getParent_no());
            pst.setString(6, student.getHostel());
            pst.setString(7, student.getRoom_no());
            pst.executeUpdate();
            

            pst.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            if(pst != null){
                pst.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        
        return flag;
        
        
        
    }


  public static boolean addWarden(Warden warden) throws SQLException{
     PreparedStatement pst = null;
     Connection connection = null;
     boolean flag = true;
     
      try {
            connection = getConnection();
            String sql = ("insert into warden values(?,?,?,?,?,?)");
            pst = connection.prepareStatement(sql);
            pst.setString(1, warden.getFullName());
            pst.setString(2, warden.getMobileNo());
            pst.setString(3, warden.getHostel());
            pst.setString(4, warden.getEmail());
            pst.setString(5, warden.getPassword());
            pst.setString(6, warden.getWardenUid());
            pst.executeUpdate();
            
            pst.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            if(pst != null){
                pst.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        
        return flag;
        
      
        
    }  
  
  public static boolean addSecurity(Security security) throws SQLException{
     PreparedStatement pst = null;
     Connection connection = null;
     boolean flag = true;
     
      try {
            connection = getConnection();
            String sql = ("insert into security values(?,?,?,?)");
            pst = connection.prepareStatement(sql);
            pst.setString(1, security.getFullName());
            pst.setString(2, security.getEmail());
            pst.setString(3, security.getPassword());
            pst.setString(4, security.getSecurityId());
            pst.executeUpdate();
            
            pst.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            if(pst != null){
                pst.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        
        return flag;
        
    }
  
    
    public static boolean getStudentByUid(Student student) throws SQLException {
        PreparedStatement pst = null;
        Connection connection = null;
        ResultSet rs  = null;
        boolean flag = true;
        
        try {
            connection = getConnection();
            String sql = ("select * from student where student_uid = ?");
            pst = connection.prepareStatement(sql);
            pst.setString(1, student.getUid());
           
            rs = pst.executeQuery();
            if(rs.next()==false){
                System.out.println("Student not found for uid " + student.getUid());
                student.setUid(null);
                
            }
            else{
                
                System.out.println("Student found for uid " + student.getUid());
                do{
                    
                student.setUid(rs.getString("student_uid"));
                student.setFullName(rs.getString("student_name"));
                student.setDept(rs.getString("student_dept"));
                student.setMobile_no(rs.getString("student_mobile"));
                student.setParent_no(rs.getString("parents_mobile"));
                student.setHostel(rs.getString("student_hostel"));
                student.setRoom_no(rs.getString("student_room_no"));
            }
                
                while(rs.next());
                
            }
            
            
            
            
            pst.close();
            
            
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        return flag;
        
    }
    
    public static boolean getWardenByUid(Warden warden) throws SQLException {
        PreparedStatement pst = null;
        Connection connection = null;
        ResultSet rs  = null;
        boolean flag = true;
        
        try {
            connection = getConnection();
            String sql = ("select * from warden where warden_id = ?");
            pst = connection.prepareStatement(sql);
            pst.setString(1, warden.getWardenUid());
           
            rs = pst.executeQuery();
            if(rs.next()==false){
                System.out.println("Warden not found for uid " + warden.getWardenUid());
                warden.setWardenUid(null);
                
            }
            else{
                
                System.out.println("Warden found for uid " + warden.getWardenUid());
                do{
                    
                warden.setFullName(rs.getString("fname"));
                warden.setMobileNo(rs.getString("mobile"));
                warden.setHostel(rs.getString("hostel"));
                warden.setEmail(rs.getString("email"));
                warden.setPassword(rs.getString("password"));
                warden.setWardenUid(rs.getString("warden_id"));
                
            }
                
                while(rs.next());
                
            }
            
            
            
            
            pst.close();
            
            
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        return flag;
        
    }
    
    public static boolean getSecurityByUid(Security security) throws SQLException {
        PreparedStatement pst = null;
        Connection connection = null;
        ResultSet rs  = null;
        boolean flag = true;
        
        try {
            connection = getConnection();
            String sql = ("select * from security where security_id = ?");
            pst = connection.prepareStatement(sql);
            pst.setString(1, security.getSecurityId());
           
            rs = pst.executeQuery();
            if(rs.next()==false){
                System.out.println("Security not found for uid " + security.getSecurityId());
                security.setSecurityId(null);
                
            }
            else{
                
                System.out.println("Security found for uid " + security.getSecurityId());
                do{
                    
                security.setFullName(rs.getString("fname"));
                security.setEmail(rs.getString("email"));
                security.setPassword(rs.getString("password"));
                security.setSecurityId(rs.getString("security_id"));
                
            }
                
                while(rs.next());
                
            }
            
            
            
            
            pst.close();
            
            
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        return flag;
        
    }
    
    
    
    
    public static boolean getGatePassByUid(GatePass gatepass) throws SQLException {
        PreparedStatement pst = null;
        Connection connection = null;
        ResultSet rs  = null;
        boolean flag = true;
        
        try {
            connection = getConnection();
            String sql = ("select * from gatepasses where student_uid = ? and status = ?");
            pst = connection.prepareStatement(sql);
            pst.setString(1, gatepass.getUid());
            pst.setString(2, "ACTIVE");
           
            rs = pst.executeQuery();
            if(rs.next()==false){
                System.out.println("Gatepass not found for uid " + gatepass.getUid());
                gatepass.setUid(null);
                
            }
            else{
                
                System.out.println("Gatepass found for uid " + gatepass.getUid());
                do{
                    
                gatepass.setUid(rs.getString("student_uid"));
                gatepass.setPlaceOfVisit(rs.getString("placeofvisit"));
                gatepass.setIssuedBy(rs.getString("issuedby"));
                gatepass.setStartDateTime(rs.getTimestamp("startdatetime"));
                gatepass.setEndDateTime(rs.getTimestamp("enddatetime"));
                gatepass.setStatus(rs.getString("status"));
                gatepass.setIssueDateTime(rs.getTimestamp("issuedatetime"));
                gatepass.setGatepassId(rs.getString("gatepassid"));
            }
                
                while(rs.next());
                
            }
            
            
            
            
            pst.close();
            
            
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        return flag;
        
    }
    
    
    

    public static boolean validateAdmin(Admin admin) throws SQLException {
        
        PreparedStatement pst = null;
        Connection connection = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            connection = getConnection();
            String sql = ("select email,password from admin where email = ?");
            pst = connection.prepareStatement(sql);
            pst.setString(1, admin.getEmail());
            rs = pst.executeQuery();
            
            while(rs.next()){
                if((admin.getPassword()).equals(rs.getString(2))){
                    flag = true;
                }          
            }

            pst.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            if(pst != null){
                pst.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        
        return flag;
        
    }

    public static boolean modifyStudent(Student student) throws SQLException{
        PreparedStatement pst = null;
        Connection connection = null;
        boolean flag = true;
        
        try {
            connection = getConnection();
            String sql = ("update student set student_name=?, student_dept=?, student_mobile=?, parents_mobile=?, student_hostel=?, student_room_no=? where student_uid=?");
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, student.getFullName());
            pst.setString(2, student.getDept());
            pst.setString(3, student.getMobile_no());
            pst.setString(4, student.getParent_no());
            pst.setString(5, student.getHostel());
            pst.setString(6, student.getRoom_no());
            pst.setString(7, student.getUid());
            pst.executeUpdate();
            System.out.println("Record updated");
            

            pst.close();
            
            
        } catch (SQLException ex) {
            flag = false;
            System.out.println(ex.getStackTrace().toString());
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            if(pst != null){
                pst.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        
        return flag;
    
    }
    
    
    public static boolean modifyWarden(Warden warden) throws SQLException{
        PreparedStatement pst = null;
        Connection connection = null;
        boolean flag = true;
        
        try {
            connection = getConnection();
            String sql = ("update warden set fname=?, mobile=?, hostel=?, email=?, password=? where warden_id=?");
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, warden.getFullName());
            pst.setString(2, warden.getMobileNo());
            pst.setString(3, warden.getHostel());
            pst.setString(4, warden.getEmail());
            pst.setString(5, warden.getPassword());
            pst.setString(6, warden.getWardenUid());
            pst.executeUpdate();
            System.out.println("Record updated");
            

            pst.close();
            
            
        } catch (SQLException ex) {
            flag = false;
            System.out.println(ex.getStackTrace().toString());
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            if(pst != null){
                pst.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        
        return flag;
    
    }
    
    public static boolean modifySecurity(Security security) throws SQLException{
        PreparedStatement pst = null;
        Connection connection = null;
        boolean flag = true;
        
        try {
            connection = getConnection();
            String sql = ("update security set fname=?, email=?, password=? where security_id=?");
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, security.getFullName());
            pst.setString(2, security.getEmail());
            pst.setString(3, security.getPassword());
            pst.setString(4, security.getSecurityId());
            pst.executeUpdate();
            System.out.println("Record updated");
            

            pst.close();
            
            
        } catch (SQLException ex) {
            flag = false;
            System.out.println(ex.getStackTrace().toString());
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            if(pst != null){
                pst.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        
        return flag;
    
    }
    
    
    
    public static boolean generatepass(GatePass gatepass) throws SQLException{
        PreparedStatement pst = null;
        Connection connection = null;
        boolean flag = true;
        
        try {
            connection = getConnection();
            String sql = ("insert into gatepasses values(?,?,?,?,?,?,?,?)");
            pst = connection.prepareStatement(sql);
            pst.setString(1, gatepass.getGatepassId());
            pst.setString(2, gatepass.getUid());
            pst.setString(3, gatepass.getPlaceOfVisit());
            pst.setString(4, gatepass.getIssuedBy());
            pst.setTimestamp(5, gatepass.getStartDateTime());
            pst.setTimestamp(6, gatepass.getEndDateTime());
            pst.setString(7, gatepass.getStatus());
            pst.setTimestamp(8, gatepass.getIssueDateTime());
           
            pst.executeUpdate();
            
            pst.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            if(pst != null){
                pst.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        
        return flag;
        
        
        
    }

    public static boolean deleteStudent(Student student) throws SQLException {
        PreparedStatement pst = null;
        Connection connection = null;
        boolean flag = true;
        
        try {
            connection = getConnection();
            String sql = ("delete from student where student_uid=?");
            pst = connection.prepareStatement(sql);
            pst.setString(1, student.getUid());
            pst.executeUpdate();
           
            pst.close();
            
            
        } catch (SQLException ex) {
            flag = false;
            System.out.println(ex.getStackTrace().toString());
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            if(pst != null){
                pst.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        
        return flag;
        
}
    
    public static boolean deleteWarden(Warden warden) throws SQLException {
        PreparedStatement pst = null;
        Connection connection = null;
        boolean flag = true;
        
        try {
            connection = getConnection();
            String sql = ("delete from warden where warden_id=?");
            pst = connection.prepareStatement(sql);
            pst.setString(1, warden.getWardenUid());
            pst.executeUpdate();
           
            pst.close();
            
            
        } catch (SQLException ex) {
            flag = false;
            System.out.println(ex.getStackTrace().toString());
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            if(pst != null){
                pst.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        
        return flag;
        
}
    
    public static boolean deleteSecurity(Security security) throws SQLException {
        PreparedStatement pst = null;
        Connection connection = null;
        boolean flag = true;
        
        try {
            connection = getConnection();
            String sql = ("delete from security where security_id=?");
            pst = connection.prepareStatement(sql);
            pst.setString(1, security.getSecurityId());
            pst.executeUpdate();
           
            pst.close();
            
            
        } catch (SQLException ex) {
            flag = false;
            System.out.println(ex.getStackTrace().toString());
            Logger.getLogger(DatabaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        finally{
            if(pst != null){
                pst.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        
        return flag;
        
}
}