
import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        if (args.length<3)
        {
            System.err.println ("Usage: client host user pwd");
        }
        String cred = String.format("%s~%s", args[1], args[2]);
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        //System.out.print("Enter the port number to connect to: <7777>");
        int port = 9999;//sc.nextInt();
        String host = args[0];//sc.next();

        // Connect to the ServerSocket at host:port
        Socket socket = new Socket(host, port);
        System.out.println("Connected to " + host + ":" + port);

        // Output stream socket.
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        ObjectInputStream ois =null;
        try {
        // Create object output stream from the output stream to send an object through it
            objectOutputStream.writeObject(cred);
            ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();

            System.out.println("Message: " + message);
        }catch (Exception e){
            System.err.println(e);
        }
        // List of Message objects
        List<Message> messages = null; //new ArrayList<>();
 //       messages.add(new Message("This is a test message!"));
        for (;;)
        {
            try {
              //  messages = new ArrayList<>();
              System.out.print("Enter message info. <enter> to quit\n");
              String msg = sc.nextLine();
              if (msg.equals("*"))
                  break;
      
              System.out.println("Sending Message Objects");
              objectOutputStream.writeObject(msg);  
           
                System.out.println ("Client waiting on reply");
                String reply = (String) ois.readObject();
                System.out.println(reply);
              
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("Closing socket");
        socket.close();
    }
}