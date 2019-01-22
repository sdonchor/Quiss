package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	
	private static DatabaseHandler dbH=null;
	private static Game currentGame=new Game();
	
	@Override
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("ServerControlPanel.fxml"));
    
        Scene scene = new Scene(root, 900,700);
    
        stage.setTitle("Quiss Server Panel");
        stage.setScene(scene);
        stage.show();

    }
	
	public static void setDatabaseHandler(DatabaseHandler db) {
		dbH=db;
	}
	public static DatabaseHandler getDatabaseHandler() {
		return dbH;
	}
	public static Game getCurrentGame() {
		return currentGame;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
