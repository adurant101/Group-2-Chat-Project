/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxswingapplication1;

/**
 *
 * @author timli
 */
/**
 * @author roberttimlin
 */
import java.io.*;
import java.net.Socket;

public class Client extends Thread{

    OutputStream outputStream = null;
    ObjectOutputStream objectOutputStream = null;
    ObjectInputStream ois = null;
    Socket socket = null;
    String messages="";
    public Client (){}
    public Client (String user, String pwd, String host){
        try {
            connect (user,pwd,host);
        }catch (Exception e)
        {}
    }
    public void run() {
        for (;;)
        {
            String msg = checkForMessage();
            System.out.println(msg);
            messages+=msg;
        }
    }
    public String getMessage(){return messages;}
    public String connect(String userName, String password, String host) throws IOException {
        String cred = String.format("%s~%s", userName, password);
        //System.out.print("Enter the port number to connect to: <7777>");
        int port = 2343;//sc.nextInt();
        socket = new Socket(host, port);

        outputStream = socket.getOutputStream();
        objectOutputStream = new ObjectOutputStream(outputStream);
        // Connect to the ServerSocket at host:port

        // System.out.println("Connected to " + host + ":" + port);
        // Output stream socket.
        try {
            // Create object output stream from the output stream to send an object through it
            objectOutputStream.writeObject(cred);
            ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            return message;
        } catch (Exception e) {
            return e.getMessage();
        }
        // List of Message objects
    }
    public String checkForMessage()
    {
            try {
                //  messages = new ArrayList<>();
                sendMessage("$");
                String reply = (String) ois.readObject();
                return reply;

            } catch (Exception e) {
                return e.getMessage();
            }
        
    }
    public String sendMessage(String msg) {
        //       messages.add(new Message("This is a test message!"));

            try {
                //  messages = new ArrayList<>();

               // System.out.println("Sending Message Objects");
                objectOutputStream.writeObject(msg);
               
                //String reply = (String) ois.readObject();
                return "";

            } catch (Exception e) {
                return e.getMessage();
            }

    }
}
