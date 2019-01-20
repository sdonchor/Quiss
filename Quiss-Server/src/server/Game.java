package server;

import java.util.ArrayList;

public class Game {
	private QuestionSet cQs=null;
	private Timer time = null;
	private boolean isStarted=false;
	private int currentRound=0;
	private ArrayList<Player> playerlist = null;
	public Game(QuestionSet cQs) {
		
	}
	public Timer getTime() {
		return time;
	}
	public void setTime(Timer time) {
		this.time = time;
	}
	public QuestionSet getcQs() {
		return cQs;
	}
	public void setcQs(QuestionSet cQs) {
		this.cQs = cQs;
	}
	public ArrayList<Player> getPlayerlist() {
		return playerlist;
	}
	public void setPlayerlist(ArrayList<Player> playerlist) {
		this.playerlist = playerlist;
	}
	public void beginGame(int rounds) {
		if(isStarted) {
			Console.println("Can't start a new game. A game is in progress.");
			return;
		}
		if(cQs==null) {
			Console.println("Can't start a new game. Choose a question set.");
			return;
		}
		if(playerlist==null || playerlist.size()==0) {
			Console.println("Can't start a new game. No players.");
			return;
		}
	}
	
}
