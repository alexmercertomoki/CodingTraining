package ds;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class DSLABServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		 String answer = "", operator = "";
	        BigInteger x, y;
	        PrintWriter out = response.getWriter();
	        response.setContentType("text/html;charset=UTF-8");
	        try {
	            //get the parameters entered by the user
	            x = new BigInteger(request.getParameter("x"));
	            y = new BigInteger(request.getParameter("y"));
	            operator = request.getParameter("operator");

	            //calculate the result
	            switch (operator) {
	                case "addition":
	                    answer = x.add(y).toString();
	                    break;
	                case "multiplication":
	                    answer = x.multiply(y).toString();
	                    break;
	                case "mod":
	                    answer = x.mod(y).toString();
	                    break;
	                case "modInverse":
	                    answer = x.modInverse(y).toString();
	                    break;
	                case "power":
	                    answer = x.pow(y.intValue()).toString();
	                    break;
	                case "relativelyPrime":
	                    if (x.gcd(y).equals(new BigInteger("1"))) {
	                        answer = "true";
	                    } else {
	                        answer = "false";
	                    }
	                    break;
	            }

	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>Servlet java</title>");
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<h1>Result</h1>");
	            out.println("<p>" + x + " " + operator + " " + y + "</p>");
	            response.setContentType("text/html;charset=UTF-8");
	        } catch (Exception e) {
	            // if error, print out the erro message
	            answer = "error " + e.getMessage();
	        } finally {
	            //if no error, print out the result
	            out.println("<p>is " + answer + "</p>");
	            out.println("</body>");
	            out.println("</html>");
	        }

	    }
}
