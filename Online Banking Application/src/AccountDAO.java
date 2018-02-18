import java.text.*;



import java.util.*;

import javax.servlet.RequestDispatcher;

import org.omg.Messaging.SyncScopeHelper;

import com.mysql.jdbc.PreparedStatement;

import java.sql.*;

   public class AccountDAO 	
   {
      static Connection currentCon = null;
      static ResultSet rs = null;  
      static Statement stmt = null;
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
      static final String DB_URL = "jdbc:mysql://localhost:3306/new_schema_demo";

      // Database credentials
      static final String USER = "root";
      static final String PASS = "password";
	  static String bal;
      public static String login(UserBean bean) {
	
         //preparing some objects for connection 
   
	
         String username = bean.getUsername();    
         String password = bean.getPassword();   
	    
          System.out.println("username  : "+username);
          System.out.println("password  : "+password);
          Scanner scn = new Scanner(System.in);
          try {
             // STEP 2: Register JDBC driver
             Class.forName("com.mysql.jdbc.Driver");

             // STEP 3: Open a connection
             System.out.print("\nConnecting to database...");
             currentCon = DriverManager.getConnection(DB_URL, USER, PASS);
             
             String query = "select * from account_bal  where username = ?;";
             System.out.println("3>>>>>>>>>>>>>>>");
             
             PreparedStatement preparedStmt = (PreparedStatement) currentCon.prepareStatement(query);
      	      //preparedStmt.setString(1, new_balance);
      	      preparedStmt.setString(1, username);
      	      rs=  preparedStmt.executeQuery();
             
             //Statement s = currentCon.createStatement();
             //rs = s.executeQuery(query);
             
             while(rs.next()) {
            	  bal=rs.getString("balance");
            System.out.println("sonal ka balance ="+bal);
            	     return bal;
           }
           
             System.out.println("balance================================"+bal);
            // ResultSet rs = stmt.executeQuery(query);
             System.out.println("4>>>>>>>>>>>>>>>");
        
             //boolean b = true;
             // iterate through the java resultset
             //System.out.println(" rs "+rs);
          }
      catch (Exception ex) 
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
      } 
	    
      //some exception handling
      finally 
      {
         if (rs != null)	{
            try {
               rs.close();
            } catch (Exception e) {}
               rs = null;
            }
	
         if (stmt != null) {
            try {
               stmt.close();
            } catch (Exception e) {}
               stmt = null;
            }
	
         if (currentCon != null) {
            try {
               currentCon.close();
            } catch (Exception e) {
            }

            currentCon = null;
         }
      }

return bal;
	
      }	
   }
