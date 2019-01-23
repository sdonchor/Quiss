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
	public void socketOpen() {
		try {
			this.socket=new Socket(address,port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ServerResponse sendMessage(String request) {
		socketOpen();
		try {
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
			printWriter.println(request);
			
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			ServerResponse sr = (ServerResponse)ois.readObject();
			return sr;
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public void initNewGame() {
		ServerResponse sr = sendMessage("new-player;"+nickname);
		if(sr==null) return;
		System.out.println(sr.getArgs());
		for(int i = 0;i<sr.getN();i++)
		{
			Question q = new Question(sr.getArgs()[i]);
			Main.getCurrentGame().addQuestion(q);
		}
		Main.getCurrentGame().showQuestion(0);
	}
	public void sendAnswer(String answer) {
		Game currGame=Main.getCurrentGame();
		currGame.disableButtons();
		String message = "answer;"+nickname+";"+currGame.getCurrentQuestionId()+";"+answer;
		ServerResponse sr = sendMessage(message);
		if(sr.getN()==1) {
			currGame.addPoint();
		}
		System.out.println(sr.getN());//
		int rounds = currGame.getRounds();
		if(currGame.getCurrentQuestionId()<rounds) {
			currGame.showQuestion(currGame.getCurrentQuestionId());
		}
		else
		{
			return;
		}
		currGame.enableButtons();
	}
}