package application;

import javafx.beans.property.SimpleIntegerProperty;

public class Player {
	private String name = null;
	private String ip = null;
	private int score = 0;
	private SimpleIntegerProperty scoreProp = new SimpleIntegerProperty(score);
	public Player(String name,String ip) {
		this.name=name;
		this.ip=ip;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
		this.scoreProp.set(score);
	}
	public SimpleIntegerProperty scoreProperty() {
	    return this.scoreProp;
	}
}
