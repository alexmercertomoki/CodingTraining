package convertmaptobyte;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class converting {
	public static void main(String[] args) throws Exception {
		
	    // Create raw data.
	    Map<Integer, String> data = new HashMap<Integer, String>();
	    data.put(1, "hello");
	    data.put(2, "world");
	    System.out.println(data.toString());

	    // Convert Map to byte array
	    ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
	    ObjectOutputStream out = new ObjectOutputStream(byteOut);
	    
	    out.writeObject(data);
//	    String s =data.toString();
	    // Parse byte array to Map
	    ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
	    ObjectInputStream in = new ObjectInputStream(byteIn);
	    Map<Integer, String> data2 = (Map<Integer, String>) in.readObject();
	    System.out.println(data2.toString());
	}
}
