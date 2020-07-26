/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatserver;


import java.io.*;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.io.ObjectOutputStream;

public class MiniServer extends Thread {
    private Socket socket = null;
    private MiniServer chat = null;
    private boolean auth = false;
    private User user = null;

    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private ObjectOutputStream chatOutputStream;
    
     private static File file1;
  //  private static FileWriter writeTo;
   
    public MiniServer(Socket socket) 
    {
        super("MiniServer");
        this.socket = socket;
    }
    public User getUser(){return user;}
    public Socket getSocket(){return socket;}
    private void requestChat(String msg)
    {
        try {
            String[]parts=msg.substring(1).split(" ");
            chat = MainServer.requestChat(parts[0], parts[1], this);
            if (chat==null)return;
       //     chatOutputStream=new ObjectOutputStream(chat.getSocket().getOutputStream());
            objectOutputStream.writeObject(String.format ("sent to %s", chat.getUser().getUsername()));
        }catch (Exception e)
        {
            System.err.println(e);   
        }        
    }
    public int message (MiniServer m, String message)
    {
        try {
            chat = m;
            System.out.printf ("\nMini initial search Message from %s to %s: %s\n", m.getUser().getUsername(), user.getUsername(), message);
                   FileWriter writeTo = new FileWriter("serverLog.txt",true);

            writeTo.write("\nMini initial search Message from " + m.getUser().getUsername() + " to " + user.getUsername() + ": " + message + "\n");
            writeTo.close();
        //    chatOutputStream = new ObjectOutputStream(m.getSocket().getOutputStream());
            objectOutputStream.writeObject(String.format ("%s: %s\n", m.getUser().getUsername(), message));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }
    public int reply  (MiniServer m, String message)
    {
        try {
            
           // chat = m;
            System.out.printf ("Reply Message from %s to %s: %s\n", m.getUser().getUsername(), user.getUsername(), message);
                    FileWriter writeTo = new FileWriter("serverLog.txt",true);

            writeTo.write("Reply Message from " + m.getUser().getUsername() + " to " + user.getUsername() + ": " + message + "\n");
            writeTo.close();
          //  chatOutputStream = new ObjectOutputStream(m.getSocket().getOutputStream());
         // chatOutputStream.writeObject(String.format ("\n\n****Reply Message from %s:\n %s\n\n", m.getUser().getUsername(), message));
           //chat.message(this,message);
           objectOutputStream.writeObject(String.format ("%s: %s\n", m.getUser().getUsername(), message));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }
    public void run() {
        System.out.println("ServerSocket awaiting connections...");
         
        try {
            // socket = ss.accept();
            System.out.println("Connection from " + socket + "!");

            // get the input stream from the connected socket
            InputStream inputStream = socket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);

            String cred = (String) objectInputStream.readObject();
            // System.out.println("CRED: "+cred);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            String[] t = cred.split("~");
            user = MainServer.getUser(t[0], t[1]);

            if (user==null) {
                System.out.println("Not Authorized!!!!");
                objectOutputStream.writeObject("\n\n****Invalid user login***\n\n");
                return;
            }
            objectOutputStream.writeObject("Logged in successfully");
            auth = true;

            // create a ObjectInputStream so we can read data from it.

            for (;;) {
                // read the list of messages from the socket
               // List<Message> listOfMessages = (List<Message>) objectInputStream.readObject();
               //System.out.println ("mini waiting...");
                      FileWriter writeTo = new FileWriter("serverLog.txt",true);
               String msg = (String)objectInputStream.readObject();
               System.out.println ("received message: "+msg);
               writeTo = new FileWriter("serverLog.txt",true);
               writeTo.write("received message: " + msg + "\n");
               if(msg.equals("exit598"))
               {
                   writeTo.write("exit598 means sender chose to end chat for both parties\n");
               }
                if (msg.charAt(0)=='@'){
                   System.out.println("sent request to start chat");
                   writeTo.write("sent request to start chat\n");
                    requestChat(msg);   
                } else if (msg.charAt(0)=='$')
                {
                    objectOutputStream.writeObject(""); 
                }
                else if(chat==null) {
                    System.out.println(msg);     
                    System.out.println("Mini.Reply to server: ");
                    
                    objectOutputStream.writeObject(msg);                    
                }else {
                    System.out.println ("mini sending message to "+chat.getUser().getUsername());
                    writeTo.write("mini sending message to "+chat.getUser().getUsername() + "\n");
                 //   objectOutputStream.writeObject("sent to "+chat.getUser().getUsername());                    
                    chat.reply(this, msg);
                }
                writeTo.close();

//                objectOutputStream.writeObject(msg);
            }
        } catch (Exception e) {
            System.err.println("RUN-EX: "+e);
        } finally {
            System.out.println("Closing sockets.");
            //socket.close();
        }
    }        

}

