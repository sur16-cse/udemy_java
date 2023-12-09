
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
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

@WebServlet(urlPatterns = "/addServlet", initParams = {
		@WebInitParam(name = "dbUrl", value = "jdbc:mysql://localhost:3306/"),
		@WebInitParam(name = "dbUser", value = "root"), 
		@WebInitParam(name = "dbPassword", value = "password"),})
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private Statement stmt;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init();
		String DB_URL = config.getInitParameter("dbUrl");
		String USER = config.getInitParameter("dbUser");
		String PASS = config.getInitParameter("dbPassword");

		try {
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

		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			Statement statement = conn.createStatement();
			int result = statement.executeUpdate("insert into user values('" + firstname + "','" + lastname + "','"
					+ email + "','" + password + "')");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.print("<H1>User Created</H1>");
			} else {
				out.print("<H1>Error creating the user</H1>");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
