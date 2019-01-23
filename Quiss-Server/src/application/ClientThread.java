package application;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;



public class ClientThread extends Thread{
	private Socket socket;
	String remoteIP=null;
	public ClientThread(Socket socket) {
		this.socket=socket;
		
	}
	public String getCleanIP() {
		String currIP=socket.getRemoteSocketAddress().toString();
		String[] split = currIP.split(":");
		return split[0];
	}

	public void run() {
		this.remoteIP=getCleanIP();
		try {
			String message=null;
			BufferedReader bufferedReader = new BufferedReader ( new InputStreamReader(socket.getInputStream()));
			while((message=bufferedReader.readLine())!=null)
			{
				Console.println("Acquired message: "+message);//debug
				if(message.contains("new-player"))
				{
					String[] request = message.split(";");
					String username = request[1];
					Player p = new Player(username,getCleanIP());
					PlayerList.addPlayer(p);
					Console.println("Player "+username+" with IP "+getCleanIP()+" has joined the game.");
					OutputStream os = socket.getOutputStream();
					String[] args = {"welcome"};
					ServerResponse sr=new ServerResponse(1,args);
					ObjectOutputStream oos = new ObjectOutputStream(os);
					oos.writeObject(sr);
					oos.close();
					os.close();

				}
			}
		} catch (IOException e) {
			//System.out.println("Connection closed.");
		}
	}
}
