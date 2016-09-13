package bhuang.andrew;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DsBhuangLabServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		response.setContentType("text/html;charset=UTF-8");
        String text=request.getParameter("palin");
        boolean yn = false;
        
        //make a string builder 
        StringBuilder str1 =new StringBuilder();
        StringBuilder str2=new StringBuilder();
        // get the input from a-z A-Z 0-9
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)>='a'&&text.charAt(i)<='z'||text.charAt(i)>='A'&&text.charAt(i)<='Z'
                    ||text.charAt(i)>='0'&&text.charAt(i)<='9'){
               str1.append(text.charAt(i));
               str2.append(text.charAt(i));
            }
        }
        //reverse one stringbuilder
           str1.reverse();
        //get the stringbuilders to string
           String a= str1.toString();
           String b= str2.toString();
        //get the strings to lower cases  
           a= a.toLowerCase();
           b= b.toLowerCase();
         //find out if it's true
           yn=a.equals(b); // default true

        //before out put determin the agent type is a phone or desktop(laptop) 
        String ua = request.getHeader("User-Agent");
        boolean mobile;
        if (ua != null && ((ua.indexOf("Android") != -1) || (ua.indexOf("iPhone") != -1))) {
            mobile = true;
            request.setAttribute("doctype", "<!DOCTYPE html PUBLIC \"-//WAPFORUM//DTD XHTML Mobile 1.2//EN\" \"http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd\">");
        } else {
            mobile = false;
            request.setAttribute("doctype", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        }
        
       //print out html 
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Palindrome</title>");            
            out.println("</head>");
            out.println("<body>"); 
            if(yn==true){
                out.println("<h1>Is Valid  Palindrome </h1>");
            }
            else if(yn==false){
                out.println("<h1>Is not a Valid  Palindrome </h1>");
            }
           
            out.println("</body>");
            out.println("</html>");
        }
	}
}
