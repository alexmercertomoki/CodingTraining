
import java.net.*;
import java.io.*;
import java.nio.ByteBuffer;
import java.util.Scanner;
/**
 * This file: TCPSpyCommanderUsingTEAandPasswords.java
 * In this file, the commander first enter the public key, after receiving 
 * the encrypted update information from the spies, the server will decrypt 
 * the information using the public key.Then the server will write a .kml 
 * file for the commander to view on Google earth.
 * @author Fred Wang
 */
public class TCPSpyCommanderUsingTEAandPasswords {
    static String key;
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter symmetric key for TEA:");
        key = keyboard.nextLine();
        System.out.println("Waiting for spies to visit...");
        try {
            int serverPort = 7896; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort);
            while (true) {
                Socket clientSocket = listenSocket.accept();
                Connection c = new Connection(clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Listen socket:" + e.getMessage());
        }
    }
}

class Connection extends Thread {

    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;

    public Connection(Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
            this.start();
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    public void run() {
        TEA tea = new TEA(TCPSpyCommanderUsingTEAandPasswords.key.getBytes());
          System.out.println(TCPSpyCommanderUsingTEAandPasswords.key);
        try {
            byte[] buffer = new byte[1000];
            //receive the key
            int length = in.read(buffer);
            byte[] a = new byte[length];
            for (int i = 0; i < length; i++) {
                a[i] = buffer[i];
            }
            byte[] spydecrypt = tea.decrypt(a);
            String getspyinfo = new String(spydecrypt).trim();
            String[] information = getspyinfo.split(" ");
            String header = information[0];
            String username = information[1];
            String password = information[2];
            String location = information[3];
            System.out.println(header+username+password+location);
            System.out.println(header);
            if (!header.equals("REALSPY")) {
                System.out.println("Illegal symmetric key used.");
                String error = "Incorrect symmetric key!";
                out.write(error.getBytes());
                out.flush();
                clientSocket.close();
            }
            if (information[1].equals("jamesb") && information[2].equals("james")
                || information[1].equals("joem") && information[2].equals("joe")
                || information[1].equals("mikem") && information[2].equals("mike")) {

                Scanner in = null;
                StringBuilder sb = new StringBuilder();
                String iloc = null;
                String jloc = null;
                String kloc = null;
                {
                    try {
                        in = new Scanner(new File("SecretAgents.kml"));
                        while (in.hasNext()) {
                            sb.append(in.next());
                            }
                            String kmlfile = sb.toString();
                            
                            int i = kmlfile.indexOf("jamesb");
                            int endi = kmlfile.indexOf("</coordinates>", i);
                            iloc = kmlfile.substring(i + 91, endi - 1);
                            int j = kmlfile.indexOf("joem");
                            int endj = kmlfile.indexOf("</coordinates>", j);
                            jloc = kmlfile.substring(j + 89, endj - 1);
                            int k = kmlfile.indexOf("mikem");
                            int endk = kmlfile.indexOf("</coordinates>", k);
                            kloc = kmlfile.substring(k + 90, endk - 1);
                            //Specify the file name and path here
                            } catch (FileNotFoundException f) {

                            }
                            BufferedWriter bw = null;
                            try {
                                String originaloc = "-79.945389,40.444216,0.00000";
                                
                                File file = new File("SecretAgents.kml");
                                FileWriter fw = new FileWriter(file);
                                bw = new BufferedWriter(fw);
                                bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?><kml xmlns=\"http://earth.google.com/kml/2.2\"><Document><Style id=\"style1\"><IconStyle><Icon><href>http://maps.gstatic.com/intl/en_ALL/mapfiles/ms/micons/bluedot.png</href></Icon></IconStyle></Style><Placemark>");
                                if (username.equals("jamesb")) {
                                    System.out.println("Got visit from James.");
                                    if (iloc == null) {
                                        bw.write("<name>jamesb</name><description>Spy</description><styleUrl>#style1</styleUrl><Point><coordinates>" + location + "</coordinates></Point></Placemark><Placemark><name>joem</name><description>Spy</description><styleUrl>#style1</styleUrl><Point><coordinates>");
                                        bw.write(originaloc + "</coordinates></Point></Placemark><Placemark><name>mikem</name><description>Spy</description><styleUrl>#style1</styleUrl><Point><coordinates>");
                                        bw.write(originaloc + "</coordinates></Point></Placemark></Document></kml>");
                                    } else {
                                        bw.write("<name>jamesb</name><description>Spy</description><styleUrl>#style1</styleUrl><Point><coordinates>" + location + "</coordinates></Point></Placemark><Placemark><name>joem</name><description>Spy</description><styleUrl>#style1</styleUrl><Point><coordinates>");
                                        bw.write(jloc + "</coordinates></Point></Placemark><Placemark><name>mikem</name><description>Spy</description><styleUrl>#style1</styleUrl><Point><coordinates>");
                                        bw.write(kloc + "</coordinates></Point></Placemark></Document></kml>");
                                    }
                                } else if (username.equals("joem")) {
                                    System.out.println("Got visit from Joe.");
                                    if (jloc == null) {
                                        bw.write("<name>jamesb</name><description>Spy</description><styleUrl>#style1</styleUrl><Point><coordinates>" + originaloc + "</coordinates></Point></Placemark><Placemark><name>joem</name><description>Spy</description><styleUrl>#style1</styleUrl><Point><coordinates>");
                                        bw.write(location + "</coordinates></Point></Placemark><Placemark><name>mikem</name><description>Spy</description><styleUrl>#style1</styleUrl><Point><coordinates>");
                                        bw.write(originaloc + "</coordinates></Point></Placemark></Document></kml>");
                                    } else {
                                        bw.write("<name>jamesb</name><description>Spy</description><styleUrl>#style1</styleUrl><Point><coordinates>" + iloc + "</coordinates></Point></Placemark><Placemark><name>joem</name><description>Spy</description><styleUrl>#style1</styleUrl><Point><coordinates>");
                                        bw.write(location + "</coordinates></Point></Placemark><Placemark><name>mikem</name><description>Spy</description><styleUrl>#style1</styleUrl><Point><coordinates>");
                                        bw.write(kloc + "</coordinates></Point></Placemark></Document></kml>");
                                    }
                                } else {
                                    System.out.println("Got visit from Mike.");
                                    if (kloc == null) {
                                        bw.write("<name>jamesb</name><description>Spy</description><styleUrl>#style1</styleUrl><Point><coordinates>" + originaloc + "</coordinates></Point></Placemark><Placemark><name>joem</name><description>Spy</description><styleUrl>#style1</styleUrl><Point><coordinates>");
                                        bw.write(originaloc + "</coordinates></Point></Placemark><Placemark><name>mikem</name><description>Spy</description><styleUrl>#style1</styleUrl><Point><coordinates>");
                                        bw.write(location + "</coordinates></Point></Placemark></Document></kml>");
                                    } else {
                                        bw.write("<name>jamesb</name><description>Spy</description><styleUrl>#style1</styleUrl><Point><coordinates>" + iloc + "</coordinates></Point></Placemark><Placemark><name>joem</name><description>Spy</description><styleUrl>#style1</styleUrl><Point><coordinates>");
                                        bw.write(jloc + "</coordinates></Point></Placemark><Placemark><name>mikem</name><description>Spy</description><styleUrl>#style1</styleUrl><Point><coordinates>");
                                        bw.write(location + "</coordinates></Point></Placemark></Document></kml>");
                                    }
                                }

                            } catch (IOException ioe) {
                                ioe.printStackTrace();
                            } finally {
                                try {
                                    if (bw != null) {
                                        bw.close();
                                    }
                                } catch (Exception ex) {
                                    System.out.println("Error in closing the BufferedWriter" + ex);
                                }
                            }   
                }
            } else {
                System.out.println("Illegal password attempt.");
                String error = "Illegal ID or Password!";
                out.write(error.getBytes());
                out.flush();
            }
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline:" + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {/*close failed*/

            }
        }
    }
}
