package collectionsexamples;

import java.util.*;

public class CardDeck {

	public Map<String, Player> player = new HashMap<String,Player>();
	public List<Card> deck = new ArrayList<Card>(); 
	public Set<Card> shuffleDeck = new HashSet<Card>();

	// create a basic deck
	public CardDeck(){
		
		//create my decks
		List<String> values = new ArrayList<String>();
		values.add("2");
		values.add("3");
		values.add("4");
		values.add("5");
		values.add("6");
		values.add("7");
		values.add("8");
		values.add("9");
		values.add("10");
		values.add("Jack");
		values.add("Queen");
		values.add("King");
		values.add("Ace");
		List<String> suites = new ArrayList<String>();
		suites.add("Clubs");
		suites.add("Spades");
		suites.add("Diamonds");
		suites.add("Hearts");
		
		// loop through and create all my cards
		for(String val : values){
			for(String ste : suites){
				
				this.deck.add(new Card(val, ste));
				
			}	
		}
		
		// used to shuffle the deck
		Collections.shuffle((List<?>) deck);
		// no one shuffles only once
		Collections.shuffle((List<?>) deck);
		// to be thorough
		Collections.shuffle((List<?>) deck);
		shuffleDeck.addAll(deck);
	}

	// deal the items out to players
	public void deal(int players, Map<String, Player> pls){
		
		this.player = pls;
		// used to iterate through the set
		Iterator<Card> iter = shuffleDeck.iterator();
		
		// deal five cards each
		for(int x = 0; x < 5; x++){	
		
			for(Player p : this.player.values()){
				Card thisCrd = iter.next();
				p.takeCard(thisCrd);
				deck.remove(0);
			}
			
		}
	}
	
	// getter for cards
	public Set<?> getCards(){
		
		return shuffleDeck;
	}
	
	
	//display a players hand based on the key submitted 
	public void getPlayerHand(String name){
		
		Player curr = player.get(name);
		System.out.println("----- display cards for only " + name + " ----");
		curr.showCards();
	}

	public void revealHands() {
		
		for(Player p : player.values()){
			System.out.println("---- " + p.name + " ----");
			p.showCards();
				
		}
		// demonstrate that my remove function is working correctly
		System.out.println("Cards left in the deck: " + deck.size());
		
	}

	
}
