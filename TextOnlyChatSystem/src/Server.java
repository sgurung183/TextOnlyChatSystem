import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket server = null;
		int port = 8080;
		try {
			server = new ServerSocket(port);
			
			//an infinite loop so that server is always listening
			while(true) {
				//listen for incxcoming request
				Socket client = server.accept();
			}
		}
		catch(Exception e) {
			
		}
	}
	
	//an inner class to handle multiple client request simultaneously
	//implements Runnable to for multi-threading
	private static class ClientHandler implements Runnable{
		
		private Socket client = null;
		
		public ClientHandler(Socket newClient) {
			client = newClient;
		}
		@Override
		public void run() {
			
			
		}
		
	}
}
