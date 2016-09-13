import java.net.*;
import java.io.*;
import java.util.Scanner;

public class EchoServerTCP {

    public static void main(String args[]) {
        Socket clientSocket = null;
        String fileName = null;
        String response="HTTP/1.1 200 OK\n\n";
        try {
            int serverPort = 7777; // the server port we are using
            
            // Create a new server socket
            ServerSocket listenSocket = new ServerSocket(serverPort);
            
            /*
             * Block waiting for a new connection request from a client.
             * When the request is received, "accept" it, and the rest
             * the tcp protocol handshake will then take place, making 
             * the socket ready for reading and writing.
          
             */
//            while
            clientSocket = listenSocket.accept();
            // If we get here, then we are now connected to a client.
            
            // Set up "in" to read from the client socket
            Scanner in;
            in = new Scanner(clientSocket.getInputStream());
            
            // Set up "out" to write to the client socket
            PrintWriter out;
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())));
            
            /* 
             * Forever,
             *   read a line from the socket
             *   print it to the console
             *   echo it (i.e. write it) back to the client
             */
            while (true) {
            	
                String data = in.nextLine();
                if(data.contains("GET")){
                	String path = data.split(" ")[1];
                	path=path.substring(1);
                	fileName=path;
                	//System.out.println(fileName);
                }
              
                
                
                Scanner file = null;
    	        try {
    	        	file = new Scanner(new File(fileName));
    	        }
    	        catch (FileNotFoundException f) {
//    	        	out.print
    	        	System.out.println("We can not find your file");
//    	        	out.print("\n\n");
    	        	out.println("<!DOCTYPE html>");
    	            out.println("<html>");
    	            out.println("<head>");
    	            out.println("<title> 404 page </title>");            
    	            out.println("</head>");
    	            out.println("<body>");
    	            out.println("<h1>404 Error</h1>");
    	            
    	            out.println("</body>");
    	            out.println("</html>");
//    	            System.exit(0);
    	            out.flush();
    	            out.close();
    	            break;
    	        }
    	        System.out.println(response);
    	        out.println(response);
//    	        out.flush();
    	        while(file.hasNextLine() == true) {
    	        	  
//    	        	  response+=file.nextLine();
                      out.println(file.nextLine());
                      out.flush();
                    
    	        }
    	        out.close();
    	        System.out.println("Echoing: " + data);
    	       
//    	        out.print(response);
    	       break;
            }
            
        // Handle exceptions
        } catch (IOException e) {
            System.out.println("IO Exception:" + e.getMessage());
            
        // If quitting (typically by you sending quit signal) clean up sockets
        } finally {
            try {
                if (clientSocket != null) {
                    clientSocket.close();
                }
            } catch (IOException e) {
                // ignore exception on close
            }
        }
    }

	private static int indexof(String string, int i) {
		// TODO Auto-generated method stub
		return 0;
	}
}