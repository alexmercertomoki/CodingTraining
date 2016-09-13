package server;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class UDPServerWithDoubleArithmetic {
	
		
		
	    public static void main(String args[]) {
	    	
	        DatagramSocket aSocket = null;
	        try {
	        	
	            aSocket = new DatagramSocket(57920);
	            // create socket at agreed port
	            byte[] buffer = new byte[1000];
	            while (true) {
	                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
	                aSocket.receive(request);
	                String calc= new String(request.getData(),"ISO-8859-1");
	                System.out.println(calc);
	                System.out.println("received request");
	                String[] a= calc.split(" ");
	                a[2] = a[2].trim();
	                if(a[2].equals("++")){
	                	a[2]="+";
	                }
	                System.out.println(a[2]);
	                double result = 0;
	                
	                if(a[2].equals("^")){
	                   result=(long) Math.pow(Long.parseLong(a[0]),Long.parseLong(a[1]));
	                }
	                if(a[2].equals("+")){
	                	System.out.println(Double.parseDouble(a[0]));
	                	result=Double.parseDouble(a[0])+Double.parseDouble(a[1]);
	                }
	                
	                if(a[2].equals("-")){
	                	result=Long.parseLong(a[0])-Long.parseLong(a[1]);
	                }
	                if(a[2].equals("*")){
	                	result=Long.parseLong(a[0])*Long.parseLong(a[1]);
	                }
	                if(a[2].equals("/")){
	                	result=Long.parseLong(a[0])/Long.parseLong(a[1]);
	                }
	               
	                String replytoclient=""+ result;
	                System.out.println(replytoclient);
	                byte[] m= replytoclient.getBytes();
	                DatagramPacket reply = new DatagramPacket(m, m.length,
	                        request.getAddress(), request.getPort());
	                
	                aSocket.send(reply);
	              
	            }
	        } catch (SocketException e) {
	            System.out.println("Socket: " + e.getMessage());
	        } catch (IOException e) {
	            System.out.println("IO: " + e.getMessage());
	        } finally {
	            if (aSocket != null) {
	                aSocket.close();
	            }
	        }
	    }
	    
}
