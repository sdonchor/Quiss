package application;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class Game {
	private ArrayList<Question> questions = new ArrayList<Question>();
	private int currentScore=0;
	private int currentQuestionId = 0;
	private Button A = null;
	private Button B = null;
	private Button C = null;
	private Button D = null;
	private TextArea qBox=null;
	private Text score = null;
	public Game(Button A, Button B, Button C, Button D, TextArea questionBox, Text scoreText) {
		this.A=A;
		this.B=B;
		this.C=C;
		this.D=D;
		this.qBox=questionBox;
		this.score=scoreText;
	}
	public void addPoint() {
		currentScore++;
		score.setText(Integer.toString(currentScore));
	}
	public int getRounds() {
		return questions.size();
	}
	public void setA(Button b) {
		this.A=b;
	}
	public void setB(Button b) {
		this.B=b;
	}
	public void setC(Button b) {
		this.C=b;
	}
	public void setD(Button b) {
		this.D=b;
	}
	public void addQuestion(Question q) {
		questions.add(q);
	}
	public int getCurrentQuestionId() {
		return currentQuestionId;
	}
	public void setCurrentQuestionId(int currentQuestion) {
		this.currentQuestionId = currentQuestion;
	}
	public Question getQuestion(int x) {
		return questions.get(x);
	}
	public void disableButtons() {
		A.setDisable(true);
		B.setDisable(true);
		C.setDisable(true);
		D.setDisable(true);
	}
	public void enableButtons() {
		A.setDisable(false);
		B.setDisable(false);
		C.setDisable(false);
		D.setDisable(false);
	}
	public void showQuestion(int id) {
		qBox.setText(questions.get(id).getContent());
		A.setText(questions.get(id).getA1());
		B.setText(questions.get(id).getA2());
		C.setText(questions.get(id).getA3());
		D.setText(questions.get(id).getA4());
		currentQuestionId++;
	}
	public void setQBox(TextArea questionBox) {
		this.qBox=questionBox;
		
	}
	

}
