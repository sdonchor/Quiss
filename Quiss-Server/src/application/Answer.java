package application;

public class Answer {
	private String content = null;
	private int id = -1;
	public Answer(int id, String content) {
		this.id=id;
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public int getId() {
		return id;
	}
}
