package com;
// STEP 1: Import required packages
import java.sql.*;

import java.util.*;

public class SQLInsert {
// JDBC driver name and database URL
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
static final String DB_URL = "jdbc:mysql://localhost:3306/new_schema_demo";

// Database credentials
static final String USER = "root";
static final String PASS = "password";

public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    Scanner scn = new Scanner(System.in);
    try {
        // STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        // STEP 3: Open a connection
        System.out.print("\nConnecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println(" SUCCESS!\n");

        // STEP 4: Ask for user input
        System.out.print("Enter user name: ");
        String username = scn.nextLine();

        System.out.print("Enter password: ");
        String password = scn.nextLine();


        String query = " insert into cred (username, password)"
                + " values (?, ?)";

              // create the mysql insert preparedstatement
              PreparedStatement preparedStmt = conn.prepareStatement(query);
              preparedStmt.setString (1, username);
              preparedStmt.setString (2, password);


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