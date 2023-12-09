
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class CreateUserServlet
 */

@WebServlet("/deleteServlet")
public class deleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private Statement stmt;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		String DB_URL = "jdbc:mysql://localhost:3306/";
		String USER = "root";
		String PASS = "password";

		try {
			  System.out.println("begin");
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	        conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      
	        if (conn != null) {
	            stmt = conn.createStatement();
	            String sql = "CREATE DATABASE IF NOT EXISTS mydb";
	            stmt.executeUpdate(sql);
	            System.out.println("Database created successfully...");
	            
	            sql = "use mydb";
	            stmt.executeUpdate(sql);
	            System.out.println("Database current");
	            
	            sql = "create table IF NOT EXISTS user(firstName varchar(20), lastName varchar(20), email varchar(20), password varchar(20))";
	            stmt.executeUpdate(sql);
	            System.out.println("Created table in the given database...");
	        } else {
	            System.out.println("Failed to establish a database connection.");
	        }
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		String email=request.getParameter("email");
		
		try {
			Statement statement = conn.createStatement();
			int result=statement.executeUpdate("delete from user where email='"+email+"'");
			PrintWriter out = response.getWriter();
			if(result>0) {
				out.print("<H1>User Deleted</H1>");
			} else {
				out.print("<H1>User not found in the database</H1>");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.destroy();
	}

}
