package bk.tales;

import java.util.ArrayList;
import java.util.Collections;

public class DeckManager {

        ArrayList<Card> deck;
        Card card;
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Q", "J", "K", "A"};


        public Deck createDeck(){

            for (int i = 0; i < Shapes.values().length; i++){
                for (int j = 0; j < values.length; j++){
                    card = new Card(Shapes.values()[i], values[j]);
                    deck.add(card);
                }
            }

            shuffle();

            return new Deck(deck);
        }

        public void shuffle(){
            Collections.shuffle(deck);
        }
            
}
