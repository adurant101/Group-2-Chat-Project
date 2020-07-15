package chat1;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        if (args.length<2)
        {
            System.err.println ("Usage: client user pwd");
        }
        String cred = String.format("%s~%s", args[0], args[1]);
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.print("Enter the port number to connect to: <7777>");
        int port = sc.nextInt();
		//int port = 9999;
		System.out.print("Enter the host address to connect to: <localhost> ");
        String host = sc.next();

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
 		sc.nextLine();

        for (;;)
        {
			String msg = "", msgA = "";
            messages = new ArrayList<>();

			for(;;)
			{
				System.out.print("Enter messages, enter * to send all messages, or ** to close socket\n");
				msg = sc.nextLine();
				
				if(msg.equals("*") || msg.equals("**"))
				{
					break;
				}
				
				msgA = msgA + msg + "\n";
			}
			
            
            if (msg.equals("**"))
                break;
            messages.add(new Message(msgA));
       
            System.out.println("Sending Message Objects");
            objectOutputStream.writeObject(messages);
            try {
                String reply = (String) ois.readObject();
                System.out.println(reply);
            }catch (Exception e){

            }
        }
        System.out.println("Closing socket");
        socket.close();
    }
}


