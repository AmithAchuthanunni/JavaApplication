<%@page import="com.cts.beans.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
<%

Object obj=session.getAttribute("studentdata");
if(obj != null){
	
	StudentBean student=(StudentBean)obj;
%>

<h1 align="center">Update Details Screen</h1>

<form action="UpdateStudentSrv" method="post">


Roll is :<input type="text" name="sroll" value="<%=student.getRoll()%>" readonly><br><br>

Name :<input type="text" name="sname" value="<%=student.getName()%>" readonly><br><br>

Address :<input type="text" name="saddress" value="<%=student.getAddress()%>"><br><br>

Email :<input type="email" name="semail" value="<%=student.getEmail()%>"><br><br>

Phone :<input type="text" name="sphone" value="<%=student.getPhone()%>"><br><br>

Password :<input type="password" name="spassword" value="<%=student.getPassword()%>"><br><br>

<input type="submit" value="Update">

</form>






<%}else{ %>

<h2>Session fails <a href="index.jsp">Login Again</a></h2>

<%} %>

</body>
</html>