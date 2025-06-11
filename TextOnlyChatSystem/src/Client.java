import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try (Socket socket = new Socket("localhost", 8080);
			 Scanner scanner = new Scanner(System.in);){
			// always create the output stream first
			ObjectOutputStream sender = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream receiver = new ObjectInputStream(socket.getInputStream());
			String message = "";
			while(true){

				System.out.print("You: ");
				message = scanner.nextLine();
				Message testMessage = new Message(message);
				sender.writeObject(testMessage);
				
				if(message.toLowerCase().equals("bye")) {
					break;
				}
				else {
					Message received = (Message) receiver.readObject();
					System.out.println("/n Server: " + received.getContent());
				}
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
