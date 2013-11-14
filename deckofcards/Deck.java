package deckofcards;

import java.util.ArrayList;

public class Deck<T extends Card> {
	private ArrayList<T> cards;
	private int dealtIndex = 0;//marks first undealt card
	
	public Deck(){}
	
	/*
     * Put all the used cards back into the deck,
     * and shuffle it into a random order.
     */
	public void shuffle(){
		
	}
	
	/*
     * As cards are dealt from the deck, the number of 
     * cards left decreases.  This function returns the 
     * number of cards that are still left in the deck.
     */
	public int cardsLeft(){
		return(cards.size() - dealtIndex);
	}
	
	/*
     * Deals one card from the deck and returns it.
     * @throws IllegalStateException if no more cards are left.
     */
	public T dealCard(){
		return null;
	}
	
	public T[] dealHand(){
		return null;
	}
}
