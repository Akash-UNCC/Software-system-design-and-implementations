import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class TransferDAO {

	 static Connection currentCon = null;
     static ResultSet rs = null;  
     static Statement stmt = null;
     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
     static final String DB_URL = "jdbc:mysql://localhost:3306/new_schema_demo";

     // Database credentials
     static final String USER = "root";
     static final String PASS = "password";
     static String bal; 
     static String new_balance;
     public static String login(UserBean bean) {
    		
         //preparing some objects for connection 
    	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	 Date date = new Date();
    	 System.out.println(dateFormat.format(date));
 	     
         String amount = bean.getAmount();    
         String account = bean.getAccount();   
	     String username = bean.getUsername();;
          System.out.println("amount  : "+amount);
          System.out.println("account  : "+account);
          System.out.println("username  : "+username);
         Scanner scn = new Scanner(System.in);
         try {
             // STEP 2: Register JDBC driver
             Class.forName("com.mysql.jdbc.Driver");

             // STEP 3: Open a connection
             System.out.print("\nConnecting to database...");
             currentCon = DriverManager.getConnection(DB_URL, USER, PASS);
             
             String query = "select * from account_bal where username =?;";
             System.out.println("3>>>>>>>>>>>>>>>");
             
          PreparedStatement preparedStmt = (PreparedStatement) currentCon.prepareStatement(query);
   	      //preparedStmt.setString(1, new_balance);
   	      preparedStmt.setString(1, username);
   	      rs=  preparedStmt.executeQuery();
             
            // Statement s = currentCon.createStatement();
             //rs = s.executeQuery(query);
             
            while(rs.next()) {
            bal=rs.getString("balance");
            System.out.println(" balance user="+bal);
            }      
            int new_bal = Integer.parseInt(bal) - Integer.parseInt(amount);	
            new_balance= String.valueOf(new_bal);
            
            System.out.println("new_balance :::"+new_balance);
            		  String query1 = "update account_bal set balance = ? where username = ?";
            	      PreparedStatement preparedStmt1 = (PreparedStatement) currentCon.prepareStatement(query1);
            	      preparedStmt1.setString(1, new_balance);
            	      preparedStmt1.setString(2, username);
            	      preparedStmt1.executeUpdate();
            	  
        //-----------------------------user ka update---------------------------------------    	      
            	      String query3 = "select * from account_bal where username =?;";
                      System.out.println("3>>>>>>>>>>>>>>>");
                      
                     PreparedStatement preparedStmt3 = (PreparedStatement) currentCon.prepareStatement(query3);
            	      //preparedStmt.setString(1, new_balance);
            	      preparedStmt3.setString(1, account);
            	      rs=  preparedStmt3.executeQuery();
                      
                     // Statement s = currentCon.createStatement();
                      //rs = s.executeQuery(query);
                      
                     while(rs.next()) {
                     bal=rs.getString("balance");
                     System.out.println("balance account ="+bal);
                     }      
                     int new_bal3 = Integer.parseInt(bal) + Integer.parseInt(amount);	
                     String new_balance3= String.valueOf(new_bal3); 	      
            	      
            	      
            	      
            	      String query2 = "update account_bal set balance = ?   where username = ?";
            	      PreparedStatement preparedStmt2 = (PreparedStatement) currentCon.prepareStatement(query2);
            	      preparedStmt2.setString(1, new_balance3);
            	      preparedStmt2.setString(2, account);
            	      preparedStmt2.executeUpdate();
            			 
System.out.println("yaha tak");
            	      
    // Transaction History Code        	      
            				 
            	      String query_th1 = " insert into transaction_history (username, transactiontype, amount, transactiondate)"
                              + " values (?, ?,?,?)";

                            // create the mysql insert preparedstatement
                            PreparedStatement preparedStmt_th1 = (PreparedStatement) currentCon.prepareStatement(query_th1);
                            preparedStmt_th1.setString (1, username);
                            preparedStmt_th1.setString (2, "DEBIT");
                            preparedStmt_th1.setString (3, amount);
                            preparedStmt_th1.setString (4, dateFormat.format(date));

                            // execute the preparedstatement
                            preparedStmt_th1.execute();
                            
                            
                            String query_th2 = " insert into transaction_history (username, transactiontype, amount, transactiondate)"
                                    + " values (?, ?,?,?)";

                                  // create the mysql insert preparedstatement
                                  PreparedStatement preparedStmt_th2 = (PreparedStatement) currentCon.prepareStatement(query_th2);
                                  preparedStmt_th2.setString (1, account);
                                  preparedStmt_th2.setString (2, "CREDIT");
                                  preparedStmt_th2.setString (3, amount);
                                  preparedStmt_th2.setString (4, dateFormat.format(date));

                                  // execute the preparedstatement
                                  preparedStmt_th2.execute();
                            
                      System.out.println(" SUCCESS!\n");
            	      

             System.out.println("Hogaya");
             

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

return new_balance;
	
      }	

}
