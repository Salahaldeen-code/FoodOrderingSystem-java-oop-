package FoodOrderingSystem;

//import the scanner from java library
import java.util.Scanner;


//Create an Customer Class as subclass and OrderingSystem as a superclass
public class Customer extends Orderingsystem {
	
	//Class data Members:
	
	public static int quantityC[] = new int [100];
	public static double PriceC[] = new double [100];
	public static String MealName[] = new String [100];
	
    
    public static double totalprice;
    public static double discount;
	public static int count = 0;
	
    //Create object of Meals class
	static Meals  meals= new Meals();
	
	//Create object of Meal class
	static Meal meal[] = new Meal[100];

    // Creating object of Scanner class
	public static Scanner input = new Scanner(System.in);
  

	  //This function to set the variables of new selected meals for the student
	public static void addVariables(int i, Double p, String name) {
		PriceC[i] = p;
		MealName[i] = name;
	}
	
	
	//This function is the showCart Meal Name,Price and Quantity
	public static void showCart() {
	    System.out.println("*************************************");
        System.out.println("*Food Cart:                         *");
        System.out.println("*Meal Name\t\t\t\tPrice\t\tQuantity     ");
		
        //looping to show all Meals Names,Prices and Quantities
        for (int x = 0; x<count; x++) {

			System.out.println("|"+(x+1)+". "+MealName[x] + "\t\t\t" + PriceC[x] + "\t\t" + quantityC[x]);

		}
	    System.out.println("*************************************");
	}
	

	
	  //This function is to select one meals From all Meals of the customer
	public static void selectFromMails() {

		//call showMealsCustomers 
		meals.showMealsCustomers();
		int Choosed = input.nextInt();
		
		if(Choosed <= meals.count+meals.countA) {
	    System.out.println("\033[1;35m\033[1m\t\t\t\t*************************************\033[0m");
	    System.out.println("\033[1;35m\033[1m\t\t\t\t*         Tun Fatimah MENU         *\033[0m");
	    System.out.println("\033[1;35m\033[1m\t\t\t\t* Enter quantity:                   *\033[0m");
	    System.out.println("\033[1;35m\033[1m\t\t\t\t*************************************\033[0m");
	    quantityC[count] = input.nextInt();

		if(Choosed> meals.countA) {
			Choosed-=meals.countA;
			if(quantityC[count] <= meal[Choosed-1].quantity[Choosed-1]) {
				addVariables(count, meal[Choosed-1].Price[Choosed-1], meal[Choosed-1].mealNameString[Choosed-1]);
				meal[Choosed-1].quantity[Choosed-1]-= quantityC[count];
			
			
			}
			else {
			    System.out.println("\t\t\t\t|Sorry! There is only " + meal[Choosed-1].quantity[Choosed-1] + " Of this meal|");
			    System.out.println("\t\t\t\t+===================================+");
			    selectFromMails();
			}
		}
	    else {
			if(quantityC[count] <= meal[Choosed-1].quantityA[Choosed-1]) {
				addVariables(count, meal[Choosed-1].PriceA[Choosed - 1], meal[Choosed-1].nameA[Choosed - 1]);
				meal[Choosed-1].quantityA[Choosed-1]-= quantityC[count];
			}else {
			    System.out.println("|Sorry! There is only " + meal[Choosed-1].quantityA[Choosed-1] + " Of this meal|");
			    System.out.println("\033[1;35m\033[1m*************************************\033[0m");
			    selectFromMails();
			}
	    }	

    	count++;
    	menu();
		}
		else {
		    System.out.println("\033[1;35m\033[1m\t\t\t\t*Sorry! Please select the right meal from the list\033[0m");
		    System.out.println("\033[1;35m\033[1m\t\t\t\t***************************************************\033[0m");
		    selectFromMails();
		}
	}
	
	
	
	  //This function is to delete all the meals from the Cart 
	public static void resetCart() {
		int x =0;
		
	    // * we use linked list to delete the mails    
    	//linked list looping to delete the meal name 
		for(x=0;  x<count; x++) {
	    	//condition to  reset the meal name  

			if( x < MealName.length -1)
			{
	    	MealName[count] = MealName[count+1];
			}
			//condition to  Quantity the meal name 
			if(x < quantityC.length -1)
			{
				quantityC[count] = quantityC[count+1];
			}
		    //condition to  Price the meal name  
			if(x < PriceC.length -1)
			{
				PriceC[count] = PriceC[count+1];
			}
		}
		count=0;
		totalprice=0;
	}
	
	
	//This function to remove Meals from the customer 
	public static void RemoveMeal() {
	    System.out.println("\033[1;35m\033[1m**************************************************\033[0m");
	    System.out.println("\033[1;35m\033[1m*Choose one to delete:                           *\033[0m");
        System.out.println("|Meal Name\t\t\t\tPrice\t\tQuantity                               *");
		for (int x = 0; x<count; x++) {

			System.out.println("|"+(x+1)+". "+MealName[x] + "\t\t\t" + PriceC[x] + "\t\t" + quantityC[x]);

		}
	    System.out.println("\033[1;35m\033[1m**************************************************\033[0m");
	    int choose = input.nextInt();
	    
	    choose -=1;

	    // * we use linked list to delete the mails 
    	//linked list looping to delete the meal name  
	    for(int i = choose; i < MealName.length -1 ; i++){
	    	MealName[i] = MealName[i+1];

	      }
    	//linked list looping to delete the quantity of the meal  
	    for(int i = choose; i < quantityC.length -1; i++){
	    	quantityC[i] = quantityC[i+1];

	      }	
    	//linked list looping to delete the Price of the meal  
	    for(int i = choose; i < PriceC.length -1; i++){
	    	PriceC[i] = PriceC[i+1];

	      }
	    // decease the count to delete the meal 
	    count-=1;

	}
	
	//This function to editQuantity for Meals  
	public static void editQuantity() {
	    System.out.println("\033[1;35m\033[1m*************************************************\033[0m");
	    System.out.println("\033[1;35m\033[1m*Choose one to Edit:                            *\033[0m");
        System.out.println("|Meal Name\t\t\t\tPrice\t\tQuantity                              *");
		
        //loop to show the list of meals 
        for (int x = 0; x<count; x++) {

			System.out.println("|"+(x+1)+". "+MealName[x] + "\t\t\t" + PriceC[x] + "\t\t" + quantityC[x]);

		}
	    System.out.println("\033[1;35m\033[1m*************************************************\033[0m");
	    int choose = input.nextInt();
	    System.out.println("\033[1;35m\033[1m\t\t\t\t*************************************\033[0m");
	    System.out.println("\033[1;35m\033[1m\t\t\t\t*         Tun Fatimah MENU          *\033[0m");
	    System.out.println("\033[1;35m\033[1m\t\t\t\t*Enter new quantity:                *\033[0m");
	    System.out.println("\033[1;35m\033[1m\t\t\t\t*************************************\033[0m");
	    int newQuantity = input.nextInt();

	    // condition to renew the quantity 
	    quantityC[choose -1] = newQuantity;
	}
	
	
	  //This function about payment   
	public static void Payment() {
		System.out.println("\033[1;32m********************************************************\033[0m");
		System.out.println("\033[1;32m* your cart:\033[0m");
        System.out.println("|Meal Name\t\tPrice\t\tQuantity     |");
		
        //looping to check all selected meals and calculate the meals
        for (int x = 0; x<count; x++) {

			System.out.println("|"+(x+1)+". "+MealName[x] + "\t" + PriceC[x] + "\t\t" + quantityC[x]);

			//  calculation of the total Price of the  meals
			totalprice += PriceC[x] * quantityC[x];
		}
		System.out.println("\033[1;32m********************************************************\033[0m");

		// show the total Price of the  meals
		System.out.println();
		System.out.println("\033[1;32m**************************************\033[0m");
		System.out.println("\033[1;32m*        Total Price = \033[0m"+ totalprice);
		System.out.println("\033[1;32m**************************************\033[0m");
		System.out.println();

	    // condition is student he/she can have 20% discount 
	    if(student == true) {
	    	
			//  calculation of the discount from the total Price of the  meals
	    	discount = totalprice-(totalprice * 0.2D);
	    	
			// show the total Price of the  meals After 20% Discount Off 
			System.out.println("\033[1;32m**************************************\033[0m");
			System.out.println("\033[1;32m    *  After 20% Discount Off =  \033[0m"+ discount);
			System.out.println("\033[1;32m**************************************\033[0m");
			
		    //record the student purchased 
			studentCount++;
	    }
	    // if he/she not student can not  have  discount 
	    else {
	    	//record the student purchased 
	    	numberOfGuest++;
		}
	    
	    //make sure if customer/student  want to Proceed With Payment or give up 
		System.out.println("\033[1;32m\t\t\t\t***************************************\033[0m");
		System.out.println("\033[1;32m\t\t\t\t*      Tun Fatimah MENU               *\033[0m");
		System.out.println("\033[1;32m\t\t\t\t*Proceed With Payment?                *\033[0m");
		System.out.println("\033[1;32m\t\t\t\t* 1.Yes          2.No                 *\033[0m");
		System.out.println("\033[1;32m\t\t\t\t***************************************\033[0m");
	    int choose = input.nextInt();
	    //switch statement
	    switch (choose){
	    
	    //case 1 if yes go to pay 
	    case 1: {
	    	
			//call function payCash to pay 
			PayCash();
			//call function show menu 
			menu();			
		}
	    
	    //case 2 if no return o the menu 
		case 2: {
			//call function show menu 
		    studentCount--;
	    	numberOfGuest --;
			menu();
		
		}
		//	* Default case that will execute for sure 
		//	* if above cases does not match
		default:
	    }

	}
	
	 	//This function to pay    
	    public static void PayCash() {
			System.out.println("\033[1;32m***************************************\033[0m");
			System.out.println("\033[1;32m*      Tun Fatimah MENU 	       *\033[0m");
			System.out.println("\033[1;32m* Enter your payment: 		   *\033[0m");
			System.out.println("\033[1;32m***************************************\033[0m");
		    double payment = input.nextDouble();
		    
			   // condition is student will print with discount 
		    if(student == true) {
		    	if(payment>=discount) {
				System.out.println("\033[1;32m***************************************\033[0m");
				System.out.println("\033[1;32m*       Money Paid = \033[0m"+ payment);
				System.out.println("\033[1;32m***************************************\033[0m");
				System.out.println("\033[1;32m*      Money return = \033[0m"+ (payment-discount));
				System.out.println("\033[1;32m***************************************\033[0m");
				System.out.println("\033[1;32m*      Thank you for Purchasing	  	 		    *\033[0m");
				System.out.println("\033[1;32m***************************************\033[0m");
				
				//after finishing the payment it will restCart for the student 
				resetCart() ;
		    	}
		    	
		    	//condition if the student enter an Insufficient amount
		    	else {
					System.out.println("\033[1;32m***************************************\033[0m");
					System.out.println("\033[1;32m*Sorry! Insufficient amount of money    *\033[0m");
					System.out.println("\033[1;32m***************************************\033[0m");
					
					//return to the payCash function
					PayCash();
				}
		    }
	   			// condition is customer will not print with discount 
		    	if(student == false) {
			    	if(payment>=totalprice) {

					System.out.println("\033[1;32m***************************************\033[0m");
					System.out.println("\033[1;32m*       Money Paid = *\033[0m"+ payment);
					System.out.println("\033[1;32m***************************************\033[0m");
					System.out.println("\033[1;32m*       Money return = *\033[0m"+ (payment-totalprice));
					System.out.println("\033[1;32m***************************************\033[0m");
					System.out.println("\033[1;32m*       Thank you for Purchasing    *\033[0m");
					System.out.println("\033[1;32m***************************************\033[0m");

					//after finishing the payment it will restCart for the student 
					resetCart() ;
					
			    	//condition if the student enter an Insufficient amount
				}		    	else {
					System.out.println("\033[1;32m***************************************\033[0m");
					System.out.println("\033[1;32m*Sorry! Insufficient amount of money*\033[0m");
					System.out.println("\033[1;32m***************************************\033[0m");
					//return to the payCash function
					PayCash();
				}
		    
		}
		    	}

	}
