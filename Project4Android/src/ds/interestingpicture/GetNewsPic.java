package ds.interestingpicture;




import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;


/**
 * 
 * @author Bilei Huang 
 * This is the model which get the picture from google webapp
 * 
 */

public class GetNewsPic {
	
	NewsPicture np = null;
	
	/*
	 * search picture
	 */
	public void search(String searchTerm, NewsPicture ip) {
		System.out.println(3);
		this.np = ip;
		new AsyncFlickrSearch().execute(searchTerm);
	}

	/*
	 * get bitmap run in background
	  */
    private class AsyncFlickrSearch extends AsyncTask<String, Void, Bitmap> {
        protected Bitmap doInBackground(String... urls) {
        	System.out.println(2);
            return search(urls[0]);
        }

        protected void onPostExecute(Bitmap picture) {
        	System.out.println(7);
        	np.pictureReady(picture);
        }

        /**
         * 
         * @param searchTerm the term that user enters to search 
         * 
         */
        
        private Bitmap search(String searchTerm) { 
        	  String pictureURL = null;
    	      Document doc = getRemoteXML("http://neusoftandcarnegiemellon.appspot"
    	      		+ ".com/project4task2googleapp?search="+searchTerm+"&submit=get+answer");
    	      System.out.println(5);
    	      NodeList nl = doc.getElementsByTagName("SnapshotImage"); 
    	      if (nl.getLength() == 0) {
    	        	return null; // no pictures found
    	      } else {

    	        	Element e = (Element) nl.item(0);
    	        	pictureURL=e.getTextContent();
    	        	
    	       } 
    	      // At this point, we have the URL of the picture that resulted from the search.  Now load the image itself.
    	        try {
    	            	URL u = new URL(pictureURL);            	            	
    	            	return getRemoteImage(u);
    	            } catch (Exception e) {
    	                e.printStackTrace();
    	                return null; // so compiler does not complain
    	          }

        }
        
        /**
         * @param url  the url that we can get an xml
         */
        private Document getRemoteXML(String url) {
        	 try {
        		    
	                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	                DocumentBuilder db = dbf.newDocumentBuilder();
	                InputSource is = new InputSource(url);
	                System.out.println(is);
	                System.out.println("parsing");
	                return db.parse(is);
	        } catch (Exception e) {
	        	System.out.print("There are errors occuring : "+e);
	        	return null;
	        }
        }
        
        /**
         * 
         * @param url use the url to get the image
         * 
         */
        private Bitmap getRemoteImage(final URL url) {
            try {
            	System.out.println(4);
                final URLConnection conn = url.openConnection();
                conn.connect();
                BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
                Bitmap bm = BitmapFactory.decodeStream(bis);
                bis.close();
                return bm;
            } catch (IOException e) {
                e.printStackTrace();
                return null;   
            }
        }
    }
}