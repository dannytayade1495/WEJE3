<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tag Demo 2</title>
</head>
<body>

	<div align="center">
		<h1>Tag Demo Jsp 2</h1>
		<%!int a = 10;
	int b = 20;
	int c = 0;%>

		<%!public int add() {
		return a + b;
	}%>

		<%
		c = add();
		%>

		<h3><%=c%></h3>
	</div>

</body>
</html>