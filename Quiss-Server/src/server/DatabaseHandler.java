package server;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			Console.println("Connected to database at "+address+".");
				
		} catch (SQLException e) {
			Console.println("Failed to connect to the database.");
		}
	}
	public void closeConnection() {
		try {
			connect.close();
		} catch (SQLException e) {
			Console.println("Failed to close database connection.");
		}
	}
}
