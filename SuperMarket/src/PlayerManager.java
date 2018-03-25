import java.util.Scanner;
import static java.lang.System.out;

public class PlayerManager {
	//Initialize Variables
	private static String name;
	private static double balence;
	
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
	
	@SuppressWarnings("unused")
	public static void restartGame() {
		out.println("Enter new name: ");
		Scanner enterName = new Scanner(System.in);
		String newName = enterName.next();
		PlayerManager.setName(newName);
		out.println("Welcome to the SuperMarket " + PlayerManager.getName());
		PlayerManager.balence = 5.00;
		int Loop = 0;
		for (int item : Inventory.inventory) {
			Inventory.inventory[Loop] = 10;
			Loop++;
		}
		enterName.close();
	}
}
