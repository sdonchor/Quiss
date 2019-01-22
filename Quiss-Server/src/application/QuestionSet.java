package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class QuestionSet {
	private int id = -1;
	private String name = null;
	private ArrayList<Question> questions = new ArrayList<Question>();
	
	public QuestionSet(int id,String name) {
		this.id=id;
		this.name=name;
		fillQuestionSet();
	}
	public void fillQuestionSet() {
		try {
			ResultSet rs = Main.getDatabaseHandler().executeQuery(QueryBuilder.getQuestionsByQuestionSet(id));
			while(rs.next()) {
				int qid = rs.getInt("q_id");
				String content = rs.getString("content");
				String[] answers = {rs.getString("answer1"),rs.getString("answer2"),rs.getString("answer3"),rs.getString("answer4")};
				Question q = new Question(content);
				q.addAnswers(answers);
				addQuestion(q);
				//Console.println(""+q);//debug
			}
		} catch (SQLException e) {
			Console.println("Couldn't fill question set.");
		}
	}
	public void addQuestion(Question q) {
		questions.add(q);
	}
	public ArrayList<Question> getQuestions(){
		return questions;
	}
	public Question popRandomQuestion() {
		int i = (int)(System.currentTimeMillis() % questions.size());
		Question q = questions.get(i);
		questions.remove(i);
		return q;
	}
	public int getSize() {
		return questions.size();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return name;
	}
}
