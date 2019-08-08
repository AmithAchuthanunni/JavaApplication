<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">

<h1 align="center">Student Register Screen</h1>


<form action="StudentRegisterSrv" method="post">


Enter Name :<input type="text" name="sname"><br><br>
Enter Address :<input type="text" name="saddres"><br><br>
Enter Email :<input type="email" name="semail"><br><br>
Enter Phone :<input type="text" name="sphone"><br><br>
Enter Password :<input type="password" name="spassword"><br><br>

<input type="submit" value="Register">


</form>





</body>
</html>