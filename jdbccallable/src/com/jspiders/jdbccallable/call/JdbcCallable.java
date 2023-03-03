package com.jspiders.jdbccallable.call;

import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

public class JdbcCallable {
	
	private static Connection connection;
	private static CallableStatement callableStatement;
	private static ResultSet resultSet;
	private static FileReader fileReader;
	private static Properties properties;
	private static String query;
	private static String filePath = 
			"D:\\WEJE3\\jdbccallable\\resources\\db_info.properties";
	
	public static void main(String[] args) {
		
		try {
			
			fileReader = new FileReader(filePath);
			properties = new Properties();
			properties.load(fileReader);
			
			Class.forName(properties.getProperty("driverPath"));
			
			connection = DriverManager.getConnection
					(properties.getProperty("dburl"), properties);
			
			query = "call proc1()";
			callableStatement = connection.prepareCall(query);
			
			resultSet = callableStatement.executeQuery();
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " || "
						+ resultSet.getString(2) + " || "
						+ resultSet.getString(3) + " || "
						+ resultSet.getString(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (callableStatement != null) {
					callableStatement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
