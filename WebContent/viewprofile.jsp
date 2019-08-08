<%@page import="com.cts.beans.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">

<%

Object obj=session.getAttribute("studentdata");
if(obj != null){
	StudentBean student=(StudentBean)obj;

%>

<h2>Roll is <%=student.getRoll() %></h2>
<h2>Name is <%=student.getName() %></h2>
<h2>Address is <%=student.getAddress() %></h2>
<h2>Email is <%=student.getEmail() %></h2>
<h2>Phone is <%=student.getPhone() %></h2>
<h2>Password is <%=student.getPassword() %></h2>







<%}else {%>

<h2>Session fails ..Login Again..</h2>
<%} %>

</body>
</html>