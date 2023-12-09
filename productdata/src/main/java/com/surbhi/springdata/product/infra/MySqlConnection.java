package com.surbhi.springdata.product.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnection {
	public static void main(String[] args) {
		String DB_URL = "jdbc:mysql://localhost:3306/";
		String USER = "root";
		String PASS = "password";
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				
				Statement stmt = conn.createStatement();) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "CREATE DATABASE IF NOT EXISTS Products";
			stmt.executeUpdate(sql);
			System.out.println("Database created successfully...");
			
			sql = "use Products";
			stmt.executeUpdate(sql);
			System.out.println("Database current");
			
			sql = "create table IF NOT EXISTS product (id int,name varchar(20),description varchar(20),price int) ";
			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
			
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
