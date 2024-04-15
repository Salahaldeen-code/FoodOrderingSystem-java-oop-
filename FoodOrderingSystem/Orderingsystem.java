package FoodOrderingSystem;
//import the scanner from java library
import java.util.Scanner;


//Create an OrderingSystem Class
	public class Orderingsystem {

		//Class data Members:
	    public static String checkMatric[] = new String[100];
		private static String password = "admin";
		public static int  studentCount =0;
		public static int  numberOfGuest=0;
		
		//Set a Student Boolean to check if student or not... we will use it at the Payment process
		//if the student is true... 20% Discount of the total price
		public static boolean student = false;
		
		
		
		//Assign the Meals class object
		static	Meals meals = new Meals();
		
		//Assign the Customer class object
		static Customer customer = new Customer();
		
	    // Creating object of Scanner class
	    public static Scanner input = new Scanner(System.in);

	    
		//Create a setter for Password variable "Mutator"
		public static void setPassword(String password) {
			Orderingsystem.password = password;
		}

		//Create a getter for StallName variable to return it's value "Accessor"
		public static String getPassword() {
			return password;
		}

		
		//Create function to edit the password	
		public static void editPassword( ) {
	    	System.out.println("\033[1;35m\033[1m\t\t\t\t*************************************\033[0m");
		    System.out.println("\033[1;35m\033[1m\t\t\t\t*         Tun Fatimah MENU          *\033[0m");
		    System.out.println("\033[1;35m\033[1m\t\t\t\t*Type your New password:               *\033[0m");
	    	System.out.println("\033[1;35m\033[1m\t\t\t\t*************************************\033[0m");
		    setPassword(input.next()) ; 
		}





		
		
		
		//This function is the Login Page of the Program... Where it will appear first when program executed	
	    public static void login() {
		    //This is to reset the data of the Customer as Student
	    	student= false;
	    	
	    	System.out.println("*************************************");
	    	System.out.println("*************************************");
		    System.out.println("*   Tun Fatimah Food Order System   *");
		    System.out.println("*       1. Log in as Customer       *");
		    System.out.println("*       2. Log in as Stall          *");
		    System.out.println("*       3. Exit                     *");
	    	System.out.println("+************************************");

	    	//Scan/Take input of chooseLogin
		    int chooseLogin = input.nextInt();
		    
	    	// Switch/Case for login page options
	        switch (chooseLogin) {
	        
			//Case 1 Login as Customer
			case 1: 
			{
				//Calling the function that is responsible for checking if Customer is Student at UTHM or not
				checkIfStudent(); 
				break;
			}
			
			//Case 2 Login as Stall Manager
			case 2:
			{
				//Calling the function that is responsible for switching to Restaurant Menu Options
				checkResturant(); 
			    break;
			    
			}
			
			//Case 3 Exit the Program
			case 3:
			{
				 System.exit(0);
			}
			
			//	* Default case that will execute for sure 
			//	* if above cases does not match
			default:
				 System.out.println("ENTER BETWEEN 1 TO 3.");
				 
				//Repeat the same function by calling itself again
				 login();
			}
		}
	    
	    
	    
	    
	    
	    
	    
		//This function to Check if Customer is student or not...   
	    public static void checkIfStudent(){
	    System.out.println("\033[1;35m\033[1m*************************************\033[0m");
	    System.out.println("\033[1;35m\033[1m*         Tun Fatimah MENU          *\033[0m");
	    System.out.println("\033[1;35m\033[1m*Are you Student?                   *\033[0m");
	    System.out.println("\033[1;35m\033[1m*1. Yes        2.No                 *\033[0m");
    	System.out.println("\033[1;35m\033[1m*************************************\033[0m");
    	
    	//Scan/Take input of Yes/No if customer is student
	    int yesNo = input.nextInt();
	    
    	// Switch/Case for  Check if Customer is student or not page options
	    
        switch (yesNo) {
        
		//Case 1 Customer is Student
		case 1: 
		{
			//if choose yes then student is true "Discount 20%"
			student = true;
	    	System.out.println("\033[1;35m\033[1m\t\t\t\t*************************************\033[0m");
		    System.out.println("\033[1;35m\033[1m\t\t\t\t*         Tun Fatimah MENU          *\033[0m");
		    System.out.println("\033[1;35m\033[1m\t\t\t\t*Type your Matric No:               *\033[0m");
	    	System.out.println("\033[1;35m\033[1m\t\t\t\t*************************************\033[0m");
	    	
		    // this line to fix the skip 
		    input.nextLine();
		    checkMatric[studentCount] = input.nextLine();
		    
		    //small trick to check the right matric number by using the length of the word is 8 letters
		    if(checkMatric[studentCount].length() == 8) {
		    	System.out.println("\033[1;35m\033[1m*************************************\033[0m");
			    System.out.println("\033[1;35m\033[1m*         Tun Fatimah MENU          *\033[0m");
			    System.out.println("\033[1;35m\033[1m*  Thank you! you have 20% discount *\033[0m");
			    System.out.println("\033[1;35m\033[1m*************************************\033[0m");
			 
			//Calling the function that is responsible for Selecting/Adding meal for the Customer
			customer.selectFromMails();	
			break;
		}
		    else 
		    {
			//if didn't write his matric then he is not Student "No Discount"	
		    	student = false;
			
			System.out.println("Make sure you entered your right Matric No!");
			//Repeat the same function by calling itself again
			checkIfStudent();
		    }
		}
		
		//Case 2 Customer is not Student
		case 2:
		{
			//Calling the function that is responsible for Selecting/Adding meal for the Customer
	    	customer.selectFromMails();	
			break;
		}
		//	* Default case that will execute for sure 
		//	* if above cases does not match
		default:
			 System.out.println("ENTER 1 OR 2.");
			 
			//Repeat the same function by calling itself again
			 checkIfStudent();
		}
	    }
	    
	    
	    
	    
	    
	    
	    
	    // This Function to check the password input of the Stall Manager
	    public static void checkResturant() { 	
	    	System.out.println("\033[1;35m\033[1m\t\t\t\t*************************************\033[0m");
		    System.out.println("\033[1;35m\033[1m\t\t\t\t*         Tun Fatimah MENU          *\033[0m");
		    System.out.println("\033[1;35m\033[1m\t\t\t\t*Enter your Password:               *\033[0m");
		    System.out.println("\033[1;35m\033[1m\t\t\t\t*************************************\033[0m");
		    input.nextLine();
		    
		    //Scan/Take input of the Stall password if customer is student
		    String interpass = input.nextLine();
		    
		    //Check if the entered Password is right or not "If the pass equals to the actual right pass from the superclass Stall"
	    	if(interpass.equalsIgnoreCase(getPassword())) {
	    	
	    	//Calling the function that Shows Stall Management Menu page
	    	resturantMenuOptions(); 
	    	}
	    	//if Pass is wrong
	    	else {
		    	System.out.println("\033[1;35m\033[1m\t\t\t\t*************************************\033[0m");
			    System.out.println("\033[1;35m\033[1m\t\t\t\t*         Tun Fatimah MENU          *\033[0m");
			    System.out.println("\033[1;35m\033[1m\t\t\t\t*         Wrong Password            *\033[0m");
				//Repeat the same function by calling itself again
			    checkResturant();
	    	}
	    
	    }
	    
	    
		// This Function to Print all the already purchased customers name "if student then print Matric... If Not student then print Guest#NO."
	    public static void printGuest() {
	        System.out.println("\t\t\t\t+===================================+");
	        System.out.println("\t\t\t\t|         Tun Fatimah MENU          |");
	        System.out.println("\t\t\t\t|List of Already Purchased Customers|");
	        
	        //check if x less than the no of already purchased students
	        for(int x = 0; x<studentCount; x++) {
	          
	          //Print all Students Matric No.
	          System.out.println("\t\t\t\t|Student's Matric:"+ checkMatric[x] +"|");
	        }
	        
	        //check if x less than the no of already purchased Customers "Not Students"
	        for(int i = 0; i<numberOfGuest; i++) {
	        
	          //Print all Customers Guest Number.
	          System.out.println("\t\t\t\t|Customer No.: Guest #"+(i+1) +"|");
	        }
	        
	        System.out.println("\t\t\t\t+===================================+");  
	        }
	    
	    
	    
	    
	    
		//This function views the Stall Management Menu page
	    public static void resturantMenuOptions() {	
	    	System.out.println("Welcome "+"\u001B[1;31m Tun Fatimah Food Order System +\u001B[0m" +"! Let's Make Studyen/Customers Happy");
	    	System.out.println("\033[1;33m+===================================================+");
	    	System.out.println("\033[1;33m+         1. Add new Meal                           +");
	    	System.out.println("\033[1;33m+         2. Remove a Meal                          +");
	    	System.out.println("\033[1;33m+         3. Show All Meals                         +");
	    	System.out.println("\033[1;33m+         4. Edit Price                             +");
	    	System.out.println("\033[1;33m+         5. Edit Quantity                          +");
	    	System.out.println("\033[1;33m+         6. View all Customers & Student purchases +");
	    	System.out.println("\033[1;33m+         7. Change Password                        +");
	    	System.out.println("\033[1;33m+         8. Log Out                                +");
	    	System.out.println("\033[1;33m+===================================================+");
	    	
		    //Scan/Take input of the SelectMenu
		    int selectMenu = input.nextInt();
		    
	    	// Switch/Case for  Check if Customer is student or not page options
		    switch (selectMenu) {
		    
		    //Case 1 Add New Meal
			case 1:
			{
			    input.nextLine();
			    
				//Create object of Meals class + execute it's constructor
				Meal m = new Meal(); 
				
				//Calling the function that is responsible for adding new meals That accessed by Stall Management only
			    //use the Meal object as a variable for AddMealforResturants(>here<)
				meals.addMealsForResturants(m);
				
				System.out.println("added Successfully");
				
				//Repeat the same function by calling itself again
				resturantMenuOptions();
			    
			}
			//Case 2 Remove a Meal
			case 2: 
			{
				//Calling the function that is responsible for Removing the Meal from meals class
				meals.removeMeal();
				
				System.out.println("Removed Successfully");
				
				//Repeat the same function by calling itself again
				resturantMenuOptions();

			}
			//Case 3 Show all Meal	
			case 3:
			{
				//Calling the function that is responsible for Shows the Meal with it's details from meals class				
				meals.showMeals();
				
				//Repeat the same function by calling itself again				
				resturantMenuOptions();
			}
			
			//Case 4 Edit the Price
			case 4:
			{
				//Calling the function that is responsible for Editing meals prices from meals class
				meals.editPrice();
				
				System.out.println("Edited Successfully");
				
				//Repeat the same function by calling itself again
				resturantMenuOptions();

			}
			
			//Case 5 Edit new Quantity
			case 5:
			{
				//Calling the function that is responsible for editing the quantity of the meals from meals Class				
				meals.editMealQuantity();
				
				System.out.println("Edited Successfully");
				
				//Repeat the same function by calling itself again				
				resturantMenuOptions();
			}
			//Case 6 Print Already Purchased customers list
			case 6:
			{
				//Calling the function that is responsible for printing the customers list that already purchased			
				printGuest();
				
				//Repeat the same function by calling itself again
				resturantMenuOptions();
			}
			
			//Case 7 Change Stall Name
			case 7:
			{
				//Calling the function that is responsible for Changing Stall Name from the superclass Stall
				editPassword();
			}
			//Case 8 Logout and login again
			case 8:
			{
				//Calling the function that is responsible for returning back to the Login Page
				login();
			}
			
			//	* Default case that will execute for sure 
			//	* if above cases does not match	
			default:
				 System.out.println("ENTER BETWEEN 0 TO 5.\n");
				 
				//Repeat the same function by calling itself again
				 resturantMenuOptions();
			}
		}
	    

	    
	    
	    
	    // function that is responsible for the options menu of the Customers
	    public static void menu(){
		System.out.println("\033[1;33m*************************************");
	    System.out.println("\033[1;33m*         1. Add new Meal           *");
	    System.out.println("\033[1;33m*         2. Remove a Meal          *");
	    System.out.println("\033[1;33m*         3. Show All Meals         *");
	    System.out.println("\033[1;33m*         4. Edit Quantity          *");
	    System.out.println("\033[1;33m*         5. Check Payment          *");
	    System.out.println("\033[1;33m*         6. Log Out                *");
	    System.out.println("\033[1;33m*************************************");
	    
	    //Scan/Take input of the SelectMenu
        int selectMenu = input.nextInt();
        
    	// Switch/Case for  Customer Menu Option
	    switch (selectMenu) {
	    
	    //Case 1 Add New Meal 
		case 1: 
		{
			//Calling the function that is responsible for Selecting/Adding meal for the Customer from customer class
			customer.selectFromMails();	
			break;
		}
	    //Case 2 Remove a Meal
		case 2:
		{
			//calling the function that is responsible for the Removing meal from customer class
			customer.RemoveMeal();
			
			//Repeat the same function by calling itself again
			menu();
			break;
		}
		
	    //Case 3 Show Cart
		case 3:
		{
			//calling the function that is responsible for only showing all the selected/added meals "Customer Cart" from customer class
			customer.showCart();
			
			//Repeat the same function by calling itself again
			menu();
			break;
		}
	    //Case 4 Check Payment
		case 4:
		{
			//calling the function that is responsible for the editing meal by assigning the quantity of the meal to new value from customer class
			customer.editQuantity();
			
			//Repeat the same function by calling itself again
			menu();
			break;
		}
		
	    //Case 5 Log Out and login again
		case 5:
		{
			//calling the function that is responsible for Payment process from customer class
			customer.Payment();
			
			//Repeat the same function by calling itself again						
			menu();
			break;
		}
		
	    //Case 6 Reset Cart
		case 6:
		{
			//calling the function that delete every meal from the Customers cart from customer class
			customer.resetCart() ;
			
			//Calling the function that is responsible for returning back to the Login Page		
			login();
			break;
		}	
		
		//	* Default case that will execute for sure 
		//	* if above cases does not match	
		default:
			System.out.println("ENTER BETWEEN 0 TO 6.\n");
			
			//Repeat the same function by calling itself again						
			menu();
		}
	    }
	    
	    


	    public static void main (String[] args) {
	    	
	    	//This boolean assigned as true to cancel the meal class contractor...
	    	meals.checkMealsInput = true;
	    	
			//Create object of Meals class
		    Meal meal = new Meal();
		    
		    //calling the function that is responsible for creating the arrays of already existed meals 
	    	meals.alreadyAddedMeals(meal);
	    	
			//Calling the function that is responsible for the Login Page		    
	    	login();
	     } 
	    
	}

