<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>Sign Up</title>
	</head>
<script>
function validateForm() {
    var x = document.forms["myForm"]["pw"].value;
    var y = document.forms["myForm"]["pw1"].value;
    if (x == y) {
      
    }else{
    	  alert("Password do not Match");
          return false;	
    }
    
}
</script>
<style>	
input[type=text], input[type=password],input[type=select] {
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
		<form name="myForm" onsubmit="return validateForm()" action="SignUp"  method="get">

			<h2>username</h2> 		
			<input type="text" name="un"/><br>		
		
			<h2>password</h2>
			<input type="password" name="pw"/>
			
			<h2>Confirm password</h2>
			<input type="password" name="pw1"/>
			
			<h2>Date of Birth<h2>
			<input type="date" name="dob"/>
			<h2>Security Question</h2>
			
			<h2><select name="sq"></h2>
            </h2><option value="Your first pet name"></h2>My first Pet Name</h2></option></h2>
            </h2><option value="Your first school">My first School</option></h2>
            </h2><option value="Your favourite place">My favorite place</option></h2>
            </h2> <option value="Your favourite food">My favorite food</option></h2>
            </h2> </select></h2>
			<h2>Answer</h2> 		
			<input type="text" name="ans"/><br>	
			<input type="submit" value="SignUp">			
		
		</form>
	</body>
</html>