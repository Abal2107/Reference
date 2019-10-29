<pre><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<script type="text/javascript">

function validate()
{
	var fullname = document.form.fullname.value;
	var email = document.form.email.value;
	var username = document.form.username.value;
	var password = document.form.password.value;
	var conpassword = document.form.conpassword.value;
	
	if(fullname == null || fullname == "")
		{alert("fullname is left empty");
		return false;
		}
		else if(email == null || email =="" )
		{
			alert("email feild is left empty");
			return false;
		}
	
		else if(username == null || username == "")
			{
			alert("username feild is left empty");
			return false;
			}
		else if(passworld.length < 6)
			{
			alert("Password length must be greater than 6");
			return false;
			}
		else if(password != conpassword)
			{
			alert("confirm password feild doesnt match the password");
			return false;
			}
	}

</script>
</head>
<body>
<center><h2>J2ee Registration </h2></center>

<form name="user registration" action= "Registration_servlet" method="post" onsubmit="return validate()">

<table align="center">


<tr>
<td>Full name</td>
<td><input type="text" name="fullname" /></td>
</tr>

<tr>
<td>Email</td>
<td><input type="text" name="email" /></td>
</tr>

<tr>
<td>UserName</td>
<td><input type="text" name="username" /></td>
</tr>

<tr>
<td>Password</td>
<td><input type="text" name="password" /></td>
</tr>


<tr>
<td>Confirm Password</td>
<td><input type="password" name="conpassword" /></td>
</tr>

<tr>
<td><%=(request.getAttribute("errMessage") == null) ? ""
: request.getAttribute("errMessage")%>
</td>
</tr>

<tr>
<td><input type="submit" value="Register" />
<input  type = "reset" value="Reset"/>
</td>
</tr>


</table>

<a href = "Login.jsp"> LOGIN </a>

</form>

</body>
</html>