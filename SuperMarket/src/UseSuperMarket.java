import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Timer;
import static java.lang.System.*;

public class UseSuperMarket {

	public static void main(String args[]) throws IOException {
		//Initialize Variables
		boolean exit = false;
		
//		if (Settings.hasPlayed = false) {
//			PlayerManager.setUp();
//		}
		
		int foodNum = 0;
		int invNum = 0;
		
		Scanner keyboard = new Scanner(System.in);
		Scanner foodScanner = new Scanner(new File("FoodList.txt"));
		Scanner playerScanner = new Scanner(new File("PlayerData.txt"));
		Scanner settingScanner = new Scanner(new File("Settings.txt"));
		
		Timer timer = new Timer();
		
		//Run findFood until there is no more food left
		while (foodScanner.hasNextLine()) {
            findFood(foodScanner, foodNum);
    		foodNum++;
        }
		
		findPlayerData(playerScanner, invNum);
		
		while (settingScanner.hasNextLine()) {
			findSettings(settingScanner);
		}
		
	//	out.println(Inventory.inventory[invNum]);

		//Start updating prices every minute
		timer.schedule(new UpdatePrices(), 0, 60000);
		
		out.println("Welcome to the SuperMarket " + PlayerManager.getName() + "!");
		
		//Main Loop
		while(!exit) {
			display();
			char menu = keyboard.next().charAt(0);
			
			switch (menu) {
			case '1':
				out.println("Buy: ");
				Inventory.showInventory();
				int index = keyboard.nextInt();
				out.println("How many " + Food.nameA[index] + " do you want to buy?");
				out.println("You have " + Inventory.inventory[index]);
				int amountToBuy = keyboard.nextInt();
				Inventory.buyItem(index, amountToBuy);
				break;
			case '2':
				out.println("Sell: ");
				Inventory.showInventory();
				int invSpot = keyboard.nextInt();
				out.println("How many " + Food.nameA[invSpot] + " do you want to sell?");
				out.println("You have " + Inventory.inventory[invSpot]);
				int amountToSell = keyboard.nextInt();
				Inventory.sellItem(invSpot, amountToSell);
				break;
			case '3':
				out.println("Prices: ");
				UpdatePrices.showPricesWithChanges();
				break;
			case 'e':
				out.println("Exit");
				exit = true;
				break;
			case 's':
				out.println("Settings: ");
				Settings.showSettings();
				int settingNum = keyboard.nextInt();
				switch (settingNum) {
				case 0:
					out.println("Would do you want to set AutoPrices to?");
					int autoPriceResponse = keyboard.nextInt();
					switch (autoPriceResponse) {
					case 0:
						Settings.autoPrices = false;
						out.println("AutoPrices: false");
						break;
					case 1:
						Settings.autoPrices = true;
						out.println("AutoPrices: true");
						break;
					default:
						out.println("Invalid Value!");
						break;
					}
				break;
				case 1:
					out.println("Are you sure you want to restart the game?");
					int restartGameResponse = keyboard.nextInt();
					switch (restartGameResponse) {
					case 0:
						out.println("Game not restarting!");
						break;
					case 1:
						PlayerManager.restartGame(keyboard);
						break;
					default:
						out.println("Invalid Value!");
						break;
					}
				}
				break;
			default:
				out.println("Invalid!");
				break;
			}
			out.println();
		}
		writeToSettings();
		writeToPlayerData();
		keyboard.close();
		foodScanner.close();
		playerScanner.close();
		settingScanner.close();
	}
	
	//Take food from FoodList and put them into an Array
	static void findFood(Scanner aScanner, int foodNum) {
		Food aFood = new Food();
		
		aFood.setName(aScanner.nextLine());
		aFood.setPrice(aScanner.nextDouble());
		aScanner.nextLine();
		aFood.setMass(aScanner.nextDouble());
		aScanner.nextLine();
		aFood.setScale(Scale.valueOf(aScanner.nextLine().toUpperCase()));
		aFood.setCalories(aScanner.nextInt());
		//aFood.displayFood();
		if (aScanner.hasNextLine()) {
			aScanner.nextLine();
		}
		
		Food.nameA[foodNum] = aFood.getName();
		Food.priceOld[foodNum] = aFood.getPrice();
		Food.massA[foodNum] = aFood.getMass();
		Food.scaleA[foodNum] = aFood.getScale();
		Food.caloriesA[foodNum] = aFood.getCalories();
		
		//aFood.displayArray(foodNum);
	}
	
	//Set player data to the PlayerManager
	static void findPlayerData(Scanner aScanner, int invNum) {
		PlayerManager.setName(aScanner.nextLine());
		PlayerManager.setBalence(aScanner.nextDouble());
		aScanner.hasNextLine();
		while (aScanner.hasNextInt()) {
			Inventory.inventory[invNum] = aScanner.nextInt();
			//out.println(Inventory.inventory[invNum]);
			invNum++;
		}
		
		invNum = 0;
		
		while (aScanner.hasNextDouble()) {
			Food.priceA[invNum] = aScanner.nextDouble();
			invNum++;
		}
		
	}
	
	static void findSettings(Scanner aScanner) {
		while (aScanner.hasNextLine()) {
			Settings.settingName.add(aScanner.nextLine());
			Settings.settingValue.add(aScanner.nextLine());
		}
	}
	
	@SuppressWarnings("unused")
	static void writeToSettings() {
		PrintWriter writer;
		try {
			writer = new PrintWriter("Settings.txt", "UTF-8");
			int value = 0;
			for (String name : Settings.settingName) {
				writer.println(Settings.settingName.get(value));
				writer.println(Settings.settingValue.get(value));
				value++;
			}
			writer.close();
		} catch (IOException ex){}
	}
	
	static void writeToPlayerData() {
		PrintWriter writer;
		try {
			writer = new PrintWriter("PlayerData.txt", "UTF-8");
			writer.println(PlayerManager.getName());
			writer.println(PlayerManager.getBalence());
			int loopNum = 1;
			for (int item : Inventory.inventory) {
				if (loopNum < Inventory.inventory.length) {
					writer.print(item + " ");
				} else {
					writer.println(item);
				}
				loopNum++;
			}
			
			loopNum = 1;
			
			for (double price : Food.priceA) {
				if (loopNum <= Food.priceA.length) {
					writer.print(price + " ");
					loopNum++;
				} else {
					writer.println(price);
				}
			}
			writer.println();
			writer.print(true);
			
			try {writer.close();} catch  (Exception ex) {}
		} catch (IOException ex) {}
	}
	
	//Display Menu Options
	static void display() {
		out.println("Buy(1)");
		out.println("Sell(2)");
		out.println("Prices(3)");
		out.println("Exit(e)");
		out.println("Settings(s)");
	}
}