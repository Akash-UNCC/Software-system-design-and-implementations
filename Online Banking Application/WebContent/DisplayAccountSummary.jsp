<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page import="java.util.List" %>
<%@ page import="java.sql.*" %>
<title>Insert title here</title>
</head>

<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
input[type=submit] {
background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}
</style>


<body>
<%
if(session.getAttribute("currentSessionUsername")==null){
	response.sendRedirect("SignIn.jsp");
}
%>
<% 
Connection currentCon = null;
ResultSet rs = null;  
Statement stmt = null;
String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
String DB_URL = "jdbc:mysql://localhost:3306/new_schema_demo";

// Database credentials
String USER = "root";
String PASS = "password";
%>

<table id="customers">
<tr>

<td><b>Transaction Type</b></td>
<td><b>Amount</b></td>
<td><b>Transaction Date</b></td>
</tr>
<% 
try {
             // STEP 2: Register JDBC driver
             Class.forName("com.mysql.jdbc.Driver");

             // STEP 3: Open a connection
             System.out.print("\nConnecting to database...");
             currentCon = DriverManager.getConnection(DB_URL, USER, PASS);
            // String username = (String)request.getSession().getAttribute("currentSessionUser");
            
    		 
    		 //session1.setAttribute("currentSessionUsername",request.getParameter("un")); 
    		 
             //UserBean user = new UserBean();
    		 String username =  (String)request.getSession(false).getAttribute("currentSessionUsername");
    		 //String username = user.getUsername();
    		 // String username = request.getParameter("username");
             String from_date = request.getParameter("from");
             String to_date = request.getParameter("to");
             String query = "select * from transaction_history  where username =? and transactiondate between ? and ?;";
             System.out.println("3>>>>>>>>>>>>>>>");
             
              PreparedStatement preparedStmt = (PreparedStatement) currentCon.prepareStatement(query);
      	      preparedStmt.setString(1, username);
      	      preparedStmt.setString(2,from_date);
      	      preparedStmt.setString(3, to_date);
      	      rs=  preparedStmt.executeQuery();
      	 
             //Statement s = currentCon.createStatement();
             //rs = s.executeQuery(query);
      	   //SummaryPOJO sumpo = new SummaryPOJO();  
           while(rs.next()) {%>
           <tr>
           
           
           <td><%=rs.getString("transactiontype") %></td>
           <td><%=rs.getString("amount") %></td>
           <td><%=rs.getString("transactiondate") %></td>

            </tr>
   
           <%}
          
     
           
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

/*  */
       

%>
</table>
<form action="Logged.jsp">
<input type="submit" value="Back"/>
</form>
</body>
</html>