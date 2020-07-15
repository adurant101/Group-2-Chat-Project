//package javachat;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainServer {
    private static List<MiniServer> users = new ArrayList<MiniServer>();
    public static MiniServer requestChat(String user, String message, MiniServer sender)
    {
        System.out.println ("RC: "+user);
//user="test";
        for (MiniServer ms : users)
        {
            if (user.equals(ms.getUser().getUsername()))
            {
                System.out.println ("Found: "+ms.getUser().getUsername());

                ms.message(sender, message);
                return ms;
            }
        }
        return null;
    }
    public static void main(String[] args) throws IOException {
        loadUsers();
        ServerSocket serverSocket = null;
        boolean listeningSocket = true;
        try {
            serverSocket = new ServerSocket(9999);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 2343");
        }
        while(listeningSocket){
            Socket clientSocket = serverSocket.accept();

            System.out.println("client");
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
                return u;
        }
        return null;
    }
}

