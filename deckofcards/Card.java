package deckofcards;

public abstract class Card {
	protected int faceValue;
	protected Suit suit;
	
	public Card(int faceValue, Suit suit){
		this.faceValue = faceValue;
		this.suit = suit;
	}
	
	public int getFaceValue(){
		return faceValue;
	}
	
	public Suit getSuit(){
		return suit;
	}
	
	public abstract int value();
}
