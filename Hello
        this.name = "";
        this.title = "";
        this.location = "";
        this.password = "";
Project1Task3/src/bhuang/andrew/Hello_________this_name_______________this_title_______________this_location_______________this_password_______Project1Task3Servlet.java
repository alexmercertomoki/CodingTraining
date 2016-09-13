package bhuang.andrew;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Hello_________this_name_______________this_title_______________this_location_______________this_password_______Project1Task3Servlet
		extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
