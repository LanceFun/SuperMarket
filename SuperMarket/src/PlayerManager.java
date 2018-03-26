import java.util.Scanner;
import static java.lang.System.out;

public class PlayerManager {
	//Initialize Variables
	private static String name;
	private static double balence;
	
	public static boolean readFromPlayerData = false;
	
	//Initialize Setters and Getters
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		PlayerManager.name = name;
	}
	public static double getBalence() {
		return balence;
	}
	public static void setBalence(double balence) {
		PlayerManager.balence = balence;
	}
	
//	public static void setUp() {
//		readFromPlayerData = true;
//		Settings.hasPlayed = true;
//	}
	
	@SuppressWarnings("unused")
	public static void restartGame(Scanner enterName) {
		out.println("Enter new name: ");
		String newName = enterName.next();
		PlayerManager.setName(newName);
		out.println("Welcome to the SuperMarket " + PlayerManager.getName());
		PlayerManager.balence = 5.00;
		int Loop = 0;
		for (int item : Inventory.inventory) {
			Inventory.inventory[Loop] = 10;
			Loop++;
		}
		
		//FIX
		Loop = 0;
		for (double price : Food.priceA) {
			Food.priceA[Loop] = Food.priceOld[Loop];
			Loop++;
		}
		out.println("Game restarted!");
	}
}
