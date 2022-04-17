<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>search</title>
</head>
<body>

	<table border="1px solid black">
		<thead>

			<td>ID</td>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Action</td>
			<td>Action</td>
		</thead>
		<c:forEach var="j" items="${sessionScope.list1}">
			<tr align="center">
			
				<td>${j.id}</td>
				<td>${j.firstname}</td>
				<td>${j.lastname}</td>
				<td><button>
						<a href='RegController?id=${j.id}&flag=delete'>Delete</a>
					</button></td>
				<td><button>
						<a href='RegController?id=${j.id}&flag=update'>Update</a>
					</button></td>

			</tr>
		</c:forEach>

	</table>

</body>
</html>