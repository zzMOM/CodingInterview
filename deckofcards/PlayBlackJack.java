package deckofcards;

import java.util.ArrayList;

public class PlayBlackJack {
	protected ArrayList<BlackJackCard> fullCards;
	protected BlackJackHand dealer = new BlackJackHand();
	protected BlackJackHand player1 = new BlackJackHand();
			
	
	public PlayBlackJack(ArrayList<BlackJackCard> fullCards){
		this.fullCards = fullCards;
	}
	
	public void play(){
		//create Deck 
		Deck deck = new Deck(fullCards);
		deck.shuffle();//shuffle fullCards
		
		//start
		//while(deck.cardsLeft() >= 10){
			//deal card
			dealer.addCard((BlackJackCard) deck.dealCard());
			System.out.println("dealer:" + dealer.getCard(0).faceValue);
			player1.addCard((BlackJackCard) deck.dealCard());
			System.out.println("player1:" + player1.getCard(0).faceValue);
			dealer.addCard((BlackJackCard) deck.dealCard());
			System.out.println("dealer:" + dealer.getCard(1).faceValue);
			player1.addCard((BlackJackCard) deck.dealCard());
			System.out.println("player1:" + player1.getCard(1).faceValue);
			
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
