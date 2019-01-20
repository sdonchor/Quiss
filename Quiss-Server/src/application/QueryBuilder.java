package application;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QueryBuilder {
	private Connection connection;
	public static void setConnection() {
		
	}
	public static PreparedStatement queryGetQuestions() {
		String sql = "SELECT * FROM questions";//TODO bazę zrób
		
	}
}
