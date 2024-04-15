package FoodOrderingSystem;

//import the scanner from java library
import java.util.Scanner;


//Create an Meals Class 
public class Meals {

	//Class data Members:
		public static int count = 0;
		public static int countA = 5;		
		public static boolean checkMealsInput = false;
		
		
		//Create object of Meals class
		static Meal[] meal = new Meal[100];
		
		
	    // Creating object of Scanner class
		static Scanner inputScanner = new Scanner(System.in);

		
		
		//This function to list the alreadyAddedMeals menu
		public void alreadyAddedMeals(Meal r) {
			
			// looping to get  the data for the meal 
	        for (int i = 0; i<countA; i++) {
	            meal[i]= r;
	        }
			// set all  the data to the already Meals 
	        int i = 0;
	        meal[i].quantityA[i] = 40;
	        meal[i].PriceA[i] = 10;
	        meal[i].nameA[i] = "Nasi Goreng	  ";
	        
	        i = 1;
	        meal[i].quantityA[i] = 50;
	        meal[i].PriceA[i] = 23;
	        meal[i].nameA[i] = "Nasi Lemak Ayam";
	        
	        i=2;
	        meal[i].quantityA[i] = 90;
	        meal[i].PriceA[i] = 34;
	        meal[i].nameA[i] = "Pizza	 ";
	        
	        i=3;
	        meal[i].quantityA[i] = 456;
	        meal[i].PriceA[i] = 134;
	        meal[i].nameA[i] = "Burger chicken ";

	        i=4;
	        meal[i].quantityA[i] = 46;
	        meal[i].PriceA[i] = 57;
	        meal[i].nameA[i] = "Burger beef	";

	        //This boolean assigned as false to go directly to the meal class contractor...
	        checkMealsInput = false;

		}
		
		
		//This function to show all meals to the customer without quantity which already added and what the stall will add after 
		public static void showMealsCustomers() {
		    System.out.println("+===================================+");
	        System.out.println("|Meal Name\t\t\t\tPrice     |");
	        
			//This looping to show all meals to the customer which already added  
			for(int i = 0; i<countA; i++) {
				
			System.out.println("|"+(i+1)+". "+meal[i].nameA[i] + "\t\t\t" + meal[i].PriceA[i]);

			}
			
			//This looping  to show all meals to the customer which the stall add later 
			for(int i = 0; i<count; i++) {
				System.out.println("|"+(i+1+countA)+". "+meal[i].mealNameString[i] + "\t\t\t\t" + meal[i].Price[i]);
			}
		    System.out.println("+===================================+");

		}
		
		
		
		
		//This function to show all meals to the stall with quantity which already added and what the stall add after 
		public static void showMeals() {
		    System.out.println("+=====================================================================+");
	        System.out.println("|Meal Name\t\t\tPrice\t\tQuantity     |");
	        
			
			//This looping to show all meals to the stall which already added  
	        for(int i = 0; i<countA; i++) {
				System.out.println("|"+(i+1)+". "+meal[i].nameA[i] + "\t\t" + meal[i].PriceA[i] + "\t\t" + meal[i].quantityA[i]);

			}
	        
			//This looping to show all meals to the stall which will be added by the library added  
			for(int i = 0; i<count; i++) {
			System.out.println("|"+(i+1+countA)+". "+meal[i].mealNameString[i] + "\t\t\t" + meal[i].Price[i] + "\t\t" + meal[i].quantity[i]);
			}
		    System.out.println("+======================================================================+");

		}
		
		


		//This function to compare the meal if there is the same name or not 
		//so this function reject any meal it has already the same name before
		public int compareResturantMeals(Meal r1, Meal r2)
	    {
	 
	        for (int i = 0; i < count; i++) {
	        	// If book name matches
	        
	        if (r1.mealNameString[count].equalsIgnoreCase(r2.mealNameString[i])) {
 
	            // Printing book exists
	            System.out.println("Meal of this Name Already Exists.");
	            return 0;
	        }
	        
	        
	        }
        return 1;
	    }
		
		

		//This function to add Meals for Stall 
		public void addMealsForResturants(Meal r)
	    {
	 
	        for (int i = 0; i < count; i++) {
	 
	            if (this.compareResturantMeals(r, this.meal[i])== 0)
	                return;
	        }
	 
	        if (count < 100) {
	            meal[count] = r;
	            count++;
	        }
	        else {
	 
	            System.out.println("you reached maximum meals inputs");
	        }

	    }


		
		
		
		//This function to remove Meals from the Stall 
		public static void removeMeal() {
	    	//This boolean assigned as true to cancel the meal class contractor...
			checkMealsInput = true;
	    	
			//Create object of Meal class 
	    	Meal meal2 = new Meal();
	    	System.out.println("\u001B[36m************************************\u001B[0m");
	    	System.out.println("\u001B[36m|Choose one to delete:             *\u001B[0m");
	    	System.out.println("\u001B[36m************************************\u001B[0m");
	    	System.out.println();
	    	
	    	
	        //call showMeals to show all meals 
	    	showMeals();
		    int x = inputScanner.nextInt();
		    
		    
		    // if statement in side it linked list to delete the mails added late   

		    if(x > countA && x <= (countA+count)) {
		    	x-=countA;
		    	//linked list looping to delete the meal name  
			    for(int i = x; i< count; i++){
			    	meal2.mealNameString[i-1] = meal2.mealNameString[i];

			      }
			    
		    	//linked list looping to delete the Price of the meal  
			    for(int i = x; i < count -1; i++){
			    	meal2.Price[i-1] = meal2.Price[i];

			      }	
			    
		    	//linked list looping to delete the quantity of the meal  
			    for(int i = x; i < count -1; i++){
			    	meal2.quantity[i-1] = meal2.quantity[i];

			      }     
			    // decease the count to delete the meal 
		    count-=1;
		    }
		    
		    // else if statement if select any choose is not from the list    
		    else if(x > (countA+count)){
			    System.out.println("|Please select Sutable No from the list|");

			    //return to the removeMeal function 
			    removeMeal();
			}
		    
		    // else statement in side it linked list to delete the mails added late   
		    else {
		    	//linked list looping to delete the meal name  
			    for(int i = x; i< meal2.nameA.length -1; i++){
			    	meal2.nameA[i-1] = meal2.nameA[i];

			      }
		    	//linked list looping to delete the Price of the meal  
			    for(int i = x; i < meal2.PriceA.length -1; i++){
			    	meal2.PriceA[i-1] = meal2.PriceA[i];

			      }
		    	//linked list looping to delete the quantity of the meal  
			    for(int i = x; i < meal2.quantityA.length -1; i++){
			    	meal2.quantityA[i-1] = meal2.quantityA[i];

			      }
			    // decease the count to delete the meal 
			    countA-=1;

			      }
	    	// after finish the deleting the meal return back the  boolean to set the meal class contractor...
		    checkMealsInput = false;

			}
		
		
		
		
		//This function to editPrice for Meals  
		public static void editPrice() {
	    	System.out.println();
			System.out.println("\u001B[36m\t\t\t\t************************************\u001B[0m");
	    	System.out.println("\u001B[36m\t\t\t\t* Choose one to edit  :            *\u001B[0m");
	    	System.out.println("\u001B[36m\t\t\t\t************************************\u001B[0m");
	        
	        //call showMeals to show all meals 
	    	showMeals();
	        
		    int x = inputScanner.nextInt();
		    
		    
	    	System.out.println("\u001B[36m\t\t\t\t************************************\u001B[0m");
	    	System.out.println("\u001B[36m\t\t\t\t*         Tun Fatimah MENU         *\u001B[0m");
	    	System.out.println("\u001B[36m\t\t\t\t* Set Price:                       *\u001B[0m");
	    	System.out.println("\u001B[36m\t\t\t\t************************************\u001B[0m");
		    double newprice = inputScanner.nextDouble();
		    
		    //if statement to renew the price which  added later
		    if(x > countA) {
		    		x-=countA;
		    meal[x-1].Price[x-1] = newprice;
		    }
		    
		    //else statement to renew the price which already added 
		    else {
			    meal[x-1].PriceA[x-1] = newprice;
			}
		}
		
		
		
		//This function to editQuantity for Meals  
		public static void editMealQuantity() {
	    	System.out.println("\u001B[36m\t\t\t\t************************************\u001B[0m");
	    	System.out.println("\u001B[36m\t\t\t\t* Choose one to edit               *\u001B[0m");
	    	
	        //call showMeals to show all meals 
	    	showMeals();
	        int x = inputScanner.nextInt();
		    
	    	System.out.println("\u001B[36m\t\t\t\t************************************\u001B[0m");
	    	System.out.println("\u001B[36m\t\t\t\t         Tun Fatimah MENU          *\u001B[0m");
	    	System.out.println("\u001B[36m\t\t\t\t* Set Quantity:                    *\u001B[0m");
	    	System.out.println("\u001B[36m\t\t\t\t************************************\u001B[0m");
		    int newQuantity = inputScanner.nextInt();
		    
		    //if statement to renew the quantity which  added later
		    if(x > countA) {
		    	x-=countA;
		    meal[x-1].quantity[x-1] = newQuantity;
		    }
		    
		    //if statement to renew the quantity which already added 
		    else {
			    meal[x-1].quantityA[x-1] = newQuantity;
			}
		}
		
		
		
	}


