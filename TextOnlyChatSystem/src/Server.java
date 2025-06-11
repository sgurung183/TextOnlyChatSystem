import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            while (true) {
                Socket client = server.accept();
                new Thread(new ClientHandler(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket client;

        public ClientHandler(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (ObjectOutputStream sender = new ObjectOutputStream(client.getOutputStream());
                 ObjectInputStream receiver = new ObjectInputStream(client.getInputStream());
                 Scanner scanner = new Scanner(System.in);
                		 ) {
            	String message = "";
            	while(true) {
            		 Message receivedMessage = (Message) receiver.readObject();
            		 if(receivedMessage.getContent().toLowerCase().equals("bye")) {
            			 System.out.print("user left the chat room");
            		 }
            		 else {
            			 System.out.println("Received from " + client.getInetAddress() + ": " + receivedMessage.getContent());
                         
                         System.out.print("You: ");
                         message = scanner.nextLine();
                         sender.writeObject(new Message(message));
            		 }
                     
            	}
            	
               
                
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
