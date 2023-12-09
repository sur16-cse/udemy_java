package com.surbhi.springdata.idgenerators;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnection {
	public static void main(String[] args) {
		String DB_URL = "jdbc:mysql://localhost:3306/mydb";
		String USER = "root";
		String PASS = "password";
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

				Statement stmt = conn.createStatement();) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql;
			sql = "use mydb";
			stmt.executeUpdate(sql);
			System.out.println("Database current");

			//identity generator type
			sql = "create table IF NOT EXISTS  employee(id int PRIMARY KEY ,name varchar(20))";
			String sql1 ="create table IF NOT EXISTS id_gen(gen_name varchar(60) PRIMARY KEY, gen_val int(20))";
					
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql1);
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
