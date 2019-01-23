package application;

import java.util.ArrayList;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PlayerList {
	//private static ArrayList<Player> list = new ArrayList<Player>();
	private static TableView<Player> table =  null;
	
	public static void setTable(TableView<Player> playerTable) {
		table=playerTable;
	}

	public static void addPlayer(Player p) {
		table.getItems().add(p);
	}
	public static Player getPlayer(String name) {
		for(int i=0;i<table.getItems().size();i++) {
			if(table.getItems().get(i).getName().equals(name))
			{
				return table.getItems().get(i);
			}
		}
		return null;
	}
	
}
