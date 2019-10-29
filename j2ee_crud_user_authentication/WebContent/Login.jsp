<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
</head>
<body>

<form name="user registration" action= "Login_servlet" method="post">

<table>

<tr>
<td>UserName</td> 
<td><input type="text" name ="username"/></td>
</tr>

<tr>
<td>Password</td> 
<td><input type="password" name ="password"/></td>
</tr>

<tr>
<td><input type="submit" value="Register" /></td>
</tr>

<tr>
<td><%=(request.getAttribute("Message") == null) ? ""
: request.getAttribute("Message")%>
</td>
</tr>

</table>

</form>



</body>
</html>