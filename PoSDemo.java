

import java.util.Scanner;

public class PoSDemo {
	
	/*This program simulates the CostLessBites catering coming to Concordia campuses to serve Concordia community.
	The user can order meals using either their money or prepaid meal cards using the Sales class,
	PrePaiCard class, PoS class. The user has an option of five meal categories with different six different diets.
	The yearly prepaid cards sold by type of diet. The user also is displayed a prompt which allows them to modify orders,
	modify prepaid cards, view other others, exit the program, and various more. Each selection is performed by static method.*/
	
	static PoS[] posArray;
	static Scanner keyboard; 
	
	//Method to add meal to a PoS
	public static void addMealSale(PoS pos, int junior, int teen, int medium, int big, int family) {
		pos.addMeals(junior, teen, medium, big, family);
	}
	
	//Method to add pre-paid card to PoS
	public static void addPrePaidCard(PoS pos, String cardType, String cardID, int dayExp, int monthExp) {
		//Proper card type is inputed
			pos.addCard(new PrePaidCard(cardType, cardID, dayExp, monthExp));
	}
	
	//Method to test if the PoS selected is in a valid index of the posArray.
	public static int posValidity(PoS[] posArray, Scanner keyboard) {
	   
		int posChoice;

	    do {
	        System.out.print("(Enter number from 0 to " + (posArray.length - 1) + "): ");
	        posChoice = keyboard.nextInt();
	        
	        if (posChoice < 0 || posChoice >= posArray.length) {
	            System.out.print("Sorry but there is no PoS number " + posChoice + "\n--> Try Again: ");
	        }
	    } while (posChoice < 0 || posChoice >= posArray.length);
	    return posChoice;}
	
	
	//Method to test if the card selected is valid index of the PrePaidCard array
	public static int cardValidity(PoS[] posArray, int posChoice, Scanner keyboard) {
	   
		int cardChoice;
	    
	    do {
	        System.out.print("(Enter number 0 to " + (posArray[posChoice].prePaidCard.length - 1) + "): ");
	        cardChoice = keyboard.nextInt();

	        if (cardChoice >= posArray[posChoice].prePaidCard.length || cardChoice < 0) {
	            System.out.print("--> Invalid choice. Try Again: ");
	        }
	    } while (cardChoice >= posArray[posChoice].prePaidCard.length || cardChoice < 0);
	    return cardChoice;
	}
	
	
	//Method for case 1
	 public static void displayAllPosContent(PoS[] posArray) {
	        System.out.println("Content of each PoS:\n---------------------");

	        // Printing out each index of the posArray
	        for (int i = 0; i < posArray.length; i++) 
	            System.out.println("PoS#" + i + ":\n" + posArray[i].toString() + "\n");
	            }
	
	 
	 //Method for case 2
	 public static void displaySinglePosContent(PoS[] posArray, Scanner keyboard) {
	        System.out.print("Which PoS do you want to see content of? ");
	       
	        // Using posValidity to get a valid PoS choice
	        int chosenPos = posValidity(posArray, keyboard);

	        System.out.println("\n" + posArray[chosenPos].toString() + "\n");
	    }

	 
	 //Method for case 3
	 public static void listPosWithSameTotalSales(PoS[] posArray) {
	        System.out.println("List of PoSs with same total $ Sales:\n");

	        //Nested loops to compare total sales between PoS pairs and to avoid repetition
	        for (int i = 0; i < posArray.length; i++) {
	            for (int j = i + 1; j < posArray.length; j++) {

	                //If equal, display a message indicating the PoS numbers and their shared total sales
	                if (posArray[i].totalSalePoS() == posArray[j].totalSalePoS())
	                    System.out.println("PoSs " + i + " and " + j + " have the same total sales: $" + posArray[i].totalSalePoS());
	                }}}
   
	 //Method for case 4
	 public static void listPosWithSameSalesCategories(PoS[] posArray) {
		    System.out.println("List of PoSs with same Sales categories:\n");

		    //Nested loops to compare sale numbers between PoS pairs and avoid repetition
		    for (int i = 0; i < posArray.length; i++) {
		        for (int j = i + 1; j < posArray.length; j++) {

		            //If equal, display a message indicating the PoS numbers
		            if (posArray[i].breakdownSales().equals(posArray[j].breakdownSales()))
		                System.out.println("PoSs " + i + " and " + j + " have: " + posArray[i].breakdownSales());
		        }}}
	 
	 //Method for case 5
	 public static void listPosWithSameSalesAndCards(PoS[] posArray) {
		    System.out.println("List of PoSs with the same $ amount of sales and same number of PrePaidCards:\n");

		    //Nested loops to compare PoS instances for equality based on total sales and pre-paid cards to avoid repetition
		    for (int i = 0; i < posArray.length; i++) {
		        for (int j = i + 1; j < posArray.length; j++) {

		            //If equal, display a message indicating the PoS numbers
		            if (posArray[i].equals(posArray[j]))
		                System.out.println("PoSs " + i + " and " + j);
		        }}}
	 
	 //Method for case 6
	 public static void addPrePaidCardToPos(PoS[] posArray, Scanner keyboard) {
		    System.out.print("Which PoS do you want to add a PrePaidCard to:");

		    //Using posValidity to get a valid PoS choice
		    int chosenPos6 = posValidity(posArray, keyboard);

		    if (chosenPos6 >= 0 && chosenPos6 < posArray.length) {
		    	System.out.println("Please enter the following information so that we can complete the PrePaidCard-");
		       
		    	//Enter meal category for the new pre-paid card
		        System.out.print("--> Type of PrePaidCard (Carnivore, Halal, Kosher, Pescatarian, Vegetarian, Vegan): ");
		        String mealForCard = keyboard.next();

		        //While loop that determines if the proper meal category is entered
		        while (!mealForCard.equals("Vegan") && !mealForCard.equals("Vegetarian") && !mealForCard.equals("Pescatarian")
		                && !mealForCard.equals("Kosher") && !mealForCard.equals("Halal") && !mealForCard.equals("Carnivore")) {

		            System.out.println("Try again. Enter a valid meal category: ");
		            mealForCard = keyboard.next();
		        }

		        //Enter ID for the new pre-paid card
		        System.out.print("--> Id of the prepaid card owner: ");
		        String idForCard = keyboard.next();

		        //Enter day and month for the new pre-paid card
		        System.out.print("--> Expiry day number and month (separated by a space): ");
		        int dayForCard = keyboard.nextInt();
		        int monthForCard = keyboard.nextInt();

		        //Creating a new PrePaidCard object using the addPrePaidCard method
		        addPrePaidCard(posArray[chosenPos6], mealForCard, idForCard, dayForCard, monthForCard);

		        System.out.println("You now have " + posArray[chosenPos6].prePaidCard.length + " PrePaidCard(s)");
		    } else {
		        System.out.println("Invalid PoS choice. Cannot add PrePaidCard.");
		    }}
	 
	//Method for case 7
	 public static void removePrePaidCardFromPos(PoS[] posArray, Scanner keyboard) {
		    System.out.print("Which PoS do you want to remove a PrePaidCard from? ");

		    //Use the method to validate the PoS choice
		    int chosenPos7 = posValidity(posArray, keyboard);

		    //If there are no pre-paid cards in that PoS, display a prompt
		    if (posArray[chosenPos7].prePaidCard == null || posArray[chosenPos7].prePaidCard.length == 0) {
		        System.out.println("There is no PrePaidCard to remove in PoS #" + chosenPos7);

		    } else {

		        System.out.print("Which PrePaidCard do you want to remove? ");

		        //Use the method to validate the card choice
		        int cardChoice = cardValidity(posArray, chosenPos7, keyboard);

		        //Display out put if card removed successfully
		        if (posArray[chosenPos7].removeCard(cardChoice)) {
		            System.out.println("PrePaidCard was successfully removed");
		        }}}

	
	 //Method for case 8
	 public static void updatePrePaidCardExpiry(PoS[] posArray, Scanner keyboard) {
		    System.out.print("Which PoS do you want to update a PrePaidCard expiry date? ");

		    // Use the method to validate the PoS choice
		    int chosenPos8 = posValidity(posArray, keyboard);

		    // If there are no pre-paid cards in that PoS, display a message
		    if (posArray[chosenPos8].prePaidCard == null || posArray[chosenPos8].prePaidCard.length == 0) {
		        System.out.println("There is no PrePaidCard to update in PoS #" + chosenPos8);

		    } else {

		        System.out.print("Which PrePaidCard do you want to update? ");

		        // Use the method to validate the card choice
		        int cardChoice = cardValidity(posArray, chosenPos8, keyboard);
 
	    	        if (posArray[chosenPos8].removeCard(cardChoice)) {
	    	            System.out.println("Expiry date updated");
	    	        }}}
	 
	 //Method for case 9
	 public static void addSalesToPoS(PoS[] posArray, Scanner keyboard) {
		    System.out.print("Which PoS do you want to add sales to? ");

		    int chosenPos9 = posValidity(posArray, keyboard);

		    int junior, teen, medium, big, family;

		    // Entering new meal amounts to PoS
		    System.out.print("How many junior, teen, medium, big, and family meals do you want to add?\nEnter 5 numbers separated by a space: ");
		    junior = keyboard.nextInt();
		    teen = keyboard.nextInt();
		    medium = keyboard.nextInt();
		    big = keyboard.nextInt();
		    family = keyboard.nextInt();

		    // Adding meals to a PoS and displaying output for totalSale
		    addMealSale(posArray[chosenPos9], junior, teen, medium, big, family);
		    System.out.println("You now have " + posArray[chosenPos9].totalSalePoS() + "$");
		}
	 
	 public static void main(String[] args) {
    	
    	Scanner keyboard = new Scanner(System.in); 
    	
    	
    	//welcome/prompt message displayed
    	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
    	"| Welcome to Concordia CostLessBites Catering Sales Counter Application?       |\n" +
    	"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"	);
    	
    	//String for order options
    	String options = ""
    			+ "| What would you like to do?                                                   |\n"
		 		+ "| 1 >> See the content of all PoSs                                             |\n"
		 		+ "| 2 >> See the content of one PoS                                              |\n"
		 		+ "| 3 >> List PoSs with same $ amount of sales                                   |\n"
		 		+ "| 4 >> List PoS with same number of Sales categories                           |\n"
		 		+ "| 5 >> List PoSs with same $ amount of Sales and same number of Prepaid cards  |\n"
		 		+ "| 6 >> Add a Prepaid card to an existing PoS                                   |\n"
		 		+ "| 7 >> Remove an existing Prepaid card from a PoS                              |\n"
		 		+ "| 8 >> Update the expiry date of an existing Prepaid card                      |\n"
		 		+ "| 9 >> Add sales to a PoS                                                      |\n"
		 		+ "| 0 >> To quit                                                                 |\n"
		 		+ "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"; 
    	
    	//empty array of pos objects. Typically will be null to start but 5 to show how code works.
    	PoS pos0 = new PoS();
    	PoS pos1 = new PoS();
    	PoS pos2 = new PoS();
    	PoS pos3 = new PoS();
    	PoS pos4 = new PoS();
 	
    	posArray = new PoS[5];
    	
    	//storing each PoS as an index of an array
    	posArray[0] = pos0;
    	posArray[1] = pos1;
    	posArray[2] = pos2;
    	posArray[3] = pos3;
    	posArray[4] = pos4;
    	
    	
    	//this section wouldn't be hard-coded but user inputs.
    	
    	//2 pos with identical sales categories and same number of pre-paid cards
    	addMealSale(pos0, 2, 1, 0, 4, 1);
    	addPrePaidCard(pos0, "Vegetarian", "40825164", 25, 12);
    	addPrePaidCard(pos0, "Carnivore", "21703195", 3,12);
    	
    	addMealSale(pos1, 2,1,0,4,1);
    	addPrePaidCard(pos1, "Vegan", "40825164",7,12);
    	addPrePaidCard(pos1,"Vegetarian", "21596387",24,8);
    	
    	/*1 PoS w1 PoS with the same total $ amount of sales of another
    	PoS but with a different configuration of sales categories and this PoS should have at least 3 prepaid cards*/
    	addMealSale(pos2, 0, 1, 5, 2, 0);
    	addPrePaidCard(pos2,"Pescatarian", "95432806",1,6);
    	addPrePaidCard(pos2,"Halal", "42087913", 18, 12);
    	addPrePaidCard(pos2,"Kosher", "40735421", 5, 4);
    	
    	//The last 2 PoSs have the same breakdown of sales but different from the other 3 and both have no prepaid cards
    	addMealSale(pos3, 3, 2, 3, 1, 2);
    	addMealSale(pos4, 3, 2, 3, 1, 2);
    	
    	
    	//making selection
    	int choice;
    	
    	//Do loop that repeats the ability access/edit PoSs until user chooses option 0 (exit case).
    	do {
             System.out.println("\n"+ options);
             System.out.print("Please enter your choice and press <Enter>: ");
             choice = keyboard.nextInt();
    	
             //switch statement depending on user choice
             switch (choice) {
    	 
    	//See the content of all PoS
    	case 1:
    		displayAllPosContent(posArray);      
    		break;
    	
    	
    	//See the content of one PoS
    	case 2:
    		displaySinglePosContent(posArray,keyboard);
    	    break;
    
    	//List of PoSs with same $ amount of sales. 
    	case 3:
    		listPosWithSameTotalSales(posArray);
    	    break;
    		
    	
    	 //List of PoSs with same number of Sales categories.	
    	case 4:
    		listPosWithSameSalesCategories(posArray);
     	    break;
    		
    	
     	//List of PoSs with same $ amount of sales and same number of pre-paid cards.
    	case 5:
    		listPosWithSameSalesAndCards(posArray);
    		break;
    	
    	
    	//Add PrePaidCard to an existing Pos.
    	case 6:
    		addPrePaidCardToPos(posArray,keyboard);
    	    break;    	
    	
    	case 7:
    		removePrePaidCardFromPos(posArray,keyboard);
    	    break;
    	
    	//Update the expiry date of an existing pre-paid card.
    	case 8:
    		
    		updatePrePaidCardExpiry(posArray, keyboard);
    	    break;
    	
    	//Adding sales to a PoS.
    	case 9:
    		addSalesToPoS(posArray, keyboard);
    		break;
    	
    	case 0:
    		System.out.println("Thank you for using Concordia CostLessBites Catering Sales Counter Application!");
    		break;
    	
    	//If any other input, display error message. 
    	default: 
    		System.out.println("Sorry that is not a valid choice. Try again.");
    	 }
    	}
    	while(choice !=0); //loop ends when case 0.
    	
keyboard.close();

}}