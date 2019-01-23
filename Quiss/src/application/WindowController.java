package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class WindowController {

    @FXML
    private TextArea questionBox;

    @FXML
    private Text serverConnectorTitle;

    @FXML
    private TextField ipInput;

    @FXML
    private TextField portInput;

    @FXML
    private TextField nickInput;

    @FXML
    private Button connectButton;
    
    @FXML
    private Button buttonA;

    @FXML
    private Button buttonB;

    @FXML
    private Button buttonD;

    @FXML
    private Button buttonC;

    @FXML
    private Text statusText;
    
    @FXML
    private Text scoreText;
 
    @FXML
    void chooseAnswerA(ActionEvent event) {
    	Main.getServerConnection().sendAnswer(buttonA.getText());
    }

    @FXML
    void chooseAnswerB(ActionEvent event) {
    	Main.getServerConnection().sendAnswer(buttonB.getText());
    }

    @FXML
    void chooseAnswerC(ActionEvent event) {
    	Main.getServerConnection().sendAnswer(buttonC.getText());
    }

    @FXML
    void chooseAnswerD(ActionEvent event) {
    	Main.getServerConnection().sendAnswer(buttonD.getText());
    }

    @FXML
    void connectClicked(ActionEvent event) {
    	if(ipInput.getText()!=null && !ipInput.getText().trim().isEmpty()) {
    		
    		if(portInput.getText()!=null && !portInput.getText().trim().isEmpty()) {
    			
    			if(nickInput.getText()!=null && !nickInput.getText().trim().isEmpty()) {
    				
    				String ip = ipInput.getText();
    				int port = Integer.valueOf(portInput.getText());
    				String nick = nickInput.getText();
    				
    				try {
    					Main.setCurrentGame(new Game(buttonA,buttonB,buttonC,buttonD,questionBox,scoreText));
						Main.setServerConnection(new ServerConnection(ip,port,nick));
						statusText.setText("Connection status: connected");
						/*Main.getCurrentGame().setA(buttonA);
						Main.getCurrentGame().setB(buttonB);
						Main.getCurrentGame().setC(buttonC);
						Main.getCurrentGame().setD(buttonD);*/
						Main.getCurrentGame().setQBox(questionBox);
						Main.getServerConnection().initNewGame();

						
						
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    				
    			}
    		}
    	}
    }

}
