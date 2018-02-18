<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.flex-container {
  display: flex;
  flex-wrap: wrap;
  align-items: center;
}

.flex-container>div {
  
  width: 250px;
  height: 50px;
  margin: 20px;
  text-align: center;
  line-height: 175px;
  font-size: 100px;
}

input[type=submit] {
background-color: #4CAF50;
    color: white;
    padding: 18px 30px;
    margin: 18px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    line-height: 100px;
}
</style>
<body>

<%
if(session.getAttribute("currentSessionUsername")==null){
	response.sendRedirect("SignIn.jsp");
}
%>

<div class="flex-container">
  <div style="flex-grow: 1"><form action="AccountBalance">
    <input type="submit" value="My Account Balance">
</form></div>
  <div style="flex-grow: 1"><form action="MoneyTransfer.jsp">
    <input type="submit"value="Transfer Money">
</form></div>
  <div style="flex-grow: 1"><form action="AccountSummary.jsp">
    <input type="submit"value="Account Summary">
</form></div>

</form>
  <div style="flex-grow: 1"><form action="Logout.jsp">
    <input type="submit"value="Logout">
</form></div>

<!--   <div style="flex-grow: 1"><form action="Logout">
    <input type="submit"value="Logout">
</form></div> -->

  
</div>




</body>
</html>



