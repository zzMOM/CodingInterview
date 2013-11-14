package deckofcards;

import java.util.ArrayList;

public class Hand<T extends Card> {
	protected ArrayList<T> cards = new ArrayList<T>();
	
	public Hand(){}
	
	/*
     * Discard all cards from the hand, making the hand empty.
     */
    public void clear(){
    	
    }
    
    /*
     * Add the card c to the hand.  c should be non-null.
     * @throws NullPointerException if c is null.
     */
    public void addCard(T c){
    	cards.add(c);
    }
    
    /*
     * If the specified card is in the hand, it is removed.
     */
    public void removeCard(T c){
    	
    }

    /*
     * Remove the card in the specified position from the
     * hand.  Cards are numbered counting from zero.
     * @throws IllegalArgumentException if the specified 
     *    position does not exist in the hand.
     */
    public void removeCard(int position){
    	
    }

    /*
     * Return the number of cards in the hand.
     */
    public int getCardCount(){
    	return 0;
    }

    /*
     * Get the card from the hand in given position, where 
     * positions are numbered starting from 0.
     * @throws IllegalArgumentException if the specified 
     *    position does not exist in the hand.
     */
    public Card getCard(int position){
    	return null;
    }

    /*
     * Sorts the cards in the hand so that cards of the same 
     * suit are grouped together, and within a suit the cards 
     * are sorted by value.
     */
    public void sortBySuit(){
    	
    }

    /*
     * Sorts the cards in the hand so that cards are sorted into
     * order of increasing value.  Cards with the same value 
     * are sorted by suit. Note that aces are considered
     * to have the lowest value.
     */
    public void sortByValue(){
    	
    }

}
