import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class UseSuperMarket {

	public static void main(String args[]) throws IOException {
		//Initialize Variables
		boolean exit = false;
		
		int foodNum = 0;
		
		Scanner keyboard = new Scanner(System.in);
		Scanner foodScanner = new Scanner(new File("FoodList.txt"));
		
		//Run findFood until there is no more food left
		while (foodScanner.hasNextLine()) {
            findFood(foodScanner, foodNum);
    		foodNum++;
        }
		out.println(Food.caloriesA[1]);
		//Main Loop
		while(!exit) {
			display();
			char menu = keyboard.next().charAt(0);
			
			switch (menu) {
			case '1':
				out.println("Shop: ");
				break;
			case '2':
				out.println("Sell: ");
				break;
			case '3':
				out.println("Prices: ");
				break;
			case 'e':
				out.println("Exit");
				exit = true;
				break;
			default:
				out.println("Invalid!");
				break;
			}
		}
		keyboard.close();
		foodScanner.close();
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
		aFood.displayFood();
		if (aScanner.hasNextLine()) {
			aScanner.nextLine();
		}
		
		Food.nameA[foodNum] = aFood.getName();
		Food.priceA[foodNum] = aFood.getPrice();
		Food.massA[foodNum] = aFood.getMass();
		Food.scaleA[foodNum] = aFood.getScale();
		Food.caloriesA[foodNum] = aFood.getCalories();
		
		//aFood.displayArray(foodNumber);
	}
	
	//Display Menu Options
	static void display() {
		out.println("Buy(1)");
		out.println("Sell(2)");
		out.println("Prices(3)");
		out.println("Exit(e)");
	}
}