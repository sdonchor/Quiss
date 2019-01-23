package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class QueryBuilder {
	private static Connection connection;
	public static void setConnection(Connection con) {
		connection=con;
	}
	public static PreparedStatement checkConnectionQuery() throws SQLException {
		String sql = "SELECT 1";
		PreparedStatement stmt = connection.prepareStatement(sql);
		return  stmt;
	}

	public static PreparedStatement getQuestionSetsQuery() throws SQLException {
		String sql = "SELECT * FROM question_sets";
		PreparedStatement stmt = connection.prepareStatement(sql);
		return stmt;
	}
	public static PreparedStatement getQuestionSetByIdQuery(int id) throws SQLException{
		String sql = "SELECT * FROM question_sets WHERE qs_id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, id);
		return stmt;
	}
	public static PreparedStatement getQuestionSetByNameQuery(String name) throws SQLException{
		String sql = "SELECT * FROM question_sets WHERE name=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, name);
		return stmt;
	}
	public static PreparedStatement getQuestionsQuery(int id) throws SQLException{
		String sql = "SELECT * FROM questions WHERE qs_id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, id);
		return stmt;
	}
	public static PreparedStatement getQuestionByIdQuery(int id) throws SQLException{
		String sql="SELECT * FROM questions WHERE q_id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, id);
		return stmt;
	}
	public static PreparedStatement getBannedIpsQuery() throws SQLException{
		String sql = "SELECT * FROM banned_ips";
		PreparedStatement stmt = connection.prepareStatement(sql);
		return stmt;
		
	}
	public static PreparedStatement getQuestionsByQuestionSetQuery(int id) throws SQLException {
		String sql = "SELECT * FROM questions WHERE qs_id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, id);
		return stmt;
	}
	public static PreparedStatement getAnswersForQuestionQuery(int id) throws SQLException {
		String sql = "SELECT * FROM answers WHERE q_id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1,id);
		return stmt;
	}
	public static PreparedStatement getAnswerByIdQuery(int id) throws SQLException {
		String sql  = "SELECT * FROM answers WHERE a_id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, id);
		return stmt;
	}
	public static PreparedStatement isBannedQuery(String ip) throws SQLException{
		String sql = "SELECT * FROM banned_ips WHERE ip=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, ip);
		return stmt;
	}
	public static PreparedStatement banIpQuery(String ip) throws SQLException{
		String sql = "INSERT INTO banned_ips(ip) VALUES (?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, ip);
		return stmt;
	}
	public static PreparedStatement addQuestionSetQuery(String name) throws SQLException {
		String sql = "INSERT INTO question_sets (name) VALUES (?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, name);
		return stmt;
	}
	public static PreparedStatement addQuestionQuery(String content, int qs_id, String answer) throws SQLException{
		String sql = "INSERT INTO questions (content,qs_id,correct_answer) VALUES (?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, content);
		stmt.setInt(2, qs_id);
		stmt.setString(3, answer);
		return stmt;
	}
	public static PreparedStatement addAnswerQuery(String content, int q_id) throws SQLException{
		String sql = "INSERT INTO answers (content,q_id) VALUES (?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, content);
		stmt.setInt(2, q_id);
		return stmt;
	}
	public static PreparedStatement getQuestionByContent(String content) throws SQLException {
		String sql = "SELECT * FROM questions WHERE content=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, content);
		return stmt;
	}
	public static PreparedStatement getAnswerByContent(String content) throws SQLException {
		String sql = "SELECT * FROM answers WHERE content=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, content);
		return stmt;
	}
	//debug
	public static void testInsert() throws SQLException {
		String sql = "INSERT INTO question_sets(name) VALUES (?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(cal.getTime());
        stmt.setString(1, time);
		stmt.executeUpdate();
	}
	
}