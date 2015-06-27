package collectionsexamples;

import java.util.*;

public class Player {

	public String name;
	public Set<Card> playerHand = new HashSet<Card>();
	
	
	public Player(String name){
		this.name = name;
	}
	
	// add the card to the players hand.
	public void takeCard(Card c){
		playerHand.add(c);
	}

	// show the cards in the players had
	public void showCards() {

		// loop through the Set and display value
		for(Card c : playerHand){
			System.out.println(c.cardValue());		
		}
	}
	
	
	
}
