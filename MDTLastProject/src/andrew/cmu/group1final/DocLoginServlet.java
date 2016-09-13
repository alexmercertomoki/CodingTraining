package andrew.cmu.group1final;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DocLoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String docName = req.getParameter("username");
		String password =req.getParameter("password");
		PrintWriter out =resp.getWriter();
		
		boolean loginFlag= false;
		if(docName.equals("wangwei")&&password.equals("123456")){
			loginFlag=true;
		}else if(docName.equals("peter")&&password.equals("123456")){
			loginFlag=true;
		}else if(docName.equals("John")&&password.equals("123456")){
			loginFlag=true;
		}
		
		if(loginFlag){
			RequestDispatcher rd=req.getRequestDispatcher("MainPage.html");
			try {
				rd.forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		else{
			RequestDispatcher rd=req.getRequestDispatcher("loginFailure.html");
			try {
				rd.forward(req, resp);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}
}
