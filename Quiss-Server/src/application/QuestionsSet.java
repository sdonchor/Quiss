package application;

import java.util.ArrayList;
import java.util.Random;

public class QuestionsSet {
	private ArrayList<Question> questions = new ArrayList<Question>();
	
	public void addQuestion(Question q) {
		questions.add(q);
	}
	public ArrayList<Question> getQuestions(){
		return questions;
	}
	public Question getRandomQuestion() {
		int i = (int)(System.currentTimeMillis() % questions.size());
		Question q = questions.get(i);
		questions.remove(i);
		return q;
	}
}
