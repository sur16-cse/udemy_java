import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {
	public static void main(String[] args) {
		String DB_URL = "jdbc:mysql://localhost:3306/";
		String USER = "root";
		String PASS = "password";

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();) {
			String sql = "CREATE DATABASE IF NOT EXISTS ACCOUNTS";
			stmt.executeUpdate(sql);
			System.out.println("Database created successfully...");
			
			sql = "use ACCOUNTS";
			stmt.executeUpdate(sql);
			System.out.println("Database current");
			
			sql = "create table IF NOT EXISTS account(accno int,lastname varchar(25),firstname varchar(25),bal int,PRIMARY KEY (accno))";
			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
			
			sql="insert into account values(1,'surbhi','kumari',1000)";
			try {
				stmt.executeUpdate(sql);
				System.out.println("rows got inserted");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				e.printStackTrace();
			}
			
			
//			sql="update account set bal=5000 where accno=1 AND bal=1000";
//			stmt.executeUpdate(sql);
//			System.out.println("rows got updated");
			
//			sql="delete from account where accno=1";
//			stmt.executeUpdate(sql);
//			System.out.println("rows got deleted");
			
			sql ="select * from account";
			ResultSet executeQuery = stmt.executeQuery(sql);
			while(executeQuery.next()) {
				System.out.println(executeQuery.getInt(1));
				System.out.println(executeQuery.getString(2));
				System.out.println(executeQuery.getString(3));
				System.out.println(executeQuery.getInt(4));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
