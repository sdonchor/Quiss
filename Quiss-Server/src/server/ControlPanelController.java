package server;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    private ComboBox<?> questionsSetList;

    @FXML
    private Button questionSetButton;
    
    @FXML
    private  TextArea console;

    @FXML
    private TableView<?> playerTable;

    
    @FXML
    void chooseQuestionSet(ActionEvent event) {

    }

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
    }
    
    @FXML
    public void initialize() {
        Console.setCout(console);
    }
    @FXML
    void newGameClicked(ActionEvent event) {

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

    }
    @FXML
    void roundNumberChanged(ActionEvent event) {

    }

}
