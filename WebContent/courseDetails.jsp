<%@page import="com.cts.beans.CourseBean"%>
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

Object obj=session.getAttribute("coursedata");
if(obj != null){

	CourseBean course=(CourseBean)obj;
%>


<h2>Course Name :<%=course.getName() %></h2>
<h2>Course Fee :<%=course.getFee() %></h2>
<h2>Course Duration :<%=course.getDuration() %></h2>
<h2>Course Capacity :<%=course.getCapacity() %></h2>
<h2>Course Availability :<%=course.getAvail() %></h2>


<%}else{ %>

<h2>Session fails...</h2>
<%} %>
</body>
</html>