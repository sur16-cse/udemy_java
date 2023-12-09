
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
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

@WebServlet("/updateServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private Statement stmt;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ServletContext context = config.getServletContext();
		String DB_URL =context.getInitParameter("dbUrl");
		String USER = context.getInitParameter("dbUser");
		String PASS = context.getInitParameter("dbPassword");

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost()");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			Statement statement = conn.createStatement();
			int result = statement
					.executeUpdate("update user set password='" + password + "' where email='" + email + "'");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.print("<H1>Password Updated</H1>");
			} else {
				out.print("<H1>Error Creating the User</H1>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

public void destroy() {
try {
	System.out.println("destroy()");
	conn.close();
} catch (SQLException e) {
	e.printStackTrace();
}

}

}
