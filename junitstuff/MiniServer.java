/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat1;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class MiniServer extends Thread {
	private Socket socket;
    private boolean auth;
    private String user;
	public MiniServer()
	{
	     Socket socket = null;
	     auth = false;
	     String user = null;
	}
    
    public MiniServer(Socket socket) {

        super("MiniServer");
        this.socket = socket;

    }

    public void run() {
        int port = 9999;
		System.out.println("FROM mini");
        System.out.println("ServerSocket awaiting connections...");
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream.

        // .accept blocks until an inbound connection on this port is attempted
        //Socket socket = null;
        try {
            // socket = ss.accept();
            System.out.println("Connection from " + socket + "!");

            // get the input stream from the connected socket
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            String cred = (String) objectInputStream.readObject();
            // System.out.println("CRED: "+cred);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            if (!cred.equals("test~1234")) {
                System.out.println("Not Authorized!!!!");
                oos.writeObject("\n\n****Invalid user login***\n\n");
                return;
            }
            oos.writeObject("auth");
            auth = true;
            user = cred;
            // create a ObjectInputStream so we can read data from it.

            for (;;) {
                // read the list of messages from the socket
                List<Message> listOfMessages = (List<Message>) objectInputStream.readObject();
                System.out.println("Received [" + listOfMessages.size() + "] messages from: " + socket);

                // for every message, call printMessage(message);
                System.out.println("All messages:");
                //listOfMessages.forEach(msg -> printMessage(msg));
                for (Message m : listOfMessages) {
                    printMessage(m);
                }
				String msg = "", msgA = "";

				for(;;)
				{
					System.out.println("Type messages, enter * to stop messages to be sent\nReply:\n");
					msg = sc.nextLine();
				
					if(msg.equals("*"))
					{
						break;
					}
						
					msgA = msgA + msg + "\n";					
				}
                oos.writeObject(msgA);
				
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            System.out.println("Closing sockets.");

            //socket.close();
        }
    }        
//implement your methods here
    private static void printMessage(Message msg) {
        System.out.println("ID: " + msg.getID());
        System.out.println("Type: " + msg.getType());
        System.out.println("Text: " + msg.getText());
    }
}
