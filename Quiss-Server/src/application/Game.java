package application;

import java.util.ArrayList;

public class Game {
	private QuestionsSet cQs=null;
	private Timer time = null;
	private ArrayList<Player> playerlist = null;
	public Game(QuestionsSet cQs) {
		
	}
	public Timer getTime() {
		return time;
	}
	public void setTime(Timer time) {
		this.time = time;
	}
	public QuestionsSet getcQs() {
		return cQs;
	}
	public void setcQs(QuestionsSet cQs) {
		this.cQs = cQs;
	}
	public ArrayList<Player> getPlayerlist() {
		return playerlist;
	}
	public void setPlayerlist(ArrayList<Player> playerlist) {
		this.playerlist = playerlist;
	}
	
}
