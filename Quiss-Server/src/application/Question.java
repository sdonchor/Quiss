package application;

import java.util.ArrayList;
import java.util.Collections;

public class Question {
	int id = -1;
	int qsId = -1;
	private String content = null;
	private ArrayList<Answer> answers = new ArrayList<Answer>();
	private String correctAnswer=null;
	
	public Question(int id, String content, int qsId, String correctAnswer) {
		this.content=content;
		this.id = id;
		this.correctAnswer=correctAnswer;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setCorrectAnswer(String a) {
		correctAnswer=a;
	}
	public String getCorrectAnswer() {
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

	public String stringForm() {
		String a1=answers.get(0).getContent();
		String a2=answers.get(1).getContent();
		String a3=answers.get(2).getContent();
		String a4=answers.get(3).getContent();
		String s = content +";"+ a1 +";"+ a2 +";"+ a3 +";"+ a4;
		return s;
	}
}
