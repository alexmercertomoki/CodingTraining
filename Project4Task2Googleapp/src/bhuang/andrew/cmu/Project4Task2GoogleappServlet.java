package bhuang.andrew.cmu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * 
 * @author Bilei Huang 
 * This is the servlet  which finds a random picture from USA today and return it.
 */

@SuppressWarnings("serial")
public class Project4Task2GoogleappServlet extends HttpServlet {
	
	/**
     * 
     * @param req the request  
     * @param resp reponse , here to android
     * 
     */
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		 
		 // the xml to return  
		 String picxml = "";
		 String SearchTerm= req.getParameter("search");
		// url to retrieve info form usa today 
		 URL url = new URL("http://api.usatoday.com/open/snapshots?last=5&keywords="
				+SearchTerm+"&api_key=jpwnpk48stehcga97k4qgwtp");
		  HttpURLConnection connection=(HttpURLConnection)url.openConnection(); 
		  // get the xml and put in the string
		  BufferedReader in = new BufferedReader
                  (new InputStreamReader(connection.getInputStream(), "UTF-8"));
          String str;
          StringBuffer sb=new StringBuffer();
          while ((str = in.readLine()) != null) {
              // str is one line of text readLine() strips newline characters
              sb.append(str);
          }
          
         in.close();
         // get the string
         picxml= sb.toString(); 
		     
         System.out.println(picxml);
         // response . writer to the android
		 PrintWriter out=resp.getWriter();
		 // get the document with xml
		 Document doc = this.getDocument(picxml);
		 NodeList nl = doc.getElementsByTagName("SnapshotImage"); 
		 // get Random picture
	     int pic = new Random().nextInt(nl.getLength()); //choose a random picture
	     //get the content in the node 
	     Element e = (Element) nl.item(pic);
	     System.out.println("hasdfasfadfas"+e);
	     picxml=e.getTextContent();
	     
//	     System.out.println(picxml);	
	     // write out the picxml
		 out.println("<SnapshotImage>"+picxml+"</SnapshotImage>");
		 
	}
	// the method from last project
	private Document getDocument(String sxml) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
       
        Document MyDoc = null;
        try {
            builder = factory.newDocumentBuilder();
            MyDoc = builder.parse(new InputSource(new StringReader(sxml)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MyDoc;
    }
	
	
}
