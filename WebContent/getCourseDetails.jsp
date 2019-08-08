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

if(obj !=null){
	List<CourseBean> courses=(List<CourseBean>)obj;
%>

<form action="GetCourseDetailsSrv" method="post">

Select Course :
<select name="cname">

<%
for(CourseBean course:courses){

%>

<option><%=course.getName() %></option>

<%} %>
</select> <br><br>

<input type="submit" value="GetDetails">

</form>






<%}else{ %>
<h2>Session fails ...Login Again</h2>

<%} %>

</body>
</html>