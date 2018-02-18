import java.text.*;


   import java.util.*;
   import java.sql.*;

   public class UserDAO 	
   {
      static Connection currentCon = null;
      static ResultSet rs = null;  
      static Statement stmt = null;
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
      static final String DB_URL = "jdbc:mysql://localhost:3306/new_schema_demo";

      // Database credentials
      static final String USER = "root";
      static final String PASS = "password";
	
      public static UserBean login(UserBean bean) {
	
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
             
             String query = "SELECT * FROM cred";
             System.out.println("1>>>>>>>>>>>>>>>");
             
             Statement s = currentCon.createStatement();
             rs = s.executeQuery(query);
             
             
            // ResultSet rs = stmt.executeQuery(query);
             System.out.println("2>>>>>>>>>>>>>>>");
             boolean b = true;
             // iterate through the java resultset
             System.out.println(" rs "+rs);
             while (rs.next())
             {
               String user_name = rs.getString("username");
               String pass_word = rs.getString("password");
               
 
               if(user_name!=null){
               if(user_name.equals(username) && pass_word.equals(password)){
            	   System.out.println("Welcome " + username);
                   //bean.setFirstName(firstName);
            	   
            	
                   //bean.setLastName(lastName);
                   bean.setValid(true);
                   return bean;
               }else{
            	   
               }
               }
              /* if(bean.isValid()==true){
            	   
               }else{
            	   
            	   
               }
               */
             
            }
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

return bean;
	
      }	
   }
