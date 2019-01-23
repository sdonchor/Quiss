package application;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class ControlPanelController {

    @FXML
    private TextField ipInput;

    @FXML
    private TextField portInput;

    @FXML
    private TextField usernameInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private TextField dbNameInput;

    @FXML
    private Button connectButton;

    @FXML
    private Button newGameButton;

    @FXML
    private Button stopGame;

    @FXML
    private ComboBox<QuestionSet> questionsSetList;
    
    @FXML
    private ComboBox<Integer> roundsList;

    @FXML
    private Button questionSetButton;
    
    @FXML
    private  TextArea console;

    @FXML
    private TableView<Player> playerTable;

    @FXML
    private TableColumn<Player, String> usernameCol;

    @FXML
    private TableColumn<Player, String> ipCol;
    
    @FXML
    private TableColumn<Player, String> scoreCol;
    
    @FXML
    void connectClicked(ActionEvent event) {
    	if(ipInput.getText()!=null  && !ipInput.getText().trim().isEmpty())
    	{
    		System.out.println(ipInput.getText().trim().isEmpty());
	    	String ip = ipInput.getText().trim();
	    	int port=3306;
	    	try {
		    	if(portInput.getText()!=null)
		    		port = Integer.valueOf(portInput.getText().trim());
	    	}catch(NumberFormatException e) {
	    		port=3306;
	    	}
	    	String username = usernameInput.getText().trim();
	    	String password = passwordInput.getText().trim();
	    	String dbName = dbNameInput.getText().trim();
	    	
	    	Main.setDatabaseHandler(new DatabaseHandler(ip,username,password,dbName,port));
	    	Console.println("Connecting to database located at address "+ip+".");
	    	
	    	System.out.println(ip+port+username+password+dbName);
    	}
    	else
    	{
    		Console.println("Connecting to default database.");
    		Main.setDatabaseHandler(new DatabaseHandler());
    
    	}
    	Main.getDatabaseHandler().connect();
    	questionsSetList.getItems().clear();
    	try {
			ResultSet rs = Main.getDatabaseHandler().executeQuery(QueryBuilder.getQuestionSetsQuery());
			while(rs.next()) {
				int id = rs.getInt("qs_id");
				String name = rs.getString("name");
				QuestionSet qs = new QuestionSet(id,name);
				questionsSetList.getItems().add(qs);
			}
		} catch (SQLException e) {
			Console.println("Failed to download question sets.");
		}
    	
    }
    @FXML
    void chooseQuestionSet(ActionEvent event) {
    	if(questionsSetList.getValue()==null)
    	{
    		Console.println("Choose a question set first.");
    		return;
    	}
    	QuestionSet qs = questionsSetList.getValue();
    	Main.getCurrentGame().setQuestionSet(qs);
    	int qsSize=qs.getSize();
    	roundsList.getItems().clear();
    	for(int i = 1; i<=qsSize;i++) {
    		roundsList.getItems().add(i);
    	}
    }

    @FXML
    public void initialize() {
        Console.setCout(console);
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        ipCol.setCellValueFactory(new PropertyValueFactory<>("ip"));
        scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
        PlayerList.setTable(playerTable);

        
    }
    @FXML
    void newGameClicked(ActionEvent event) {
    	Main.getServerThread().start();
    }

    @FXML
    void questionSetChanged(ActionEvent event) {

    }

    @FXML
    void stopGameClicked(ActionEvent event) {

    }
    
    @FXML
    void entriesEndClicked(ActionEvent event) {
    	
    }
    @FXML
    void roundsCountClicked(ActionEvent event) {
    	if(roundsList.getValue()!=null)
    	{
	    	int roundsCount = roundsList.getValue();
	    	Main.getCurrentGame().setRounds(roundsCount);
	    	
    	}
    	else
    	{
    		Console.println("Pick number of rounds first.");
    	}
    }

}
