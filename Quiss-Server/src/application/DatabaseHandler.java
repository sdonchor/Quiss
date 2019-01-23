package application;

import java.sql.PreparedStatement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHandler {
	private Connection connect = null;
    private String address;
    private String username;
    private String password;
    private String dbName;
    private int port;
    
	public DatabaseHandler(String address,String username,String password,String dbName,int port) {
		this.address=address;
		this.username=username;
		this.password=password;
		this.dbName=dbName;
		this.port=port;	
	}
	public DatabaseHandler() {
		//default values for debug purposes
		address="sql.sdonchor.nazwa.pl";
		username="sdonchor_Quiss-DB";
		password="ZXCasdqwe123";
		dbName="sdonchor_Quiss-DB";
		port=3306;
	}
	public void connect() {
		try {
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setUser(username);
			dataSource.setPassword(password);
			dataSource.setServerName(address);
			dataSource.setPort(port);
			dataSource.setDatabaseName(dbName);
			connect = dataSource.getConnection();
			QueryBuilder.setConnection(connect);
			Console.println("Connected to database at "+address+".");
				
		} catch (SQLException e) {
			Console.println("Failed to connect to the database.");
		}
	}
	public ResultSet executeQuery(PreparedStatement preparedStatement) {
		checkConnection();
		ResultSet rs=null;
		try {
			rs = preparedStatement.executeQuery();
		} catch (SQLException e) {
			Console.println("Failed to execute db query: "+preparedStatement);
		}
		return rs;
	}
	public boolean executeUpdate(PreparedStatement stmt) {
		checkConnection();
		boolean success=false;
		int rows=0;
		try {
			rows = stmt.executeUpdate();
			if(rows>=1) {
				success=true;
			}
		} catch(SQLException e) {
			success=false;
		}
		if(success==true) {
			return true;
		}
		else
		{
			Console.println("Failed to execute db update: "+stmt);
			return false;
		}
	}
	public boolean checkConnection() {
		boolean success=false;
		try {
			PreparedStatement stmt = connect.prepareStatement("SELECT 1");
			stmt.executeQuery();
			
		} catch (SQLException e) {
			success=false;
			Console.println("Database connection not active. Retrying...");
			connect();
		}
		return success;
	}

	public void closeConnection() {
		try {
			connect.close();
		} catch (SQLException e) {
			Console.println("Failed to close database connection.");
		}
	}
	//Table specific operations
	public int getIdOfQuestionSet(String name) {
		int qs_id = -1;
		try {
			ResultSet rs = executeQuery(QueryBuilder.getQuestionSetByNameQuery(name));
			if(rs.next()) {
				qs_id = rs.getInt("qs_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qs_id;
	}
	public int getIdOfQuestion(String content) {
		int q_id = -1;
		try {
			ResultSet rs = executeQuery(QueryBuilder.getQuestionByContent(content));
			if(rs.next()) {
				q_id = rs.getInt("q_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q_id;
	}
	public int getIdOfAnswer(String content) {
		int a_id = -1;
		try {
			ResultSet rs = executeQuery(QueryBuilder.getAnswerByContent(content));
			if(rs.next()) {
				a_id = rs.getInt("a_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a_id;
	}
	public int createQuestionSet(String name) {
		int qs_id=-1;
		try {
			executeUpdate(QueryBuilder.addQuestionSetQuery(name));
			qs_id = getIdOfQuestionSet(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qs_id;
	}
	public int createAnswer(String content, int q_id) {
		int a_id=-1;
		try {
			executeUpdate(QueryBuilder.addAnswerQuery(content,q_id));
			a_id = getIdOfAnswer(content);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a_id;
	}
	public int createQuestion(String content,int qs_id, String answer) {
		int q_id=-1;
		try {
			executeUpdate(QueryBuilder.addQuestionQuery(content,qs_id, answer));
			q_id = getIdOfQuestion(content);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return q_id;
	}
}
