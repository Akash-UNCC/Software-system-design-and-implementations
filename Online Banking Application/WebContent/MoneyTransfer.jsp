<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function validateForm() {
    var x = document.forms["myForm1"]["acc"].value;
    if (x == "") {
        alert("Account Holder name must be filled out");
        return false;
    }
    var y = document.forms["myForm1"]["amo"].value;
    if (y == "") {
        alert("Amount must be filled out");
        return false;
    }
}
</script>
<style>
h2 {
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
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
</style>
</head>
<body>

<%
if(session.getAttribute("currentSessionUsername")==null){
	response.sendRedirect("SignIn.jsp");
}
%>
            <form name="myForm1" onsubmit="return validateForm()" action="TransferMoney" onsubmit="return validateForm()" method="get" >

			<h2>Account Holder name</h2> 		
			<input type="text" name="acc"/><br>		
		
			<h2>Amount transfer<h2>
			<input type="text" name="amo"/>
			
			<input type="submit" value="Send Money">			
		
		</form>


</body>
</html>