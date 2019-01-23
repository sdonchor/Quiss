package application;

import java.io.IOException;

public class ServerThread extends Thread {

	@Override
	public void run() {
		Server server = new Server();
		try {
			server.runServer();
		} catch (IOException e1) {
			Console.println("Couldn't run server.");
		}
		
	}
}
