package FoodOrderingSystem;

//import the scanner from java library
import java.util.Scanner;

//Create an Meal Class as subclass and Meals as a superclass
public class Meal {
	
	//Class data Members:
	public static String mealNameString[]= new String [100];
	public static double Price[]= new double [100];
	public static int quantity[]= new int [100];
	
	public static double PriceA[] = new double [100];
	public static int quantityA[] = new int [100];
	public static String nameA[] = new String[100];

    // Creating object of Scanner class
	static Scanner inputScanner = new Scanner(System.in);
	
	static	Meals meals = new Meals();

	
	//constructor of meal class 
	public Meal() {
		
		//set s condition for the constructor
		if(meals.checkMealsInput == false) {
		inputScanner.nextLine();
		// TODO Auto-generated constructor stub

    	System.out.println("\u001B[36m************************************\u001B[0m");
    	System.out.println("\u001B[36m*         Tun Fatimah MENU         *\u001B[0m");
    	System.out.println("\u001B[36m* Meal Name:                       *\u001B[0m");
    	System.out.println("\u001B[36m************************************\u001B[0m");
			this.mealNameString[meals.count] = inputScanner.nextLine();
			

			//set Price for the meal
	    	System.out.println("\u001B[36m************************************\u001B[0m");
	    	System.out.println("\u001B[36m*         Tun Fatimah MENU         *\u001B[0m");
	    	System.out.println("\u001B[36m* Meal price:                      *\u001B[0m");
	    	System.out.println("\u001B[36m************************************\u001B[0m");
			this.Price[meals.count] = inputScanner.nextInt();
		
			
			//set quantity for the meal
	    	System.out.println("\u001B[36m************************************\u001B[0m");
	    	System.out.println("\u001B[36m*         Tun Fatimah MENU         *\u001B[0m");
	    	System.out.println("\u001B[36m* Meal Quantity:                   *\u001B[0m");
	    	System.out.println("\u001B[36m************************************\u001B[0m");
			this.quantity[meals.count] = inputScanner.nextInt();
		}
	}
	
	

}
