import java.net.*;
import java.io.*;
import java.util.Scanner;

public class EchoServerTCP {

	public static void main(String args[]) {
		Socket clientSocket = null;
		String fileName = null;
		String response = "HTTP/1.1 200 OK\n\n";
		
			
				int serverPort = 7777; // the server port we are using
				PrintWriter out;
				// Create a new server socket
			
				/*
				 * Block waiting for a new connection request from a client.
				 * When the request is received, "accept" it, and the rest the
				 * tcp protocol handshake will then take place, making the
				 * socket ready for reading and writing.
				 */
				
			while (true) {
				try {
				ServerSocket listenSocket = null;
				listenSocket = new ServerSocket(serverPort);
				clientSocket = listenSocket.accept();
				out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(clientSocket.getOutputStream())));
				
				// If we get here, then we are now connected to a client.

				// Set up "in" to read from the client socket
				Scanner in;
				in = new Scanner(clientSocket.getInputStream());

				// Set up "out" to write to the client socket
				

				/*
				 * Forever, read a line from the socket print it to the console
				 * echo it (i.e. write it) back to the client
				 */

				String data = in.nextLine();
				if (data.contains("GET")) {
					String path = data.split(" ")[1];
					path = path.substring(1);
					fileName = path;
					// System.out.println(fileName);
				}

				Scanner file = null;
				File resfile=new File(fileName);
				try {
					file = new Scanner(new File(fileName));
				} catch (FileNotFoundException f) {

					System.out.println("asjfjl;afjWe can not find your file");
					out.print("HTTP/1.1 404 NotFound\n\n");
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("<head>");
					out.println("<title> 404 page </title>");
					out.println("</head>");
					out.println("<body>");
					out.println("<h1>404 Error</h1>");
					out.println("</body>");
					out.println("</html>");
					// System.exit(0);
					out.flush();
				

				}
			    if(resfile.exists()){
			    	
				out.println(response);
			    
				while (file.hasNextLine() == true) {
					response+="\n";
					response+=file.nextLine();
					out.println(file.nextLine());
					out.flush();

					}
					//out.println(response);
			    }
//				System.out.println("Echoing: " + data);
			    out.close();
			    listenSocket.close();
			    clientSocket.close();
			}

			// Handle exceptions
			catch (IOException e) {
				System.out.println("IO Exception:" + e.getMessage());

				// If quitting (typically by you sending quit signal) clean up
				// sockets
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
	}

	private static int indexof(String string, int i) {
		// TODO Auto-generated method stub
		return 0;
	}
}