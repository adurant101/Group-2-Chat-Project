/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachat2;

import java.io.*;
import java.net.Socket;

public class Client extends Thread {

    OutputStream outputStream = null;
    ObjectOutputStream objectOutputStream = null;
    ObjectInputStream ois = null;
    Socket socket = null;
    String messages = "";
    intMessage client;

    public Client() {
    }

    public Client(String user, String pwd, String host, intMessage msg) {
        try {
            messages = connect(user, pwd, host);
            client = msg;
            
            msg.setServerMessage(messages);
        } catch (Exception e) {
            msg.setServerMessage(e.getMessage());
        }
    }

    public void run() {
        for (;;) {
            String msg = checkForMessage();
            //System.out.println(msg);
            messages += msg;
            if (msg==null){
                client.setServerMessage("Server connection lost");
                break;
            }
            else
                client.setServerMessage(msg);
            messages = "";
        }
    }

    public String getMessages() {
        return messages;
    }

    public String connect(String userName, String password, String host) throws IOException {
        String cred = String.format("%s~%s", userName, password);
        int port = 2343;//sc.nextInt();
        socket = new Socket(host, port);

        outputStream = socket.getOutputStream();
        objectOutputStream = new ObjectOutputStream(outputStream);
        try {
            objectOutputStream.writeObject(cred);
            ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            return message;
        } catch (Exception e) {
            System.exit(0);
            //return e.getMessage();
        }
        return null;
    }

    public String checkForMessage() {
        try {
            String reply = (String) ois.readObject();
            return reply;
        } catch (Exception e) {
         //System.exit(0);            
            return e.getMessage();
        }
    }

    public String sendMessage(String msg) {
        try {
            objectOutputStream.writeObject(msg);
            return "";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
