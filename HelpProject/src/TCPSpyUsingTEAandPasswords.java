import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
public class TCPSpyUsingTEAandPasswords {
	public static void main (String args[]) {
		Socket s = null;
                StringBuilder sb = new StringBuilder();
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Enter symmetric key for TEA:");
                String spykey = keyboard.nextLine();
                byte[] key = spykey.getBytes();
                TEA tea = new TEA(key);
                
                
                System.out.println("Enter your name:");
                String spyname = "REALSPY"+" "+keyboard.nextLine();
               
                
                System.out.println("Enter your password:");
                String spypassword = keyboard.nextLine();
           
                
                
                
                System.out.println("Enter your location:");
                String spyloc = keyboard.nextLine();
                
                
                String spyinput = sb.append(spyname).append(" ").append(spypassword).append(" ").append(spyloc).toString();
                byte[] toserver = tea.encrypt(spyinput.getBytes());
                
                
		try{
			int serverPort = 7896;
			s = new Socket("localhost", serverPort);    
			DataInputStream in = new DataInputStream( s.getInputStream());
			DataOutputStream out =new DataOutputStream( s.getOutputStream());
                        out.write(toserver);
                        out.flush();
                        byte[] buffer = new byte[1000];
                        in.read(buffer);	    // read a line of data from the stream
                        String reply = new String(buffer);
			System.out.println(reply.trim()) ; 
		}catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		}catch (IOException e){System.out.println("readline:"+e.getMessage());
		}finally {if(s!=null) try {s.close();}catch (IOException e){System.out.println("close:"+e.getMessage());}}
     }
}