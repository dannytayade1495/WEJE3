package com.jspiders.jdbc.insert;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import com.jspiders.jdbc.entity.Employee;

public class EmployeeInsert {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static int result;
	private static FileReader fileReader;
	private static Properties properties;
	private static String query;
	private static String filePath = 
			"D:\\WEJE3\\jdbc\\resources\\db_info.properties";
	
	public static void main(String[] args) {
		
		try {
			
			fileReader = new FileReader(filePath);
			properties = new Properties();
			properties.load(fileReader);
			
			Class.forName(properties.getProperty("driverPath"));
			
			connection = DriverManager.getConnection
					(properties.getProperty("dburl"), properties);
			
			query = "insert into emp "
					+ "values (?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			
			Employee employee = new Employee();
			employee.setEmpno(6);
			employee.setEname("Mehta");
			employee.setEmail("mehtasahab@gmail.com");
			employee.setContact(9856741230L);
			
			preparedStatement.setInt(1, employee.getEmpno());
			preparedStatement.setString(2, employee.getEname());
			preparedStatement.setString(3, employee.getEmail());
			preparedStatement.setLong(4, employee.getContact());
			
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
