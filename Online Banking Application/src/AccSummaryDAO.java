import java.text.*;
import java.util.*;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import org.omg.Messaging.SyncScopeHelper;

import com.mysql.jdbc.PreparedStatement;

import java.sql.*;

   public class AccSummaryDAO 	
   {
      static Connection currentCon = null;
      static ResultSet rs = null;  
      static Statement stmt = null;
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
      static final String DB_URL = "jdbc:mysql://localhost:3306/new_schema_demo";
      static ArrayList res = new ArrayList();
      // Database credentials
      static final String USER = "root";
      static final String PASS = "password";
	  static String bal;
      public static List login(UserBean bean) {
	
         //preparing some objects for connection 
   
	
         String username = bean.getUsername();    
         String password = bean.getPassword();   
	    
          System.out.println("username  : "+username);
         // System.out.println("password  : "+password);*/
    	 System.out.println("from date = "+ bean.getFrom()); 
    	 System.out.println("to date = "+ bean.getTo()); 
          Scanner scn = new Scanner(System.in);
          try {
             // STEP 2: Register JDBC driver
             Class.forName("com.mysql.jdbc.Driver");

             // STEP 3: Open a connection
             System.out.print("\nConnecting to database...");
             currentCon = DriverManager.getConnection(DB_URL, USER, PASS);
             
             
            
             String query = "select * from transaction_history  where username =? and transactiondate between ? and ?;";
             System.out.println("3>>>>>>>>>>>>>>>");
             
             PreparedStatement preparedStmt = (PreparedStatement) currentCon.prepareStatement(query);
      	      preparedStmt.setString(1, username);
      	      preparedStmt.setString(2,bean.getFrom());
      	      preparedStmt.setString(3, bean.getTo());
      	      rs=  preparedStmt.executeQuery();
      	 
             //Statement s = currentCon.createStatement();
             //rs = s.executeQuery(query);
      	   //SummaryPOJO sumpo = new SummaryPOJO();  
           while(rs.next()) {
          SummaryPOJO sumpo = new SummaryPOJO();  	   
           sumpo.setUsername(rs.getString("username"));
           sumpo.setUsername(rs.getString("transactiontype"));
           sumpo.setUsername(rs.getString("amount"));
           sumpo.setUsername(rs.getString("transactiondate"));
           System.out.println("tranTime =");
           res.add(sumpo);
           }
           return res;
          // RequestDispatcher rd = request.getRequestDispatcher("DisplayAccountSummary.jsp");
           
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
              // rs.close();
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
		return res;

      }	
   }
