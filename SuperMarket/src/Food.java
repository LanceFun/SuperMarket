import static java.lang.System.out;

public class Food {
	//Initialize Variables
	private double mass;
	private String name;
	private Scale scale;
	private int calories;
	private int servings;
	private double price;
	
	static String nameA[] = new String[4];
	static double priceA[] = new double[4];
	static double massA[] = new double[4];
	static Scale scaleA[] = new Scale[4];
	static int caloriesA[] = new int[4];
	
	//Initialize Constructors
	public Food(String name, Scale scale) {
		this.name = name;
		this.scale = scale;
	}
	
	public Food() {
		mass = 0.0;
		scale = Scale.GRAM;
	}
	
	public Food(String name, double price, double mass, Scale scale, int calories) {
		this.name = name;
		this.scale = scale;
		this.calories = calories;
	}

	//Initialize Setters and Getters
	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Scale getScale() {
		return scale;
	}

	public void setScale(Scale scale) {
		this.scale = scale;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getServings() {
		return servings;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	//Display a food item
	public void displayFood() {
		out.println(name);
		out.println("$" + price);
		out.printf("%.2f %sS\n", getMass(), getScale());
		out.println(calories + " Calories");
		out.println();
	}
	
	public void displayArray(int foodNum) {
		out.println(nameA[foodNum]);
		out.println("$" + priceA[foodNum]);
		out.printf("%.2f %sS\n", massA[foodNum], scaleA[foodNum]); 
		out.println(caloriesA[foodNum] + " Calories");
		out.println();
	}
}
