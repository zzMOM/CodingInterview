package deckofcards;

import java.util.ArrayList;
import java.util.Random;

public class Deck<T extends Card> {
	private ArrayList<T> cards;
	private int dealtIndex = 0;//marks first undealt card
	
	public Deck(ArrayList<T> cards){
		this.cards = cards;
	}
	
	/*
     * Put all the used cards back into the deck,
     * and shuffle it into a random order.
     */
	public void shuffle(){
		Random rd = new Random();
		T tempCard;
		for(int i = 0; i < cards.size(); i++){
			int position = rd.nextInt(cards.size());
			tempCard = cards.get(i);
			cards.set(i, cards.get(position));
			cards.set(position, tempCard);
		}
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
		return cards.get(dealtIndex++);
	}
	
	public T[] dealHand(){
		return null;
	}
}
