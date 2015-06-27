package collectionsexamples;

import java.util.*;

public class CardGame {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Map<String, Player> players = new HashMap<String, Player>();
		CardDeck deck = new CardDeck();
		
		
		players.put("James", new Player("James"));
		players.put("Rick", new Player("Rick"));
		players.put("Matthew", new Player("Matthew"));
		players.put("Phil", new Player("Phil"));
		
		
		// give cards to 4 players
		deck.deal(4, players);
		
		// show everyones hand to ensure we arent cheating
		deck.revealHands();		
		deck.getPlayerHand("James");
				
	}

}
