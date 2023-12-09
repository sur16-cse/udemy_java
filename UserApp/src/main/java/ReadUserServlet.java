
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class CreateUserServlet
 */

@WebServlet("/readServlet")
public class ReadUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private Statement stmt;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		String DB_URL = config.getInitParameter("dbUrl");
		String USER = config.getInitParameter("dbUser");
		String PASS = config.getInitParameter("dbPassword");

		try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
		        conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      
		        if (conn != null) {
		        	 System.out.println("start");
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from user");
			PrintWriter out = response.getWriter();
			out.print("<table>");
			out.print("<tr>");
			out.print("<th>");
			out.println("First Name");
			out.print("</th>");
			out.print("<th>");
			out.println("Last Name");
			out.print("</th>");
			out.print("<th>");
			out.println("Email ");
			out.print("</th>");
			out.print("</tr>");
			while (resultSet.next()) {
				out.println("<tr>");
				out.println("<td>");
				out.print(resultSet.getString(1));
				out.println("</td>");
				out.println("<td>");
				out.print(resultSet.getString(2));
				out.println("</td>");
				out.println("<td>");
				out.print(resultSet.getString(3));
				out.println("</td>");
				out.println("</tr>");
			}
			out.print("</table>");

		} catch (SQLException e) {
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
