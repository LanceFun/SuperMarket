import static java.lang.System.out;
import java.util.ArrayList;

public class Settings {
	public static boolean autoPrices = false;
	public static boolean hasPlayed = false;
	
	public static ArrayList<String> settingName = new ArrayList<String>();
	public static ArrayList<String> settingValue = new ArrayList<String>();
	
	public static void showSettings() {
		out.println("(0)AutoPrices: " + autoPrices);
		out.println("(1)RestartGame");
	}
}
