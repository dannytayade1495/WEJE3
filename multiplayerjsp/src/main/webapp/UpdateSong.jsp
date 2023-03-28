<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
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
<title>Update Song Page</title>
</head>
<body>

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
	if (id == null) {
	%>
	<div align="center">
		<form action="./UpdateSong.jsp" method="post">
			<fieldset>
				<legend style="margin: auto;">Update Song</legend>
				<table>
					<tr>
						<td>Enter ID</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
			</fieldset>
			<input style="margin-top: 2px;" type="submit" value="select">
		</form>
		<%
		if (result != 0) {
		%>
		<h5><%=result%>
			row affected
		</h5>
		<%
		}
		%>
	</div>
	<%
	} else {
	openConnection();
	query = "select * from song where id = ?";
	preparedStatement = connection.prepareStatement(query);
	preparedStatement.setString(1, id);
	resultSet = preparedStatement.executeQuery();
	%>
	<div align="center">
		<form action="./UpdateSong.jsp" method="post">
			<fieldset>
				<legend style="margin: auto;">Update Song</legend>
				<table>
					<thead>
						<tr>
							<td hidden="true">Song ID</td>
							<td>Song Name</td>
							<td>Singer Name</td>
						</tr>
					</thead>
					<%
					while (resultSet.next()) {
					%>
					<tr>
						<td hidden="true"><input type="text"
							value="<%=resultSet.getString(1)%>" name="id"></td>
						<td><input type="text" value="<%=resultSet.getString(2)%>"
							name="songName"></td>
						<td><input type="text" value="<%=resultSet.getString(3)%>"
							name="singerName"></td>
					</tr>
					<%
					}
					%>
				</table>
			</fieldset>
			<input style="margin-top: 2px;" type="submit" value="update">
		</form>
	</div>
	<%
	}
	%>

</body>
</html>