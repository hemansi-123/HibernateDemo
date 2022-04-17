<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RegController" method="post">
		<table border="1px">
			<tr>
				<td>FIRSTNAME:</td>
				<td><input type="text" name="fn" /></td>
			</tr>
			<tr>
				<td>LASTNAME:</td>
				<td><input type="text" name="ln" /> <input type="hidden"
					name="flag" value="edit"></td>
			</tr>
			<tr>
				<td><input type="submit" value="SUBMIT" /></td>
			</tr>
		</table><br>
			</form><br>
</body>
</html>