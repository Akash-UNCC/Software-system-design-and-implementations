<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
h1 {
    text-align: center;
    text-transform: uppercase;
    color: #4CAF50;
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
<h1>your transaction is successful!! Your new Account balance is <%= request.getAttribute("new_balance") %> </h1>
  
  
   <form action="Logged.jsp">
   <input type="submit" value="Back"/>
  </form>
</body>
</html>