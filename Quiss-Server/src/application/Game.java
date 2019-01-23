package application;

import java.util.ArrayList;

public class Game {
	private QuestionSet qs=null;
	private int rounds = 0;
	private boolean isStarted=false;
	private boolean canChangeOptions = true;
	private int currentRound=0;
	private ArrayList<Player> playerlist = null;
	public Game() {
		
	}

	public QuestionSet getQuestionSet() {
		return qs;
	}
	public void setQuestionSet(QuestionSet qs) {
		if(canChangeOptions)
		{
			this.qs = qs;
			Console.println("Picked question set "+qs+" with "+qs.getSize()+" questions.");
		}
		else
		{
			Console.println("Can't change options now.");
		}
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
		if(qs==null) {
			Console.println("Can't start a new game. Choose a question set.");
			return;
		}
		if(playerlist==null || playerlist.size()==0) {
			Console.println("Can't start a new game. No players.");
			return;
		}
	}
	public int getRounds() {
		return rounds;
	}
	public void setRounds(int rounds) {
		Console.println("Set the rounds count to "+rounds+".");
		this.rounds = rounds;
	}
	public int getCurrentRound() {
		return currentRound;
	}
	public void setCurrentRound(int currentRound) {
		this.currentRound = currentRound;
	}
	
}
