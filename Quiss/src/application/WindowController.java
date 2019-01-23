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
    private Text statusText;

    @FXML
    void chooseAnswerA(ActionEvent event) {
    	
    }

    @FXML
    void chooseAnswerB(ActionEvent event) {
    	
    }

    @FXML
    void chooseAnswerC(ActionEvent event) {
    	
    }

    @FXML
    void chooseAnswerD(ActionEvent event) {
    	
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
						Main.setServerConnection(new ServerConnection(ip,port,nick));
						Main.getServerConnection().sendMessage("new-player;"+nick);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    				
    			}
    		}
    	}
    }

}
