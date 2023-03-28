<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");
String email = request.getParameter("email");
String contact = request.getParameter("contact");
String city = request.getParameter("city");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details Page</title>
</head>
<body>
	<div align="center">
		<fieldset>
			<legend style="margin: auto;">Student Details</legend>
			<table>
				<tr>
					<td>NAME :</td>
					<td><%=name%></td>
				</tr>
				<tr>
					<td>EMAIL :</td>
					<td><%=email%></td>
				</tr>
				<tr>
					<td>CONTACT :</td>
					<td><%=contact%></td>
				</tr>
				<tr>
					<td>CITY :</td>
					<td><%=city%></td>
				</tr>
			</table>
		</fieldset>
	</div>
</body>
</html>