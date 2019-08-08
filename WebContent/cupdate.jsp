<%@page import="com.cts.beans.CourseBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Object obj=session.getAttribute("coursedata1");

if(obj != null){
	
	CourseBean c=(CourseBean)obj;
%>

<form action="CourseUpdateSrv" method="post">

Course Name :<input type="text" name="cname" value="<%=c.getName()%>" readonly><br><br>

Course Fee :<input type="text" name="cfee" value="<%=c.getFee()%>"><br><br>

Course Duration :<input type="text" name="cduration" value="<%=c.getDuration()%>"><br><br>

Course Capacity :<input type="text" name="ccapacity" value="<%=c.getCapacity()%>"><br><br>

Course Availibility <input type="text" name="cavail" value="<%=c.getAvail()%>" readonly><br><br>

<input type="submit" value="Update">


</form>



<%

String bookedNo=request.getParameter("flag");

if(bookedNo != null)
{
%>
<h2>Can not give Less Capacity ..Already <%=bookedNo %> Student Registered</h2>
<%} %>


<%}else{ %>
<h2>Sesion fails..</h2>
<%} %>


</body>
</html>