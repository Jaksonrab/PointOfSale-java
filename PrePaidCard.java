
public class PrePaidCard {
/*  This program is the PrePaidCard class that creates methods concerning the pre-paid cards of PoS.
    Accessor and mutator methods handle attribute retrieval and modification with validation. 
    The toString method generates a formatted string representation, and the equals method checks for object equality. 
    This class encapsulates prepaid card functionality within a PoS system */
	
	//Instance variables 
    private String cardType;
    private String cardID;
    private int day_exp;
    private int month_exp;

    //Default constructor.
    public PrePaidCard() {
        cardType = "";
        cardID = "";
        day_exp = 0;
        month_exp = 0;
    }

    //Parameterized constructor.
    public PrePaidCard(String cardType, String cardID, int day_exp, int month_exp) {
        this.cardType = cardType;
        this.cardID = cardID;

        // Validate and set the expiry day
        if (day_exp >= 1 && day_exp <= 31)
            this.day_exp = day_exp;
        else
            this.day_exp = 0;

        // Validate and set the expiry month
        if (month_exp >= 1 && month_exp <= 12)
            this.month_exp = month_exp;
        else
            this.month_exp = 0;
    }

    //Copy constructor.
    public PrePaidCard(PrePaidCard anotherPrePaidCard) {
        this.cardType = anotherPrePaidCard.getCard();
        this.cardID = anotherPrePaidCard.getID();
        this.day_exp = anotherPrePaidCard.getDay();
        this.month_exp = anotherPrePaidCard.getMonth();
    }

    //Accessor methods.
    public String getCard() {
        return this.cardType;
    }

    public String getID() {
        return this.cardID;
    }

    public int getDay() {
        return this.day_exp;
    }

    public int getMonth() {
        return this.month_exp;
    }

    //Mutator methods.
    public void setDay(int num) {
        
    	// Validate and set the expiry day
        if (num >= 1 && num <= 31)
            this.day_exp = num;
        else
            this.day_exp = 0;
    }

    public void setMonth(int num) {
       // Validate and set the expiry month.
        if (num >= 1 && num <= 12)
            this.month_exp = num;
        else
            this.month_exp = 0;
    }

    //Method to generate a formatted string representation of the PrePaidCard.
    public String toString() {
        String formattedDay = String.format("%02d", this.day_exp);
        String formattedMonth = String.format("%02d", this.month_exp);
        return this.cardType + " - " + this.cardID + " - " + formattedDay + "/" + formattedMonth + ".";
    }

    //Method to check equality between two PrePaidCard objects.
    public boolean equals(PrePaidCard anotherPrePaidCard) {
        return this.cardType.equals(anotherPrePaidCard.getCard()) && this.cardID.equals(anotherPrePaidCard.getID()) &&
                this.day_exp == anotherPrePaidCard.getDay() && this.month_exp == anotherPrePaidCard.getMonth();
    }
}