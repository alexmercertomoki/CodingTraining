package andrew.cmu.group1final;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AdviseServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String advice =  req.getParameter("advice");
		String docname=req.getParameter("docname");
		
		DoctorAdviceServlet.adviceAr.add("<Info> <DoctorName> "+docname+" </DoctorName> "
				+ "<Advice>"+advice+"</Advice></Info>");
		
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("/mdtlastproject");
		dispatcher.forward(req, resp);
		
	}
}
