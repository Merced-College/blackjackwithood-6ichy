/*
Jesus Coria
Richard Manzo
*/
public class Card {

    //data variables
    //fields from file
    private String suit;
    private int value;
    private String rank;
    private String picName;
    //put other 3 data variables here as private

    //default constructors 
    public Card() {
        this.suit = "heart";  // Default suit
        this.rank = "Ace";    // Default rank
        this.value = 11;      // Default value
        this.picName = "default.gif"; // Default image
    }

    public Card(String suit, String rank, int value, String picName) {
        this.suit = suit;
        this.value = value;
        this.rank = rank;
        this.picName = picName;
    }

    //**setters and getters**//
    //setters
    public void setSuit(String suit) { //sets suit of card
        this.suit = suit;
    }

    public void setValue(int value) {  //sets value of card
        this.value = value;
    }

    public void setRank(String rank) { //sets rank of card
        this.rank = rank;
    }

    public void setPicName(String picName){ //sets image filename of card
        this.picName = picName;
    }

    //getters
    public String getSuit () { //gets suit of card
        return suit;
    }

    public String getRank () { //gets rank of card
        return rank;
    }

    public int getValue () { //gets numeric value of card
        return value;
    }

    public String getPicName () { //gets image filename of card
        return picName;
    }

    //checks if two cards are equal based on their rank
    public boolean equals(Card other) {
        return rank.equals(other.rank);
    }

    //string method (4)
    public String toString() {
        return "Suit: " + suit + ", Rank: " + rank + ", Value: " + value + ", Image: " + picName;
    }

}