import java.util.TimerTask;
import java.text.NumberFormat;
import java.util.Random;
import static java.lang.System.out;

public class UpdatePrices extends TimerTask{
	
	//Initialize Min and Max numbers for random
	public static int max = 20;
	public static int min = -20;
	
	static double oldPrices[] = new double[4];
	
	public void run() {
		changePrices();
		if (Settings.autoPrices == true) {
			showPrices();
			out.println();
			UseSuperMarket.display();
		}
	}
	
	@SuppressWarnings("unused")
	public static void changePrices() {
		Random random = new Random();
		int number;
		double result;
		int loopNum = 0;
		double newPrice;
		for (double price : Food.priceA) {
			oldPrices[loopNum] = price;
			number = random.nextInt(max + 1 -min) + min;
			result = number / 100.0;
			newPrice = price += result;
			Food.priceA[loopNum] = newPrice;
			loopNum++;
		}
	}
	
	public static void showPrices() {
		int loopNum = 0;
		for (double price : Food.priceA) {
			NumberFormat nf = NumberFormat.getCurrencyInstance();
			out.print(Food.nameA[loopNum] + ": ");
			out.println(nf.format(price));
			loopNum++;
		}
		out.println();
	}
	
	public static void showPricesWithChanges() {
		int loopNum = 0;
		for (double price : Food.priceA) {
			NumberFormat nf = NumberFormat.getCurrencyInstance();
			//out.print(Food.nameA[loopNum] + ": ");
			if (price < oldPrices[loopNum]) {
				out.print("(Lower)" + Food.nameA[loopNum] + ": ");
			} else if (price > oldPrices[loopNum]) {
				out.print("(Higher)" + Food.nameA[loopNum] + ": ");
			} else {
				out.print("(Same)" + Food.nameA[loopNum] + ": ");
			}
			out.println(nf.format(price));
			loopNum++;
		}
		out.println();
	}
}