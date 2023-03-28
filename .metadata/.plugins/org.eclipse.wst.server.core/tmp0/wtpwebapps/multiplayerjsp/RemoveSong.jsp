<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<%
String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove Song Page</title>
</head>
<body>

	<div align="center">
		<form action="./RemoveSong.jsp" method="post">
			<fieldset>
				<legend style="margin: auto;">Remove Song</legend>
				<label>Enter id :</label> <input type="text" name="id">
			</fieldset>
			<input style="margin-top: 2px;" type="submit" value="remove">
		</form>
	</div>

	<%!Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	int result = 0;
	String dburl = "jdbc:mysql://localhost:3306/weje3";
	String user = "root";
	String password = "root";
	String driverPath = "com.mysql.cj.jdbc.Driver";
	String query;%>

	<%!private void openConnection() {
		try {
			Class.forName(driverPath);
			connection = DriverManager.getConnection(dburl, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}%>

	<%!private void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}%>

	<%
	openConnection();
	query = "select * from song";
	preparedStatement = connection.prepareStatement(query);
	resultSet = preparedStatement.executeQuery();
	%>
	<div align="center">
		<table>
			<thead>
				<tr>
					<td>Song ID</td>
					<td>Song Name</td>
					<td>Singer Name</td>
				</tr>
			</thead>
			<%
			while (resultSet.next()) {
			%>
			<tr>
				<td><%=resultSet.getString(1)%></td>
				<td><%=resultSet.getString(2)%></td>
				<td><%=resultSet.getString(3)%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<%
	closeConnection();
	%>
	<%
	if (id != null) {
		openConnection();
		query = "delete from song where id = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, id);
		result = preparedStatement.executeUpdate();
	}
	%>

	<%
	if (result != 0) {
	%>
	<h5 align="center">
		<%=result%>
		row deleted successfully
	</h5>
	<%
	}
	%>
	<%
	closeConnection();
	%>

</body>
</html>