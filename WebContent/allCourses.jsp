<%@page import="com.cts.beans.CourseBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">

<%

Object obj=session.getAttribute("coursesdata");

if(obj != null){
	
	List<CourseBean> courses=(List<CourseBean>)obj;
%>

<table border="1" align="center">

<tr> 

	<th>CourseName</th>
	<th>CourseFee</th>
	<th>CourseDuration</th>
	<th>CourseCapacity</th>
	<th>CourseAvailability</th>
	
</tr>

<% for(CourseBean c:courses) {
%>


<tr> 

	<td><%=c.getName() %></td>
	<td><%=c.getFee() %></td>
	<td><%=c.getDuration() %></td>
	<td><%=c.getCapacity()%></td>
	<td><%=c.getAvail() %></td>
	<td><a href=UpdateCourseSrv?cname=<%=c.getName() %>>Update</a></td>
	
</tr>



<%} %>



</table>








<%}else{ %>

<h2>Session fails...</h2>

<%} %>
</body>
</html>