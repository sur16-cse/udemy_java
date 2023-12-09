import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class AdditionServlet extends GenericServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getParameter("number1")!=null && req.getParameter("number2")!=null) {
			Long num1 = Long.parseLong(req.getParameter("number1"));
			Long num2 = Long.parseLong(req.getParameter("number2"));
			PrintWriter writer = res.getWriter();
			writer.println("The result is: "+(num1+num2));
		}
		
	}

}
