package application;

import java.util.Arrays;
import java.util.Collections;

public class Question {
	private String content = null;
	private String answerA = null;
	private String answerB = null;
	private String answerC = null;
	private String answerD = null;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * Assigns given answer list's elements to random A/B/C/D positions.
	 * @param answers list of answers
	 */
	public void addAnswers(String[] answers) {
		if(answers.length!=4)
		{
			Console.println("Error: invalid answers list.");
			return;
		}
		Collections.shuffle(Arrays.asList(answers));
		answerA=answers[0];
		answerB=answers[1];
		answerC=answers[2];
		answerD=answers[3];
	}
}
