
public class Sales {
	/*This program is the Sales class model that creates methods concerning the sale aspect of the PoS.
	  There's methods for sales order, tracking quantities for different items, calculating total costs.
	  There's also some for order modification, access, and representation. The default constructor initializes
	  order amounts to zero, and there are parameterized and copy constructors for creating instances with specific values.*/
    
	//Constants for item costs
    static final int JUNIOR_COST = 5;
    static final int TEEN_COST = 10;
    static final int MEDIUM_COST = 12;
    static final int BIG_COST = 15;
    static final int FAMILY_COST = 20;

    //Instance variables for order amounts
    private int junior_amount;
    private int teen_amount;
    private int medium_amount;
    private int big_amount;
    private int family_amount;

    //Default constructor initializes order amounts to zero
    public Sales() {
        junior_amount = 0;
        teen_amount = 0;
        medium_amount = 0;
        big_amount = 0;
        family_amount = 0;
    }

    //Parameterized constructor to set order amounts
    public Sales(int junior_amount, int teen_amount, int medium_amount, int big_amount, int family_amount) {
        this.junior_amount = junior_amount;
        this.teen_amount = teen_amount;
        this.medium_amount = medium_amount;
        this.big_amount = big_amount;
        this.family_amount = family_amount;
    }

    //Copy constructor to create a Sales object identical to another
    public Sales(Sales anotherSale) {
        this.junior_amount = anotherSale.getJuniorAmount();
        this.teen_amount = anotherSale.getTeenAmount();
        this.medium_amount = anotherSale.getMediumAmount();
        this.big_amount = anotherSale.getBigAmount();
        this.family_amount = anotherSale.getFamilyAmount();
    }

    //Accessor methods for order amounts
    public int getJuniorAmount() {
        return this.junior_amount;
    }

    public int getTeenAmount() {
        return this.teen_amount;
    }

    public int getMediumAmount() {
        return this.medium_amount;
    }

    public int getBigAmount() {
        return this.big_amount;
    }

    public int getFamilyAmount() {
        return this.family_amount;
    }

    //Modifier methods for order amounts
    public void setJuniorAmount(int num) {
        this.junior_amount = num;
    }

    public void setTeenAmount(int num) {
        this.teen_amount = num;
    }

    public void setMediumAmount(int num) {
        this.medium_amount = num;
    }

    public void setBigAmount(int num) {
        this.big_amount = num;
    }

    public void setFamilyAmount(int num) {
        this.family_amount = num;
    }

    //Method to add more orders
    public void addSales(int more_junior, int more_teen, int more_medium, int more_big, int more_family) {
        this.junior_amount += more_junior;
        this.teen_amount += more_teen;
        this.medium_amount += more_medium;
        this.big_amount += more_big;
        this.family_amount += more_family;
    }

    //Method to calculate the total cost of the order
    public int salesTotal() {
        return (JUNIOR_COST * this.junior_amount + TEEN_COST * this.teen_amount + MEDIUM_COST * this.medium_amount + BIG_COST * this.big_amount + FAMILY_COST * this.family_amount);
    }

    //Method to generate a string representation of the order
    public String toString() {
        return ("Junior(s):" + this.junior_amount + " + Teen(s):" + this.teen_amount + " + Medium(s):" + this.medium_amount + " + Big(s):" + this.big_amount + " + Family(s):" + this.family_amount);
    }

    //Method to check if two orders are identical
    public boolean equals(Sales anotherSale2) {
        return this.junior_amount == anotherSale2.getJuniorAmount() && this.teen_amount == anotherSale2.getTeenAmount() &&
                this.medium_amount == anotherSale2.getMediumAmount() && this.big_amount == anotherSale2.getBigAmount() &&
                this.family_amount == anotherSale2.getFamilyAmount();
    }
}