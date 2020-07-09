
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.net.*;

import java.net.*;
import java.io.*;
import java.util.Date;

public class Server
{
    public static void main(String argv[]) throws Exception 
    {
       String clientSentence;
       String capitalizedSentence;
       ServerSocket welcomeSocket = new ServerSocket(6789);
       while(true)
       {
           Socket connectionSocket = welcomeSocket.accept(); 
           BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 
           DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream()); 
           clientSentence = inFromClient.readLine();
           capitalizedSentence = clientSentence.toUpperCase() + '\n';
           outToClient.writeBytes(capitalizedSentence); 
           connectionSocket.close();
         //  welcomeSocket.close();
        }
     }
}