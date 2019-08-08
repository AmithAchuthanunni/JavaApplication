<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="wheat">

<h1 align="center" >Student Registration Project</h1>

<div align="center" style="border: 2px solid green;">
<form action="LoginSrv" method="post">

Enter Username :<input type="text" name="uname"><br><br>
Enter Password :<input type="password" name="pass"><br><br>

Login As :<select name="loginas">

<option>Admin</option>
<option>Student</option>

</select><br><br>

<input type="submit" value="Login">



</form>

<br><br>

<a href="registerStudent.jsp">New Student? SignUP</a>




</div>

</body>
</html>