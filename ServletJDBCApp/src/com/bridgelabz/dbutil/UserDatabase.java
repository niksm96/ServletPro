package com.bridgelabz.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.bridgelabz.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDatabase {
	public static Connection getMyConnection() throws ClassNotFoundException, SQLException {
		String hostName = "localhost";
		String dbName = "servletproject";
		String userName = "root";
		String password = "password";
		return getMySQLConnection(hostName, dbName, userName, password);
	}

	public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password)
			throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}

	public static void registerUser(User user) throws ClassNotFoundException, SQLException {
		String insertQuery = "insert into User values(?,?,?,?,?,?)";
		Connection connection = getMyConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setInt(1, 0);
		preparedStatement.setString(2, user.getFirstName());
		preparedStatement.setString(3, user.getLastName());
		preparedStatement.setLong(4, user.getContact());
		preparedStatement.setString(5, user.getEmailId());
		preparedStatement.setString(6, user.getPassword());
		preparedStatement.execute();
		connection.close();
	}

	public static User loginUser(User user) throws ClassNotFoundException, SQLException {
		String selectQuery = "select * from User where emailid=? and password=?";
		Connection connection = getMyConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
		preparedStatement.setString(1, user.getEmailId());
		preparedStatement.setString(2, user.getPassword());
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			User userDetails=new User();
			userDetails.setFirstName(resultSet.getString(2));
			userDetails.setLastName(resultSet.getString(3));
			userDetails.setContact(resultSet.getLong(4));
			userDetails.setEmailId(resultSet.getString(5));
			userDetails.setPassword(resultSet.getString(6));
			return userDetails;
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return null;

	}
	
	public static int editUser(User user) throws ClassNotFoundException, SQLException {
		String updateQuery="update User set firstName=?, lastName=?, contact=? where emailid=?";
		int updatedRows = 0;
		Connection connection = getMyConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
		preparedStatement.setString(1, user.getFirstName());
		preparedStatement.setString(2, user.getLastName());
		preparedStatement.setLong(3, user.getContact());
		preparedStatement.setString(4, user.getEmailId());
		updatedRows = preparedStatement.executeUpdate();
		connection.close();
		return updatedRows;
	}
}
