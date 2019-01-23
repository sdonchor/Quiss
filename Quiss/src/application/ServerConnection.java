package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.sql.rowset.CachedRowSet;

public class ServerConnection {
	private Socket socket = null;
	private String address = null;
	private String nickname = null;
	private int port;
	private boolean newRequest = false;
	public ServerConnection(String address, int port, String nickname) throws Exception {
		this.address=address;
		this.port=port;
		this.nickname=nickname;
		this.socket=new Socket(address,port);
	}
	public void socketClose() {
		try {
			socket.close();
		} catch (IOException e) {
			System.out.println("Couldn't close socket");
		}
	}
	public void sendMessage(String request) {
		
		try {
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
			printWriter.println(request);
			
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			ServerResponse sr = (ServerResponse)ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}