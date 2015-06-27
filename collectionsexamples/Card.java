package collectionsexamples;




public class Card {
	
	public String value;
	public String suite;
	
	
	// simple card class
	public Card(String value, String suite){
		
		this.value = value;
		this.suite = suite;
		
	}
	
	public String cardValue() {
		return value + " of " + suite;
	}
}
