import javax.servlet.http.*;


import javax.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Servlet implementation class MySQLConnect
 */
 
public class SignUp extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/new_schema_demo";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "password";
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String user1 = request.getParameter("un");
        String pass = request.getParameter("pw");
        String dob =  request.getParameter("dob");
        String SecQues = request.getParameter("sq");
        String ans =  request.getParameter("ans");
        
     //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
   	// Date date = new Date();
       // Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dob);  
   	 //System.out.println(dateFormat.format(dob));
        
        Connection conn = null;
        Statement stmt = null;
        Scanner scn = new Scanner(System.in);
        UserBean user = new UserBean();
        try {
            // STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // STEP 3: Open a connection
            System.out.print("\nConnecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println(" SUCCESS!\n");


            String query = " insert into cred (username, password)"
                    + " values (?, ?)";

                  // create the mysql insert preparedstatement
                  PreparedStatement preparedStmt = conn.prepareStatement(query);
                  preparedStmt.setString (1, user1);
                  preparedStmt.setString (2, pass);


                  // execute the preparedstatement
                  preparedStmt.execute();
           System.out.println("yaha tak aaya");       
                  
                String query1 = " insert into userdetails (username, password, dob, SecurityQues,answer)"
                          + " values (?, ?, ?, ?, ?)";

                        // create the mysql insert preparedstatement
                        PreparedStatement preparedStmt1 = conn.prepareStatement(query1);
                        preparedStmt1.setString (1, user1);
                        preparedStmt1.setString (2, pass);
                        preparedStmt1.setString (3, dob);
                        preparedStmt1.setString (4, SecQues);
                        preparedStmt1.setString (5, ans);
                        // execute the preparedstatement
                        preparedStmt1.execute();       
                  
                        String query2 = " insert into account_bal (username, balance)"
                                + " values (?, ?)";

                              // create the mysql insert preparedstatement
                              PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
                              preparedStmt2.setString (1, user1);
                              preparedStmt2.setString (2, "0");

                              // execute the preparedstatement
                              preparedStmt2.execute();              
                        
                        
            System.out.println(" SUCCESS!\n");

         /*   System.out.println("user gets a session!");  
            HttpSession session = request.getSession(true);	    
            session.setAttribute("currentSessionUser",user);
            
            HttpSession session1 = request.getSession(true);	    
            session1.setAttribute("currentSessionUsername",request.getParameter("un")); */
            response.sendRedirect("SignIn.jsp");
            
            
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt != null)
                    conn.close();
            } catch(SQLException se) {
            }
            try {
                if(conn != null)
                    conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Thank you for your patronage!");
      }
}