package application;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;



public class ClientThread extends Thread{
	private Socket socket;
	String remoteIP=null;
	Player currentPlayer = null;
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
				
				if(message.contains("new-player"))
				{
					String[] request = message.split(";");
					String username = request[1];
					Player p = new Player(username,getCleanIP());
					PlayerList.addPlayer(p);
					Console.println("Player "+username+" with IP "+getCleanIP()+" has joined the game.");
					OutputStream os = socket.getOutputStream();
					currentPlayer=p;
					int n = Main.getCurrentGame().getRounds();
					String[] args = Main.getCurrentGame().getQuestionsString();
					
					ServerResponse sr=new ServerResponse(n,args);
					ObjectOutputStream oos = new ObjectOutputStream(os);
					oos.writeObject(sr);
					oos.close();
					os.close();

				}
				if(message.contains("answer"))
				{
					String[] request = message.split(";");
					String name = request[1];
					int id = Integer.valueOf(request[2]);
					if(id>Main.getCurrentGame().getQuestionQueue().size()) {
						return;
					}
					String answer = request[3];
					Question que = Main.getCurrentGame().getQuestionQueue().get(id-1);
					int result=0;
					if(que.getCorrectAnswer().equals(answer)) {
						PlayerList.getPlayer(name).setScore(PlayerList.getPlayer(name).getScore()+1);
						result=1;
					}
					
					Console.println("Player "+name+" answered "+answer+".");
					OutputStream os = socket.getOutputStream();
					String[] args = {};
					ServerResponse sr=new ServerResponse(result,args);
					ObjectOutputStream oos = new ObjectOutputStream(os);
					oos.writeObject(sr);
					oos.close();
					os.close();

				}
				else
					return;
			}
		} catch (IOException e) {
			//System.out.println("Connection closed.");
		}
	}
}
