/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatserver;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainServer {

  
    private static List<MiniServer> users = new ArrayList<MiniServer>();
    private static File file1;
   // private static FileWriter writeTo;


 
    public static MiniServer requestChat(String user, String message, MiniServer sender)
    {
        System.out.printf ("Receiptent: {%s}\n",user);
        String s = "Receiptent: " + user + "\n";
        try
        {
                    FileWriter writeTo = new FileWriter("serverLog.txt",true);

           writeTo.write(s);
        
//user="test";
        for (MiniServer ms : users)
        {
            if (user.equals(ms.getUser().getUsername()))
            {
                System.out.println ("Found: "+ms.getUser().getUsername() + " Sending Message");
                writeTo.write("Found: "+ms.getUser().getUsername() + " Sending Message\n");
                ms.message(sender, message);
                return ms;
            }
        }
            writeTo.close();

        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        System.out.printf ("Not Found {%}\n", user);
        return null;
    }
    public static void main(String[] args) throws IOException {
        loadUsers();
               try{
       file1 = new File("serverLog.txt");
       if(file1.createNewFile())
       {
           System.out.println("File created, log will be saved to serverLog.txt"); 
       }
        FileWriter writeTo = new FileWriter("serverLog.txt",false);
        writeTo.write("");
        writeTo.close();
        }catch(IOException e)
        {
            System.out.println(e);
        }
        System.out.println("Main Server running...");
        ServerSocket serverSocket = null;
        boolean listeningSocket = true;
        try {
            serverSocket = new ServerSocket(2343);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 2343");
        }
        while(listeningSocket){
            Socket clientSocket = serverSocket.accept();

            //System.out.println("client");
            MiniServer mini = new MiniServer(clientSocket);
            users.add(mini);
            mini.start();
        }
        serverSocket.close();       
    }    
    private static List<User>userList = new ArrayList<User>();
    private static void loadUsers()
    {
        userList.add(new User("bob", "123"));
        userList.add(new User("abc", "123"));
        userList.add(new User("jeff", "123"));
        userList.add(new User("andre", "123"));
    }
    public static User getUser (String un, String p)
    {
        System.out.printf("Get User: %s/%s\n", un,p);
        for (User u : userList)
        {
            if (u.isValid(un, p))
            {
               System.out.println("User " + un + " is valid, logging in");
                try
                {
                           FileWriter writeTo = new FileWriter("serverLog.txt",true);

                            
                    writeTo.write("User " + un + " is valid, logging in\n");
                    writeTo.close();
                }
                catch(IOException e)
                {
                    
                }
            
               return u;
            }
        }
        return null;
    }
}



