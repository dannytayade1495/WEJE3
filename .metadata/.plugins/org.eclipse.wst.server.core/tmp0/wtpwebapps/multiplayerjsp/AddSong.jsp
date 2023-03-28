<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<%
String id = request.getParameter("id");
String songName = request.getParameter("songName");
String singerName = request.getParameter("singerName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Song Page</title>
</head>
<body>

	<div align="center">
		<form action="">
			<fieldset>
				<legend style="margin: auto;">Add Song</legend>
				<table>
					<tr>
						<td>Id</td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td>Name</td>
						<td><input type="text" name="songName"></td>
					</tr>
					<tr>
						<td>Singer</td>
						<td><input type="text" name="singerName"></td>
					</tr>
				</table>
			</fieldset>
			<input type="submit" value="Add">
		</form>
	</div>

	<%!Connection connection;
	PreparedStatement preparedStatement;
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}%>

	<%
	if (id != null && songName != null && singerName != null) {
		openConnection();
		query = "insert into song values (?,?,?)";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, id);
		preparedStatement.setString(2, songName);
		preparedStatement.setString(3, singerName);
		result = preparedStatement.executeUpdate();

		if (result != 0) {
	%>
	<h5 align="center"><%=result%>
		row inserted successfully
	</h5>
	<%
	}
	%>

	<%
	closeConnection();
	}
	%>

</body>
</html>