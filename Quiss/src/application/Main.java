package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	private static ServerConnection sc = null;
	private static Game currentGame = null;
	@Override
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
    
        Scene scene = new Scene(root, 900,700);
    
        stage.setTitle("Quiss");
        stage.setScene(scene);
        stage.show();
    }

	public static void main(String[] args) {
		launch(args);
	}

	public static ServerConnection getServerConnection() {
		return sc;
	}

	public static void setServerConnection(ServerConnection sc) {
		Main.sc = sc;
	}

	public static Game getCurrentGame() {
		return currentGame;
	}

	public static void setCurrentGame(Game currentGame) {
		Main.currentGame = currentGame;
	}
}
