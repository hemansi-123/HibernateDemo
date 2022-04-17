<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="RegController" method=post>
 <input type="search" name="search">
<input type='hidden' name='flag' value='search'>
<input type="submit">
</form>
<table border="1px solid black">
	<thead>
	
		<td>ID</td>
		<td>First Name</td>
		<td>Last Name</td>
		
	</thead>
	<c:forEach var="i" items="${sessionScope.list}" varStatus="j">
		<tr align="center">
		<%-- <td>${j.count}</td> --%>
		
		<td>${i.id}</td>
		<td>${i.firstname}</td>
		<td>${i.lastname}</td>
		
		
		</tr>
	</c:forEach>
	
</table>
	
</body>
</html>