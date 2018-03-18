package com.telusko.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class LoginDAO {

	
    static final String USER = "root";
    static final String PASS = "password";

	static Connection connection = null;
    static ResultSet rs = null;  
    static Statement stmt = null;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/playdb";
	
	
    public static ResultSet getResultSet() throws ClassNotFoundException, SQLException{
    Class.forName("com.mysql.jdbc.Driver");

    // STEP 3: Open a connection
    System.out.print("\nConnecting to database...");
    connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
    
    String query = "SELECT * FROM validate_login";
    System.out.println("1>>>>>>>>>>>>>>>");
    
    Statement s = (Statement) connection.createStatement();
    return rs = s.executeQuery(query);
    }
}
