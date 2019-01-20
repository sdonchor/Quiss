package application;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.scene.control.TextArea;

public class Console {
	private static TextArea cout;

	public static TextArea getCout() {
		return cout;
	}

	public static void setCout(TextArea cout) {
		Console.cout = cout;
	}
	public static void println(String s) {
		if(!(cout.getLength()==0)) {
			String newLine = System.getProperty("line.separator");
			cout.appendText(newLine);
		}
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(cal.getTime());
		cout.appendText("["+time+"] " + s);
	}
	
}
