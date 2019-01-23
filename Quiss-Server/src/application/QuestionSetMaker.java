package application;

import java.io.File;
import java.util.Scanner;

public class QuestionSetMaker {
	
	public static void stringToQuestion(String string){
		String[] arguments = string.split(";");
		if(arguments.length==7) {
			String question_set = arguments[0];
			String content = arguments[1];
			String ans1 = arguments[2];
			String ans2 = arguments[3];
			String ans3 = arguments[4];
			String ans4 = arguments[5];
			int correct = Integer.valueOf(arguments[6]);
			String correct_ans=ans4;
			switch(correct) {
			case 1:
				correct_ans=ans1;
				break;
			case 2:
				correct_ans=ans2;
				break;
			case 3:
				correct_ans=ans3;
				break;
			case 4:
				correct_ans=ans4;
				break;
			}
			int qs_id=Main.getDatabaseHandler().getIdOfQuestionSet(question_set);
			if(qs_id==-1) {
				qs_id=Main.getDatabaseHandler().createQuestionSet(question_set);
			}
			int q_id=Main.getDatabaseHandler().createQuestion(content, qs_id, correct_ans);
			int a1_id=Main.getDatabaseHandler().createAnswer(ans1, q_id);
			int a2_id=Main.getDatabaseHandler().createAnswer(ans2, q_id);
			int a3_id=Main.getDatabaseHandler().createAnswer(ans3, q_id);
			int a4_id=Main.getDatabaseHandler().createAnswer(ans4, q_id);
			
		}
	}

}
