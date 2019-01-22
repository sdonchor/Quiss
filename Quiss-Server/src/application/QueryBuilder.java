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
	public static PreparedStatement getQuestionsByQuestionSet(int id) throws SQLException {
		String sql = "Select * FROM questions WHERE qs_id=?";
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