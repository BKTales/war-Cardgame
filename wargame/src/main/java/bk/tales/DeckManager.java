package bk.tales;

import java.util.ArrayList;
import java.util.Collections;

public class DeckManager {

        ArrayList<Card> cardDeck = new ArrayList<>();
        Card card;
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Q", "J", "K", "A"};


        public Deck createDeck(){

            for (int i = 0; i < Shapes.values().length; i++){
                for (int j = 0; j < values.length; j++){
                    cardDeck.add(createCard(Shapes.values()[i], values[j]));
                }
            }

            shuffle();

            return new Deck(cardDeck);
        }

        private Card createCard(Shapes shape, String value){
            return new Card(shape, value);
        }

        public void shuffle(){
            Collections.shuffle(cardDeck);
        }
           
}
