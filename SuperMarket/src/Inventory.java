import static java.lang.System.out;

import java.text.NumberFormat;

public class Inventory extends PlayerManager {
	static int inventory[] = new int[4];
	static int nameNum;
	
	public static void showInventory() {
		int nameNum = 0;
		for (int item : inventory) {
			out.println(Food.nameA[nameNum] + "(" + nameNum + ")");
			out.println(item);
			nameNum++;
		}
	}

	public static void sellItem(int invIndex, int amount) {
		if (inventory[invIndex] >= amount) {
			int newInvAmount = inventory[invIndex] - amount;
			inventory[invIndex] = newInvAmount;
			out.println("You now have " + inventory[invIndex] + " " + Food.nameA[invIndex] + " left.");
			PlayerManager.setBalence(PlayerManager.getBalence() + (amount * Food.priceA[invIndex]));
			NumberFormat nf = NumberFormat.getCurrencyInstance();
			out.println("You now have " + nf.format(PlayerManager.getBalence()));
		} else {
			out.println("Not Enough " + Food.nameA[invIndex]);
		}
	}
	
	public static void buyItem(int invIndex, int amount) {
		if(PlayerManager.getBalence() >= amount) {
			PlayerManager.setBalence(PlayerManager.getBalence() - (Food.priceA[invIndex] * amount));
			int newAmount = inventory[invIndex] + amount;
			inventory[invIndex] = newAmount;
			NumberFormat nf = NumberFormat.getCurrencyInstance();
			out.println("You now have " + inventory[invIndex] + " " + Food.nameA[invIndex] + ".");
			out.println("You now have " + nf.format(PlayerManager.getBalence()));
		} else {
			out.println("Insufficient Funds!");
		}
	}
}
