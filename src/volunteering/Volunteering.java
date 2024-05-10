package volunteering;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Volunteering {
public  String sql_url = "jdbc:mysql://localhost:3306/volunteer";
public   String sql_user = "root";
public   String sql_password = "root123";
public  Connection conn;
public   ResultSet rs;
public  Statement pst;
  
    public static void main(String[] args){
        new login().setVisible(true);
        
        
          
    }
    
}
