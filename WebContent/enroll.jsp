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
<body bgcolor="wheat">

<%

Object obj=session.getAttribute("coursesdata");
if(obj != null){

	List<CourseBean> courses=(List<CourseBean>)obj;
%>


<table align="center" border="1">

<tr>

<th>CourseName</th>
<th>CourseFee</th>
<th>CourseDuration</th>
<th>CourseAvailibility</th>

</tr>

<%

for(CourseBean c:courses){
	
	
	String a=c.getAvail()+"";
	
	String b="<a href=EnrollSrv?cname="+c.getName()+">Enroll</a>";
	
	
	
	if(c.getAvail()==0){
		
		a="Full";
		b="Not Applicable";
		
		
	}
	
	
	
%>

<tr>

<td><%=c.getName() %></td>
<td><%=c.getFee() %></td>
<td><%=c.getDuration() %></td>
<td><%=a %></td>
<td><%=b %></td>
</tr>



<%} %>




</table>







<%}else{ %>

<h2>Session fails...</h2>
<%} %>
</body>
</html>