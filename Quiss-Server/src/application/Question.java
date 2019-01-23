package application;

import java.util.ArrayList;
import java.util.Collections;

public class Question {
	int id = -1;
	int qsId = -1;
	private String content = null;
	private ArrayList<Answer> answers = new ArrayList<Answer>();
	private Answer correctAnswer=null;
	
	public Question(int id, String content, int qsId, String correctAnswer) {
		this.content=content;
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setCorrectAnswer(Answer a) {
		correctAnswer=a;
	}
	public Answer getCorrectAnswer() {
		return correctAnswer;
	}
	public void addAnswer(Answer a) {
		if(answers.size()>=4)
		{
			Console.println("Error: max 4 answers.");
			return;
		}
		else
		{
			answers.add(a);
			Collections.shuffle(answers);
			
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
}
