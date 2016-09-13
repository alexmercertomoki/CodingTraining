package andrew.cmu.group1final;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DoctorAdviceServlet extends HttpServlet {
	public static ArrayList<String> personAr=new ArrayList<String>();
	public static ArrayList<String> adviceAr=new ArrayList<String>();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		//set up file acceptance to xml 
		resp.setContentType("text/xml");
		resp.getWriter().println("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
		
		Random r =new Random(); 
		//mdtfinalgroup1         appid
		
		// all the attributes we need 
		String userName= req.getParameter("userName");
		String id= req.getParameter("id");
		String Height =req.getParameter("Height");
		String Gender =req.getParameter("Gender");
		String BloodPressure =req.getParameter("BloodPressure");
		String HeartRate =req.getParameter("HeartRate");
		//add to list 
		personAr.add(userName+" "+id+" "+Height+" "+Gender+" "+BloodPressure+" "+HeartRate);
		
		// the printer 
		PrintWriter out= resp.getWriter();
		
//		String[] advice =  new String[10];
//		advice[0]="<Info> <DoctorName> wangwei </DoctorName> "
//				+ "<Advice>Hello just eat sleep and you will be healthy! </Advice></Info>";
//		advice[1]=" <Info> <DoctorName> wangwei </DoctorName><Advice>You should do more sports</Advice> </Info>";
//		advice[2]="<Info><DoctorName>wangwei </DoctorName><Advice>You need to do not only sports but also eat sleep</Advice></Info>";
//		adviceAr.add(advice[0]);
//		adviceAr.add(advice[1]);
//		adviceAr.add(advice[2]);
		//get advice 
		for(int i = 0; i < adviceAr.size();i++){
			System.out.println(adviceAr.get(i));
		}
		
//		out.print(advice[r.nextInt(adviceAr.size())]);
		
		//  give the xml back 
		System.out.println(" Hey this should be printed out  ");
	
		out.print(adviceAr.get(adviceAr.size()-1));
		
		
//		RequestDispatcher resultView = request.getRequestDispatcher(nextView);
//	    resultView.forward(request, response);
		
		
		
		
		
		
	}
}
