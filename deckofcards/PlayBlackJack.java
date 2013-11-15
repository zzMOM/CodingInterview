package deckofcards;

import java.util.ArrayList;

public class PlayBlackJack {
	protected ArrayList<BlackJackCard> fullCards = new ArrayList<BlackJackCard>();
	protected BlackJackHand dealer = new BlackJackHand();
	protected BlackJackHand player1 = new BlackJackHand();
			
	
	public PlayBlackJack(){}
	
	public void play(){
		//Black Jack, uses four decks of card, exclude Joker.
		ADeckOfCards dc = new ADeckOfCards();
		for(int i = 0; i < 4; i++){
			for(Card c : dc.getADeckOfCards()){
				if(!c.suit.equals(Suit.Joker)){
					fullCards.add((BlackJackCard)c);
				}
			}
		}
		//create Deck 
		Deck deck = new Deck(fullCards);
		deck.shuffle();//shuffle fullCards
		
		//start
		//while(deck.cardsLeft() >= 10){
			//deal card
			dealer.addCard((BlackJackCard) deck.dealCard());
			player1.addCard((BlackJackCard) deck.dealCard());
			dealer.addCard((BlackJackCard) deck.dealCard());
			player1.addCard((BlackJackCard) deck.dealCard());
			
			dealer.score();
			player1.score();
			if(dealer.score() > player1.score()){
				System.out.println("dealer win");
			} else {
				System.out.println("player1 win");
			}
		//}
	}
}
