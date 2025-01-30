import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {

	//Makes list of all cards in deck
	private static ArrayList<Card> deckOfCards = new ArrayList<Card>();
	
	//list stores player's cards
	private static ArrayList<Card> playerCards = new ArrayList<Card>();


	public static void main(String[] args) {

		Scanner input = null;
		
		//attempts to open card.txt file
		try {
			input = new Scanner(new File("cards.txt"));
		} catch (FileNotFoundException e) {
			// prints "error" if the file is not found
			System.out.println("error");
			e.printStackTrace();
		}

		//while loop fills in the list of cards in deck using file
		while(input.hasNext()) {
			String[] fields  = input.nextLine().split(",");
			//	public Card(String cardSuit, String cardName, int cardValue, String cardPicture) {
			Card newCard = new Card(fields[0], fields[1].trim(),
					Integer.parseInt(fields[2].trim()), fields[3]);
			deckOfCards.add(newCard);	
		}

		shuffle();

		//for(Card c: deckOfCards)
			//System.out.println(c);

		//deal the player 5 cards
		for(int i = 0; i < 4; i++) {
			playerCards.add(deckOfCards.remove(i));
		}
		
		//Prints player's cards
		System.out.println("players cards");
		for(Card c: playerCards)
			System.out.println(c);

		//Checks for 2 of kind and prints 
		System.out.println("pairs is: " + checkFor2Kind());

		//Checks for 3 of kind and prints 
		System.out.println("3 of a kind is: " + checkFor3Kind());

		//Prints goodbye message
		System.out.println("Thanks for playing!");


	}//end main

	public static void shuffle() {

		//shuffling the cards by deleting and reinserting
		for (int i = 0; i < deckOfCards.size(); i++) {
			int index = (int) (Math.random()*deckOfCards.size());
			Card c = deckOfCards.remove(index);
			//System.out.println("c is " + c + ", index is " + index);
			deckOfCards.add(c);
		}
	}

	//check for pair in the players hand
	//check for 2 of a kind
	public static boolean checkFor2Kind() {
		
		//initializes matches to one
		int count = 1;
		//reads through and compares cards in hand
		for (int i = 0; i < playerCards.size(); i++) {
			for (int j = i + 1; j < playerCards.size(); j++) {
				if (playerCards.get(i).getRank().equals(playerCards.get(j).getRank())) {
					count++; //if there is a match in hand counts is incremented
				}
				//if 2 matches are found, 2 of a kind is true
				if (count == 2) {
					return true; 
				}
			}
		}
		return false; //No 2 of a kind was found
	}
	
	//check for 3 of a kind
	public static boolean checkFor3Kind() {
		
		//initializes matches to one
		int count = 1;
		//reads through and compares cards in hand
		for (int i = 0; i < playerCards.size(); i++) {
			for (int j = i + 1; j < playerCards.size(); j++) {
				if (playerCards.get(i).getRank().equals(playerCards.get(j).getRank())) {
					count++; //if there is a match in hand counts is incremented
				}
				//if 3 matches are found, 3 of a kind is true
				if (count == 3) {
					return true; 
				}
			}
		}
		return false; //No 3 of a kind was found
	}
}//end class
