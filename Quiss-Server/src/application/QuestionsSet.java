package application;

import java.util.ArrayList;

public class QuestionsSet {
	ArrayList<Question> questions = new ArrayList<Question>();
	
	public void addQuestion(Question q) {
		questions.add(q);
	}
	public ArrayList<Question> getQuestions(){
		return questions;
	}
}
