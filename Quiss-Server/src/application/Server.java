package application;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//
public class Server {
	private int defaultServerPort=4545;
	private int serverPort;
	public Server(int port) {
		serverPort=port;
	}
	public Server() {
		serverPort=defaultServerPort;
	}
	public void runServer() throws IOException{
		ServerSocket serverSocket = new ServerSocket(serverPort);
		Console.println("Server initialized on port "+serverPort+". Awaiting connections.");
		while(true) {
			Socket socket = serverSocket.accept();

			new ClientThread(socket).start();
		}
	}
}
