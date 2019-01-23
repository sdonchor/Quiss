package application;

import java.util.ArrayList;
import java.util.Collections;

public class Question {
	private String content=null;
	private String a1=null;
	private String a2=null;
	private String a3=null;
	private String a4=null;
	public Question(String stringForm) {
		String[] parameters = stringForm.split(";");
		this.content=parameters[0];
		this.a1=parameters[1];
		this.a2=parameters[2];
		this.a3=parameters[3];
		this.a4=parameters[4];
	}
	public String getA1() {
		return a1;
	}
	public String getA2() {
		return a2;
	}
	public String getA3() {
		return a3;
	}
	public String getA4() {
		return a4;
	}
	public String getContent() {
		return content;
	}
}
