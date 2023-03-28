<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="TagDemo2.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tag Demo Page</title>
</head>
<body>
	<div align="center">
		<h1>Tag Demo Jsp 1</h1>
		<%!List<Integer> list = new ArrayList();%>
		<%
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		%>
		<%
		for (Integer num : list) {
		%>
		<h3><%=num%></h3>
		<%
		}
		%>
	</div>
</body>
</html>