
package com;
import javax.servlet.http.*;

import javax.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;
 
/**
 * Servlet implementation class MySQLConnect
 */
 
public class MySQLConnect extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/new_schema_demo";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "password";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("un");
        String pass = request.getParameter("pw");
        


   
            Connection conn = null;
            Statement stmt = null;
           
            try {
                // STEP 2: Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                // STEP 3: Open a connection
                System.out.print("\nConnecting to database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println(" SUCCESS!\n");

                // STEP 4: Ask for user input



                String query = " insert into cred (username, password)"
                        + " values (?, ?)";

                      // create the mysql insert preparedstatement
                      PreparedStatement preparedStmt = conn.prepareStatement(query);
                      preparedStmt.setString (1, user);
                      preparedStmt.setString (2, pass);


                      // execute the preparedstatement
                      preparedStmt.execute();
                      
                System.out.println(" SUCCESS!\n");

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
