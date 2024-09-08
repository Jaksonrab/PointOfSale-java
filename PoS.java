
public class PoS{
/*This program is the PoS class which is methods that utilize PrePaidCards and Sales methods to create a Point of Sale system.
  There is a default constructor initializes PrePaidCards to a null array Sales to empty. The parameterized constructor stores values. 
  The methods handle various operations, such as comparing sales, checking individual sale equality, and manipulating prepaid cards, 
  adding sales for different meal categories, testing object equality, and generating string representations 
  of sales and prepaid cards.*/
	
	private Sales sales;
	PrePaidCard[] prePaidCard ;
	
	//Default constructor
	public PoS() {
		sales = new Sales();    //set the list of values as 0 or empty strings.
		prePaidCard = null;    //set the array of prepaid cards as containing no data
	} 
	
	//Parameterized constructor
	public PoS(Sales sales, PrePaidCard[] prePaidCard){
		this.sales = new Sales(sales);
		
		if (prePaidCard == null)
			this.prePaidCard = null;
		else 
			this.prePaidCard = (PrePaidCard[]) prePaidCard.clone(); 
		}
	
	//Method comparing total price of two objects.
	public boolean compareTotalSale(PoS anotherPoS) {
		return this.sales.salesTotal()== anotherPoS.sales.salesTotal();
	}
	
	//Method comparing strings for two objects to see if PoS is identical.
	public boolean compareIndividualSale(PoS anotherPoS) {
		String thisOrderString = this.sales.toString();
	    String anotherOrderString = anotherPoS.sales.toString();

	    // Compare the string representations for equality
	    return thisOrderString.equals(anotherOrderString);
	}
	
	//Method to get the total sales of the PoS
	public int totalSalePoS() {
		return this.sales.salesTotal();
	}
	
	//Method to get the total number of pre-paid cards.
	public int totalPrePaidCards() {
		
		if (this.prePaidCard == null)
			return 0;
		
		else 
			return this.prePaidCard.length;
	}
	
	//Method to add a pre-paid card and return the updated number of cards.
	public int addCard(PrePaidCard newCard) {
		if(this.prePaidCard == null) {
			this.prePaidCard = new PrePaidCard[]{newCard};
			
			return this.prePaidCard.length;}
		
		else {
			PrePaidCard[] anotherOne = new PrePaidCard[this.prePaidCard.length+1];
			
			for(int i =0; i< this.prePaidCard.length; i++)
				anotherOne[i]= this.prePaidCard[i];
			
			anotherOne[prePaidCard.length] = newCard;
			this.prePaidCard = anotherOne;
			
			return this.prePaidCard.length;}	
		}
	
	//Method to remove the last pre-paid card and return true or false if the process worked.
	public boolean removeCard(int cardIndex) {
	    if (this.prePaidCard != null && this.prePaidCard.length > 0 && cardIndex >= 0 && cardIndex < this.prePaidCard.length) {
	        PrePaidCard[] anotherOne = new PrePaidCard[this.prePaidCard.length - 1];

	        for (int i = 0; i < cardIndex; i++) {
	            anotherOne[i] = this.prePaidCard[i];
	        }

	        for (int i = cardIndex; i < this.prePaidCard.length - 1; i++) {
	            anotherOne[i] = this.prePaidCard[i + 1];
	        }

	        this.prePaidCard = anotherOne;
	        return true;
	    } else {
	        return false;
	    }
	}
	
	//Method to update the expiry date of a pre-paid card.
	 public void updateCardExpiryDate(int cardIndex, int newDay, int newMonth) {
	        if (prePaidCard != null && cardIndex >= 0 && cardIndex < prePaidCard.length) {
	            prePaidCard[cardIndex].setDay(newDay);
	            prePaidCard[cardIndex].setMonth(newMonth);
	        }
	    }
	 
	//Method to add sales of different meal categories to the PoS
	 public int addMeals(int junior, int teen, int medium, int big, int family) {
	        sales.addSales(junior, teen, medium, big, family);
	        return sales.salesTotal();
	 }
	
	 //Method to test if two PoS objects are equal
	 public boolean equals(PoS anotherPoS) {
		 if(this.prePaidCard != null && anotherPoS.prePaidCard!= null)
			 return this.sales.salesTotal() == anotherPoS.sales.salesTotal() && this.prePaidCard.length == anotherPoS.prePaidCard.length;
		 else 
			 return this.sales.salesTotal() == anotherPoS.sales.salesTotal();
		
	 }
	
	 //Method to generate a string displaying sales and pre-paid cards.
	 public String toString() {
		String output = this.sales.toString();
		 
		 if (this.prePaidCard != null && this.prePaidCard.length>0) {
			 for(int i =0; i< this.prePaidCard.length; i++)
				 output+= "\n" + this.prePaidCard[i].toString();}
		
		 else 
			 output+="\nNo pre-paid cards";
			
		 
		 return output;
	 }
	 
	// Method to generate a string displaying sales breakdown. 
	 public String breakdownSales() {
		 return this.sales.toString();
	 }
	 
}


