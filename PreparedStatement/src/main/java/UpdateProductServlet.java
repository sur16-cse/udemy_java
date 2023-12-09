
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
	Statement stmt;
	
	PreparedStatement stmt1;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		ServletContext context = config.getServletContext();
		String DB_URL = context.getInitParameter("dbUrl");
		String USER = context.getInitParameter("dbUser");
		String PASS = context.getInitParameter("dbPassword");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			if (conn != null) {
				stmt = conn.createStatement();
				String sql = "CREATE DATABASE IF NOT EXISTS prepared";
				stmt.executeUpdate(sql);
				System.out.println("Database created successfully...");

				sql = "use prepared";
				stmt.executeUpdate(sql);
				System.out.println("Database current");

				sql = "create table IF NOT EXISTS product (id int,name varchar(20),description varchar(20),price int)";
				stmt.executeUpdate(sql);
				System.out.println("Created table in the given database...");

				stmt1 = conn.prepareStatement("update product set price=? where id=?");
			} else {
				System.out.println("Failed to establish a database connection.");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		super.init();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		int price = Integer.parseInt(request.getParameter("price"));

		try {
			stmt1.setInt(1, price);
			stmt1.setInt(2,id);
			
			int res=stmt1.executeUpdate();
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.print("<b>"+res+"Products Updated</b>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.destroy();
	}

}
