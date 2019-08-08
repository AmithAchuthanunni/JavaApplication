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
<body>
<%

Object obj=session.getAttribute("coursedata");
if(obj != null){

	List<CourseBean> courses=(List<CourseBean>)obj;
	
	if(courses.size()>0){
%>

<table align="center" border="1">

<tr>

<th>Course Name</th>
<th>Course Fee</th>
<th>Course Duration</th>

</tr>


<%for(CourseBean c:courses){ %>


<tr>

<td><%=c.getName() %></td>
<td><%=c.getFee() %></td>
<td><%=c.getDuration() %></td>

</tr>



<%} %>



</table>







<%}else{ %>

<h2>You r not Enrolled In Any Course</h2>

<%} %>

<%}else{ %>

<h2>Sesion fails...</h2>

<%} %>

</body>
</html>