package deckofcards;

import java.util.ArrayList;

public class ADeckOfCards {
	protected ArrayList<Card> deckCards = new ArrayList<Card>();
	private Card c;
	
	public ADeckOfCards(){}
	
	public ArrayList<Card> getADeckOfCards(){
		c = null;
		for(Suit s : Suit.values()){
			if(s.getValue() != 4){
				for(int i = 1; i <= 13; i++){
					c.faceValue = i;
					c.suit = s;
					deckCards.add(c);
				}
			}
		}
		c.faceValue = 0; //little Joker
		c.suit = Suit.Joker;
		deckCards.add(c);
		c.faceValue = 1; //big Joker
		c.suit = Suit.Joker;
		deckCards.add(c);
		
		return deckCards;
	}
}
