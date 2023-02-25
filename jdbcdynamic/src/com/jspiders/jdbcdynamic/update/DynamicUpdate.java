package com.jspiders.jdbcdynamic.update;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class DynamicUpdate {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static int result;
	private static FileReader fileReader;
	private static Properties properties;
	private static String query;
	private static String filePath = 
			"D:\\WEJE3\\jdbcdynamic\\resources\\db_info.properties";
	
	public static void main(String[] args) {
		
		try {
			
			fileReader = new FileReader(filePath);
			properties = new Properties();
			properties.load(fileReader);
			
			Class.forName(properties.getProperty("driverPath"));
			
			connection = DriverManager.getConnection
					(properties.getProperty("dburl"), properties);
			
			query = "update emp "
					+ "set contact = ? "
					+ "where empno = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setLong(1, 9876543210L);
			preparedStatement.setInt(2, 5);
			
			result = preparedStatement.executeUpdate();
			
			System.out.println
			("Query OK, " + result + " row(s) affected.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
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
