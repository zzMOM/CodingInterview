package deckofcards;

import java.util.ArrayList;

public class BlackJackHand extends Hand<BlackJackCard>{
	
	public int score(){
		int scores = 0;
		for(int i = 0; i < cards.size(); i++){
			int temp = cards.get(i).faceValue;
			if(temp >= 10){
				scores += 10;
			} else {
				scores += temp;
			}
		}
		
		return scores;
	}
	
	
	public boolean busted(){
		return (score() > 21);
	}
	
	public boolean is21(){
		return (score() == 21);
	}
	
	public boolean isBlackJack(){
		return false;
	}
}
