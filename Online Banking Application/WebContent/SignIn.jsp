<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>Sign In</title>
	</head>
<script>
function validateForm() {
    var x = document.forms["myForm"]["un"].value;
    if (x == "") {
        alert("Name must be filled out");
        return false;
    }
    var y = document.forms["myForm"]["pw"].value;
    if (y == "") {
        alert("Password must be filled out");
        return false;
    }
}
</script>
<style>	
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
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

body {
    background-color: white;
}

h1 {
    color: white;
    text-align: center;
}

h2 {
    text-align: center;
    text-transform: uppercase;
    color: #4CAF50;
}

p {
    font-family: verdana;
    font-size: 20px;
}
</style>	

	<body>
		<form name="myForm" onsubmit="return validateForm()" action="SignIn" method="get">
   
			<h2>Please enter your username 	</h2>	
			<input type="text" placeholder="Enter Username" name="un"/><br>		
		
			<h2>Please enter your password </h2>
			<input type="password" placeholder="Enter password" name="pw"/>
			
			<input type="submit" value="SignIn">
			</form>
			<form action="SignUp.jsp">			
		    <input type="submit" value="New User? SignUp">
		    <input type="submit" value="Forgot Password">
	       </form>
	</body>
</html>