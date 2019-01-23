package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			//get questions from db
			ResultSet rs = Main.getDatabaseHandler().executeQuery(QueryBuilder.getQuestionsByQuestionSetQuery(id));
			while(rs.next()) {
				int qid = rs.getInt("q_id");
				String content = rs.getString("content");
				String correct_answer = rs.getString("correct_answer");
				Question q = new Question(qid, content,this.id,correct_answer);
				//get answers from db
				ResultSet as = Main.getDatabaseHandler().executeQuery(QueryBuilder.getAnswersForQuestionQuery(qid));
				while(as.next()) {
					int aid = as.getInt("a_id");
					String aContent = as.getString("content");
					Answer ans = new Answer(aid,aContent,qid);
					q.addAnswer(ans);
				}
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
