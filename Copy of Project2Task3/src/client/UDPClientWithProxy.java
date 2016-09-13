package client;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class UDPClientWithProxy {

    public static void main(String args[]) {
    	
    	System.out.println("please input the calculation you need from 1-n sum: ");
    	Scanner sc =new Scanner(System.in); 
    	String input= sc.nextLine();
    	double in= Double.parseDouble(input);
    	double result = 0;
    	for(double i=1;i<=in;i++){
    	    double j=i+0.25;
    	    
    		System.out.print(result+"+"+j+"=");
    		//System.out.println("hahahahahahaha"+result);
    		result=sumaddtion(result,j);
    		System.out.println(result);
    		
    	}
    	
    }
    static double sumaddtion(double x,double y){
        // args give message contents and destination hostname
        DatagramSocket aSocket = null;
        double result;
        try {
        
            aSocket = new DatagramSocket();
            int serverPort = 57920;
            InetAddress aHost = InetAddress.getByName("localhost");
            StringBuilder sb=new StringBuilder();
            sb.append(x+" ");
            sb.append(y+" ");
            sb.append("+");
            String s =sb.toString();
        	byte[] m=s.getBytes();
            byte[] buffer = new byte[1000];
            	
                DatagramPacket request
                        = new DatagramPacket(m, m.length, aHost, serverPort);
                aSocket.send(request);
                
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
                
                aSocket.receive(reply);
              
                String ss=new String(reply.getData());
                result=Double.parseDouble(ss.trim());
              
                return result;
                
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
		return -1;
    }
}
