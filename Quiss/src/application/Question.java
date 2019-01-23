package application;

import java.util.ArrayList;
import java.util.Collections;

public class Question {
	String content=null;
	String a1=null;
	String a2=null;
	String a3=null;
	String a4=null;
	public Question(String stringForm) {
		String[] parameters = stringForm.split(";");
		this.content=parameters[0];
		this.a1=parameters[1];
		this.a2=parameters[2];
		this.a3=parameters[3];
		this.a4=parameters[4];
	}
}
