package application;

public class Answer {
	private String content = null;
	private int id = -1;
	private int q_id = -1;
	public Answer(int id, String content, int q_id) {
		this.id=id;
		this.content = content;
		this.q_id=q_id;
	}
	public String getContent() {
		return content;
	}
	public int getId() {
		return id;
	}
	public int getq_id() {
		return q_id;
	}
	public void setq_id(int q_id) {
		this.q_id = q_id;
	}
}
